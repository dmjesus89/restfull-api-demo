package com.kn.apim.restfulldemo.services.interfaces;

import com.kn.apim.restfulldemo.model.Example;
import com.kn.apim.restfulldemo.model.ExampleInput;

import java.util.List;

public interface ExampleService {
    Example getExampleById(String exampleId);

    void createExample(ExampleInput exampleInput);

    List<Example> listExamples(String type, Integer page, Integer pageSize);

    void deleteExample(String exampleId);

    Example putExample(String exampleId, ExampleInput exampleInput);
}