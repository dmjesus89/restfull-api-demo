package com.kn.apim.restfulldemo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Object containing the query filters applied to the collection resource.
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Schema(name = "ResponsePage_query", description = "Object containing the query filters applied to the collection resource.")
@JsonTypeName("ResponsePage_query")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ResponsePageQuery {

  private String type;

  public ResponsePageQuery() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ResponsePageQuery(String type) {
    this.type = type;
  }

  public ResponsePageQuery type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of the examples to retrieve.
   * @return type
  */
  @NotNull @Size(max = 50) 
  @Schema(name = "type", description = "The type of the examples to retrieve.", requiredMode = Schema.RequiredMode.REQUIRED)
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
    ResponsePageQuery responsePageQuery = (ResponsePageQuery) o;
    return Objects.equals(this.type, responsePageQuery.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePageQuery {\n");
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

