package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.*;

import java.awt.print.Book;
import java.io.*;

public class MyService {

    public int servicing(InputStream in) throws IOException {
        InputStream inputStream = PGPUtils.getStream(in);
        PGPService pgpService = new PGPService(inputStream);
        return pgpService.operation(inputStream);
    }

    public static void main(String[] args) {
        Double d = 1.23432;
        System.out.println(d.toString().substring(d.toString().indexOf(".")+1).length());
        System.out.println(validate(d.toString()));

        Mono<String> item =
                WebClient.create("http://localhost:12345").get().uri("/a/bc")
                        .retrieve()
                        .onStatus(status -> status.equals(HttpStatus.NOT_FOUND),
                                response -> Mono.error(new RuntimeException()))
                        .bodyToMono(String.class);
       // item.block();

    }

    public static Integer validate(String n) {
        if(n.contains("."))
            return n.replaceAll(".*\\.(?=\\d?)", "").length();
        return 0;
    }



}
