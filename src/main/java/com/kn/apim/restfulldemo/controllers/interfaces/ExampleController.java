package com.kn.apim.restfulldemo.controllers.interfaces;

import com.kn.apim.restfulldemo.model.Example;
import com.kn.apim.restfulldemo.model.ExampleInput;
import com.kn.apim.restfulldemo.model.ExamplePatchOperation;
import com.kn.apim.restfulldemo.model.ResponsePage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "examples", description = "the examples API")
public interface ExampleController {

    /**
     * POST /examples : Create a new example
     * Create a new example
     *
     * @param exampleInput (required)
     * @return The created example (status code 201)
     * or Error occurred - see status code and problem object for more information. (status code 200)
     */
    @Operation(
            operationId = "createExample",
            summary = "Create a new example",
            description = "Create a new example",
            responses = {
                    @ApiResponse(responseCode = "201", description = "The created example", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Example.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = Example.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Error occurred - see status code and problem object for more information.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class))
                    })
            }
    )
    ResponseEntity<Example> createExample(@Parameter(name = "ExampleInput", description = "", required = true) @Valid @RequestBody ExampleInput exampleInput);

    /**
     * GET /examples : Retrieve a list of examples
     * Retrieve a list of examples
     *
     * @param type     Filter examples by type (optional)
     * @param page     The page number to retrieve. (optional, default to 1)
     * @param pageSize The number of examples per page. (optional, default to 20)
     * @return A list of examples (status code 200)
     * or Error occurred - see status code and problem object for more information. (status code 200)
     */
    @Operation(
            operationId = "listExamples",
            summary = "Retrieve a list of examples",
            description = "Retrieve a list of examples",
            responses = {
                    @ApiResponse(responseCode = "200", description = "A list of examples", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ResponsePage.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = ResponsePage.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Error occurred - see status code and problem object for more information.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class))
                    })
            }
    )
    ResponseEntity<ResponsePage> listExamples(
            @Size(max = 50) @Parameter(name = "type", description = "Filter examples by type", in = ParameterIn.QUERY) @Valid @RequestParam(value = "type", required = false) String type,
            @Min(1) @Parameter(name = "page", description = "The page number to retrieve.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @Min(1) @Max(100) @Parameter(name = "pageSize", description = "The number of examples per page.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize);

    /**
     * DELETE /examples/{exampleId} : Delete an example
     * Delete an example
     *
     * @param exampleId ID of the example to delete (required)
     * @return The example was successfully deleted (status code 204)
     * or Error occurred - see status code and problem object for more information. (status code 200)
     */
    @Operation(
            operationId = "deleteExample",
            summary = "Delete an example",
            description = "Delete an example",
            responses = {
                    @ApiResponse(responseCode = "204", description = "The example was successfully deleted"),
                    @ApiResponse(responseCode = "default", description = "Error occurred - see status code and problem object for more information.", content = {
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class))
                    })
            }
    )
    ResponseEntity<Void> deleteExample(@Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to delete", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId);


    /**
     * GET /examples/{exampleId} : Retrieve a single example by ID
     * Retrieve a single example by ID
     *
     * @param exampleId ID of the example to retrieve (required)
     * @return The requested example (status code 200)
     * or Error occurred - see status code and problem object for more information. (status code 200)
     */
    @Operation(
            operationId = "getExampleById",
            summary = "Retrieve a single example by ID",
            description = "Retrieve a single example by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "The requested example", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Example.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = Example.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Error occurred - see status code and problem object for more information.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class))
                    })
            }
    )
    ResponseEntity<Example> getExampleById(@Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId);


    /**
     * PATCH /examples/{exampleId} : Partially update an example by ID
     * Update an existing example by ID using a JSON Patch document
     *
     * @param exampleId             ID of the example to update (required)
     * @param examplePatchOperation JSON Patch document containing the changes to apply (required)
     * @return The updated example (status code 200)
     * or Error occurred - see status code and problem object for more information. (status code 200)
     */
    @Operation(
            operationId = "patchExample",
            summary = "Partially update an example by ID",
            description = "Update an existing example by ID using a JSON Patch document",
            responses = {
                    @ApiResponse(responseCode = "200", description = "The updated example", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Example.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = Example.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Error occurred - see status code and problem object for more information.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class))
                    })
            }
    )
    ResponseEntity<Example> patchExample(
            @Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to update", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId,
            @Parameter(name = "ExamplePatchOperation", description = "JSON Patch document containing the changes to apply", required = true) @Valid @RequestBody List<ExamplePatchOperation> examplePatchOperation
    );


    /**
     * PUT /examples/{exampleId} : Update an existing example by ID
     * Update an existing example by ID
     *
     * @param exampleId    ID of the example to update (required)
     * @param exampleInput (required)
     * @return The updated example (status code 200)
     * or Error occurred - see status code and problem object for more information. (status code 200)
     */
    @Operation(
            operationId = "putExample",
            summary = "Update an existing example by ID",
            description = "Update an existing example by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "The updated example", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Example.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = Example.class))
                    }),
                    @ApiResponse(responseCode = "default", description = "Error occurred - see status code and problem object for more information.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class)),
                            @Content(mediaType = "application/problem+json", schema = @Schema(implementation = com.kn.apim.restfulldemo.model.Problem.class))
                    })
            }
    )
    ResponseEntity<Example> putExample(
            @Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to update", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId,
            @Parameter(name = "ExampleInput", description = "", required = true) @Valid @RequestBody ExampleInput exampleInput
    );

}
