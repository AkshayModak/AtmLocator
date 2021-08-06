# AtmLocator

## This Project consists of APIs to Fetch ATM Locations.

Clone the project and start the server with the following command:
**mvn spring-boot:run**

After running the above command the server will start by default on port: **8080**

###### Two GET APIs available. You can run these APIs directly from Postman or Browser.

1. Get ATM Locations By Name: **localhost:8080/getAtmLocatorByCity/Zaandam**
2. Get Lits of Atm Locations: **localhost:8080/getAtmLocatorList**

###### Or

###### You can use the below cURL Commands:
* curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET localhost:8080/getAtmLocatorByCity/Zaandam
* curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET localhost:8080/getAtmLocatorList


###### Developed on:
Spring-boot
