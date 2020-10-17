FROM openjdk:8-jdk-slim
# Create app directory.
RUN mkdir -p /app/
# Set app directory.
WORKDIR /app

COPY "./build/libs/java-spring-lawyer.jar" "java-spring-lawyer.jar"
COPY "./build/resources/main/application.properties" "application.properties"

EXPOSE 8080
ENTRYPOINT ["java","-jar","java-spring-lawyer.jar"]
