#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    create database file_manager;
    create schema file_manager authorization admin;
    grant all privileges on database file_manager to admin;

    create table if not exists file_manager.account
    (
        id   serial      not null,
        name varchar(30) not null,
        pass varchar(30) not null,
        constraint account_pk
            primary key (id)
    );

    create table if not exists file_manager.file
    (
        id             serial      not null,
        name           varchar     not null,
        extension      varchar(10) not null,
        path           varchar     not null,
        id_user_upload integer     not null,
        date_upload    date        not null,
        constraint file_pk
            primary key (id),
        constraint file_account_id_fk
            foreign key (id_user_upload) references file_manager.account,
        constraint fkb8h62dvqicg4ia2rhi3n8400j
            foreign key (id_user_upload) references file_manager.account
    );
EOSQL
