<%@page import="br.com.encontreoferta.CategoriaService"%>
<%@page import="br.com.encontreoferta.Categoria"%>
<%@page import="br.com.encontreoferta.Vendedor"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.VendedorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Promoção</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <%@ include file="header.html" %>
        <div class="boxBranco">
            <h2>Incluir Promoção</h2>
            <hr>
            <form method="post" action="controle">
                <input type="hidden" name="acao" value="incluirPromocao" />
                <p><label>Titulo: <input type="text" name="titulo" required="true"></label></p>
                <p><label>Descrição: <textarea name="descricao" maxlength="200" required id="descricao"></textarea></label></p>
                <p><label>Vendedor: 
                        <select name="cnpj">
                            <%
                                VendedorDao vd = new VendedorDao();
                                List<Vendedor> vendedores = vd.selecionarTodos();
                                if (vendedores != null) {
                                    for (Vendedor vendedor : vendedores) {
                            %>
                            <option value="<%= vendedor.getCnpj()%>"><%= vendedor.getNomeFantasia()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </label></p>
                <p><label>Nome da imagem: <input type="text" name="imagem" required="true"></label></p>
                <p><label>Categoria: 
                        <select name="idCategoria">
                            <%
                                CategoriaService categoriaService = new CategoriaService();
                                List<Categoria> categorias = categoriaService.selecionarTodos();
                                if (categorias != null) {
                                    for (Categoria categoria : categorias) {
                            %>
                            <option value="<%= categoria.getIdCategoria()%>"><%= categoria.getNome()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </label></p>
                <p><label>Quantidade: <input type="number" name="quantidade" required="true"></label></p>
                <p><label>Data de termino: <input type="date" name="tempo" required="true"></label></p>
                <p><label>Valor: <input type="number" name="valor" required="true"></label></p>
                <p><input type="submit" value="Incluir"></p>
            </form>
        </div>
        <%@ include file="footer.html" %>
    </body>
</html>
