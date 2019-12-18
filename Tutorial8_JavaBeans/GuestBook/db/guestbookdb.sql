drop table if exists guests;

create table guests (
       firstName varchar (20) NOT NULL,
       lastName varchar (20) NOT NULL,
       email varchar (50) NOT NULL,
       PRIMARY KEY (email)
);