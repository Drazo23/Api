create table consultas(
        id bigint not null auto_increment,
        mensaje varchar(200) not null,
        curso varchar(100) not null,
        titulo varchar (100) not null,

        primary key(id)
);