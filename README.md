# GraphQL API 
[![CircleCI](https://circleci.com/gh/grzegorz103/graphql.svg?style=svg)](https://circleci.com/gh/grzegorz103/graphql)

## Table of contents
* [General info](#general-info)
* [Demo](#demo)
* [Technologies](#technologies)
* [Features](#features)
* [Setup](#setup)

## General info

This application consists of GraphQL API/RESTful (level 3) created using Spring Boot and Angular 8 client.

## Demo

Angular 8 live demo at https://vehicle-site3021.firebaseapp.com/

## Technologies

- Spring Boot, GraphQL/REST, HATEAOS, Data JPA, Cache, AOP
- Hibernate
- PostgreSQL (production mode)
- H2 (develop mode)
- JUnit & Mockito
- Mapstruct
- Angular 8, Apollo

## Setup
### Prerequisites

- Angular 8 or greater is required
```$xslt
$ npm install -g @angular/cli
``` 
- Java 8+

### Deployment

```
$ mvn spring-boot:run -Drun.profiles=dev
$ cd front
$ npm install
$ ng serve
```
Run browser and head to ```http://localhost:4200```
