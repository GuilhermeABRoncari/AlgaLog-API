CREATE TABLE CLIENTS (
        ID BIGINT NOT NULL AUTO_INCREMENT,
        NAME VARCHAR(255) NOT NULL,
        EMAIL VARCHAR(255) NOT NULL UNIQUE,
        FONE VARCHAR(20),

        PRIMARY KEY(ID)
);