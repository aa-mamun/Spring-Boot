# Database Migration using Flyway in Spring Boot

### Steps
The following steps illustrate how to configure flyway in spring boot

* Add bellow dependencies  to pom.xml

			<dependency>
				<groupId>mysql</groupId>
				<artifactId>mysql-connector-java</artifactId>
				<scope>runtime</scope>
			</dependency>

			<dependency>
				<groupId>org.flywaydb</groupId>
				<artifactId>flyway-core</artifactId>
			</dependency>
* Add migration scripts in db/migration directory
* Follow flyway naming convention from Flyway [Official Documention](https://flywaydb.org/documentation/migrations#naming)
* 


