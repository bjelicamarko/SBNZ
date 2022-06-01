-- ***************** ULOGE ******************
insert into authority (name) values ('ROLE_ADMIN'); -- 1
insert into authority (name) values ('ROLE_EMPLOYER'); -- 2
insert into authority (name) values ('ROLE_EMPLOYEE'); -- 3
insert into authority (name) values ('ROLE_STUDENT'); -- 4


-- ***************** OBLASTI EKPERTIZE GLOBALNI (BICE DEFINISANI i ADMIN Ih Dodaje) ******************
insert into area_of_expertise_globally(name_of_area) values ('Web programiranje');
insert into specializations_globally(id, specialization) values (1, 'Backend');
insert into specializations_globally(id, specialization) values (1, 'Frontend-React');
insert into specializations_globally(id, specialization) values (1, 'Frontend-Angular');
insert into specializations_globally(id, specialization) values (1, 'Frontend-VUE');
insert into specializations_globally(id, specialization) values (1, 'Devops');
insert into specializations_globally(id, specialization) values (1, 'NodeJS');

insert into area_of_expertise_globally(name_of_area) values ('AI');
insert into specializations_globally(id, specialization) values (2, 'Machine-Learning');
insert into specializations_globally(id, specialization) values (2, 'Soft-compjuting');

insert into area_of_expertise_globally(name_of_area) values ('Information engineering');
insert into specializations_globally(id, specialization) values (3, 'SQL');
insert into specializations_globally(id, specialization) values (3, 'Mongo');
insert into specializations_globally(id, specialization) values (3, 'MySQL');

-- ***************** ADMINISTRATORI ******************
insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('mare@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Mare', 'Mare', 'ROLE_ADMIN', false, false);
insert into admin(client) values (1);
insert into client_authority (client_id, authority_id) values (1, 1); -- admin

insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('dare@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Dare', 'Dare', 'ROLE_ADMIN', false, false);
insert into admin(client) values (2);
insert into client_authority (client_id, authority_id) values (2, 1); -- admin


-- ***************** POSLODAVCI ******************
insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('seneka@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Seneka', 'Senaka', 'ROLE_EMPLOYER', false, false);
insert into employer(client, company_name, company_average_rating, penalty_points, penalty, 
employer_recklessness_type, employer_carelessness_type) values 
(3, 'Seneka', 10.0, 0, false, 'NOT_RECKLESS', 'NOT_CARELESS');
insert into client_authority (client_id, authority_id) values (3, 2); -- employer

-- zahtevi koji ce biti vezani za seneku :D
insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (1, 'Backend');
insert into specializations(id, specialization) values (1, 'Frontend-React');

insert into request_for_employee(type_of_employment, required_working_hours, required_salary, 
employer_id) 
values ('FULL_TIME', '08:00h-16:00h', 250000.0, 3);
insert into required_languages(id, language) values (1, 'english');
insert into required_languages(id, language) values (1, 'serbian');

insert into request_for_employee(type_of_employment, required_working_hours, required_salary, 
employer_id) 
values ('FULL_TIME', '08:30h-15:00h', 140000.0, 3);
insert into required_languages(id, language) values (2, 'english');
insert into required_languages(id, language) values (2, 'french');


insert into area_of_expertise(name_of_area) values ('AI');
insert into specializations(id, specialization) values (2, 'Machine-Learning');

--insert into request_for_student(work_methods, employer_id, area_of_expertise_id) values ('FROM_HOME', 3, 2);
--insert into request_for_student(work_methods, employer_id, area_of_expertise_id) values ('DIRECT', 3, 2);
-- kraj zahteva za seneku


-- ***************** ZAPOSLENI ******************
insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('nikola@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Nikola', 'Jokic', 'ROLE_EMPLOYEE', false, false);
insert into employee(client, preferred_working_hours, preferred_salary, points, approval) 
values (4, '10:00h-21:00h', 10000.0, 0.0, 0);
insert into client_authority (client_id, authority_id) values (4, 3); -- employee
insert into languages(id, language) values (4, 'english');
insert into languages(id, language) values (4, 'serbian');
insert into languages(id, language) values (4, 'french');

insert into area_of_expertise(name_of_area, employee_id) values ('Web programiranje', 4);
insert into specializations(id, specialization) values (1, 'Backend');
insert into area_of_expertise(name_of_area, employee_id) values ('Web programiranje', 4);
insert into specializations_globally(id, specialization) values (1, 'Frontend-React');

-- radna iskustva vezana za Jokica :D
insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (1, 'Backend');
insert into work_experience(type_of_employment, date_from, date_to, company_rating, employer_rating, 
paid, employer_id, employee_id, area_of_expertise_id) 
values ('FULL_TIME', 1589320800, 1620856800, 10.0, 10.0, false, 3, 4, 5);

insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations_globally(id, specialization) values (1, 'Frontend-React');
insert into specializations_globally(id, specialization) values (1, 'Frontend-Angular');
insert into work_experience(type_of_employment, date_from, employer_id, employee_id, area_of_expertise_id,
paid) 
values ('FULL_TIME', 1620856800, 3, 4, 6, false);
-- kraj radnih iskustava


-- ***************** STUDENTI ******************
--insert into client(email, password, first_name, last_name, role, blocked, deleted)
--values ('luka@maildrop.cc', '$2a$12$z2SQcqZu3nwufrN74D4QdertkMnJBsn.Z7FMygO8iqmhxLd5fQQHa', 
--'Luka', 'Doncic', 'ROLE_STUDENT', false, false);
--insert into student(client, financial_status, status_of_student, points) values (5, 'MIDDLE_CLASS', 'DILIGENT_AND_GOOD', 0.0);
--insert into client_authority (client_id, authority_id) values (5, 4); -- student
--
---- projekti vezani za Luku
--insert into project(mark, project_type, difficulty) values (10.0, 'TEAM', 5);
--insert into project(mark, project_type, difficulty) values (10.0, 'INDIVIDUAL', 6);
--insert into project(mark, project_type, difficulty) values (7.5, 'INDIVIDUAL', 8);
--insert into project(project_type, difficulty) values ('INDIVIDUAL', 5);
---- kraj projekata
--
---- prakse vezane za Luku
--insert into intership(date_from, date_to) values (1618264800, 1618876800);
--insert into mark_mentor(mark, mentor) values (6.9, 'Pera');
--insert into mark_mentor(mark, mentor) values (7.5, 'Dusko');
--
--insert into intership(date_from, date_to) values (1650412800, 1652572800);
--insert into mark_mentor(mark, mentor) values ('10.0', 'Pera');
--insert into mark_mentor(mark, mentor) values ('6.4', 'Dusko');
--insert into mark_mentor(mark, mentor) values ('4.3', 'Dunja');
---- kraj praksi