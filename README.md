![github](https://user-images.githubusercontent.com/40741056/74937413-4304d980-53ec-11ea-8010-58655042feb5.jpg)

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
* Docker
* Maven
* Docker
* Docker-compose


____________________________________________________________________________________________________________
  ####  Get Credits 
  ##### Method returns a json data about a list of all credits and their customers and products:
  * URL    ---------------------> /credit              
* Method   ----------------> GET
* Succes Response --> Code 200

 #### Create Credit
  ##### Method creates new credit with customer and product:
 * URL ------------------------> /credit   
* Method -------------------> POST
* Data Params  
{  
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"credit" : {  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"creditName" : "String"  
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},  
	"customer" : {  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"pesel" : "String,  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"firstName" : "String",  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"surname" : "String"  
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;},  
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"product" : {  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"productName" : "String",  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"value" : Integer  
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}  
}
* Succes Response ------> Code 200  

___________________________________________________________________________________________________________________________________________
#### Get Customers
##### Method returns a json data with a list of all customers:
* URL ------------------------>/customer
* Method -------------------> GET
* URL Params-------------> creditIds=integer, integer...
* Succes Response------> Code 200

#### Create Customer
##### Method creates customer:
* URL -------------------->/customer
* Method --------------->POST
* Data Params:

	
{  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"pesel" : "String",  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"firstName" : "String",  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"surname" : "String",  
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"creditId : Integer  
} 
* Succes Response ---> Code 200 

#### Get Customer By Pesel
##### Method returns a json data about Customer found by Pesel:
* URL --------------------> /customer/getCustomerByPesel
* Method ---------------> GET
* URL Params ---------> pesel=integer
* Succes Response --> Code 200
--------------------------------------------------------------------------------------------------------
#### Get Products
##### Method returns a json data with a list of all products:
* URL  ----------------------->/product
* Method ------------------> GET
* URL Params------------> creditIds=integer, integer...
* Succes Response ----> Code 200

#### Create Product
##### Method creates product:
* URL -------------------->/product
* Method ---------------> POST
* Data Params:  
{  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"pesel" : "String",  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"firstName" : "String",  
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"surname" : "String",  
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"creditId : Integer  
} 
* Succes Response ---> Code 200





   


# Build docker images

Add user to docker group
```
sudo usermod -aG docker $USER
```
    ./mvnw package docker:build
    ./mvnw clean compile && ./mvnw package docker:build
     docker run -p 3306:3306 ziembatomasz/database:1.0
     
    
