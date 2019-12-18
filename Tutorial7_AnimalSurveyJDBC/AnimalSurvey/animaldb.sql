DROP TABLE IF EXISTS surveyresults;
CREATE TABLE surveyresults (
  id int NOT NULL,
  surveyoption varchar (20) NOT NULL,
  votes int NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO surveyresults VALUES 
(1, 'Dog', 3),
(2, 'Cat', 2),
(3, 'Bird', 5),
(4, 'Snake', 2),
(5, 'None', 6);