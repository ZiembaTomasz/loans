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