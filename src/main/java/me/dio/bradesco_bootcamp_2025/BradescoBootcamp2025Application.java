package me.dio.bradesco_bootcamp_2025;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {
		@Server(url = "/", description = "Default server url")
})
@SpringBootApplication
public class BradescoBootcamp2025Application {

	public static void main(String[] args) {
		SpringApplication.run(BradescoBootcamp2025Application.class, args);
	}

}
