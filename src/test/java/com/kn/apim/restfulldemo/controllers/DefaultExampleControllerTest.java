package com.kn.apim.restfulldemo.controllers;

import com.kn.apim.restfulldemo.model.Example;
import com.kn.apim.restfulldemo.model.ExampleInput;
import com.kn.apim.restfulldemo.services.interfaces.ExampleService;
import com.kn.apim.restfulldemo.model.ResponsePage;
import com.kn.apim.restfulldemo.model.ExamplePatchOperation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DefaultExampleControllerTest {

    @Mock
    private ExampleService exampleService;

    @InjectMocks
    private DefaultExampleController exampleController;

    @Test
    void testCreateExample() {
        ExampleInput exampleInput = new ExampleInput();
        ResponseEntity<Example> responseEntity = exampleController.createExample(exampleInput);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void testListExamples() {
        when(exampleService.listExamples(any(), anyInt(), anyInt())).thenReturn(Collections.singletonList(new Example()));
        ResponseEntity<ResponsePage> responseEntity = exampleController.listExamples(null, 1, 20);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().getExamples().size());
    }

    @Test
    void testDeleteExample() {
        ResponseEntity<Void> responseEntity = exampleController.deleteExample("exampleId");
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void testPutExample() {
        ExampleInput exampleInput = new ExampleInput();
        when(exampleService.putExample(any(String.class), any(ExampleInput.class))).thenReturn(new Example());
        ResponseEntity<Example> responseEntity = exampleController.putExample("exampleId", exampleInput);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetExampleById() {
        when(exampleService.getExampleById(any(String.class))).thenReturn(new Example());
        ResponseEntity<Example> responseEntity = exampleController.getExampleById("exampleId");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testPatchExample() {
        ResponseEntity<Example> responseEntity = exampleController.patchExample("exampleId", Collections.singletonList(new ExamplePatchOperation()));
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
