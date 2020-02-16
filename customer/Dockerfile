FROM openjdk:8-jre-alpine

COPY target/customer-0.0.1.jar /app.jar

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=local", "/app.jar"]