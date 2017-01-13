	-- This file is for ORACLE

	--**************************
	--Tables
	--**************************
	
	create table Order (
	oid varchar(36),
	cart varchar(24) not null, 
	orderedon TIMESTAMP not null, 
	primary key (oid));
	
	
