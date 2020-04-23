# GraphQL API [![CircleCI](https://circleci.com/gh/grzegorz103/graphql.svg?style=svg)](https://circleci.com/gh/grzegorz103/graphql)

GraphQL API integrated with Spring Boot and PostgreSQL database

## Technology stack

- Spring Boot, GraphQL/REST, HATEAOS, Data JPA, Cache
- Hibernate
- PostgreSQL (production mode)
- H2 (develop mode)
- JUnit & Mockito
- Angular 8

## Demo

Angular 8 live demo at https://vehicle-site3021.firebaseapp.com/


## How to run app
1. Clone this repository
2. Open terminal in main directory and type `mvn spring-boot:run -Drun.profiles=dev`
3. Run another terminal and type following commands:
* `cd front`
* `npm install`
* `ng serve`
4. Run browser and head to `http://localhost:4200'
