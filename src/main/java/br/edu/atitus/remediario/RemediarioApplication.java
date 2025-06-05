package br.edu.atitus.remediario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "br.edu.atitus.remediario")
public class RemediarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemediarioApplication.class, args);
	}

}
