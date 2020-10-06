FROM openjdk:11
EXPOSE 8080
ADD /target/kalamba-0.0.1-SNAPSHOT.jar kalamba.jar
ENTRYPOINT ["java", "-jar", "kalamba.jar"]