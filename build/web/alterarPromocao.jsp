<%@page import="br.com.encontreoferta.Vendedor"%>
<%@page import="br.com.encontreoferta.VendedorDao"%>
<%@page import="br.com.encontreoferta.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.CategoriaService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="br.com.encontreoferta.Promocao"%>
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
            Promocao promocao = (Promocao) request.getAttribute("promocao");
        %>
        <div class="boxBranco">
            <h2>Alterar Promoção</h2>
            <hr>
            <form method="post" action="controle">
                <input type="hidden" name="acao" value="alterarPromocao" />
                <input type="hidden" name="id" value="<%= promocao.getIdPromocao()%>" />
                <p><label>Titulo: <input type="text" name="titulo" value="<%= promocao.getTitulo()%>" required="true"></label></p>
                <p><label>Descrição: <textarea name="descricao" required="true"><%= promocao.getDescricao()%></textarea></label></p>
                <p><label>Vendedor: 
                        <select name="cnpj">
                            <%
                                Vendedor vendedor = (Vendedor) session.getAttribute("vendedor");
                            %>
                            <option value="<%= vendedor.getCnpj()%>"><%= vendedor.getNomeFantasia()%></option>
                        </select>
                    </label></p>
                <p><label>Nome da imagem: <input type="text" name="imagem" value="<%= promocao.getImagem()%>" required="true"></label></p>
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
                <p><label>Quantidade: <input type="number" name="quantidade" value="<%= promocao.getQuantidade()%>" required="true"></label></p>
                <p><label>Data de termino: <input type="date" name="tempo" value="<%= promocao.getTempo()%>" required="true"></label></p>
                <p><label>Valor: <input type="number" name="valor" value="<%= new DecimalFormat("###0").format(promocao.getValor())%>" required="true"></label></p>
                <p><input type="submit" value="Alterar"></p>
            </form>
        </div>
        <%@ include file="footer.html" %>
    </body>
</html>
