<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.painel.persistence.ManterListaEsperaDAO" %>
<%@ page import="br.com.painel.persistence.ManterListaEsperaDAOImpl" %>
<%@ page import="br.com.painel.domain.ListaEspera" %>
<%@ page import="java.math.BigDecimal" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="refresh" content="3;URL=chamada.jsp" />
<title>Chamada de Clientes</title>
</head>
<body>

<%
ManterListaEsperaDAO listaEspera = new ManterListaEsperaDAOImpl();
String nome      = null;
BigDecimal senha = null;
String nomeAudio = null;

for(ListaEspera lista : listaEspera.chamaProximoDaFila()){
  nome  = lista.getNmCliente();
  senha = lista.getCdSenha();
}

nomeAudio = nome;

%>

<h1>Senha: <%=senha%></h1>
<h1>Usu�rio: <%=nomeAudio%></h1>

<%  if(nomeAudio != null){ %>
<embed src="http://translate.google.com.br/translate_tts?ie=UTF-8&q=<%=nomeAudio%>&tl=pt&total=1&idx=0&textlen=30&prev=input" autostart="true" loop="true" hidden="true">
</embed>
<%  } %>


</body>
</html>