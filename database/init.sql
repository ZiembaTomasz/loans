create database customer;
use customer;

CREATE TABLE customer(
    pesel VARCHAR(11),
    first_name TEXT,
    surname TEXT,
    credit_id INTEGER,

    PRIMARY KEY (pesel)
);

INSERT INTO customer VALUES ('89051425693', 'Jan', 'Kowalski', 1);
INSERT INTO customer VALUES ('84102475325', 'Joanna', 'Witkowska', 2);
INSERT INTO customer VALUES ('70071724933', 'Kazimierz', 'Janowski', 3);

create database credit;
use credit;

CREATE TABLE credit(
    id INTEGER AUTO_INCREMENT,
    credit_name TEXT,

    PRIMARY KEY (id)
);

INSERT INTO credit VALUES (1, "Axel Credit");
INSERT INTO credit VALUES (2, "Maven Credit");
INSERT INTO credit VALUES (3, "Gradle Credit");

create database product;
use product;

CREATE TABLE product(
    product_name VARCHAR(50),
    value INTEGER,
    credit_id INTEGER,

    PRIMARY KEY (product_name)
);

INSERT INTO product VALUES ("Fast Loan", 2000, 1);
INSERT INTO product VALUES ("Extra Loan", 3000, 2);
INSERT INTO product VALUES ("Free Loan", 5000, 3);

