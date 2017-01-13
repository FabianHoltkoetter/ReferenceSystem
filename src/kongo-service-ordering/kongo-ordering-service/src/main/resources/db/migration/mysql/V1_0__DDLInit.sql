	-- This file is for MYSQL

	--**************************
	--Tables
	--**************************
	
	create table Order (
	oid varchar(36),
	cart varchar(24) not null, 
	orderedon datetime not null, 
	primary key (oid));
	
	
