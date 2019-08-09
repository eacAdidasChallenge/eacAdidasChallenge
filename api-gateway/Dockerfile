FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
COPY target/api-gateway-${version}.jar /api-gateway.jar
ENV JAVA_OPTS ""
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /api-gateway.jar
