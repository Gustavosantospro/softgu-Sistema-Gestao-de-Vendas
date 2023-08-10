package com.gustavosantospro.softgu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@ComponentScan({"com.gustavosantospro.softgu.controller"})
@EntityScan("com.gustavosantospro.softgu.model")
@EnableJpaRepositories("com.gustavosantospro.softgu.repository")*/
public class SoftguApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftguApplication.class, args);
	}

}
