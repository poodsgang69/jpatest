<h1>
Java Spring Boot Self Learning Repository
</h1>

# JPATest
This is a simple CRUD project with integrations for Kafka, Spring Security, GitHub Actions (GHA), and Docker.

![GitHub stars](https://img.shields.io/github/stars/poodsgang69/valo2)
![Twitter Follow](https://img.shields.io/twitter/follow/ChungusDevotee?style=social)

## 📜 Description (To Run Locally)
Pre-Requisites:
1) Java 17
2) Gradle (Optional)
3) MySql 8.3.0 (Local Installation)

To run locally:
1) Clone the project
2) Download dependencies (From the Gradle Tab IntelliJ).
3) Clean build using gradle wrapper: `./gradlew clean build`
4) Run using gradle wrapper: `./gradlew bootrun`

### Note: 
If you don't have a local installation of MySQL, you can pull an image from docker hub using this command:
```bash
$ docker run --name <sql_image_name> --network <network_name> -e MYSQL_ROOT_PASSWORD=<pwd> -d mysql:8.3.0
```

Then configure another mysql container instance and runs the mysql command line client against your original mysql container, allowing you to execute SQL statements against your database instance:
```bash
$ docker run -it --network <network_name> --rm mysql mysql -h<sql_image_name> -uroot -p<pwd>
```
Note: If we did not define a username while pulling the image, the default username will be root. You can check this in the container logs: `docker logs <container_id>`
Note: Make sure you create a network first before adding --network in the commads. You can create a network by using the following commands:

```bash
# Check for current networks
$ docker network ls

# Create the network
$ docker create network <network_name>

# Connect an already running container to a network
$ Docker network connect <network name> <image/container name>
``` 

## 📜 Description (To Run Using Docker)
To run using Docker, use these commands:

```bash
# Build the Docker image
docker build -t poodsgang69/jpatest .

# Push the Docker image to the repository
docker push poodsgang69/jpatest:latest

# Run the Docker image
docker run -it --network image -p 7070:7070 <docker_image>
```
To check the network configuration: `docker inspect <container_id>`

This is how the Network properties should be configured (if we expose our port as 7070)

![image](https://github.com/poodsgang69/jpatest/assets/96367679/f800049d-ecc7-4ea0-9aa7-ab5a334ac26d)

Make sure to run `docker ps` to get the correct and latest image tag.

This project requires MySQL running as another image, but connected to the same network.

To run locally, change the datasource URL in the application.properties file from `mysql:3306/test` to `0.0.0.0:3306/test`.
