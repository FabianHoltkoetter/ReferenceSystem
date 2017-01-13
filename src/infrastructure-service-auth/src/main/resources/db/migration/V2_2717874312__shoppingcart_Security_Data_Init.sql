-- Roles
insert into _authorities (oid, auth_authority) values ('00000000-a1ff-7888-0000-000000000001','shoppingcart_ADMIN');
insert into _authorities (oid, auth_authority) values ('00000000-a1ff-7888-0000-000000000002','shoppingcart_READ_ONLY_USER');

insert into _users_authorities (authority_oid, user_oid) values ('00000000-a1ff-7888-0000-000000000001', '00000000-0000-0000-0000-000000000001');
insert into _users_authorities (authority_oid, user_oid) values ('00000000-a1ff-7888-0000-000000000001', '00000000-0000-0000-0000-000000000003');
insert into _users_authorities (authority_oid, user_oid) values ('00000000-a1ff-7888-0000-000000000001', '00000000-0000-0000-0000-000000000004');

insert into _users_authorities (authority_oid, user_oid) values ('00000000-a1ff-7888-0000-000000000002', '00000000-0000-0000-0000-000000000002');

-- Permissions for entity: Cart
insert into _permissions (oid,perm_permission) values ('00000000-a1ff-7888-0000-000005f5e100','shoppingcart_READ_Cart');
insert into _permissions (oid,perm_permission) values ('00000000-a1ff-7888-0000-00000bebc200','shoppingcart_WRITE_Cart');
insert into _permissions (oid,perm_permission) values ('00000000-a1ff-7888-0000-000011e1a300','shoppingcart_DELETE_Cart');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-a1ff-7888-0000-000000000002','00000000-a1ff-7888-0000-000005f5e100');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-a1ff-7888-0000-000000000001','00000000-a1ff-7888-0000-000005f5e100');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-a1ff-7888-0000-000000000001','00000000-a1ff-7888-0000-00000bebc200');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-a1ff-7888-0000-000000000001','00000000-a1ff-7888-0000-000011e1a300');

-- Permission for businessaction: addToCart
insert into _permissions (oid,perm_permission) values ('00000000-a1ff-7888-0000-000035a4e900','shoppingcart_BUSINESSACTION_AddToCart');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-a1ff-7888-0000-000000000001','00000000-a1ff-7888-0000-000035a4e900');

