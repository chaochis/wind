#!/bin/bash

# 搭建docker私有仓库
docker pull registry:2
docker run -d -p 5000:5000 --restart=always --name docker-registry registry:2
#查看docker仓库镜像列表
curl http://localhost:5000/v2/_catalog
