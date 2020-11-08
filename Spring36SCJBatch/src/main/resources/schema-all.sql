drop table if exists TB_ALUNO;

create table TB_ALUNO(
    id INTEGER auto_increment primary key,
    nome varchar(200),
    rm INTEGER NOT NULL,
    codigo_curso varchar(6)
);
