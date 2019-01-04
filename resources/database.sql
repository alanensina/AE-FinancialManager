/*
 * Use this script to create the database used in this project.
 */

-- Creating the database:
create database aefm;

-- Selecting the database:
use aefm;

-- Creating the user's table:
create table user(
ID int not null auto_increment,
name varchar(255) not null,
surname varchar(255) not null,
login varchar(255) not null,
password varchar(255) not null,
phone varchar(255) not null,
email varchar(255) not null,
birthday varchar(255) not null,
profession varchar(255) not null,
active boolean not null,
admin boolean not null,

CONSTRAINT pk_user PRIMARY KEY (ID)
);

-- Creating the income's table:
create table income(
ID int not null auto_increment,
user int not null,
name varchar(255) not null,
description varchar(255) not null,
value double not null,
date varchar(255) not null,

CONSTRAINT pk_income PRIMARY KEY (ID),
CONSTRAINT fk_user FOREIGN KEY (user)
    REFERENCES user(ID)
);

-- Creating the expense's table:
create table expense(
ID int not null auto_increment,
user int not null,
name varchar(255) not null,
description varchar(255) not null,
value double not null,
date varchar(255) not null,

CONSTRAINT pk_expense PRIMARY KEY (ID),
CONSTRAINT fk_user_expense FOREIGN KEY (user)
    REFERENCES user(ID)
);

-- Creating the admin master:
insert into user values(1, 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', 'admin', true, true);

-- Checking the users:
select * from user;