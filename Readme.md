# Barcode Validator
This project is a simple Barcode Validator application built using Spring Boot. It provides an API endpoint to validate barcodes based on specific rules.
## Features
- RESTful API endpoint for barcode validation
- S10 barcode validation logic
- Unit tests for validation logic
## Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
## Getting Started
To run the application locally, follow these steps:
1. Clone the repository:
   ```bash
   git clone https://github.com/oak-manasi/validator.git
   ```
2. Navigate to the project directory:
   ```bash  
    cd validator
    ```
3. Build the project using Maven:
   ```bash
    mvn clean install
    ```
4. Run the application:
   ```bash
    mvn spring-boot:run
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
        ```
        #for true Example:
        curl -X POST "http://localhost:8080/validate" -H "Content-Type: application/json" -d "{\"Code\": \"AA473124829GB\"}"
        #for false example:
        curl -X POST "http://localhost:8080/validate" -H "Content-Type: application/json" -d "{\"Code\": \"AA473124828GB\"}"
        ```
    - **Example Response:**
        ```
        true/false
        ```
## Running Tests
To run the unit tests, use the following Maven command:
```bash         
mvn test
```



##docker To build and run the application using Docker, follow these steps:
##prequisites
- Docker installed on your machine
## Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/oak-manasi/validator.git   ```
2. Navigate to the project directory:
   ```bash  
    cd validator
    ```
3. Build the Docker image:
   ```bash
   docker build -t barcode-validator .
   ```  
4. Run the Docker container:
   ```bash
    docker run -p 8080:8080 barcode-validator
    ```
The application will be accessible at `http://localhost:8080`.