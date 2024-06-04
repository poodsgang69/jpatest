FROM eclipse-temurin:17-jdk-focal
ADD /build/libs/jpatest-0.0.1-SNAPSHOT.jar jpatest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/jpatest-0.0.1-SNAPSHOT.jar"]



#WORKDIR /app
#
##COPY build.gradle settings.gradle ./
##COPY src ./src
##
##COPY gradlew ./
##COPY gradle ./gradle
#
#COPY . .
#
#RUN chmod +x gradlew
#
##RUN ./gradlew build
#
##RUN pwd
##RUN ls -lrt
#
#COPY /build/libs/*.jar ./
#
##RUN ls -lrt /app/build/libs/
#
#EXPOSE 8080
#
#ENTRYPOINT ["java", "-jar", "jpatest-0.0.1-SNAPSHOT.jar"]
#
#FROM mysql:8.3.0
#
#ENV MYSQL_ROOT_PASSWORD=root123