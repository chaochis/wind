FROM alpine:latest
LABEL version='1.0' description='该镜像是风旅博客的前端镜像' by='刘超/chaochis'
ENV version='1.0'
VOLUME '/home/wind'
EXPOSE 80
RUN echo http://mirrors.aliyun.com/alpine/v3.10/main/ > /etc/apk/repositories && \
    echo http://mirrors.aliyun.com/alpine/v3.10/community/ >> /etc/apk/repositories
RUN apk update && apk upgrade
RUN apk add --no-cache nodejs
RUN apk add --no-cache npm
RUN apk add --no-cache git
RUN apk add --no-cache nginx
ADD config/nginx.conf /etc/nginx/conf.d/
RUN useradd -ms /bin/bash wind
USER wind
WORKDIR /home/wind
