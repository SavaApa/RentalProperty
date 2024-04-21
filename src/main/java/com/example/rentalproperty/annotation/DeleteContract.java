package com.example.rentalproperty.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@RequestMapping(method = RequestMethod.DELETE)
@Operation(
        summary = "Delete contract",
        description = "Delete an existing contract by ID",
        tags = {"CONTRACT"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique contract ID",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid")
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The contract was successfully removed"
                ),
                @ApiResponse(
                        responseCode = "510",
                        description = "This contract not exist in base"
                )
        }

)
public @interface DeleteContract {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
