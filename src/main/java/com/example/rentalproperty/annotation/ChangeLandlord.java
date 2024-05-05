package com.example.rentalproperty.annotation;

import com.example.rentalproperty.entity.Landlord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.PUT)
@Operation(
        summary = "Update landlord",
        description = "Update landlord and return",
        tags = {"LANDLORD"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The landlord to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Landlord.class)
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The landlord updated",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Landlord.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "The landlord already exist",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Landlord.class)
                        )
                )
        }
)
public @interface ChangeLandlord {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
