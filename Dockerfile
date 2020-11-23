FROM openjdk:8
ADD target/docker-web-test.jar docker-web-test.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-web-test.jar"]