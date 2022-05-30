1.安装redis

执行sudo apt-get install -y redis-server

2.修改配置文件

首先执行这个命令: vim /etc/redis/redis.conf

>找到bind 127.0.0.1 ::1，把这行前面加个#注释掉
再查找protected-mode yes 把yes修改为no

3.重启redis服务

systemctl restart redis-server.service
