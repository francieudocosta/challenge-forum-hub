create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null ,
    mensagem varchar(600) not null,
    data datetime not null,
    estado tinyint not null,
    autor varchar(100) not null,
    curso_id bigint not null,

    primary key (id),
    constraint fk_topico_curso_id foreign key (curso_id) references cursos(id)
);