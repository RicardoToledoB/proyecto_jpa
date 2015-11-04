
insert into Usuarios(usuario_id,username,password,estado) values(888,'ADMIN1','1234','ACTIVO');
insert into Usuarios(usuario_id,username,password,estado) values(887,'USER','1234','ACTIVO');
insert into Usuarios(usuario_id,username,password,estado) values(886,'ADMIN3','1234','ACTIVO');
insert into Usuarios(usuario_id,username,password,estado) values(885,'ADMIN4','1234','ACTIVO');
insert into Usuarios(usuario_id,username,password,estado) values(884,'ADMIN5','1234','ACTIVO');


insert into Roles(rol_id,tipo,estado) values(1,'ADMINISTRADOR','ACTIVO');
insert into Roles(rol_id,tipo,estado) values(2,'EJECUTIVO','ACTIVO');

insert into Usuarios_Roles(usuario_id,rol_id) values(888,1);
insert into Usuarios_Roles(usuario_id,rol_id) values(887,2);

