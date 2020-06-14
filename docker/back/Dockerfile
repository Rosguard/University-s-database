FROM openjdk:11-jdk-alpine
EXPOSE 8080
#ENV SPRING_DATASOURCE_URL="jdbc:postgresql://172.17.0.1:5432/postgres"
WORKDIR /usr/app/back
COPY ./ ./
ADD target/BD-1.0-SNAPSHOT.jar BD-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "BD-1.0-SNAPSHOT.jar"]
