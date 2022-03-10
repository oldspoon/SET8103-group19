FROM openjdk:latest
COPY ./target/seMethods-1.0.1.2-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar" ,"seMethods-1.0.1.2-jar-with-dependencies.jar"]