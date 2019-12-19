drop table if exists product;

create table product(
productId int auto_increment,
productName varchar(255),
productCode varchar(255),
releaseDate varchar(255),
price double,
description varchar(2000),
starRating double,
imageUrl varchar(1000)
);

insert into product values(1,'Mobile','mob-100','12/12/2019',500,'Samsung J Series',4.5,'');