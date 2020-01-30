/*
nombre de la base de datos: ssw
usuario: usuario
password: usuario
*/
drop table opta;
drop table comentarios;
drop table incidencias;
drop table administradores;

drop table usuarios;


CREATE TABLE usuarios (
    username varchar(255) PRIMARY KEY,
    password varchar(255) NOT NULL,
	nombre varchar(255),
	apellidos varchar(255),
    dni varchar(30),
    cp varchar(30),
    email varchar(255),
    tipo varchar(40) DEFAULT 'NORMAL' CONSTRAINT tipoUsuario_ck CHECK (tipo IN('NORMAL','AUTONOMO','ADMIN')),
    telefono varchar(30) DEFAULT NULL,
    especialidad VARCHAR(32) DEFAULT NULL CONSTRAINT especialidad_ck CHECK(especialidad IN('SOLDADURA', 'ALBAÑILERIA','CARPINTERIA','ELECTRICA','ENCOFRADO','FONTANERIA','PINTURA','JARDINERIA')),
    descripcion varchar(255) DEFAULT NULL,
	imagen blob DEFAULT NULL
);

CREATE TABLE administradores(
    usuario varchar(255) REFERENCES usuarios(username),
    fecha_inicio date,
    fecha_fin date
);


CREATE TABLE Incidencias (
    ID int NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    titulo varchar(255) NOT NULL,
    direccion varchar(255),
    imagen blob,
    descripcion varchar(255),
    estado VARCHAR(32) CONSTRAINT estado_ck CHECK(Estado IN('SIN_ASIGNAR', 'EN_PROGRESO', 'SOLUCIONADA', 'SIN_APROBAR', 'INVALIDA')),
    prioridad VARCHAR(32) CONSTRAINT prioridad_ck CHECK(Prioridad IN('LEVE', 'MEDIA', 'GRAVE', 'URGENTE')),
    tipoincidencia VARCHAR(32) CONSTRAINT tipoincidencia_ck CHECK(TipoIncidencia IN('SOLDADURA', 'ALBAÑILERIA','CARPINTERIA','ELECTRICA','ENCOFRADO','FONTANERIA','PINTURA','JARDINERIA')),
    usuario varchar(255) REFERENCES usuarios(username),
    autonomo varchar(255) REFERENCES usuarios(username),
	informe varchar(255) DEFAULT NULL,
    PRIMARY KEY (ID)
);


CREATE TABLE comentarios(
    usuario varchar(255) REFERENCES usuarios(username),
    incidencia int REFERENCES incidencias(id),
    comentario varchar(255)
);

CREATE TABLE opta(
    usuario varchar(255) REFERENCES usuarios(username),
    incidencia int REFERENCES incidencias(id)
);

INSERT INTO usuarios VALUES ('normal','317B32C143692B9939C197F6A5DF54F9698DF9A4882FE8BF19608968662BE4FA','normal nombre','normal apellidos','123456789A','47585','email@email.c','NORMAL',NULL,NULL,NULL,NULL);
INSERT INTO usuarios VALUES ('autonomo','928E00B27C1ADFDF56F0DEE202DC32173CF8FC03D48537AA42B4E28A4BD31002','autonomo nombre','normal apellidos','123456789A','47585','email@email.c','AUTONOMO','985214785','SOLDADURA','Autonomo de los buenos',NULL);

INSERT INTO usuarios VALUES ('admin','8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918','admin nombre','admin apellidos','123456789A','47585','email@email.c','ADMIN',NULL,NULL,NULL,NULL);
INSERT INTO administradores VALUES ('admin','2010-01-01',NULL);

INSERT INTO INCIDENCIAS (TITULO, DIRECCION, IMAGEN, DESCRIPCION, ESTADO, PRIORIDAD, TIPOINCIDENCIA, USUARIO, AUTONOMO)
	VALUES ('Farola no enciende', 'Calle manzano', NULL, 'Hay una farola que no enciende en la calle manzano', 'SOLUCIONADA', 'LEVE', 'ELECTRICA', 'normal', 'autonomo');

INSERT INTO INCIDENCIAS (TITULO, DIRECCION, IMAGEN, DESCRIPCION, ESTADO, PRIORIDAD, TIPOINCIDENCIA, USUARIO, AUTONOMO)
	VALUES ('Semaforo roto', 'Calle manzano', NULL, 'Hay una semaforo que no enciende en la calle manzano', 'SIN_ASIGNAR', 'LEVE', 'ELECTRICA', 'normal', NULL);