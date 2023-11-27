package com.kn.apim.restfulldemo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.kn.apim.restfulldemo.model.Example;
import com.kn.apim.restfulldemo.model.ResponsePageQuery;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * ResponsePage
 */
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ResponsePage {

  private URI self;

  private URI first;

  private URI prev;

  private URI next;

  private URI last;

  private ResponsePageQuery query;

  @Valid
  private List<@Valid Example> examples = new ArrayList<>();

  public ResponsePage() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ResponsePage(URI next, List<@Valid Example> examples) {
    this.next = next;
    this.examples = examples;
  }

  public ResponsePage self(URI self) {
    this.self = self;
    return this;
  }

  /**
   * Link pointing to the current page.
   * @return self
  */
  @Valid 
  @Schema(name = "self", description = "Link pointing to the current page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("self")
  public URI getSelf() {
    return self;
  }

  public void setSelf(URI self) {
    this.self = self;
  }

  public ResponsePage first(URI first) {
    this.first = first;
    return this;
  }

  /**
   * Link pointing to the first page.
   * @return first
  */
  @Valid 
  @Schema(name = "first", description = "Link pointing to the first page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("first")
  public URI getFirst() {
    return first;
  }

  public void setFirst(URI first) {
    this.first = first;
  }

  public ResponsePage prev(URI prev) {
    this.prev = prev;
    return this;
  }

  /**
   * Link pointing to the previous page.
   * @return prev
  */
  @Valid 
  @Schema(name = "prev", description = "Link pointing to the previous page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("prev")
  public URI getPrev() {
    return prev;
  }

  public void setPrev(URI prev) {
    this.prev = prev;
  }

  public ResponsePage next(URI next) {
    this.next = next;
    return this;
  }

  /**
   * Link pointing to the next page.
   * @return next
  */
  @NotNull @Valid 
  @Schema(name = "next", description = "Link pointing to the next page.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("next")
  public URI getNext() {
    return next;
  }

  public void setNext(URI next) {
    this.next = next;
  }

  public ResponsePage last(URI last) {
    this.last = last;
    return this;
  }

  /**
   * Link pointing to the last page.
   * @return last
  */
  @Valid 
  @Schema(name = "last", description = "Link pointing to the last page.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("last")
  public URI getLast() {
    return last;
  }

  public void setLast(URI last) {
    this.last = last;
  }

  public ResponsePage query(ResponsePageQuery query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
  */
  @Valid 
  @Schema(name = "query", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("query")
  public ResponsePageQuery getQuery() {
    return query;
  }

  public void setQuery(ResponsePageQuery query) {
    this.query = query;
  }

  public ResponsePage examples(List<@Valid Example> examples) {
    this.examples = examples;
    return this;
  }

  public ResponsePage addExamplesItem(Example examplesItem) {
    if (this.examples == null) {
      this.examples = new ArrayList<>();
    }
    this.examples.add(examplesItem);
    return this;
  }

  /**
   * Array of examples.
   * @return examples
  */
  @NotNull @Valid @Size(max = 1000) 
  @Schema(name = "examples", description = "Array of examples.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("examples")
  public List<@Valid Example> getExamples() {
    return examples;
  }

  public void setExamples(List<@Valid Example> examples) {
    this.examples = examples;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponsePage responsePage = (ResponsePage) o;
    return Objects.equals(this.self, responsePage.self) &&
        Objects.equals(this.first, responsePage.first) &&
        Objects.equals(this.prev, responsePage.prev) &&
        Objects.equals(this.next, responsePage.next) &&
        Objects.equals(this.last, responsePage.last) &&
        Objects.equals(this.query, responsePage.query) &&
        Objects.equals(this.examples, responsePage.examples);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, first, prev, next, last, query, examples);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponsePage {\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
    sb.append("    examples: ").append(toIndentedString(examples)).append("\n");
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

