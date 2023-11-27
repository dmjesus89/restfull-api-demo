package com.kn.apim.restfulldemo.services;

import com.kn.apim.restfulldemo.model.Example;
import com.kn.apim.restfulldemo.model.ExampleInput;
import com.kn.apim.restfulldemo.exception.ResourceNotFoundException;
import com.kn.apim.restfulldemo.services.interfaces.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultExampleService implements ExampleService {

    List<Example> exampleList = new ArrayList<>();

    @Override
    public Example getExampleById(String exampleId) {
        return exampleList.stream()
                .filter(example -> example.getId().equalsIgnoreCase(exampleId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("example", "exampleId", exampleId));
    }

    @Override
    public void createExample(ExampleInput exampleInput) {
        Example example = new Example();
        example.setId(UUID.randomUUID().toString());
        example.setName(exampleInput.getName());
        example.setType(exampleInput.getType());
        exampleList.add(example);
    }

    @Override
    public void deleteExample(String exampleId) {
        Example exampleToDelete = exampleList.stream()
                .filter(example -> example.getId().equals(exampleId)).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("example", "exampleId", exampleId));
        exampleList.remove(exampleToDelete);
    }

    @Override
    public Example putExample(String exampleId, ExampleInput exampleInput){
    Example exampleReturned = exampleList.stream()
            .filter(example -> example.getId().equals(exampleId)).findFirst()
            .orElseThrow(() -> new ResourceNotFoundException("example", "exampleId", exampleId));
        return exampleReturned;
}

    @Override
    public List<Example> listExamples(String type, Integer page, Integer pageSize) {
        //This example doesn't contain a filter example because we are using a list class instead a real database to store the examples.
        if (type != null) {
            return exampleList.stream()
                    .filter(example -> example.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
        }
        return exampleList;
    }

}
