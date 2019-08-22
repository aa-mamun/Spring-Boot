# Spring HATEOAS demo


* Hypermedia is an important aspect of REST
* hypermedia-driven REST service with Spring HATEOAS, a library of APIs that helps to easily create links pointing to Spring MVC controllers

* Dependency required

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-hateoas</artifactId>
            </dependency>
* Response

         {
            "content":"Hello, User!",
            "_links":{
              "self":{
                "href":"http://localhost:8080/user?name=User"
              }
            }
          } 
* Response demonstrates that the @RequestParam arrangement in RootController is working as expected. The name parameter has been given a default value of "User", but can always be explicitly overridden through the query string.