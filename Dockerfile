FROM eclipse-temurin:17-jdk-focal

WORKDIR /app

#COPY build.gradle settings.gradle ./
#COPY src ./src
#
#COPY gradlew ./
#COPY gradle ./gradle

COPY . /app

RUN chmod +x gradlew

RUN ./gradlew build

#RUN pwd
#RUN ls -lrt

COPY build/libs/*.jar /app/build/libs/

#RUN ls -lrt /app/build/libs/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/jpatest-0.0.1-SNAPSHOT.jar"]