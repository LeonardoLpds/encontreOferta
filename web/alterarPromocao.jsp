<%@page import="java.text.DecimalFormat"%>
<%@page import="br.com.encontreoferta.Promocao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Promoção</title>
    </head>
    <body>
        <%
            Promocao promocao = (Promocao) request.getAttribute("promocao");
        %>
        <h1>Alterar Promoção</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="alterar" />
            <input type="hidden" name="id" value="<%= promocao.getIdPromocao()%>" />
            <p><label>Titulo: <input type="text" name="titulo" value="<%= promocao.getTitulo()%>" required="true"></label></p>
            <p><label>Descrição: <input type="text" name="descricao" value="<%= promocao.getDescricao()%>" required="true"></label></p>
            <p><label>CNPJ do Vendedor: <input type="text" name="cnpj" value="<%= promocao.getCnpj()%>" required="true"></label></p>
            <p><label>Nome da imagem: <input type="text" name="imagem" value="<%= promocao.getImagem()%>" required="true"></label></p>
            <p><label>Id da categoria: <input type="text" name="idCategoria" value="<%= promocao.getIdCategoria()%>" required="true"></label></p>
            <p><label>Quantidade: <input type="number" name="quantidade" value="<%= promocao.getQuantidade()%>" required="true"></label></p>
            <p><label>Data de termino: <input type="date" name="tempo" value="<%= promocao.getTempo()%>" required="true"></label></p>
            <p><label>Valor: <input type="number" name="valor" value="<%= new DecimalFormat("###0").format(promocao.getValor())%>" required="true"></label></p>
            <p><input type="submit" value="Alterar"></p>
        </form>
    </body>
</html>
