FROM amazoncorretto:17.0.7-alpine
VOLUME /tmp
ARG JAR_FILE=target/validator-0.0.1-SNAPSHOT.jar    
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]