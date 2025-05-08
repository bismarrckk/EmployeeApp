
###Database Setup###

install xampp which will provide a mysql database server for this project
start apache and MySql in the xampp server
Navigate to localhost/phpmyadmin and create a database named employeedb
Import the sql file named employeedb.sql located in the database folder
Create a new user named bizz with password= 12345 and grant all priviledges
This will later be used to connect the application server with the database server



###Payara Server Setup###

Download and install payara server
Start CMD as administrator and navigate to the bin installation folder of payara 
Type asadmin start-domain command to start the server.


###Set up netbeans project###

Download and install netbeans
Start netbeans, navigate to file and click on import project and choose the zip file you downloaded(EmployeeApp.zip)
Navigate to services tab under servers, add payara server
The glassfish-resources.xml will provide server side configurations for payara
The persistence.xml file will provide application level configurations
Run the project