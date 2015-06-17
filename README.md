# ClaimStore
Implementation of Claims Web Service in Java.

Functionalities implemented are:
-Create a claim and storing.( input is XML.)
-Read a claim from the database
-list of claims in database by date range of LossDate.
-[optional] Update a claim in the backing store. (only jdbc code)
-[optional] Delete a claim from the backing store.

Technologies:
Web Services implemented using JAXWS
Database used MYSQL
For coversion between Java objects and xml used JAXB
Used xjc for  generating objects from XML schema

How to run:-
-Publish the WebService (HelloWorldWSPublisher.java):
   https://github.com/PayalGodse/ClaimStore/blob/master/JAXWSServer/src/com/mitchell/examples/webservice/HelloWorldWSPublisher.java
-Run the test located in client code:
   https://github.com/PayalGodse/ClaimStore/blob/master/JAXWSClient/src/com/mitchell/examples/webservice/MitchellClaimTest.java
   
Have executed all operations in one test only.
Modify https://github.com/PayalGodse/ClaimStore/blob/master/JAXWSServer/src/com/mitchell/examples/webservice/HelloWorldImpl.java
for execution of specific functionality.

