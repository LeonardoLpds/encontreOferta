<%@page import="br.com.encontreoferta.Categoria"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Promoção</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <%@ include file="header.jsp" %>
        <%
            Categoria categoria = (Categoria) request.getAttribute("categoria");
        %>
        <div class="boxBranco">
            <h2>Alterar Categoria</h2>
            <hr>
            <form method="post" action="controle">
                <input type="hidden" name="acao" value="alterarCategoria" />
                <input type="hidden" name="id" value="<%=categoria.getIdCategoria()%>" />
                <p><label>nome: <input type="text" name="nome" value="<%= categoria.getNome()%>" required="true" maxlength="50"></label></p>
                <p><label>Descrição: <input type="text" name="descricao" value="<%= categoria.getDescricao()%>" required="true" maxlength="100"></label></p>
                <p><input type="submit" value="Alterar"></p>
            </form>
        </div>
    </body>
</html>