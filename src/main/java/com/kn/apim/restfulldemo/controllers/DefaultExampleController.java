package com.kn.apim.restfulldemo.controllers;

import com.kn.apim.restfulldemo.controllers.interfaces.ExampleController;
import com.kn.apim.restfulldemo.model.Example;
import com.kn.apim.restfulldemo.model.ExampleInput;
import com.kn.apim.restfulldemo.model.ExamplePatchOperation;
import com.kn.apim.restfulldemo.model.ResponsePage;
import com.kn.apim.restfulldemo.services.interfaces.ExampleService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/examples")
@RequiredArgsConstructor
public class DefaultExampleController implements ExampleController {

    private final ExampleService exampleService;

    @PostMapping(
            produces = {"application/json", "application/problem+json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<Example> createExample(@Parameter(name = "ExampleInput", description = "", required = true) @Valid @RequestBody ExampleInput exampleInput) {
        log.info("Initiating createExample: '{}'", exampleInput);
        exampleService.createExample(exampleInput);
        log.info("Successfully created example: '{}'", exampleInput);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(
            produces = {"application/json", "application/problem+json"}
    )
    public ResponseEntity<ResponsePage> listExamples(@Size(max = 50) @Parameter(name = "type", description = "Filter examples by type", in = ParameterIn.QUERY) @Valid @RequestParam(value = "type", required = false) String type,
                                                     @Min(1) @Parameter(name = "page", description = "The page number to retrieve.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                     @Min(1) @Max(100) @Parameter(name = "pageSize", description = "The number of examples per page.", in = ParameterIn.QUERY) @Valid @RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize) {
        log.info("Initiating listExamples");
        List<Example> exampleList = exampleService.listExamples(type, page, pageSize);
        ResponsePage responsePage = new ResponsePage();
        responsePage.setExamples(exampleList);
        log.info("Successfully returned a list of examples");
        return ResponseEntity.ok(responsePage);
    }

    @DeleteMapping(
            value = "/{exampleId}",
            produces = {"application/problem+json"}
    )
    public ResponseEntity<Void> deleteExample(@Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to delete", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId) {
        log.info("Initiating deleteExample by exampleId: '{}'", exampleId);
        exampleService.deleteExample(exampleId);
        log.info("Successfully deleted by exampleId: '{}'", exampleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(
            value = "/{exampleId}",
            produces = {"application/json", "application/problem+json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<Example> putExample(
            @Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to update", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId,
            @Parameter(name = "ExampleInput", description = "", required = true) @Valid @RequestBody ExampleInput exampleInput) {
        log.info("Initiating patchExample by exampleId: '{}' with exampleInput: {}", exampleId, exampleInput);
        Example example = exampleService.putExample(exampleId, exampleInput);
        log.info("Successfully updated by exampleId: '{}'", exampleId);
        return ResponseEntity.ok(example);
    }

    @GetMapping(
            value = "/{exampleId}",
            produces = {"application/json", "application/problem+json"}
    )
    public ResponseEntity<Example> getExampleById(@Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId) {
        log.info("Initiating getExampleById by exampleId: '{}'", exampleId);
        Example example = exampleService.getExampleById(exampleId);
        log.info("Successfully retrieved example by exampleId: '{}'", exampleId);
        return ResponseEntity.ok(example);
    }


    @PatchMapping(
            value = "/{exampleId}",
            produces = {"application/json", "application/problem+json"},
            consumes = {"application/json-patch+json"}
    )
    public ResponseEntity<Example> patchExample(@Size(max = 50) @Parameter(name = "exampleId", description = "ID of the example to update", required = true, in = ParameterIn.PATH) @PathVariable("exampleId") String exampleId,
                                                @Parameter(name = "ExamplePatchOperation", description = "JSON Patch document containing the changes to apply", required = true) @Valid @RequestBody List<ExamplePatchOperation> examplePatchOperation) {
        log.info("Initiating patchExample by exampleId: '{}'", exampleId);
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
