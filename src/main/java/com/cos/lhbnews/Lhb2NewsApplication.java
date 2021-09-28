package com.cos.lhbnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Lhb2NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lhb2NewsApplication.class, args);
	}

}
