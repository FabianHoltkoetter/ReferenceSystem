	-- This file is for ORACLE

	--**************************
	--Tables
	--**************************
	
	create table Product (
	oid varchar(36),
	name varchar(255) not null, 
	description varchar(2047), 
	price NUMBER(19, 9) not null, 
	quantity NUMBER(19, 0) not null, 
	primary key (oid));
	
	
