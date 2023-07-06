create table tcliente
(
    codcli bigint auto_increment primary key,
    nomcli varchar(150) not null,
	email  varchar(255) not null,
    senha  varchar(200) not null
);

create table tfuncionario
(
    codfunc bigint auto_increment primary key,
    nomfunc varchar(150) not null,
    senha   varchar(200) not null
);
