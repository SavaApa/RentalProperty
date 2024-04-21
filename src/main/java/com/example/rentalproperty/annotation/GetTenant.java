package com.example.rentalproperty.annotation;

import com.example.rentalproperty.entity.Tenant;
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
@RequestMapping(method = RequestMethod.GET)
@Operation(summary = "Show tenant by ID", description = "Receiving an tenant by Id", tags = {"TENANT"},
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Tenant received and returned",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Tenant.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "510",
                        description = "This tenant not exist in base",
                        content = @Content()
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "It is uncorrected UUID",
                        content = @Content()
                )
        })
public @interface GetTenant {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
