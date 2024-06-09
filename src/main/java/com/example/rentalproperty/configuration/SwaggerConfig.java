package com.example.rentalproperty.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Rental property",
                description = "There is a prototype of the BackEnd Rental Property Core Services data",
                version = "1.0.0",
                contact = @Contact(
                        name = "Savelii Apanasenko",
                        url = "https://github.com/SavaApa/RentalProperty"
                )
        )
)
@Configuration
public class SwaggerConfig {
    @Value("${swagger.packageName:com.example.rentalproperty}")
    private String PACKAGE_NAME;
    public static final String CONTRACT = "contract service";
    public static final String LANDLORD = "landlord service";
    public static final String TENANT = "tenant service";

    public static final String USER = "user service";

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan(PACKAGE_NAME)
                .addOpenApiCustomizer(openApi -> {
                    openApi.addTagsItem(new Tag().name(CONTRACT).description("API for working with contracts service"));
                    openApi.addTagsItem(new Tag().name(LANDLORD).description("API for working with landlords service"));
                    openApi.addTagsItem(new Tag().name(TENANT).description("API for working with tenants service"));
                    openApi.addTagsItem(new Tag().name(USER).description("API for working with users service"));
                })
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")));
    }
}