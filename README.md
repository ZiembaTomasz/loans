![github](https://user-images.githubusercontent.com/40741056/74937413-4304d980-53ec-11ea-8010-58655042feb5.jpg)

# About

##### REST API  microservices application uses Database(MySQL) and Spring Boot. 

* getting credits, customers and products
* creating credits, customers and products

* application tests

## Technologies

* Java 8
* Spring Boot
* Hibernate
* REST API
* Lombok
* Mockito
* MySQL
* Maven
* Docker
* Docker-compose


____________________________________________________________________________________________________________
  ####  Get_Credits 
  ##### Method returns a json data about a list of all credits and their customers and products:
 * GET
 * Example Request: 
  ````
http://localhost:8080/credit
````           
* Example Response:
````
{
        "credit": {
            "id": 1,
            "creditName": "Axel Credit"
        },
        "customer": {
            "pesel": "89051425693",
            "firstName": "Jan",
            "surname": "Kowalski",
            "creditId": 1
        },
        "product": {
            "productName": "Fast Loan",
            "value": 2000,
            "creditId": 1
        }
 }
````
* Succes Response: Code 200

 #### Create_Credit
  ##### Method creates new credit with customer and product:
 * POST 
* Example Request
````
http://localhost:8080/credit
````
* Example JSON Body:
````
{
	"credit" : {
		"creditName" : "Groovy Credit"
	},
	"customer" : {
		"pesel" : "64112267415",
		"firstName" : "Krystyna",
		"surname" : "Janowicz"
	},
	"product" : {
		"productName" : "Mega Loan",
		"value" : 8000
	}
}
````
* Succes Response: Code 200  

___________________________________________________________________________________________________________________________________________
#### Get_Customers
##### Method returns a json data about list of customers given by credit id:
* GET  
* Example Request:
````
http://localhost:8081/customer?creditIds=1,2,3
````
* Example Response:
````
[
    {
        "pesel": "70071724933",
        "firstName": "Kazimierz",
        "surname": "Janowski",
        "creditId": 3
    },
    {
        "pesel": "84102475325",
        "firstName": "Joanna",
        "surname": "Witkowska",
        "creditId": 2
    },
    {
        "pesel": "89051425693",
        "firstName": "Jan",
        "surname": "Kowalski",
        "creditId": 1
    }
]
````
* Succes Response: Code 200 

#### Create_Customer
##### Method creates customer:
* POST
* Example Request:
````
http://localhost:8081/customer
````
* Example JSON Body:
````	
{
	"pesel": "79021425894",
	"firstName": "Jacek",
	"surname": "Tarnowski,
	"creditId": 4
}
````
* Succes Response: Code 200 

#### Get_Customer_By_Pesel
##### Method returns a json data about customer found by pesel:
* GET
* Example Request:
````
http://localhost:8081/customer/getCustomerByPesel?pesel=70071724933
````
* Example Response:
````
{
    "pesel": "70071724933",
    "firstName": "Kazimierz",
    "surname": "Janowski",
    "creditId": 3
}
````
* Succes Response: Code 200
--------------------------------------------------------------------------------------------------------
#### Get_Products
##### Method returns a json data about list of products given by credit id:
* GET 
* Example Request:
````
http://localhost:8082/product?creditIds=1,2
````
* Example Response
````
[
    {
        "productName": "Extra Loan",
        "value": 3000,
        "creditId": 2
    },
    {
        "productName": "Fast Loan",
        "value": 2000,
        "creditId": 1
    }
]
````
* Succes Response: Code 200

#### Create_Product
##### Method creates product:
* POST
* Example Request: 
````
http://localhost:8082/product
````
* Example JSON Body:
```` 
{
	"productName": "Andrzej Dutkowski",
	"value": 2000,
	"creditId": 5
}
````
* Succes Response: Code 200

# Build docker images
    ./mvnw package docker:build && docker-compose up 
    
     
