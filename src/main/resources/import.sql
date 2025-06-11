--Person
INSERT INTO person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 1,'Alphonsus','Mary of Ligouri', '1990-01-01 00:00:00', true);
INSERT INTO person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('dfd62ac7-a841-4074-af38-fef78c392377', 2,'Peter','Damian', '1985-01-12 00:00:00', true);
INSERT INTO person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('76484b82-ce0c-4d3f-bcfa-46637ffcf508', 3,'Tarcicius','of Roma', '2010-01-06 00:00:00', true);
INSERT INTO person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('21662e5e-c8b1-4a9d-a102-fcd600e9d425', 4,'Thomas','More', '1995-01-07 00:00:00', true);
INSERT INTO person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('c0235ea5-b15b-443c-ab9b-4f44de7c498a', 5,'Joseph','Shanches Del Rio', '2015-01-08 00:00:00', true);

--Account
INSERT INTO account (id, login, password, person_id, is_blocked, is_activated) VALUES ('ae094b6e-b73e-4f78-a614-2f505c77fd9e','test@test.com','12345678','50f0c341-ceb5-4aa9-971f-fb14337abd0c', false, true);
INSERT INTO account (id, login, password, person_id, is_blocked, is_activated) VALUES ('46deeb32-b273-415b-8c5d-c4d591d7aebb','test2@test.com','1234567890','dfd62ac7-a841-4074-af38-fef78c392377', false, true);