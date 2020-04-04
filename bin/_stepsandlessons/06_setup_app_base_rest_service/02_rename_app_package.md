
# Rename Root SpringBoot Application
```
From: 
	src/main/java/com/aikiinc/coronavirus/DemoApplication.java
To: 
	src/main/java/com/aikiinc/coronavirus/CoronaVirusApp.java
```



# Create Class CornaVirusController

Here is the content:

```
package com.aikiinc.coronavirus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CornaVirusController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot Corona Virus!";
	}

}
```

* Explained
-----------------
```
In the directory src/com/aikiinc/springbootstarter, create a file:
HelloController.java
```

> <u>**Explained**</u> 
```
@RestController
```
> - [ ]  Define the class as a spring rest controller.
```
@RequestMapping("/")
```
> - [ ]  Define the endpoint for the rest service as the root path: /
> - [ ]  If we access the endpoint, return the message:    Greetings from Spring Boot Corona Virus!









