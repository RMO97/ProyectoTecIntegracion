create database perros;
use perros;
create user 'me'@'localhost' identified by '123';
create user 'me'@'127.0.0.1' identified by '123';
create user 'me'@'%' identified by '123';
grant all privileges on *.* to 'me'@'localhost';
grant all privileges on *.* to 'me'@'127.0.0.1'; 
grant all privileges on *.* to 'me'@'%';
flush privileges;