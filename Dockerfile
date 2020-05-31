# USING ALPINE JDK8 IMAGE
FROM openjdk:8-jre-alpine
MAINTAINER  saisiva_yenduri <saisiva.yenduri@gmail.com>

#COPYING jar into IMAGE
COPY target/spring-mysql-docker-1.0.0.jar /spring-mysql-docker-1.0.0.jar

#PORT
EXPOSE 8080

#RUN APPLICATION
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/spring-mysql-docker-1.0.0.jar"]

