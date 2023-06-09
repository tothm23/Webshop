# Webshop
JAX-RS Web Application with Maven in Netbeans

# Tools
 - Apache Netbeans 18
 - WildFly Application Server 26.1.1 (WildFly Preview EE 9.1 Distribution)
 - MySQL Connector 8.0.28
 - Postman
 - XAMPP 8.0.28

# Project Structure
|Folder or File|Description|
|--------------|-----------|
|`src/man/java`|Contains the Java source code for the application|
|`src/man/resources`|Resource files such as configuration files (**`persistence.xml`**) or database scripts can be stored in this directory|
|`src/main/webapp`|Contains the files and resources of the web application (**`index.html`**)|
|`src/test/java`|It's used for testing|
|`pom.xml`|This is a Maven project file that contains the project's configuration and dependencies|

|Package|Description|
|-------|-----------|
|`com.webshop.Config`|Contains the token class|
|`com.webshop.Controller`|Contains the controllers classes|
|`com.webshop.Exception`|Contains the custom exception classes|
|`com.webshop.Model`|Entities must be generated here|
|`com.webshop.Service`|Contains the service classes and methods|

# Create Project
1. New Project > Java with Maven > Web Application
2. Opcional: Project Name, Project Location, Group Id, Version, Package
3. Use WildFly Application Server 26.1.1 with Java EE 7 Web

# Create persistence.xml
1. New > Persistence > Persistence Unit 
2. Optional: Persistence Unit Name
3. Persistence Library: EclipseLink (JPA2.2)
4. Database Connection: Database Connection from Services
5. Table Generation Strategy: None

# Create Endpoints
1. New > Web Services > RESTfull web services from Patterns
2. Simple Root Resource
3. Resource Package > com.webshop.Config
4. Optional: Patch, Class Name, MIME Type

# Create JDBC Driver manually (file system)
1. Open the **modules/system/layers/base/com**
2. Open the **mysql** folder (If it doesn't exist, create it)
3. Create **main** directory and open it
4. Paste the **MySQL connector file** here
5. Create **module.xml** file and add this lines (replace the **path** section)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.5" name="com.mysql"> 
    <resources>
        <resource-root path="./mysql-connector-java-8.0.28.jar"/>   
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
```

# Create JDBC Driver graphically (admin console)
1. Open WildFly Admin Console > Configuration > Subsystems > Datasources & Drivers > JDBC Drivers > Add
2. Fill the form:
Driver Name: mysql
Driver module Name: com.mysql
Driver Class name: com.mysql.cj.jdbc.Driver
3. Add

# Create Datasource manually (file system)
1. Open the **standalone/configuration/standalone-full.xml** file
2. Add this lines and replace the **MyDataSource**, **mydatabase**, **user-name** and **password** section
```xml
<datasource jndi-name="java:/jdbc/MyDataSource" pool-name="MyDataSource" enabled="true" use-java-context="true">  
	<connection-url>jdbc:mysql://localhost:3306/mydatabase</connection-url>  
	<driver>mysql</driver>  
	<security>  
		<user-name>username</user-name>  
		<password>password</password>  
	</security>  
</datasource>

<driver name="mysql" module="com.mysql">
    <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
</driver>
```

# Create Datasource graphically (admin console)
1. Open WildFly Admin Console > Configuration > Subsystems > Datasources & Drivers > Datasources > Add Datasource
2. Choose Template: MySQL
3. Attributes
 - Name: database_name
 - JNDI Name: java:/jdbc/database_name
4. JDBC Driver
 - Driver name: mysql
 - Driver Module Name: com.mysql
 - Driver Class Name: com.mysql.cj.jdbc.Driver
5. Connection
 - Connection URL: jdbc:mysql://localhost:3306/database_name
 - User Name: username
 - Password: password
6. Test Connection
7. Review

# Pay attention to these!

## pom.xml
 - Find and insert all **dependencies**!
 - Always check the **groupId** in **pom.xml**!

## persistence.xml
 - Persistence unit Name is optional
 - The Persistence Provider is always **Hibernate (JPA 2.1)(default)** or EclipseLink (JPA 2.2)(default)!

## Stored procedures
 - When calling the stored procedure, check the **Persistence Unit** name!
 - Check the stored procedure name!
 - Always check the parameter **types**, **counts**, **names**, mode(**IN**, **OUT**)
 - Always register also the **OUT** parameters

## Postman
- In the POST Request JSON raw's **names** must equal the Entity classes **field names**

## Other
- Add `@JsonIgnoreProperties(ignoreUnknown = true)` annotation to Entity classes

# Solve the errors!

## XAMPP

### Problem
Start the Apache2 server and the error is "Another web service is running"

### Solution
 - Go Netbeans > Services > Servers
 - Right click the WildFl Application Server > **Kill Server**
 - Go Netbeans > Services > Internal Wenserver
 - Right click > **Stop**

## Wildfly

### Problem
Start the WildFly Server and it want to deploy a project with error and it can't start 

### Solution
 - Open **standalone/deployments** folder
 - Delete All Directory and file (except the **README.txt**)
 - Open **standalone/configuration/standalone-full.xml** file
 - At the bottom, remove **deployment section**