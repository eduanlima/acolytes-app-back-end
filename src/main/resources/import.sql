--Person
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 1,'Alphonsus','Mary of Ligouri', '1990-01-01 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('dfd62ac7-a841-4074-af38-fef78c392377', 2,'Peter','Damian', '1985-01-12 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('76484b82-ce0c-4d3f-bcfa-46637ffcf508', 3,'Tarcicius','of Roma', '2010-01-06 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('21662e5e-c8b1-4a9d-a102-fcd600e9d425', 4,'Thomas','More', '1995-01-07 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, is_activated) VALUES ('c0235ea5-b15b-443c-ab9b-4f44de7c498a', 5,'Joseph','Shanches Del Rio', '2015-01-08 00:00:00', true);

--Account
INSERT INTO tb_account (id, login, password, person_id, is_blocked, is_activated) VALUES ('ae094b6e-b73e-4f78-a614-2f505c77fd9e','test@test.com','12345678','50f0c341-ceb5-4aa9-971f-fb14337abd0c', false, true);
INSERT INTO tb_account (id, login, password, person_id, is_blocked, is_activated) VALUES ('46deeb32-b273-415b-8c5d-c4d591d7aebb','test2@test.com','1234567890','dfd62ac7-a841-4074-af38-fef78c392377', false, true);

--Acolyte
INSERT INTO tb_acolyte (id, person_id) VALUES ('ba7e1f98-2d69-42fb-9aad-3a4e89dc7cff', '50f0c341-ceb5-4aa9-971f-fb14337abd0c');
INSERT INTO tb_acolyte (id, person_id) VALUES ('facb1b76-56f0-4065-80ba-fa00ef5aee22', 'dfd62ac7-a841-4074-af38-fef78c392377');
INSERT INTO tb_acolyte (id, person_id) VALUES ('57f8a324-7951-4fbf-b7c5-181dbd94e8a3', '76484b82-ce0c-4d3f-bcfa-46637ffcf508');
INSERT INTO tb_acolyte (id, person_id) VALUES ('5d53435a-404d-42d8-9833-182bdec21744', '21662e5e-c8b1-4a9d-a102-fcd600e9d425');
INSERT INTO tb_acolyte (id, person_id) VALUES ('7990fa03-d5b5-42a6-8cc0-78ec01edee9c', 'c0235ea5-b15b-443c-ab9b-4f44de7c498a');

--AccountAcolyte
INSERT INTO tb_account_acolyte (account_id, acolyte_id) VALUES ('ae094b6e-b73e-4f78-a614-2f505c77fd9e', 'ba7e1f98-2d69-42fb-9aad-3a4e89dc7cff');
INSERT INTO tb_account_acolyte (account_id, acolyte_id) VALUES ('ae094b6e-b73e-4f78-a614-2f505c77fd9e', 'facb1b76-56f0-4065-80ba-fa00ef5aee22');
INSERT INTO tb_account_acolyte (account_id, acolyte_id) VALUES ('ae094b6e-b73e-4f78-a614-2f505c77fd9e', '57f8a324-7951-4fbf-b7c5-181dbd94e8a3');
INSERT INTO tb_account_acolyte (account_id, acolyte_id) VALUES ('ae094b6e-b73e-4f78-a614-2f505c77fd9e', '5d53435a-404d-42d8-9833-182bdec21744');
INSERT INTO tb_account_acolyte (account_id, acolyte_id) VALUES ('ae094b6e-b73e-4f78-a614-2f505c77fd9e', '7990fa03-d5b5-42a6-8cc0-78ec01edee9c');

INSERT INTO tb_account_acolyte (account_id, acolyte_id) VALUES ('46deeb32-b273-415b-8c5d-c4d591d7aebb', '5d53435a-404d-42d8-9833-182bdec21744');
