#!/bin/sh

echo "\nStop Docker containers..."

docker stop config-service
if [ $? -gt 0 ]
then
    echo "\nconfig-server image stop failed. Please check the errors :("
    exit 1;
fi

docker stop eureka-service
if [ $? -gt 0 ]
then
    echo "\neureka-server image stop failed. Please check the errors :("
    exit 1;
fi

docker stop auth-server
if [ $? -gt 0 ]
then
    echo "\nsecurity-server image stop failed. Please check the errors :("
    exit 1;
fi

docker stop api-gateway
if [ $? -gt 0 ]
then
    echo "\nzuul-server image stop failed. Please check the errors :("
    exit 1;
fi

docker stop mysql-db
if [ $? -gt 0 ]
then
    echo "\nmysql image stop failed. Please check the errors :("
    exit 1;
fi

docker stop subscription-data-service
if [ $? -gt 0 ]
then
    echo "\nsubscription-data image stop failed. Please check the errors :("
    exit 1;
fi

docker stop subscription-mail-service
if [ $? -gt 0 ]
then
    echo "\nsubscription-mail image stop failed. Please check the errors :("
    exit 1;
fi

docker stop subscription-service
if [ $? -gt 0 ]
then
    echo "\nsubscription-service image stop failed. Please check the errors :("
    exit 1;
fi

echo "\nDocker containers stopped!"
