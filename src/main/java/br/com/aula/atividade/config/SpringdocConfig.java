package br.com.aula.atividade.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringdocConfig {
	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Documentação da API da Atividade")
	              .description("API Restful utilizando Springdoc para documentação da atividade da Aula.")
	              .version("1.0.0")
	              .license(new License().name("Apache 2.0").url("http://atividade.aula.com.br")))
	              .externalDocs(new ExternalDocumentation()
	              .description("Link do Repositório da Aplicação")
	              .url("https://github.com/eaojunior/aula-pratica-modulo-6"));
	  }
}
