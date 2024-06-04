package com.supa.spring.supaspring.configuration

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
        val contact = Contact()
        contact.email = "hendisantika@yahoo.co.id"
        contact.name = "HENDI SANTIKA"
        contact.url = "https://www.s.id/hendisantika"
        return OpenAPI()
            .info(
                Info()
                    .title("Microservice Base Service Application API")
                    .version("appVersion")
                    .description("appDescription")
                    .termsOfService("http://swagger.io/terms/")
                    .license(License().name("Apache 2.0").url("http://springdoc.org"))
                    .contact(contact)
            )
    }
}