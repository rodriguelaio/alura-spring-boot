INSERT INTO grupo_de_produtos (id, nome) values (0001, 'Grupo A');
INSERT INTO grupo_de_produtos (id, nome) values (0002, 'Grupo B');
INSERT INTO grupo_de_produtos (id, nome) values (0003, 'Grupo C');
INSERT INTO grupo_de_produtos (id, nome) values (0004, 'Grupo D');
INSERT INTO grupo_de_produtos (id, nome) values (0005, 'Grupo E');


INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000001, 'Produto A - PA', 1, 0001);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000002, 'Produto B - PA', 1, 0001);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000003, 'Produto C - MP', 2, 0002);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000004, 'Produto D - MP', 2, 0002);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000005, 'Produto E - RV', 3, 0002);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000006, 'Produto F - RV', 3, 0004);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000007, 'Produto G - PA', 1, 0005);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000008, 'Produto H - MP', 2, 0005);
INSERT INTO produto (id, nome, tipo_de_produtos, grupo_de_produtos_id) values (000000009, 'Produto I - RV', 3, 0005);


INSERT INTO gerente (id, nome) values (000001, 'Gerente A');
INSERT INTO gerente (id, nome) values (000002, 'Gerente B');
INSERT INTO gerente (id, nome) values (000003, 'Gerente C');
INSERT INTO gerente (id, nome) values (000004, 'Gerente D');
INSERT INTO gerente (id, nome) values (000005, 'Gerente E');


INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000001, 0001);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000001, 0002);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000001, 0003);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000002, 0001);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000002, 0004);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000003, 0002);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000003, 0003);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000004, 0003);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000004, 0004);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000005, 0001);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000005, 0003);
INSERT INTO gerente_grupo_de_produto (gerente_id, grupo_de_produto_id) values (000005, 0004);


INSERT INTO gerente_produto (gerente_id, produto_id) values (000001, 000000007);
INSERT INTO gerente_produto (gerente_id, produto_id) values (000001, 000000008);
INSERT INTO gerente_produto (gerente_id, produto_id) values (000002, 000000009);