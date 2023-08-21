# Microservices

This repository contains multiple microservices modules for a distributed system. Each module serves a specific purpose and is designed to work together as part of a larger system.

## Technology
* Java 11
* Spring Boot
* Spring Cloud
* PostgreSQL
* Kafka
* Redis

## Project Features

* Create a service registry and discovery
* Set up an API gateway into microservices
* Create a Spring cloud config server
* Create API rate limiting
* Create producer and consumer in kafka
* Create redis Publish/Subscribe

## Modules

### discovery-service

This module provides service discovery functionality using Eureka Server. It allows services to register and discover each other.

### api-gateway

The API Gateway module acts as a gateway to route and manage incoming API requests. It also includes rate limiting using Redis and routing to various service endpoints.

### config-server

The Config Server module manages the configuration for all other services in a centralized way. It retrieves configurations from a Git repository and serves them to the respective services.

### base-domains

The Base Domains module contains common DTOs and models that are shared across different services in the system.

### user-service

The User Service module handles user-related operations. It communicates with a database to manage user data and provides REST endpoints for user information retrieval.

### order-service

The Order Service module handles the order placement process. It uses Kafka for event-driven communication to send order events to other services.

### stock-service

The Stock Service module manages stock information and orders. It communicates with a database to manage orders and stock data and provides REST endpoints for order placement and retrieval.

### email-service

The Email Service module is responsible for sending email notifications. It listens to Kafka topics for order events and sends email notifications based on received events.

## RestApi Endpoints

* Create an order in Kafka Producer:POST http://localhost:9191/api/v2/orders

 ````
Example Request
  {
    "name":"Book Order",
    "qty":50,
    "price":500000,
    "userId":3
  }
  Success Response Example
  {
    "message": "Order placed successfully"
  }
````

  -------------------------------------------------------------

* Retrieve orders of any user using RestTemplate:GET http://localhost:9191/api/v3/stocks/3
````
 Success Response Example
 {
    "id": 3,
    "name": "Book Order",
    "qty": 50,
    "price": 500000,
    "user": {
        "id": 3,
        "name": "Khoa",
        "email": "nguyenvankhoa@gmail.com"
    }
}
 ````

  -------------------------------------------------------------

* Create a text message using redis: POST http://localhost:9191/api/v2/message
````
Example Request
  {
    "message": "message"
  }
  Success Response Example
  {
    "message": "Success messages"
  }
 ````