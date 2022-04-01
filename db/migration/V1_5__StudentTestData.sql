INSERT INTO testdb.finance_info (id, inn) VALUES (9, '1452652541');
INSERT INTO testdb.finance_info (id, inn) VALUES (22, '4522145814');
INSERT INTO testdb.finance_info (id, inn) VALUES (24, '452233588');

INSERT INTO testdb.st_groups (id, group_name) VALUES (9, 'B-46');

INSERT INTO testdb.students (id, last_name, middle_name, name, phone, user_pic, finance_id, group_id) VALUES (1, 'Mazur', 'Aleksandrovich', 'Maks', '+380965156858', 'localHost', 9, 9);
INSERT INTO testdb.students (id, last_name, middle_name, name, phone, user_pic, finance_id, group_id) VALUES (2, 'Petrovskiy', 'Petrov', 'Valentin', '+380965186858', 'localHost', 22, 9);
INSERT INTO testdb.students (id, last_name, middle_name, name, phone, user_pic, finance_id, group_id) VALUES (3, 'Semenov', 'Skalniy', 'Petr', '+380965186858', 'localHost', 24, 9);