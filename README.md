### Customer XML

this program will read xml and convert it into model and persist to H2 database.

### Main points
- Main.java contains all the logic and information.

- DAOs and models are autogenerated along with the Database.

- H2 is a memory based database that will run automatically as well.

- Xml location can be found in /src/main/resources/*.xml

### Technology used
Java

Spring - application framework

XStream - Xml parser/marshaller

JOOQ - Query handler

JPA - Data management


### How to run

In root folder type in console - 
```
mvn spring-boot:run
```

### Sample logs
``` java
2016-01-23 03:54:51.717  INFO 21012 --- [           main] com.example.Main                         : [CustomerTbl (any_guid, alex, 26)]
2016-01-23 03:54:51.718  INFO 21012 --- [           main] com.example.Main                         : [CustomerInfoTbl (any_guid, COUNTRY, PH), CustomerInfoTbl (any_guid, CITY, MANILA)]
2016-01-23 03:54:51.807  INFO 21012 --- [           main] com.example.Main                         : map1: Customer{name='solo customer', age=26, other={country=PH, city=Makati}}
2016-01-23 03:54:51.828  INFO 21012 --- [           main] com.example.Main                         : map2: Customers{customers=[Customer{name='someone else', age=26, other={country=MY, city=Kuala Lumpur}}, Customer{name='someone else2', age=28, other={country=MY, city=Kuala Lumpur, municipal=Project 4}}]}
2016-01-23 03:54:51.833  INFO 21012 --- [           main] com.example.Main                         : [CustomerTbl (any_guid, alex, 26), CustomerTbl (ac8d8b3e-c12a-4780-bc29-a4e3854c1a19, solo customer, 26), CustomerTbl (629da520-6a0f-4a81-a7a4-b6003d0c7097, someone else, 26), CustomerTbl (91639ec4-efb5-46ce-9e2b-5f646f4e4f2a, someone else2, 28)]
2016-01-23 03:54:51.834  INFO 21012 --- [           main] com.example.Main                         : [CustomerInfoTbl (any_guid, COUNTRY, PH), CustomerInfoTbl (any_guid, CITY, MANILA), CustomerInfoTbl (ac8d8b3e-c12a-4780-bc29-a4e3854c1a19, COUNTRY, PH), CustomerInfoTbl (ac8d8b3e-c12a-4780-bc29-a4e3854c1a19, CITY, Makati), CustomerInfoTbl (629da520-6a0f-4a81-a7a4-b6003d0c7097, COUNTRY, MY), CustomerInfoTbl (629da520-6a0f-4a81-a7a4-b6003d0c7097, CITY, Kuala Lumpur), CustomerInfoTbl (91639ec4-efb5-46ce-9e2b-5f646f4e4f2a, COUNTRY, MY), CustomerInfoTbl (91639ec4-efb5-46ce-9e2b-5f646f4e4f2a, CITY, Kuala Lumpur), CustomerInfoTbl (91639ec4-efb5-46ce-9e2b-5f646f4e4f2a, MUNICIPAL, Project 4)]
```