create table tcliente
(
    codcli long auto_increment primary key,
    nomcli varchar(150) not null,
    email  varchar(255) not null,
    senha  varchar(200) not null
);

create table tfuncionario
(
    codfunc long auto_increment primary key,
    nomfunc varchar(150) not null,
    usuario varchar(150) not null,
    senha   varchar(200) not null
);

insert into tfuncionario values (1, Administrador, admin, admin)