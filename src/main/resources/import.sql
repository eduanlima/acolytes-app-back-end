--Person
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, deleted) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 1,'Alphonsus','Mary of Ligouri', '1990-01-01 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, deleted) VALUES ('dfd62ac7-a841-4074-af38-fef78c392377', 2,'Peter','Damian', '1985-01-12 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, deleted) VALUES ('76484b82-ce0c-4d3f-bcfa-46637ffcf508', 3,'Tarcicius','of Roma', '2010-01-06 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, deleted) VALUES ('21662e5e-c8b1-4a9d-a102-fcd600e9d425', 4,'Thomas','More', '1995-01-07 00:00:00', true);
INSERT INTO tb_person (id, code, first_name, last_name, date_birth, deleted) VALUES ('c0235ea5-b15b-443c-ab9b-4f44de7c498a', 5,'Joseph','Shanches Del Rio', '2015-01-08 00:00:00', true);
--User
INSERT INTO tb_user (id, login, password, is_blocked) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c','test@test.com','12345678', false);
INSERT INTO tb_user (id, login, password, is_blocked) VALUES ('21662e5e-c8b1-4a9d-a102-fcd600e9d425','test2@test.com','1234567890', false);
INSERT INTO tb_user (id, login, password, is_blocked) VALUES ('76484b82-ce0c-4d3f-bcfa-46637ffcf508','test3@test.com','12345678901', false);

--Acolyte
INSERT INTO tb_acolyte (id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c');
INSERT INTO tb_acolyte (id) VALUES ('dfd62ac7-a841-4074-af38-fef78c392377');
--INSERT INTO tb_acolyte (id) VALUES ('76484b82-ce0c-4d3f-bcfa-46637ffcf508');
INSERT INTO tb_acolyte (id) VALUES ('21662e5e-c8b1-4a9d-a102-fcd600e9d425');
INSERT INTO tb_acolyte (id) VALUES ('c0235ea5-b15b-443c-ab9b-4f44de7c498a');

--User Acolyte
INSERT INTO tb_user_acolyte (user_id, acolyte_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', '50f0c341-ceb5-4aa9-971f-fb14337abd0c');
INSERT INTO tb_user_acolyte (user_id, acolyte_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 'dfd62ac7-a841-4074-af38-fef78c392377');
--INSERT INTO tb_user_acolyte (user_id, acolyte_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', '76484b82-ce0c-4d3f-bcfa-46637ffcf508');
INSERT INTO tb_user_acolyte (user_id, acolyte_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', '21662e5e-c8b1-4a9d-a102-fcd600e9d425');
INSERT INTO tb_user_acolyte (user_id, acolyte_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 'c0235ea5-b15b-443c-ab9b-4f44de7c498a');
INSERT INTO tb_user_acolyte (user_id, acolyte_id) VALUES ('21662e5e-c8b1-4a9d-a102-fcd600e9d425', '21662e5e-c8b1-4a9d-a102-fcd600e9d425');

--Position
INSERT INTO tb_position (id, code, name, description) VALUES ('b1188eb0-f57d-4bf2-8e3a-e1dd8ee286d4', 1, 'Acólito 1', '');
INSERT INTO tb_position (id, code, name, description) VALUES ('d6371123-566b-4a20-a92c-817ff0548e4a', 2, 'Acólito 2', '');
INSERT INTO tb_position (id, code, name, description) VALUES ('c2309a21-ab45-42a3-945c-0f76d557e555', 3, 'Turiferário', '');
INSERT INTO tb_position (id, code, name, description) VALUES ('774b85f1-3a94-45ae-9ee2-5bb8e0a6c295', 4, 'Cerimoniário', '');
INSERT INTO tb_position (id, code, name, description) VALUES ('4c96d452-0633-485e-b7f0-8412076011ac', 5, 'Cruciferário', '');

--Acolyte Position
INSERT INTO tb_acolyte_position (acolyte_id, position_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 'b1188eb0-f57d-4bf2-8e3a-e1dd8ee286d4');
INSERT INTO tb_acolyte_position (acolyte_id, position_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 'd6371123-566b-4a20-a92c-817ff0548e4a');
INSERT INTO tb_acolyte_position (acolyte_id, position_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', 'c2309a21-ab45-42a3-945c-0f76d557e555');
INSERT INTO tb_acolyte_position (acolyte_id, position_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', '774b85f1-3a94-45ae-9ee2-5bb8e0a6c295');
INSERT INTO tb_acolyte_position (acolyte_id, position_id) VALUES ('50f0c341-ceb5-4aa9-971f-fb14337abd0c', '4c96d452-0633-485e-b7f0-8412076011ac');
INSERT INTO tb_acolyte_position (acolyte_id, position_id) VALUES ('21662e5e-c8b1-4a9d-a102-fcd600e9d425', 'b1188eb0-f57d-4bf2-8e3a-e1dd8ee286d4');
