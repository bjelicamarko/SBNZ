insert into AUTHORITY (name)
values ('ROLE_ADMIN'); -- 1
insert into AUTHORITY (name)
values ('ROLE_EMPLOYER'); -- 2
insert into AUTHORITY (name)
values ('ROLE_EMPLOYEE'); -- 3
insert into AUTHORITY (name)
values ('ROLE_STUDENT'); -- 4

insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('mare@maildrop.cc', '$2a$12$BN3TxQQYc9WTziVqPU5gcuxsL2nhW8IEuJXMfSLIefcx3eD/G5Vtq', 
'Mare', 'Mare', 'ROLE_ADMIN', false, false);
insert into admin(client) values (1);
insert into client_authority (client_id, authority_id)
values (1, 1); -- admin

insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('dare@maildrop.cc', '$2a$12$5p9RcUuQQUM/O3Esp6Ut0OJwLyOzw6UR8OtoG2izRQru5kFXOEuuq', 
'Dare', 'Dare', 'ROLE_ADMIN', false, false);
insert into admin(client) values (2);
insert into client_authority (client_id, authority_id)
values (2, 1); -- admin