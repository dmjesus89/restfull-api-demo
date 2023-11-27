package com.kn.apim.restfulldemo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.kn.apim.restfulldemo.model.Details;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Example
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Example {

  private String id;

  private String name;

  private String type;

  private Details details;

  public Example() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Example(String id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public Example id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier for the example
   * @return id
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "id", example = "id1", description = "The unique identifier for the example", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Example name(String name) {
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

  public Example type(String type) {
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

  public Example details(Details details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
  */
  @Valid 
  @Schema(name = "details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("details")
  public Details getDetails() {
    return details;
  }

  public void setDetails(Details details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Example example = (Example) o;
    return Objects.equals(this.id, example.id) &&
        Objects.equals(this.name, example.name) &&
        Objects.equals(this.type, example.type) &&
        Objects.equals(this.details, example.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, type, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Example {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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

