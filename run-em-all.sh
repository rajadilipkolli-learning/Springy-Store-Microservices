#!/usr/bin/env bash
## Author: Mohamed Taman
## version: v4.3

echo -e "Starting [Springy Store] Infrastructure Services....\n\
---------------------------------------\n"

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "Docker is not running. Please start Docker and try again."
    exit 1
fi

# Start infrastructure services using docker-compose
echo "Starting MongoDB, MySQL, zipkin and RabbitMQ..."
docker compose up -d mongodb mysql zipkin rabbitmq
echo "Waiting for infrastructure services to be healthy..."
sleep 10

echo -e "\nStarting [Springy Store] μServices ....\n\
---------------------------------------\n"

function runService(){
   ./mvnw --quiet compile spring-boot:run -pl $1
}

for dir in `find  store-services/*-service -maxdepth 0 -type d`
do
    echo -e "Starting [$dir] μService.... \n" && \
    runService "$dir" &
done
