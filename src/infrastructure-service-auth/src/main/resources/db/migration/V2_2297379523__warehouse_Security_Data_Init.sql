-- Roles
insert into _authorities (oid, auth_authority) values ('00000000-88ef-3ac3-0000-000000000001','warehouse_ADMIN');
insert into _authorities (oid, auth_authority) values ('00000000-88ef-3ac3-0000-000000000002','warehouse_READ_ONLY_USER');

insert into _users_authorities (authority_oid, user_oid) values ('00000000-88ef-3ac3-0000-000000000001', '00000000-0000-0000-0000-000000000001');
insert into _users_authorities (authority_oid, user_oid) values ('00000000-88ef-3ac3-0000-000000000001', '00000000-0000-0000-0000-000000000003');
insert into _users_authorities (authority_oid, user_oid) values ('00000000-88ef-3ac3-0000-000000000001', '00000000-0000-0000-0000-000000000004');

insert into _users_authorities (authority_oid, user_oid) values ('00000000-88ef-3ac3-0000-000000000002', '00000000-0000-0000-0000-000000000002');

-- Permissions for entity: Product
insert into _permissions (oid,perm_permission) values ('00000000-88ef-3ac3-0000-000005f5e100','warehouse_READ_Product');
insert into _permissions (oid,perm_permission) values ('00000000-88ef-3ac3-0000-00000bebc200','warehouse_WRITE_Product');
insert into _permissions (oid,perm_permission) values ('00000000-88ef-3ac3-0000-000011e1a300','warehouse_DELETE_Product');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-88ef-3ac3-0000-000000000002','00000000-88ef-3ac3-0000-000005f5e100');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-88ef-3ac3-0000-000000000001','00000000-88ef-3ac3-0000-000005f5e100');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-88ef-3ac3-0000-000000000001','00000000-88ef-3ac3-0000-00000bebc200');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-88ef-3ac3-0000-000000000001','00000000-88ef-3ac3-0000-000011e1a300');

