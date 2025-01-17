# Stage 1: Build the application
FROM maven AS build
WORKDIR /app

COPY pom.xml /app/
COPY src /app/src/

RUN mvn clean install -DskipTests


# Stage 2: Run the application
FROM openjdk:24-jdk AS runtime
WORKDIR /app

ARG PROJECT_VERSION=0.0.1
COPY --from=build /app/target/Docker-Example-${PROJECT_VERSION}.jar /app/Docker-Example.jar

EXPOSE 8080
CMD ["java","-jar","/app/Docker-Example.jar"]

