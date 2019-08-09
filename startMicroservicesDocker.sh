#!/bin/sh

echo "Welcome to Adiego Adidas Challenge (08-2019)"

echo "\nCreating Docker images..."

docker build -t adiego/config-service:1.0.0 ./config-service
if [ $? -gt 0 ]
then
    echo "\nconfig-server image creation failed. Please check the errors :("
    exit 1;
fi

docker build -t adiego/eureka-service:1.0.0 ./eureka-service
if [ $? -gt 0 ]
then
    echo "\neureka-server image creation failed. Please check the errors :("
    exit 1;
fi

docker build -t adiego/auth-server:1.0.0 ./auth-server
if [ $? -gt 0 ]
then
    echo "\nsecurity-server image creation failed. Please check the errors :("
    exit 1;
fi

docker build -t adiego/api-gateway:1.0.0  ./api-gateway
if [ $? -gt 0 ]
then
    echo "\nzuul-server image creation failed. Please check the errors :("
    exit 1;
fi

docker build -t mysql-db ./mysql-db
if [ $? -gt 0 ]
then
    echo "\nmysql image creation failed. Please check the errors :("
    exit 1;
fi

docker build -t adiego/subscription-data-service:1.0.0  ./subscription-data-service
if [ $? -gt 0 ]
then
    echo "\nsubscription-data image creation failed. Please check the errors :("
    exit 1;
fi

docker build -t adiego/subscription-mail-service:1.0.0  ./subscription-mail-service
if [ $? -gt 0 ]
then
    echo "\nsubscription-mail image creation failed. Please check the errors :("
    exit 1;
fi

docker build -t adiego/subscription-service:1.0.0 ./subscription-service
if [ $? -gt 0 ]
then
    echo "\nsubscription image creation failed. Please check the errors :("
    exit 1;
fi

docker-compose up --no-start

echo "\nDocker images and its containers created!"