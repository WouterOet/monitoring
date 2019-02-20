FROM openjdk:jre-slim
VOLUME /tmp
ADD target/app.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]