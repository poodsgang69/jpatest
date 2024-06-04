FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

COPY build.gradle settings.gradle ./
COPY src ./src

COPY gradlew ./
COPY gradle ./gradle

RUN chmod +x gradlew

RUN ./gradlew build

COPY build/libs/*.jar /app/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]