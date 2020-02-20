FROM mysql:5.7.29

ENV MYSQL_ROOT_PASSWORD my-password

RUN	mkdir /usr/sql
RUN	chmod 644 /usr/sql

ADD init.sql /docker-entrypoint-initdb.d