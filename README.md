# ShoppingCart

Ironhack Bootcamp Final Project: Shopping Cart  
by: [Ari](https://github.com/ari0707)

## Goal

The Goal of this project is making a recap of all the contents seen throughout the course. To do so, we will have to implement Spring Microservices as the backend, allowing to use a distributed system architecture, which improves efficiency, scalability and computing power and implementing Vue.js for the User Interface. The proposal for this application is a small ecommerce software, although is a pretty standard proposal, the project has plenty of room for growing as needed. And the main focus is making a secure, robust and scalable application.

## Requirements

Your project must meet all of the requirements below:

- Include a microservices Java/Spring Boot back-end and an Angular frontend.
- Include at least 2 SQL database tables.
- Include at least 4 services plus at least 1 edge service.
- Include at least 1 GET, POST, PUT/PATCH, and DELETE route.
- Include adequate and complete documentation.
- Include at least 1 technology, tool, framework, or library that has not been covered in class

## Tools
- IntelliJ (Compile and run Java Program)
- VSCode (Vue.js)
- Spring Boot
- MySQL Worbench
- Postman
- Swagger (API Document with HTML)
- Drawio

 ## Examples of EndPoints
  
### Users
  
| Request |                 Route                 | 
|---------|---------------------------------------|
| GET     | /users/signup                         |
| GET     | /users/signin                         | 


### Cart
  
| Request |                 Route                 | 
|---------|---------------------------------------|
| POST    | /cart/create                          |
| GET     | /cart/                                | 
| DELETE  | /cart/delete/{cartItemId}             | 

### Category
  
| Request |                 Route                 | 
|---------|---------------------------------------|
| POST    | /category/create                      |
| GET     | /category/list                        | 


### Product
  
| Request |                 Route                 | 
|---------|---------------------------------------|
| POST    | /product/create                       |
| GET     | /product/list                         | 


### SQL Relations Diagram
![sql relations diagram](https://github.com/ari0707/ShoppingCart/blob/main/Backend/ShoppingCart/src/main/resources/SQL%20Relations%20Diagram.jpg)


# Thanks♥️
