create table if not exists jogadores(
    id serial,
    nome varchar(30),
    dataNasc date,
    timeJogador varchar(30),
    altura int,
    peso float,
    camisa varchar(3),
    gols int,
    assists int
);