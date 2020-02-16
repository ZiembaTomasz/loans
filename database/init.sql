create database customer;
use customer;

CREATE TABLE customer(
    pesel VARCHAR(11),
    first_name TEXT,
    surname TEXT,
    credit_id INTEGER,

    PRIMARY KEY (pesel)
);

INSERT INTO customer VALUES ('89051425693', 'Jan', 'Kowalski', 1212);

create database credit;
use credit;

CREATE TABLE credit(
    id INTEGER,
    credit_name TEXT,

    PRIMARY KEY (id)
);

create database product;
use product;

CREATE TABLE product(
    credit_name VARCHAR(100),
    value INTEGER,
    credit_id INTEGER,

    PRIMARY KEY (credit_name)
);