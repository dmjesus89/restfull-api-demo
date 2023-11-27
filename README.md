# apim-restfull-demo-api



RESTful API with Java 17 and Maven 3



This project is a RESTful API developed in Java 17 using, Spring boot 3 and built with Maven 3. It is designed to be consumed by the WSO2 platform, This project contains source code and supporting files for a Spring Boot based blueprint application implementing a GraphQL API.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [API, Swagger, Actuator, and Health Endpoints](#api-swagger-actuator-and-health-endpoints)
- [JWT Authentication](#jwt-authentication)
- [OpenAPI Specification](#openapi-specification)
- [Centralized Error Handling](#centralized-error-handling)
- [Generating Presentation Layer](#generating-presentation-layer)


## Prerequisites

Make sure you have the following installed on your system:
- Java 17
- Maven 3

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://git.int.kn/scm/api/apim-restfull-demo-api.git
   ```
2. Navigate to the project directory:
   ```bash
   cd apim-restfull-demo-api
   ```

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
    ```bash
   mvn spring-boot:run
   ```


## API, Swagger, Actuator, and Health Endpoints
- The API will be accessible at http://localhost:80.
- Swagger UI: Accessible at http://localhost:80/swagger-ui.html
- Actuator Endpoints: Available at http://localhost:80/actuator
- Health Endpoint: http://localhost:80/actuator/health

These endpoints provide valuable information about the API, its health, and various metrics.



## JWT Authentication
WSO2 JWT token authentication is mandatory for accessing this API. Ensure that each request includes a valid JWT token in the header.


## OpenAPI Specification
The API definition is documented using the OpenAPI Specification. You can find the OpenAPI file at:
> src/main/resources/knite/restfullexample_v1.yaml


## Centralized Error Handling
The API includes centralized error handling to provide consistent and informative error responses. The error responses follow a standardized format for easy consumption by clients.

## Generating Presentation Layer
To generate the DTOs from the OpenAPI file, use the Maven plugin configured in the pom.xml file. Run the following command:

```bash
mvn verify
```
