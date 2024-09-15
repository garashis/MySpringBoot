package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@ExtendWith(SpringExtension.class)


@ImportAutoConfiguration(exclude= {SecurityAutoConfiguration.class, ....all files in config folder})
public class MySpringBootApplicationTests {
 ObjectMapper objectMapper = new ObjectMapper();
	@Test
	public void contextLoads(@Value("${classpath:appDTO.json}") Resource dto) throws IOException {
		AppDTO appDTO = objectMapper.readValue(dto.getContentAsByteArray(), AppDTO.class);
		Assertions.assertEquals("ashish", appDTO.getFName());
		Assertions.assertTrue(true);
	}

}
