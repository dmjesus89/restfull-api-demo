package com.kn.apim.restfulldemo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ExamplePatchOperation
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ExamplePatchOperation {

  private String op;

  private String path;

  private JsonNullable<Object> value = JsonNullable.<Object>undefined();

  public ExamplePatchOperation op(String op) {
    this.op = op;
    return this;
  }

  /**
   * Get op
   * @return op
  */
  @Size(max = 50) 
  @Schema(name = "op", example = "REPLACE", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("op")
  public String getOp() {
    return op;
  }

  public void setOp(String op) {
    this.op = op;
  }

  public ExamplePatchOperation path(String path) {
    this.path = path;
    return this;
  }

  /**
   * The JSON Pointer path to the value to be modified
   * @return path
  */
  @Size(max = 50) 
  @Schema(name = "path", example = "/name", description = "The JSON Pointer path to the value to be modified", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public ExamplePatchOperation value(Object value) {
    this.value = JsonNullable.of(value);
    return this;
  }

  /**
   * The new value to be assigned to the specified path
   * @return value
  */
  
  @Schema(name = "value", example = "New Example Name", description = "The new value to be assigned to the specified path", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("value")
  public JsonNullable<Object> getValue() {
    return value;
  }

  public void setValue(JsonNullable<Object> value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExamplePatchOperation examplePatchOperation = (ExamplePatchOperation) o;
    return Objects.equals(this.op, examplePatchOperation.op) &&
        Objects.equals(this.path, examplePatchOperation.path) &&
        equalsNullable(this.value, examplePatchOperation.value);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(op, path, hashCodeNullable(value));
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExamplePatchOperation {\n");
    sb.append("    op: ").append(toIndentedString(op)).append("\n");
    sb.append("    path: ").append(toIndentedString(path)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

