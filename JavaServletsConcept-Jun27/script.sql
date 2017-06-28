show databases;

create database test_db;

use test_db;


create table login(
	uid char(10),
	pass char(10)
);

insert into login values ("user","pass");


create table blog(
	blog_id char(10),
	blog_content text
);


select * from blog;