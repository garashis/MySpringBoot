package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.Mono;

import java.util.*;

@RestController
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    private static Mono<? extends Throwable> handle4xxClientError(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(String.class).flatMap(body -> {
            if (body.contains("user not found")) {
                return Mono.error(new RuntimeException("user is not found"));
            }
            return Mono.error(new RuntimeException("internal server error"));
        });
    }

    private static Mono<? extends Throwable> handle5xxServerError(ClientResponse clientResponse) {
        return clientResponse.bodyToMono(String.class).flatMap(body -> Mono.error(new RuntimeException("internal server error")));
    }

    private static Mono<ClientResponse> exchangeFilterResponseProcessor(ClientResponse response) {
        HttpStatusCode status = response.statusCode();
        if (HttpStatus.NOT_FOUND.equals(status)) {
            return response.bodyToMono(String.class).flatMap(body -> {
                if (body.contains("user not found")) {
                    return Mono.error(new RuntimeException("user is not found"));
                }
                return Mono.error(new RuntimeException("internal server error"));
            });
        } else if (status.is4xxClientError() || status.is5xxServerError()) {
            return response.bodyToMono(String.class).flatMap(body -> Mono.error(new RuntimeException("internal server error")));
        }
        return Mono.just(response);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot world.";
    }

    @GetMapping("/formatDate")
    public String date(@RequestParam @Validated @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        throw new NoRecordFoundException("some error");
        //return "Hello Spring Boot world.";
    }

    @PostMapping("/create")
    public ResponseEntity<Greeting> create(@RequestBody AppDTO dto) {
        return new ResponseEntity<>(appService.sum(dto), HttpStatus.FOUND);
    }

    @RequestMapping("/validate")
    public String validate(@RequestParam Size size) {
        return "Hello " + size;
    }

    @RequestMapping("/format")
    public DTO formatting() {
        DTO dto = new DTO();
        dto.setPrice(123.0);
        return dto;
    }

    @RequestMapping("/webclient")
    public ResponseEntity<String> webclient(@Param("client") int client) {
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:3000")
                //.filter(ExchangeFilterFunction.ofResponseProcessor(AppController::exchangeFilterResponseProcessor))
                .build();

        ResponseEntity<String> response = webClient.get().uri(uriBuilder -> uriBuilder.path("/abc").queryParam("client", client).build())
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, AppController::handle4xxClientError).onStatus(HttpStatusCode::is5xxServerError, AppController::handle5xxServerError).toEntity(String.class).block();

        return response;
//        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
//            return ResponseEntity.status(NOT_FOUND).body("user missing");
//        }
//        return ResponseEntity.status(OK).body(response);
    }

    @Autowired
    MyTableRepository repository;
    @GetMapping
    @Cacheable(value = "users")
    public List<MyTestTable> getData(@RequestParam int version){
        //List<MyTestTable> data = myRepository.findAll();
        System.out.println(">>>>>>>>>>>> caching");
        List<MyTestTable> data = repository.findResult(version);
        return data;
    }


}
