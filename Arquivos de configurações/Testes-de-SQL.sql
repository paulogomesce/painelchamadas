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