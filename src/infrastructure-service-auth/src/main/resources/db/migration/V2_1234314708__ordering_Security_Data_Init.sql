-- Roles
insert into _authorities (oid, auth_authority) values ('00000000-4992-25d4-0000-000000000001','ordering_ADMIN');
insert into _authorities (oid, auth_authority) values ('00000000-4992-25d4-0000-000000000002','ordering_READ_ONLY_USER');

insert into _users_authorities (authority_oid, user_oid) values ('00000000-4992-25d4-0000-000000000001', '00000000-0000-0000-0000-000000000001');
insert into _users_authorities (authority_oid, user_oid) values ('00000000-4992-25d4-0000-000000000001', '00000000-0000-0000-0000-000000000003');
insert into _users_authorities (authority_oid, user_oid) values ('00000000-4992-25d4-0000-000000000001', '00000000-0000-0000-0000-000000000004');

insert into _users_authorities (authority_oid, user_oid) values ('00000000-4992-25d4-0000-000000000002', '00000000-0000-0000-0000-000000000002');

-- Permissions for entity: order
insert into _permissions (oid,perm_permission) values ('00000000-4992-25d4-0000-000005f5e100','ordering_READ_Order');
insert into _permissions (oid,perm_permission) values ('00000000-4992-25d4-0000-00000bebc200','ordering_WRITE_Order');
insert into _permissions (oid,perm_permission) values ('00000000-4992-25d4-0000-000011e1a300','ordering_DELETE_Order');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-4992-25d4-0000-000000000002','00000000-4992-25d4-0000-000005f5e100');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-4992-25d4-0000-000000000001','00000000-4992-25d4-0000-000005f5e100');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-4992-25d4-0000-000000000001','00000000-4992-25d4-0000-00000bebc200');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-4992-25d4-0000-000000000001','00000000-4992-25d4-0000-000011e1a300');

-- Permission for businessaction: orderCart
insert into _permissions (oid,perm_permission) values ('00000000-4992-25d4-0000-000035a4e900','ordering_BUSINESSACTION_OrderCart');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-4992-25d4-0000-000000000001','00000000-4992-25d4-0000-000035a4e900');

-- Permission for businessaction: sendInvoice
insert into _permissions (oid,perm_permission) values ('00000000-4992-25d4-0000-000035a4e901','ordering_BUSINESSACTION_SendInvoice');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-4992-25d4-0000-000000000001','00000000-4992-25d4-0000-000035a4e901');

-- Permission for businessaction: cancelOrder
insert into _permissions (oid,perm_permission) values ('00000000-4992-25d4-0000-000035a4e902','ordering_BUSINESSACTION_CancelOrder');
insert into _authorities_permissions (authority_oid, permission_oid) values ('00000000-4992-25d4-0000-000000000001','00000000-4992-25d4-0000-000035a4e902');

