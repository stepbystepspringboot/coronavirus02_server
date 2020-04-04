# Create A Project Using Springboot CLI

```
cd <workspacedir>

. setspringcli

spring init --build=maven --java-version=1.8 --dependencies="web" --packaging=jar --groupId=com.aikiinc --artifactId=coronavirus --version=0.0.1-RELEASE coronavirus.zip 
```

> <u>**Explained**</u> 
> spring init: Use spring cli to initialize a project
>
> - [ ]  . setspringcli: Initialize the spring CLI configuration
> - [ ] --build=maven: Use maven to build our project
> - [ ] --java-version=1.8: Use java version 1.8
> - [ ] --dependencies=web: Create a web application
> - [ ] --packaging=jar: The project will be packaged as a jar
> - [ ] --groupId=com.aikiinc: Maven group id for the target project
> - [ ] --artifactId=coronavirus: Maven artifactId for the target project
> - [ ] --version=0.0.1-RELEASE: Maven version for the target project
> - [ ] coronavirus.zip: The file name for the create Springboot project



# Extract Zip File To A Directory

Extract zip coronavirus.zip to directory called: coronavirus.

This will be our maven project directory.



# View The Generate Project Files
```
cd coronavirus

mvnw
mvnw.cmd
pom.xml
/src/main/java/com/aikiinc/coronavirus/DemoApplication.java
/src/main/resources/application.properties
/src/main/resources/static
/src/main/resources/templates
/src/test/java/com/aikiinc/coronavirus/DemoApplicationTest.java
/target
```


> <u>**Explained**</u> 
> This is the basic structure setup for a Springboot maven project



# View Project pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.5.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.aikiinc</groupId>
	<artifactId>coronavirus</artifactId>
	<version>0.0.1-RELEASE</version>
	<name>demo</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```


> <u>**Explained**</u> 
> We see the spring-boot-starter-security dependency:
> 	<dependency>
> 		<groupId>org.springframework.boot</groupId>
> 		<artifactId>spring-boot-starter-security</artifactId>
> 	</dependency>
>
> ​	Spring Boot automatically secures all HTTP endpoints with "basic" authentication.
>
> 
>
> We see the spring-boot-starter-web  dependency:
> 	<dependency>
> 		<groupId>org.springframework.boot</groupId>
> 		<artifactId>spring-boot-starter-web</artifactId>
> 	</dependency>




# Run the Project

```
cd coronavirus

mvn clean install

mvn spring-boot:run
```



## Open browser to:
```
http://localhost:8080/
```

> <u>**Explained**</u> 
> We see an error page since there is no service or template page.
> 
> What we have is a starter project for Springboot.



