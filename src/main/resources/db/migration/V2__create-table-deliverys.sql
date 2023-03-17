CREATE TABLE deliverys (
        ID BIGINT NOT NULL AUTO_INCREMENT,
        CLIENT_ID BIGINT NOT NULL,
        RATE DECIMAL(10,2) NOT NULL,
        STATUS VARCHAR(20) NOT NULL,
        ORDERDATE DATETIME NOT NULL,
        FINISHEDDATE DATETIME,

        recipient_name VARCHAR(60) NOT NULL,
        recipient_street VARCHAR(255) NOT NULL,
        recipient_number VARCHAR(30) NOT NULL,
        recipient_complement VARCHAR(255),
        recipient_neighborhood VARCHAR(255) NOT NULL,

        PRIMARY KEY(ID)
);

ALTER TABLE deliverys ADD CONSTRAINT fk_delivery_client FOREIGN KEY (client_id) REFERENCES clients (id);