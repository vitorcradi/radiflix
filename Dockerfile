FROM maven:3.5.2-jdk-8
COPY /target/radiflix-0.0.1.jar /artifact
WORKDIR /artifact
ENTRYPOINT ["java", "-jar", "radiflix-0.0.1.jar"]