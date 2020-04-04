# Configure The Default Security Setup
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

By default 'spring-boot-starter-security' provides basic authentication, the Authentication gets enabled for the Application. Also, basic formLogin and logout are provided by this security setup. It will include the SecurityAutoConfiguration class.



When we start the Springboot application a default password is generated:

```
'Using generated security password: 29b5960e-37be-4b02-9459-bcdc7c40c749'
```



We can override the user name and password in the file: src/main/resources/application.properties. Define these values:

```
spring.security.user.name=user
spring.security.user.password=user
```



