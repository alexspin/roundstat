# Tasks schema
 
# --- !Ups

CREATE SEQUENCE ideas_id_seq;
CREATE TABLE ideas (
    id integer NOT NULL DEFAULT nextval('ideas_id_seq'),
    idea varchar(255),
);
 
 CREATE SEQUENCE user_id_seq;
 CREATE TABLE users (
 id integer NOT NULL DEFAULT nextval('user_id_seq'),
 email varchar(255),
 f_name varchar(255),
 l_name varchar(255),
 password varchar(255),
 company varchar(255)
 )
   
 
# --- !Downs

DROP SEQUENCE IF EXISTS idea_id_seq; 
DROP TABLE IF EXISTS idea;

DROP SEQUENCE IF EXISTS user_id_seq;
DROP TABLE IF EXISTS users;
