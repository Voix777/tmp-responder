# we will use openjdk
FROM amazoncorretto:11-al2023-jdk

# copy the packaged jar file into our docker image
COPY build/libs/responder-0.0.1-SNAPSHOT.jar /responder-0.0.1-SNAPSHOT.jar

# expose port
EXPOSE 8080
# set the startup command to execute the jar
ENTRYPOINT ["java", "-jar", "/responder-0.0.1-SNAPSHOT.jar"]