# adiegoAdidasChallenge - Code Challenge Doc

#### Summary
I defined an architecture based on spring cloud (+netflix +security) that can be robust.
The business microservices (3) have followed the rules indicated in the challenge (entry point + persistence + mailing + response).
All the MS are mavenized and dockerized with some scripts helping us to build / start / stop containers.
A postman collection has been exported to obtain the access info easily (and reproduce as success*).

*Note: Be care with the email data of the body because a mail will be sent en each success operation.


#### Technology
The stack technology is the following:
- Java 8
- Docker 0.22.1
- Spring Boot 2.1.2
- Spring Cloud 2 (Greenwich.RC2)
- Mysql latest


#### Libraries
- lombok
- swagger2 (springfox)
- spring-boot-email-core
- mysql-connector-java
- jwt-commons


#### Microservices
**gateway-service**				Gateway for routing and filtering.

**auth-server**					Authorization server using JWT.

**config-service**				Store and deliver config files for the applications.

**eureka-service**				Service discovery.

**subscription-service**		Main business microservice.

**subscription-data-service**	Microservice connected to mysql database for register subscriptions.

**subscription-mail-service**	Microservice used to send confirmation mails to the user.


#### Tools and third parties
**PC**
Install Git --> Version: 2.20.1.windows.1
*Configure to add environment variable for windows
Install Gradle --> Version 5.5.1
*Configure to add environment variable for windows
Install eclipse --> Version: 2019-06 (4.12.0)
*Configure --> Add this line to the .project file of the root folder: <nature>org.eclipse.jdt.core.javanature</nature>
Install Docker Desktop --> Version 2.1.0.0 (Win Pro 10 needed)
*Configure --> Settings/General: Expose daemon on tcp://localhost:2375 without TLS
*Configure --> Settings/Advanced: (increase if its necessary)
Install "Docker Tooling" from Eclipse marketplace (restart is mandatory)
*Configure --> In D.T. view: write a “Connection name” and use custom TCP connection settings http://localhost:2375 (docker must expose daemon)
Install "Spring Tool Suite 4" from Eclipse marketplace (restart is mandatory)
Install Cygwin for windows (for script shell)
Install Postman

**GMAIL**
Create account (eacadidaschallenge@gmail.com/a******19)
Obtain permissions for non secure access -external-.

**GITHUB**
Create account (eacAdidasChallenge/a********19) + email validation


#### Running apps
**COMMON ACTIONS FOR MS**
- Download / Clone the github repo.
- Maven over the root folder: "mvn clean package -DskipTests=true"
- Run over the root folder: "sh startMicroservices.sh"
- Docker start for each container in this order:
	docker start -a config-service
	docker start -a eureka-service 
	docker start -a auth-server 
	docker start -a mysql-db 
	docker start -a subscription-service 
	docker start -a subscription-data-service 
	docker start -a subscription-mail-service
	docker start -a api-gateway
- Execute the login query with the postman collection
- Copy the Bearer Authorization and add it to the subscription query
- Exeute the subscription query (you will receive the position of the record and a mail in the defined mailbox)
- Swagger can be checked: http://localhost:8080/swagger-ui.html
