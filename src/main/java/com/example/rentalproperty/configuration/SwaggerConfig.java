package com.example.rentalproperty.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@OpenAPIDefinition(
        info = @Info(
                title = "Renal property",
                description = "This is the backend of the rental property educational application.",
                version = "0.0.1",
                contact = @Contact(
                        name = "Savelii Apanasenko",url = "https://github.com/SavaApa/RentalProperty"
                )
        )
)
@EnableSwagger2
public class SwaggerConfig {
}
