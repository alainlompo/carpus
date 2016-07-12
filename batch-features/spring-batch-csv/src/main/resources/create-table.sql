drop table if exists PERSONS;
create table PERSONS
(
  id number(10) not null,
  name character varying(50),
  address character varying(255)
);
