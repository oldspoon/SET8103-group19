FROM openjdk:latest
COPY src/main/java/com/napier/sem /tmp/com
WORKDIR /tmp
ENTRYPOINT ["java", "com.napier.sem.App"]