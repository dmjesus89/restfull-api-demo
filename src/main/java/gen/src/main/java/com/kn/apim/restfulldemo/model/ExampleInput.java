package com.kn.apim.restfulldemo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ExampleInput
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ExampleInput {

  private String name;

  private String type;

  public ExampleInput() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ExampleInput(String name, String type) {
    this.name = name;
    this.type = type;
  }

  public ExampleInput name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the example
   * @return name
  */
  @NotNull @Size(max = 200) 
  @Schema(name = "name", example = "Example 1", description = "The name of the example", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ExampleInput type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of the example
   * @return type
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "type", example = "TYPE_1", description = "The type of the example", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExampleInput exampleInput = (ExampleInput) o;
    return Objects.equals(this.name, exampleInput.name) &&
        Objects.equals(this.type, exampleInput.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExampleInput {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

