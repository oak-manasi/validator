# Barcode Validator
This project is a simple Barcode Validator application built using Spring Boot. It provides an API endpoint to validate barcodes based on specific rules.
## Features
- RESTful API endpoint for barcode validation
- S10 barcode validation logic
- Unit tests for validation logic
## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- (Optional) Docker for containerized deployment


## Getting Started
To build the application locally, follow these steps:
    
1. Clone the repository:
   ```bash
   git clone https://github.com/oak-manasi/validator.git
   ```
2. Navigate to the project directory:
   ```bash  
    cd validator
    ```

    
## Option A: Using Maven to run the application locally

3(A). Build the project using Maven:
   ```bash
   mvn clean install
   ```

4(A). Run the application:
   ```bash
    mvn spring-boot:run
    ```
 
### Option B: Docker To build and run the application using Docker
   ```bash
  prequisites
    - Docker installed on your machine
    ```
3(B) Build the Docker image:
   ```bash
   docker build -t barcode-validator .
   ```
4(B)Run the Docker container:
   ```bash
    docker run -p 8080:8080 barcode-validator
    ```


    5. The application will start on `http://localhost:8080`.
## API Endpoint
- **Validate Barcode**
- **URL:** `/validate`
- **Method:** `POST`
- **Request Body with JSON:**
    ```json
    {
        "barCode": "AA473124829GB"
    }
    ```
- **Response:** `true` if the barcode is valid, `false` otherwise
- **Example Request:**
        ```bash
        #for true Example:
        curl --location "http://localhost:8080/validate" --header "Content-Type: application/json" --data "{\"barCode\": \"AA473124829GB\"}"
        #for false example:
        curl --location "http://localhost:8080/validate" --header "Content-Type: application/json" --data "{\"barCode\": \"AA473124829GB\"}"
        ```
- **Example Response:**
        ```bash
        true/false
        ```


## Running Tests
To run the unit tests, use the following Maven command:
```bash
mvn test
```