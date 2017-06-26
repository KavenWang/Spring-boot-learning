package com.kaven.kavencore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.kaven.kavencore"})
@MapperScan("com.kaven.kavencore.mapper")
@SpringBootApplication
public class KavenCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(KavenCoreApplication.class, args);
	}
}
