	-- This file is for ORACLE

	--**************************
	--Tables
	--**************************
	
	create table Cart (
	oid varchar(36),
	userid varchar(24) not null, 
	totalprice NUMBER(19, 9) not null, 
	primary key (oid));
	
	--Cart_Items ValueObject Table
	create table cart_items (
	cart_oid varchar(36) not null, 
	order_index bigint,
	product varchar(24) not null,
	quantity NUMBER(19, 0) not null,
	primary key ( cart_oid) );
	
	alter table cart_items 
	add constraint FK_cart_items_TO_cart 
	foreign key (cart_oid) 
	references cart;
	
	
