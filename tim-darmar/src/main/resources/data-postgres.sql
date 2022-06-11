 -- ***************** ULOGE ******************
insert into authority (name) values ('ROLE_ADMIN'); -- 1
insert into authority (name) values ('ROLE_EMPLOYER'); -- 2
insert into authority (name) values ('ROLE_EMPLOYEE'); -- 3
insert into authority (name) values ('ROLE_STUDENT'); -- 4


-- ***************** OBLASTI EKPERTIZE GLOBALNI I JEZICI (BICE DEFINISANI i ADMIN Ih Dodaje) ******************
insert into area_of_expertise_globally(name_of_area) values ('Web programiranje');
insert into specializations_globally(id, specialization) values (1, 'Backend');
insert into specializations_globally(id, specialization) values (1, 'Frontend');
insert into specializations_globally(id, specialization) values (1, 'Devops');
insert into specializations_globally(id, specialization) values (1, 'NodeJS');

insert into area_of_expertise_globally(name_of_area) values ('AI');
insert into specializations_globally(id, specialization) values (2, 'Machine-Learning');
insert into specializations_globally(id, specialization) values (2, 'Soft-compjuting');

insert into area_of_expertise_globally(name_of_area) values ('Information engineering');
insert into specializations_globally(id, specialization) values (3, 'SQL');
insert into specializations_globally(id, specialization) values (3, 'Mongo');
insert into specializations_globally(id, specialization) values (3, 'MySQL');


insert into language_globally(name) values ('English');
insert into language_globally(name) values ('French');
insert into language_globally(name) values ('Serbian');
insert into language_globally(name) values ('Italian');

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
insert into employer(client, company_average_rating, penalty_points, penalty, 
employer_recklessness_type, employer_carelessness_type) values 
(3, 10.0, 0, false, 'NOT_RECKLESS', 'NOT_CARELESS');
insert into client_authority (client_id, authority_id) values (3, 2); -- employer

---- ***************** ZAPOSLENI ******************
-- ZAPOSLEN #1
insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('nikola@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Nikola', 'Jokic', 'ROLE_EMPLOYEE', false, false);
insert into employee(client, preferred_working_hours, preferred_salary, points, approval, 
status_of_employee) 
values (4, '10:00-18:00', 5000.0, 0.0, 0, 'EMPLOYED');
insert into client_authority (client_id, authority_id) values (4, 3); -- employee

insert into languages(id, language) values (4, 'English');
insert into languages(id, language) values (4, 'Serbian');

insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (1, 'Backend');
insert into specializations(id, specialization) values (1, 'Frontend');
insert into employee_area_of_expertises(employee_client, area_of_expertises_id) values (4, 1);

insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (2, 'Backend');
insert into work_experience(type_of_employment, date_from, date_to, employer_rating, employee_rating, paid,
employer_id, employee_id, area_of_expertise_id, accepted) values 
('FULL_TIME', 1640991600000, 1642201200000, 10.0, 10.0, true, 3, 4, 2, true);

insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (3, 'Frontend');
insert into work_experience(type_of_employment, date_from, date_to, employer_rating, employee_rating, paid,
employer_id, employee_id, area_of_expertise_id, accepted) values 
('FULL_TIME', 1640991600000, 1642201200000, 10.0, 10.0, true, 3, 4, 3, true);

-- ZAPOSLEN #2
insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('boban@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Boban', 'Marjanovic', 'ROLE_EMPLOYEE', false, false);
insert into employee(client, preferred_working_hours, preferred_salary, points, approval,
status_of_employee) 
values (5, '15:00-23:00', 11000.0, 0.0, 0, 'UNEMPLOYED');
insert into client_authority (client_id, authority_id) values (5, 3); -- employee

insert into languages(id, language) values (5, 'English');

insert into area_of_expertise(name_of_area) values ('AI');
insert into specializations(id, specialization) values (4, 'Machine-Learning');
insert into employee_area_of_expertises(employee_client, area_of_expertises_id) values (5, 4);

insert into area_of_expertise(name_of_area) values ('AI');
insert into specializations(id, specialization) values (5, 'Machine-Learning');
insert into work_experience(type_of_employment, date_from, date_to, employer_rating, employee_rating, paid,
employer_id, employee_id, area_of_expertise_id, accepted) values 
('FULL_TIME', 1640991600000, 1642201200000, 10.0, 10.0, true, 3, 5, 5, true);

insert into employee_friends_group (employee_client, friends_group_client) values (4, 5);

-- ***************** STVARI ZA STUDENTE ******************
-- TODO videti dal se ovo moze spojiti sa onim gore
insert into area_of_expertise_intership(name_of_area) values ('Web programiranje');
insert into specializations_intership(id, specialization) values (1, 'Backend');
insert into specializations_intership(id, specialization) values (1, 'Frontend');
insert into specializations_intership(id, specialization) values (1, 'Devops');
insert into specializations_intership(id, specialization) values (1, 'NodeJS');

insert into area_of_expertise_intership(name_of_area) values ('AI');
insert into specializations_intership(id, specialization) values (2, 'Machine-Learning');
insert into specializations_intership(id, specialization) values (2, 'Soft-compjuting');

insert into area_of_expertise_intership(name_of_area) values ('Information engineering');
insert into specializations_intership(id, specialization) values (3, 'SQL');
insert into specializations_intership(id, specialization) values (3, 'Mongo');
insert into specializations_intership(id, specialization) values (3, 'MySQL');

insert into area_of_expertise_intership(name_of_area) values ('Databases');
insert into specializations_intership(id, specialization) values (4, 'SQL');
insert into specializations_intership(id, specialization) values (4, 'MySQL');

-- predmeti na faxy
insert into uni_subject (name) values ('OOP');
insert into uni_subject_subject_area_of_expertises (uni_subject_id, subject_area_of_expertises_id) values (1, 4);

-- ocene mentora
insert into mark_mentor (mark, mentor) values (7.0, 'Djura');
insert into mark_mentor (mark, mentor) values (9.0, 'Pera');

-- fax projekti
insert into project(mark, project_type, difficulty) values (9.0, 'TEAM', 7);
insert into project(mark, project_type, difficulty) values (10.0, 'INDIVIDUAL', 8);
insert into project(mark, project_type, difficulty) values (9.0, 'TEAM', 7);
insert into project(mark, project_type, difficulty) values (8.5, 'INDIVIDUAL', 8);

-- praksa projekti
insert into project(mark, project_type, difficulty) values (10.0, 'TEAM', 7);
insert into project(mark, project_type, difficulty) values (10.0, 'INDIVIDUAL', 8);

-- prakse
insert into intership(date_from, date_to) values (1618264800, 1618876800);
insert into intership_mentor_marks(intership_id, mentor_marks_id) values (1, 1);
insert into intership_mentor_marks(intership_id, mentor_marks_id) values (1, 2);
insert into intership_intership_projects(intership_id, intership_projects_id) values (1, 5);
insert into intership_intership_projects(intership_id, intership_projects_id) values (1, 6);

-- ***************** STUDENTI ******************
insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('luka@maildrop.cc', '$2a$12$z2SQcqZu3nwufrN74D4QdertkMnJBsn.Z7FMygO8iqmhxLd5fQQHa', 
'Luka', 'Doncic', 'ROLE_STUDENT', false, false);
insert into client_authority (client_id, authority_id) values (6, 4); -- student

insert into student(client, financial_status, status_of_student, points, monthly_income_by_family_member) values (6, 'MIDDLE_CLASS', null, 0.0, 3000.0);
insert into student_interships(student_client, interships_id) values (6, 1);
insert into student_passed_subjects(student_client, passed_subjects_id) values (6, 1);
insert into student_uni_projects(student_client, uni_projects_id) values (6, 1);
insert into student_uni_projects(student_client, uni_projects_id) values (6, 2);
insert into student_uni_projects(student_client, uni_projects_id) values (6, 3);
insert into student_uni_projects(student_client, uni_projects_id) values (6, 4);

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

insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('platon@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Platon', 'Platon', 'ROLE_EMPLOYER', false, false);
insert into employer(client, company_average_rating, penalty_points, penalty, 
employer_recklessness_type, employer_carelessness_type) values 
(7, 10.0, 0, true, 'NOT_RECKLESS', 'NOT_CARELESS');
insert into client_authority (client_id, authority_id) values (7, 2); -- employer

-- ZAPOSLENI 3
insert into client(email, password, first_name, last_name, role, blocked, deleted)
values ('nikoladjuricko@maildrop.cc', '$2a$12$ok67kLZVobeZU5lDdqHKIeaqOd61RI6fnH9oukE52E6uYyHDrPQ7u', 
'Nikola', 'Jokic', 'ROLE_EMPLOYEE', false, false);
insert into employee(client, preferred_working_hours, preferred_salary, points, approval, 
status_of_employee) 
values (8, '10:00-18:00', 5000.0, 0.0, 0, 'EMPLOYED');
insert into client_authority (client_id, authority_id) values (8, 3); -- employee

insert into languages(id, language) values (8, 'English');
insert into languages(id, language) values (8, 'Serbian');

insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (6, 'Backend');
insert into specializations(id, specialization) values (6, 'Frontend');
insert into employee_area_of_expertises(employee_client, area_of_expertises_id) values (8, 6);

insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (7, 'Backend');
insert into work_experience(type_of_employment, date_from, date_to, employer_rating, employee_rating, paid,
employer_id, employee_id, area_of_expertise_id, accepted) values 
('FULL_TIME', 1640991600000, 1642201200000, 10.0, 10.0, true, 3, 8, 7, true);

insert into area_of_expertise(name_of_area) values ('Web programiranje');
insert into specializations(id, specialization) values (8, 'FrontendReact');
insert into work_experience(type_of_employment, date_from, date_to, employer_rating, employee_rating, paid,
employer_id, employee_id, area_of_expertise_id, accepted) values 
('FULL_TIME', 1640991600000, 1642201200000, 10.0, 10.0, true, 3, 8, 8, true);

insert into employee_friends_group (employee_client, friends_group_client) values (5, 8);