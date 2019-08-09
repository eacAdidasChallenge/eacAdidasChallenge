CREATE TABLE subscription (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR (50),
  first_name VARCHAR (20),
  gender VARCHAR (10),
  date_of_bith DATE,
  consent TINYINT (1),
  id_newsletter INT (10),
  PRIMARY KEY(id)
);

INSERT INTO subscription (email, first_name, gender, date_of_bith, consent, id_newsletter)
VALUES ('enrique.adiego@externals.adidas.com','Enrique','Male','2019-08-08',1,999);

CREATE TABLE hibernate_sequence (
    sequence_name VARCHAR(255) NOT NULL,
    next_val INT(19),
    PRIMARY KEY (sequence_name)
);

INSERT INTO hibernate_sequence SET sequence_name='Clazz', next_val=2;