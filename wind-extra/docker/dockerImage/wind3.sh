#!/bin/bash

#docker build -t wind3-mysql ./wind3Mysql
#docker build -t wind3-redis ./wind3Redis
#
# docker run -itd --name wind3-d-redis -p 6379:6379 wind3-redis
# docker run -itd --name wind3-d-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 wind3-mysql

docker build -t wind ./dockerWind
docker rm wind -f
docker run -itd --name wind -p 80:80 -p 3306:3306 wind
