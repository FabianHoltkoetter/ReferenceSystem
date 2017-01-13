	-- This file is for H2

	--**************************
	--Tables
	--**************************
	
	create table Product (
	oid varchar(36),
	name varchar(255) not null, 
	description varchar(2047), 
	price decimal not null, 
	quantity bigint not null, 
	primary key (oid));
	
	
