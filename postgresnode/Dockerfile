FROM postgres:15
MAINTAINER Armen Arzumanyan
WORKDIR /etc/postgresql/
COPY postgresql.conf postgresql.conf
CMD ["postgres", "-c", "config_file=/etc/postgresql/postgresql.conf"]
