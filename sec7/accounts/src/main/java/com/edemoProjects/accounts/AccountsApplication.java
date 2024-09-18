package com.edemoProjects.accounts;

import com.edemoProjects.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "EazyBank Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Rini Dabral",
						email = "rini03dabral@gmail.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "url for more license details"
				)
		),
		externalDocs = @ExternalDocumentation( //to learn more about the application
				description =  "EazyBank Accounts microservice REST API Documentation",
				url = "documentation url"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}

