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
        summary = "Delete landlord",
        description = "Delete an existing landlord by ID",
        tags = {"LANDLORD"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique landlord ID",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "uuid")
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "The landlord was successfully removed"
                ),
                @ApiResponse(
                        responseCode = "510",
                        description = "This landlord not exist in base"
                )
        }

)
public @interface DeleteLandlord {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
