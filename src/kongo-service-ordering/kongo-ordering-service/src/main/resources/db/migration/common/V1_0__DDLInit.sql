	-- This file is for H2

	--**************************
	--Tables
	--**************************
	
	create table OrderingItem (
	oid varchar(36),
	cart varchar(36) not null, 
	orderedon datetime not null, 
	primary key (oid));
	
	
