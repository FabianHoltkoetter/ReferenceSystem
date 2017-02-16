	-- This file is for H2

	--**************************
	--Tables
	--**************************
	
	create table Cart (
	oid varchar(36),
	userid varchar(36) not null, 
	totalprice decimal not null, 
	primary key (oid));
	
	--Cart_Items ValueObject Table
	create table cart_items (
	cart_oid varchar(36) not null, 
	order_index bigint,
	product varchar(36) not null,
	quantity bigint not null,
	primary key ( cart_oid) );
	
	alter table cart_items 
	add constraint FK_cart_items_TO_cart 
	foreign key (cart_oid) 
	references cart;
	
	
