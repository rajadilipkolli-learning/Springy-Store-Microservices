#!/usr/bin/env bash
## Author: Mohamed Taman
## version: v1.1

echo -e "Stopping [Springy Store] μServices ....\n\
---------------------------------------\n"
for port in 9080 9081 9082 9083
do
    echo "Stopping μService at port $port ...."
    curl -X POST localhost:${port}/actuator/shutdown
    echo -e "\nμService at port ${port} stopped successfully .... \n"
done

echo -e "\nStopping [Springy Store] Infrastructure Services....\n\
---------------------------------------\n"

# Check if Docker is running
if ! docker info > /dev/null 2>&1; then
    echo "Docker is not running. No infrastructure services to stop."
    exit 0
fi

# Stop infrastructure services using docker-compose
echo "Stopping MongoDB, MySQL, zipkin and RabbitMQ..."
docker compose down

echo -e "\nAll infrastructure services stopped successfully."
