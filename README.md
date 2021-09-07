


# Initialization of the project

## https://alapaque.github.io/My-planning/

## Steps to reproduce  :

- run the following commands
    - `mvn clean install`
    - `start application pointing on MyPlanningApplication.class`
- make request to the url http://localhost:8081
- [Swagger documentation](http://localhost:8081/swagger-ui/index.html?configUrl=/myplanning-doc/swagger-config)
- if you want to generate a jwt token to perform queries use the below curl query
  `````bash
  curl -X 'POST' \
    'http://localhost:8081/auth/login' \
    -H 'accept: */*' \
    -H 'Content-Type: application/json' \
    -d '{
    "usernameOrEmail": "Administrateur",
    "password": "Administrateur"
  }'
  `````

## Technologies used :

<img src="https://e7.pngegg.com/pngimages/811/186/png-clipart-java-programming-programming-language-computer-programming-others-miscellaneous-text.png" height="100"> <img src="https://www.pngfind.com/pngs/m/53-535670_spring-framework-logo-spring-boot-hd-png-download.png" height="100"> <img src="https://e7.pngegg.com/pngimages/747/798/png-clipart-mysql-mysql-thumbnail.png" height="100"> <img src="https://e7.pngegg.com/pngimages/852/593/png-clipart-using-docker-developing-and-deploying-software-with-containers-application-software-software-deployment-computer-software-github-marine-mammal-logo.png" height="100">

## Libraries used :

```  
<dependencies>  
  
	<!-- SPRING BASE -->  
	<dependency>  
		 <groupId>org.springframework.boot</groupId>  
		 <artifactId>spring-boot-starter-web</artifactId>  
	</dependency>  
	<dependency>  
		 <groupId>org.springframework.boot</groupId>  
		 <artifactId>spring-boot-starter-data-jpa</artifactId>  
	</dependency>  
	<dependency>  
		 <groupId>org.springframework.data</groupId>  
		 <artifactId>spring-data-rest-hal-explorer</artifactId>  
	</dependency>  
	  
	<!-- EXCEPTIONS -->  
	<dependency>  
		 <groupId>org.apache.velocity</groupId>  
		 <artifactId>velocity-tools</artifactId>  
		 <version>2.0</version>  
	</dependency>  
	  
	<!-- SECURITY includes Bcrypt -->  
	<dependency>  
		 <groupId>org.springframework.boot</groupId>  
		 <artifactId>spring-boot-starter-security</artifactId>  
	</dependency>  
	  
	<!-- TESTING -->  
	<dependency>  
		 <groupId>org.springframework.boot</groupId>  
		 <artifactId>spring-boot-starter-test</artifactId>  
		 <scope>test</scope>  
	</dependency>  
	  
	<!-- For Working with Json Web Tokens (JWT) -->  
	<dependency>  
		 <groupId>io.jsonwebtoken</groupId>  
		 <artifactId>jjwt</artifactId>  
		 <version>0.9.1</version>  
	</dependency>  
	<dependency>  
		 <groupId>javax.xml.bind</groupId>  
		 <artifactId>jaxb-api</artifactId>  
		 <version>2.3.0</version>  
	</dependency>  
	<dependency>  
		 <groupId>org.hibernate</groupId>  
		 <artifactId>hibernate-validator</artifactId>  
		 <version>6.0.13.Final</version>  
	</dependency>  
	  
	<!-- MYSQL -->  
	<dependency>  
		 <groupId>mysql</groupId>  
		 <artifactId>mysql-connector-java</artifactId>  
		 <scope>runtime</scope>  
	</dependency>  
	  
	<!-- MAPSTRUCT -->  
	<!-- USED TO TRANSFORM DTO TO ENTITY OR ENTITY TO DTO -->
	<dependency>  
		 <groupId>org.mapstruct</groupId>  
		 <artifactId>mapstruct</artifactId>  
		 <version>1.4.2.Final</version>  
	</dependency>  
	<!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor -->  
	<dependency>  
		 <groupId>org.mapstruct</groupId>  
		 <artifactId>mapstruct-processor</artifactId>  
		 <version>1.4.2.Final</version>  
	</dependency>  

	<!-- SWAGGER -->  
	<!-- https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-annotations -->  
	<dependency>  
		 <groupId>io.swagger.core.v3</groupId>  
		 <artifactId>swagger-annotations</artifactId>  
		 <version>2.1.10</version>  
	</dependency>  
	<dependency>  
		 <groupId>io.swagger</groupId>  
		 <artifactId>swagger-models</artifactId>  
		 <version>1.6.2</version>  
	</dependency>  
	<dependency>  
		 <groupId>org.springdoc</groupId>  
		 <artifactId>springdoc-openapi-ui</artifactId>  
		 <version>1.5.10</version>  
	</dependency>  
	<dependency>  
		 <groupId>com.fasterxml.jackson.core</groupId>  
		 <artifactId>jackson-annotations</artifactId>  
	</dependency>  
	<dependency>  
		 <groupId>javax.validation</groupId>  
		 <artifactId>validation-api</artifactId>  
	</dependency>  
	<!-- https://mvnrepository.com/artifact/org.threeten/threetenbp -->  
	<dependency>  
		 <groupId>org.threeten</groupId>  
		 <artifactId>threetenbp</artifactId>  
		 <version>1.5.1</version>  
	</dependency> 
</dependencies>
```