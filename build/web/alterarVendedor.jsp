<%@page import="br.com.encontreoferta.Vendedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Vendedor</title>
    </head>
    <body>
        <%
            Vendedor vendedor = (Vendedor) request.getAttribute("vendedor");
        %>
        <h1>Alterar Vendedor</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="alterarVendedor" />
            <input type="hidden" name="cnpj" value="<%= vendedor.getCnpj()%>" />
            <p><label>Nome Fantasia: <input type="text" name="nome" value="<%= vendedor.getNomeFantasia()%>" required="true"></label></p>
            <p><label>Descrição: <input type="text" name="descricao" value="<%= vendedor.getDescricao()%>" required="true"></label></p>
            <p><label>Telefone: <input type="text" name="telefone" value="<%= vendedor.getTelefone()%>" required="true"></label></p>
            <p><label>Email: <input type="text" name="email" value="<%= vendedor.getEmail()%>" required="true"></label></p>
            <p><label>Endereço: <input type="text" name="endereco" value="<%= vendedor.getEndereco()%>" required="true"></label></p>
            <p><input type="submit" value="Alterar"></p>
        </form>
    </body>
</html>
