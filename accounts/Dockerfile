#FROM ubuntu:latest
#LABEL authors="aatman"
#
#ENTRYPOINT ["top", "-b"]

# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Add Maintainer Info, Who manage the image
MAINTAINER aatman

# Copy the application's jar to the container
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

# Run the jar file (execute application)
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]


