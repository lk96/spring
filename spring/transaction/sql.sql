CREATE TABLE account (
  id number NOT NULL ,
  name varchar(20) NOT NULL,
  money number DEFAULT NULL,
  PRIMARY KEY (id)
) 
INSERT INTO account VALUES ('1', 'aaa', '1000');
INSERT INTO account VALUES ('2', 'bbb', '1000');
INSERT INTO account VALUES ('3', 'ccc', '1000');