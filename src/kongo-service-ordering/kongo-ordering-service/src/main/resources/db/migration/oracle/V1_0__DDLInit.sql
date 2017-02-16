	-- This file is for ORACLE

	--**************************
	--Tables
	--**************************
	
	create table OrderingItem (
	oid varchar(36),
	cart varchar(36) not null, 
	orderedon TIMESTAMP not null, 
	primary key (oid));
	
	
