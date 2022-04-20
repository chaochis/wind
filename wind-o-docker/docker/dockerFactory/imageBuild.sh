#!/bin/bash

#制作wind3专属镜像
docker build -t windweb dockerWindWeb
docker tag windweb 127.0.0.1:5000/windweb
docker push 127.0.0.1:5000/windweb
docker rmi 127.0.0.1:5000/windweb

#docker rmi -f $(docker images -aq)

docker ps -a | grep "Exited" | awk '{print $1 }'|xargs docker stop
docker ps -a | grep "Exited" | awk '{print $1 }'|xargs docker rm
docker images|grep none|awk '{print $3 }'|xargs docker rmi
