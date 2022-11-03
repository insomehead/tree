CREATE SEQUENCE NODE_SEQ START WITH 0 INCREMENT BY 1;

CREATE TABLE NODE (
    ID INTEGER,
    PARENT_ID INTEGER,
    NAME VARCHAR(30),
    IP VARCHAR(30),
    PORT VARCHAR (30)
);

ALTER TABLE NODE ADD CONSTRAINT NODE_ID_PK PRIMARY KEY (ID);
ALTER TABLE NODE ADD CONSTRAINT NODE_PARENT_ID_FK FOREIGN KEY (PARENT_ID) REFERENCES NODE(ID) ON DELETE CASCADE;
