create database aefm;

use aefm;

create table user (
id int not null auto_increment,
name varchar(20) not null,
surname varchar(30) not null,
phone varchar(15) not null, 
email varchar(40) not null,
birthday varchar(10) not null,
username varchar(12) unique not null,
user_password varchar(12) not null,
profession varchar(80) not null,
active boolean default true,
CONSTRAINT PK_user PRIMARY KEY (id)
);

create table income(
id int not null auto_increment,
user int not null,
name varchar(30) not null,
description varchar(255) not null,
value double not null,
date varchar(10),
CONSTRAINT PK_income PRIMARY KEY (id),
CONSTRAINT FK_user_income FOREIGN KEY (user) REFERENCES user(id)
);

create table expense(
id int not null auto_increment,
user int not null,
name varchar(30) not null,
description varchar(255) not null,
value double not null,
date varchar(10),
CONSTRAINT PK_income PRIMARY KEY (id),
CONSTRAINT FK_user_expense FOREIGN KEY (user) REFERENCES user(id)
);
