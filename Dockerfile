FROM openjdk:8-jdk-alpine
WORKDIR /usr/local
VOLUME /tmp
RUN mkdir app && mkdir app/config && mkdir app/logs
COPY target/*.jar app/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "${JAVA_OPTS}", "-jar","app/app.jar"]