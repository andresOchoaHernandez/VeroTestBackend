package com.andresochoahernandez.testonline;

import com.andresochoahernandez.testonline.configuration.security.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class TestonlineApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestonlineApplication.class, args);
	}
}
