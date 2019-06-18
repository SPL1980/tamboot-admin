FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir /usr/local/app
RUN mkdir /usr/local/app/config
RUN mkdir /usr/local/app/logs
COPY target/*.jar /usr/local/app/app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "${JAVA_OPTS}", "-jar","/usr/local/app/app.jar"]