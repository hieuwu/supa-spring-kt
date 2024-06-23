package com.supa.spring.supaspring

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfiguration {

    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("base-service")
            .pathsToMatch("/**")
            .build()
    }

    @Bean
    fun customOpenAPI(): OpenAPI {
        val contact = Contact().apply {
            name = "Hieu Vu"
            url = "https://github.com/hieuwu"
        }
        return OpenAPI()
            .info(
                Info()
                    .title("Spring Boot backend with RESTful APIs, session management via Supabase")
                    .version("1.0")
                    .description("Spring Boot Kotlin, built with supabase-kt library")
                    .termsOfService("http://swagger.io/terms/")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
                    .contact(contact)
            )
    }
}