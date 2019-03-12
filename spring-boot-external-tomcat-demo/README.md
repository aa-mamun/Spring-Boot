# Run Spring Boot Application in External Tomcat

### Steps
The following steps illustrate how to configure spring boot app to run in external tomcat

* Add bellow dependency to pom.xml
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>

* Change packaging and define starter class
	<properties>
		  <packaging>war</packaging>
		  <start-class>com.mamun.springbootexternaltomcatdemo.SpringBootExternalTomcatDemoApplication</start-class>
	</properties>
	
* Modify initializer class as bellow
		@SpringBootApplication
		public class SpringBootExternalTomcatDemoApplication extends SpringBootServletInitializer {

			@Override
			protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
				return application.sources(SpringBootExternalTomcatDemoApplication.class);
			}
			
			public static void main(String[] args) {
				SpringApplication.run(SpringBootExternalTomcatDemoApplication.class, args);
			}

		}
		
