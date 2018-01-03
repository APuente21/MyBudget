CREATE DATABASE MyBudget;
USE MyBudget;

DROP TABLE IF EXISTS BUDGET_ENTRIES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS CATEGORIES;


CREATE TABLE USERS (
    ID INT NOT NULL AUTO_INCREMENT
    , FIRST_NAME VARCHAR(25) NOT NULL
    , LAST_NAME VARCHAR(25) NOT NULL
    , EMAIL VARCHAR(30) NOT NULL
 	, PASSWORD VARCHAR(16) NOT NULL
 	, PHONE_NUMBER VARCHAR(100) NOT NULL
    , UNIQUE UQ_BOOK_1 (FIRST_NAME, LAST_NAME)
    , UNIQUE UQ_BOOK_2 (PHONE_NUMBER)
    , PRIMARY KEY (ID)
);

CREATE TABLE CATEGORIES (
    ID INT NOT NULL AUTO_INCREMENT
    , NAME VARCHAR(50) NOT NULL
    , UNIQUE UQ_CATEGORIES_1 (NAME)
    , PRIMARY KEY (ID)
);

CREATE TABLE BUDGET_ENTRIES (
    ID INT NOT NULL AUTO_INCREMENT
    , USER_ID INT NOT NULL
    , CATEGORY_ID INT
    , AMOUNT BIGINT NOT NULL
    , ENTRY_DATE DATE NOT NULL
    , PRIMARY KEY (ID)
    , CONSTRAINT FK_BUDGET_ENTRIES_1 FOREIGN KEY (USER_ID)
     	REFERENCES USERS (ID) 
    , CONSTRAINT FK_BUDGET_ENTRIES_2 FOREIGN KEY (CATEGORY_ID)
     	REFERENCES CATEGORIES (ID) 
);