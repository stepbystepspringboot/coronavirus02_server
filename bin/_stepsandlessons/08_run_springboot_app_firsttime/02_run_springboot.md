# Run The Springboot Application

```
cd <workspace>/coronavirus02_view_jhipster_basicauth_login

mvn spring-boot:run
```

> <u>**Explained**</u> 
> mvn: Use the maven command
> spring-boot:run: Target the maven lifecycle phase for springboot


# See The Springboot Application In The Browser

```
Open browser to: http://localhost:8080/

```

> <u>**Explained**</u> 
> We see the error page for spring boot:
> 	"Whitelabel Error Page".
>
> Why?
> 	There is no implementation  to the root path: /.



## Use the /greeting endpoint

http://localhost:8080/greeting

> ```
> <u>**We see:**</u> 
> ```
> {"id":5,"content":"Hello, World!"}
> 
> Refresh the browser and see the id incremented safely:
> {"id":6,"content":"Hello, World!"}
> 



## Add a parameter to the /greeting endpoint: 

http://localhost:8080/greeting?name=Sponge%20Bob


> ```
> <u>**We see:**</u>
> ```
> {"id":7,"content":"Hello, Sponge Bob!"}
> 
> Refresh the browser and see the id incremented safely:
> {"id":8"content":"Hello, Sponge Bob!"}

