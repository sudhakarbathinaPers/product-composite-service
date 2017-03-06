# product-composite-service
## Introduction
This is a Restful macroservice which aggregrates all product data from other 3 services(basic, ratings, price) and provide consolidated data for single product as shown below.

{  

"item": {    "product_id": "456",    "name": "product2"  }, 

"price": {    "product_id": "456",    "price": "40"  },

"rating": {    "product_id": "456",    "rating": "5"  }

}

## Technology Stack

* Java 8
* SpringBoot
* RxJava
* Maven
* Docker

## Dependency
It requires other three Item related micro services to be up and running

### product-basic
### product-ratings
### product-price

## Running app

./mvnw package && java -jar target/product-composite-service-0.0.1-SNAPSHOT.jar

## To build docker image

./mvnw package docker:build   - This command builds a docker image with name: sudhakarbathina/product-composite-service:latest

## Running docker image

docker run -p 9006:9006 -t sudhakarbathina/product-composite-service   

## Routes

[list all routes that this service supports]

| Method | Route | Class | Description
| ------ | ----- | ----- | -----------
| GET | /products/v1/{id} | ProductCompositeResource.productById | Provides requested product Itemid, name, rating and price info
