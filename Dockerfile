FROM openjdk:17
EXPOSE 8081
ADD target/tagNtrac-application.jar
ENTRYPOINT ["java","-jar", "/tagNtrac-application.jar"]