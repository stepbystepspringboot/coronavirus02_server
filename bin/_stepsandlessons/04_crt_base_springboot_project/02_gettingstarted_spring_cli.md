# SpringBoot CLI Resource

All resources are from the official source:
```
https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html#getting-started-installing-the-cli
```



# Download SpringBoot CLI For Fedora

```
https://repo.spring.io/release/org/springframework/boot/spring-boot-cli/2.2.5.RELEASE/spring-boot-cli-2.2.5.RELEASE-bin.tar.gz
```

```
Unzip boot-cli-2.2.5.RELEASE-bin.tar.gz

I moved the created directory spring-2.2.5.RELEASE/ to my bin environment.
```



# Create a Script To Set SpringBoot CLI Environment

File: <mybindirectory>/bin/setspringcli
```
#!/bin/bash
SPRING_HOME=<mybindirectory>/spring-2.2.5.RELEASE
PATH=$SPRING_HOME/bin:$PATH:.
#----
export $SPRING_HOME
export $PATH
#----
clear
echo .
echo SPRING_HOME=$SPRING_HOME
echo .
echo PATH=$PATH
echo .
```



##  Init SpringBoot CLI Environment On Command Line

```
cd to a shell terminal environment.

Run springboo cli shell:
. setspringcli
```

```
We see:

SPRING_HOME=<mybindirectory>/spring-2.2.5.RELEASE
.
PATH=<mybindirectory>/spring-2.2.5.RELEASE/bin:<mybindirectory>/spring-2.2.5.RELEASE/bin:./:<mybindirectory>/jdk8/bin/:/home/pchauvet/.local/bin:/home/pchauvet/bin:/usr/share/Modules/bin:/usr/local/bin:/usr/local/sbin:/usr/bin:/usr/sbin:<mybindirectory>/bin:/home/pchauvet/.local/bin:/home/pchauvet/bin:.:.
.
```



# Check Installation

```
spring --version

We see:
    Spring CLI v2.2.5.RELEASE
```



## List Available Options
```
spring init --list

Supported dependencies
+--------------------------------------+--------------------------------------------------------------+-------------------------------+
| Id                                   | Description                                                  | Required version              |
+--------------------------------------+--------------------------------------------------------------+-------------------------------+
| activemq                             | Spring JMS support with Apache ActiveMQ 'Classic'.           |                               |
| h2                                   | Provides a fast in-memory database that supports JDBC API    |                               |
|                                      | and R2DBC access, with a small (2mb) footprint. Supports     |                               |
|                                      | embedded and server modes as well as a browser based console |                               |
|                                      | application.                                                 |                               |
| hateoas                              | Eases the creation of RESTful APIs that follow the HATEOAS   |                               |
|                                      | principle when working with Spring / Spring MVC.             |                               |
| mysql                                | MySQL JDBC and R2DBC driver.                                 |                               |
| oracle                               | A JDBC driver that provides access to Oracle.                | >=2.2.0.RC1                   |
| postgresql                           | A JDBC and R2DBC driver that allows Java programs to connect |                               |
|                                      | to a PostgreSQL database using standard, database            |                               |
|                                      | independent Java code.                                       |                               |
| web                                  | Build web, including RESTful, applications using Spring MVC. | web-services                  |
| webflux                              | Build reactive web applications with Spring WebFlux and      | websocket                     | 
Parameters
+-------------+------------------------------------------+------------------------------+
| Id          | Description                              | Default value                |
+-------------+------------------------------------------+------------------------------+
| artifactId  | project coordinates (infer archive name) | demo                         |
| bootVersion | spring boot version                      | 2.2.5.RELEASE                |
| description | project description                      | Demo project for Spring Boot |
| groupId     | project coordinates                      | com.example                  |
| javaVersion | language level                           | 1.8                          |
| language    | programming language                     | java                         |
| name        | project name (infean.AuthenticationBean;

| type        | project type                             | maven-project                |
| version     | project version                          | 0.0.1-SNAPSHOT               |
+-------------+------------------------------------------+------------------------------+
Project types (* denotes the default)
+-----------------+------------------------------------------+-----------------------------+
| Id              | Description                              | Tags                        |
+-----------------+------------------------------------------+-----------------------------+
| gradle-build    | Generate a Gradle build file.            | build:gradle,format:build   |
| gradle-project  | Generate a Gradle based project archive. | build:gradle,format:project |
| maven-build     | Generate a Maven pom.xml.                | build:maven,format:build    |
| maven-project * | Generate a Maven based project archive.  | build:maven,format:project  |
+-----------------+------------------------------------------+-----------------------------+

```