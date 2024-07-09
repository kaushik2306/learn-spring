CREATE TABLE Category (
ID INT not null AUTO_INCREMENT,
Name varchar(255),
PRIMARY KEY ( ID )
);

CREATE TABLE SubCategory(
    ID INTEGER not null AUTO_INCREMENT,
    Name varchar(255),
    CATEGORY_ID INTEGER not null,
    PRIMARY KEY ( ID ),
    FOREIGN KEY ( CATEGORY_ID ) REFERENCES Category (ID)
);

CREATE TABLE Product (
    ID INT not null AUTO_INCREMENT,
    Name varchar(255),
    SUB_CATEGORY_ID INTEGER not null,
    PRIMARY KEY ( ID ),
    FOREIGN KEY ( SUB_CATEGORY_ID ) REFERENCES SubCategory ( ID )
);


