Barcode Validator

This project is a simple Barcode Validator application built using Spring Boot.
It exposes a REST API endpoint to validate barcodes based on predefined rules.

Features

RESTful API endpoint for barcode validation

S10 barcode validation logic

Unit tests for validation logic

Prerequisites

Java 17 or higher

Maven 3.6 or higher

(Optional) Docker for containerized deployment

Getting Started
Clone the Repository
git clone https://github.com/oak-manasi/validator.git
cd validator

Option A: Run Locally Using Maven
Build the Project
mvn clean install

Run the Application
mvn spring-boot:run


The application will start at:

http://localhost:8080

Option B: Run Using Docker
Prerequisites

Docker installed on your machine

Build the Docker Image
docker build -t barcode-validator .

Run the Docker Container
docker run -p 8080:8080 barcode-validator


The application will be available at:

http://localhost:8080

API Endpoint
Validate Barcode

URL: /validate

Method: POST

Content-Type: application/json

Request Body
{
  "barCode": "AA473124829GB"
}

Response

true → valid barcode

false → invalid barcode

Example Requests
# Valid barcode example
curl --location "http://localhost:8080/validate" \
     --header "Content-Type: application/json" \
     --data "{\"barCode\":\"AA473124829GB\"}"

# Invalid barcode example
curl --location "http://localhost:8080/validate" \
     --header "Content-Type: application/json" \
     --data "{\"barCode\":\"INVALID123\"}"

Example Response
true


or

false

Running Tests

Run unit tests using Maven:

mvn test
