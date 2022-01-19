drop database if exists shopify;
create database shopify;

use shopify;

create table PRODUCT(
	product_id bigint auto_increment primary key,
    product_name varchar(50),
	product_description varchar(255),
    product_value bigint,
    product_location varchar(255),
    product_createdat timestamp,
    product_modifyat timestamp
);

insert into product (product_name, product_description, product_value, product_location, product_createdat, product_modifyat) 
values ("iphone 13 pro max", "big phone with big price", 1750.65, "Waterloo, ON, CA", '2021-01-11 11:11:00', '2021-01-12 05:05:00');
insert into product (product_name, product_description, product_value, product_location, product_createdat, product_modifyat) 
values ("iphone 13 mini", "little phone with little price", 985.45, "Toronto, ON, CA", '2021-12-25 15:15:00', '2021-12-25 15:15:00');
insert into product (product_name, product_description, product_value, product_location, product_createdat, product_modifyat) 
values ("samsung note 9", "old phone with old price", 365.96, "Kitchner, ON, CA", '2022-01-14 10:10:00', '2022-01-17 09:05:00');

commit;