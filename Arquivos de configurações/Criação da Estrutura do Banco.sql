/*
Resetar todo o banco de dados
DROP sequence painel.seq_cd_agendamento;
DROP TABLE painel.tb_lista_espera;
DROP sequence painel.seq_id_usuario_sistema;
DROP TABLE painel.tb_usuario;
*/

create schema painel;
create sequence painel.seq_cd_agendamento;
create table painel.tb_lista_espera(
  cd_agendamento     integer default nextval('seq_cd_agendamento'),
  nm_cliente         varchar(100) null,
  cd_senha           integer not null,
  data_hora_inclusao timestamp default LOCALTIMESTAMP(0),
  cd_stutus          int not null,
  dt_mudanca_status  timestamp null,
  nm_usuario_status  varchar(50) null,
  CONSTRAINT PK_CD_AGENDAMENTO PRIMARY KEY (cd_agendamento)
);

create sequence painel.seq_id_usuario_sistema;
create table painel.tb_usuario(
  id integer,
  login varchar(50) not null,
  senha varchar(50) not null,
  constraint pk_id_usuario primary key(id)
);

--Criar a sequence seq_cd_senha
create or replace function painel.drop_sequence_cd_senha() returns void as $$
begin
  drop sequence painel.seq_cd_senha;
end;
$$ language plpgsql;

--Criar a sequence seq_cd_senha
create or replace function painel.create_sequence_cd_senha() returns void as $$
begin
  create sequence painel.seq_cd_senha;
end;
$$ language plpgsql;

--Resetar a sequencia de senhas de chamadas
create or replace function painel.reset_sequence_cd_senha() returns void as $$
begin
  execute painel.drop_sequence_cd_senha();
  execute painel.create_sequence_cd_senha();
end;
$$ language plpgsql;

----------------------------------------------------------------------------------
-- Testes
----------------------------------------------------------------------------------
select painel.drop_sequence_cd_senha();
select painel.create_sequence_cd_senha();
select painel.reset_sequence_cd_senha();

select nextval('painel.seq_cd_senha');

select md5('casa')

insert into painel.tb_usuario values(nextval('painel.seq_id_usuario_sistema'), 'adejanny', md5('87297857'));

insert into tb_lista_espera(nm_cliente, cd_senha, data_hora_inclusao, cd_stutus, dt_mudanca_status, nm_usuario_status)
values('PAULO', 1, LOCALTIMESTAMP(0), 0, NULL, 'FPAULOG');

select * from painel.tb_usuario
SELECT * FROM painel.tb_lista_espera;
SELECT LOCALTIMESTAMP(0)