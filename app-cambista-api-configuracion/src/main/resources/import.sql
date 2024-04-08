INSERT INTO tipocambio(id,moneda_origen,moneda_destino,monto,factor) VALUES(1,'soles','dolares', 3.70,1);
INSERT INTO tipocambio(id,moneda_origen,moneda_destino,monto,factor) VALUES(2,'dolares','soles', 3.70,2);
insert into usuario(id, email, password) values(1,'jojelo.25@gmail.com','$2a$10$rWMPZJEpIxB3pV7XUCfL.uCP/vA.msyrsVvsfDrnHYYQXkrvvuH0u');
insert into rol(id, name) values(1, 'ROLE_USER');
insert into rol(id, name) values(2, 'ROLE_MODERATOR');
insert into rol(id, name) values(3, 'ROLE_ADMIN');
insert into user_roles(role_id, user_id) values(3,1);