<%@page import="br.com.encontreoferta.Categoria"%>
<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Promoção</title>
    </head>
    <body>
        <%
            Categoria categoria = (Categoria) request.getAttribute("categoria");
        %>
        <h1>Alterar Categoria</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="alterarCategoria" />
            <input type="hidden" name="id" value="<%=categoria.getIdCategoria()%>" />
            <p><label>nome: <input type="text" name="nome" value="<%= categoria.getNome()%>" required="true"></label></p>
            <p><label>Descrição: <input type="text" name="descricao" value="<%= categoria.getDescricao()%>" required="true"></label></p>
            <p><input type="submit" value="Alterar"></p>
        </form>
    </body>
</html>