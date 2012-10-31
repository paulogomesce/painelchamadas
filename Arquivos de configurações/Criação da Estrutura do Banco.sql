--Resetar todo o schema
/*
DROP sequence painel.seq_id_usuario_sistema;
DROP TABLE painel.tb_lista_espera;
DROP sequence painel.seq_cd_agendamento;
DROP sequence painel.seq_cd_senha;
DROP TABLE painel.tb_usuario;
DROP function painel.drop_sequence_cd_senha();
DROP function painel.create_sequence_cd_senha();
DROP function painel.reset_sequence_cd_senha();
DROP schema painel;
*/
/*

CREATE DATABASE painel
  WITH ENCODING='UTF8'
       OWNER=postgres
       LC_COLLATE='Portuguese, Brazil'
       LC_CTYPE='Portuguese, Brazil'
       CONNECTION LIMIT=-1;
*/

create schema painel;
create sequence painel.seq_cd_agendamento;
create sequence painel.seq_cd_senha
  MINVALUE 1
  MAXVALUE 99999;
create table painel.tb_lista_espera(
  cd_agendamento     integer default nextval('painel.seq_cd_agendamento'),
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

--Cria o login do usuario administrador do sistema
insert into painel.tb_usuario values(nextval('painel.seq_id_usuario_sistema'), 'administrador', md5('administrador'));

CREATE ROLE painel LOGIN ENCRYPTED PASSWORD 'md580536d4226e2e45a1cd5d337d622d5a9'
  SUPERUSER CREATEDB CREATEROLE REPLICATION
   VALID UNTIL 'infinity';