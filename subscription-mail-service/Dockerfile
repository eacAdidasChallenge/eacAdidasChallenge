FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/subscription-mail-service-${version}.jar /subscription-mail-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /subscription-mail-service.jar
