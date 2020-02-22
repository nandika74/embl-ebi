package com.embl.ebi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = { "com.embl.ebi.controller", "com.embl.ebi.finder", "com.embl.ebi.service",
		"com.embl.ebi.mapper", "com.embl.ebi.model" })
@EnableSwagger2
@SpringBootApplication
public class EmblEbiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmblEbiApplication.class, args);
	}

}
