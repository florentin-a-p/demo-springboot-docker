# docker commands

## create docker network
docker create mysql-network

## start mysql
docker run  \
-d \
--name ms \
--net mysql-network \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=password \
mysql

## start phpmyadmin
docker run \
-d \
--name phpmyadmin \
--net mysql-network \
-p 9080:80 \
-e MYSQL_ROOT_PASSWORD=password \
-e PMA_HOST=ms2 \
phpmyadmin
