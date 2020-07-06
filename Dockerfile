FROM openjdk:15-ea-10-jdk-alpine
WORKDIR /usr/myapp
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw package -DskipTests
RUN cd ./target
EXPOSE 8080
ENTRYPOINT ["java","-jar", "./target/storage-v1.jar"]