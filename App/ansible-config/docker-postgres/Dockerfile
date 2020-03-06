FROM postgres:latest
MAINTAINER Oleg Vzukov

ENV POSTGRES_USER admin
ENV POSTGRES_PASSWORD admin

COPY ./docker-entrypoint-initdb.d/docker-entrypoint.sh /docker-entrypoint-initdb.d

USER root

EXPOSE 5432
CMD ["postgres"]
