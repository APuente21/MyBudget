DROP TABLE IF EXISTS BUDGET_ENTRIES;
DROP TABLE IF EXISTS CATEGORIES;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PHONES;

CREATE TABLE PHONES (
    ID INT NOT NULL AUTO_INCREMENT
    , COUNTRY_CODE VARCHAR(5) NOT NULL
    , AREA_CODE VARCHAR(3) NOT NULL
    , NUMBER VARCHAR(7) NOT NULL
    , UNIQUE UQ_PHONES_1 (COUNTRY_CODE, AREA_CODE, NUMBER)
    , PRIMARY KEY (ID)
);

CREATE TABLE USERS (
    ID INT NOT NULL AUTO_INCREMENT
    , FIRST_NAME VARCHAR(25) NOT NULL
    , LAST_NAME VARCHAR(25) NOT NULL
    , EMAIL VARCHAR(30) NOT NULL
 	, PASSWORD VARCHAR(16) NOT NULL
 	, PHONE_ID INT NOT NULL
    , UNIQUE UQ_USERS_1 (FIRST_NAME, LAST_NAME)
    , PRIMARY KEY (ID)
    , FOREIGN KEY (PHONE_ID)
        REFERENCES PHONES (ID)
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
    , DESCRIPTION VARCHAR(50) NOT NULL
    , AMOUNT DOUBLE NOT NULL
    , ENTRY_DATE DATE NOT NULL
    , PRIMARY KEY (ID)
    , FOREIGN KEY (USER_ID) REFERENCES USERS (ID) 
    , FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES (ID) 
);
