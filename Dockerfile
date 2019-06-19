FROM openjdk:8-jdk-alpine
WORKDIR /usr/local
VOLUME /tmp
RUN mkdir app && mkdir app/config && mkdir app/logs
COPY target/*.jar app/app.jar
ENTRYPOINT ["java", "-jar", "app/app.jar"]