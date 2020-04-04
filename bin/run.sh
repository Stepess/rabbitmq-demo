#!/bin/bash

echo "Persist RabbitMQ data to '$(pwd)/rabbitmq-data'"

docker run --rm -d --hostname rabbit -p 5672:5672 -p 8081:15672 \
        -v $(pwd)/rabbitmq-data:/var/lib/rabbitmq \
        --name rabbitmq rabbitmq:3-management
