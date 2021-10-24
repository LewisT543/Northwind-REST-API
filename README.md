# Northwind-REST-API
A Spring-Boot example of a RESTful-API designed to expose endpoints from within the Northwind database.

## Tools used
- Java -> Programming language.
- IntelliJ (+JPA buddy plugin) -> IDE used, has many useful tools including built-in database support. JPA buddy for creating entities from our database.
- Spring boot -> Framework used to write our IPA, does a lot of the ground work for us.
- Maven -> Dependency manager and build tool. Used primarily for dependencies.
- MySQL + MySQL Workbench -> Chosen database, MySQL workbench for database browsing tools and querying.
- Git/Github -> Version control

## Brief explaination
This api exposes a number of endpoints, through which data from the northwind database can be accessed. The URL's were designed with no specific user in mind and as such may not be 100% suitable for either an high detail internal API or a publicly available 'customer' API. It does, however, attempt to display the essential information within the database without concern for security or appropriateness.

## The endpoints
The base URL of the API:
http://localhost:8080/northwind

The endpoints can be accessed by adding any of the following after the base URL.
- /categories, categories/{categoryId}
- /customers, customers/{customerId}, \<name> and \<country> may be queried here seperately or combined.
- /employees, \<employeeId>, \<firstName>, \<lastName>, \<country>, \<firstName>&\<country>, \<lastName>&\<country>, \<firstName>&\<lastName>
- /orders, \<customerId>, \<country>, \<shippedDate>, \<orderDate>, \<employeeId>
- /orderdetails, \<orderId>, \<product>
- /products, /products/inStock, /products/outOfStock, /products/discontinued, /products/{productId}, \<productName>, \<supplierId>, \<categoryId>
- /shippers, /shippers/{shipperId}
- /suppliers, suppliers/{supplierId}, \<country>, \<city>, \<postcode>, \<title>, \<companyName>, \<country>&\<city>
- /territories, /territories/{territoryId}, \<name>, \<region>

  ## Testing
  Currently no unit tests on account of me not knowing what I am doing.
  Manual testing for each unique endpoint (a range of values for larger range endpoints).

  ## Future to-do
    - Testing.
    - Condense clumbsy implementation of many controllers into more complex but flexible mapping methods in one central controller. Should not change much in terms of usage for     the user.
    - More endpoints / DTO's for specific 'users' e.g. internal API would require all details, whereas an external one would require sensitivity to what data is exposed.