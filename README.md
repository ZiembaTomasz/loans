# About

##### REST API  microservices application uses Databases(MySQL) and Spring Boot. 

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
 * curl --location --request GET  
  ````
http://localhost:8080/credit
````           
* Example Response: 
* Succes Response --> Code 200

 #### Create_Credit
  ##### Method creates new credit with customer and product:
 * URL ------------------------> /credit   
* Method -------------------> POST
* Data Params  
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
##### Method provides credit numbers for which customers should be returned as a json data:
* curl --location --request GET   
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
#### Create_Customer
##### Method creates customer:
* curl --location --request POST  
* Example Request:
````
http://localhost:8081/customer
````
* Example data raw in JSON:
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
##### Method returns a json data about Customer found by Pesel:
* curl --location --request GET 
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
* Succes Response --> Code 200
--------------------------------------------------------------------------------------------------------
#### Get_Products
##### Method provides credit numbers for which products should be returned as a json data:
* curl --location --request GET 
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
* Succes Response ----> Code 200

#### Create_Product
##### Method creates product:
* curl --location --request POST 
````
http://localhost:8082/product
````
* Example data raw in JSON:
```` 
{
	"productName": "Andrzej Dutkowski",
	"value": 2000,
	"creditId": 5
}
````
* Succes Response ---> Code 200





   


# Build docker images

Add user to docker group
```
sudo usermod -aG docker $USER
```
    ./mvnw package docker:build
    ./mvnw clean compile && ./mvnw package docker:build
     docker run -p 3306:3306 ziembatomasz/database:1.0
     
