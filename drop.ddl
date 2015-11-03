ALTER TABLE Equipos DROP FOREIGN KEY FK_Equipos_bodega_id
ALTER TABLE Equipos DROP FOREIGN KEY FK_Equipos_modelo_id
ALTER TABLE Recepciones DROP FOREIGN KEY FK_Recepciones_proveedor_id
ALTER TABLE Recepciones DROP FOREIGN KEY FK_Recepciones_usuario_id
ALTER TABLE Devoluciones DROP FOREIGN KEY FK_Devoluciones_usuario_id
ALTER TABLE Devoluciones DROP FOREIGN KEY FK_Devoluciones_aprobado_id
ALTER TABLE RecepcionesDetalles DROP FOREIGN KEY FK_RecepcionesDetalles_equipo_id
ALTER TABLE RecepcionesDetalles DROP FOREIGN KEY FK_RecepcionesDetalles_recepcion_id
ALTER TABLE SubMenus DROP FOREIGN KEY FK_SubMenus_menu_id
ALTER TABLE Modelos DROP FOREIGN KEY FK_Modelos_marca_id
ALTER TABLE Solicitudes DROP FOREIGN KEY FK_Solicitudes_plan_id
ALTER TABLE Solicitudes DROP FOREIGN KEY FK_Solicitudes_usuario_id
ALTER TABLE Solicitudes DROP FOREIGN KEY FK_Solicitudes_cliente_id
ALTER TABLE Solicitudes DROP FOREIGN KEY FK_Solicitudes_equipo_id
ALTER TABLE Rechazos DROP FOREIGN KEY FK_Rechazos_usuario_id
ALTER TABLE Rechazos DROP FOREIGN KEY FK_Rechazos_solicitud_id
ALTER TABLE Aprobados DROP FOREIGN KEY FK_Aprobados_solicitud_id
ALTER TABLE Aprobados DROP FOREIGN KEY FK_Aprobados_usuario_id
ALTER TABLE Usuarios_Roles DROP FOREIGN KEY FK_Usuarios_Roles_rol_id
ALTER TABLE Usuarios_Roles DROP FOREIGN KEY FK_Usuarios_Roles_usuario_id
ALTER TABLE Roles_Menus DROP FOREIGN KEY FK_Roles_Menus_rol_id
ALTER TABLE Roles_Menus DROP FOREIGN KEY FK_Roles_Menus_menu_id
DROP TABLE Bodegas
DROP TABLE Equipos
DROP TABLE Recepciones
DROP TABLE Planes
DROP TABLE Devoluciones
DROP TABLE Marcas
DROP TABLE Clientes
DROP TABLE RecepcionesDetalles
DROP TABLE Usuarios
DROP TABLE Proveedores
DROP TABLE Menus
DROP TABLE SubMenus
DROP TABLE Modelos
DROP TABLE Solicitudes
DROP TABLE Rechazos
DROP TABLE Aprobados
DROP TABLE Roles
DROP TABLE Usuarios_Roles
DROP TABLE Roles_Menus
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
