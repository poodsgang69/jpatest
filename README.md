<h1>
Java Spring Boot Self Learning Repository
</h1>

# Project Title

![GitHub stars](https://img.shields.io/github/stars/poodsgang69/valo2)
![Twitter Follow](https://img.shields.io/twitter/follow/ChungusDevotee?style=social)

## 📜 Description

This is a simple CRUD project with integrations for Kafka, Spring Security, GitHub Actions (GHA), and Docker.

To run using Docker, use these commands:

```bash
# Build the Docker image
docker build -t poodsgang69/jpatest .

# Push the Docker image to the repository
docker push poodsgang69/jpatest:latest

# Run the Docker image
docker run -it --network image <docker_image>
```
Make sure to run docker ps to get the correct and latest image tag.

This project requires MySQL running as another image, but connected to the same network.

To run locally, change the datasource URL in the application.properties file from `mysql:3306/test` to `0.0.0.0:3306/test`.
