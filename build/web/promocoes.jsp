
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.PromocaoDao"%>
<%@page import="br.com.encontreoferta.Promocao"%>
<%@page import="br.com.encontreoferta.CategoriaService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promoções</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@ include file="header.html" %>
        <div class="boxBranco">
            <h2>Ultimas Promoções:</h2>
            <hr>
            <table>
                <thead>
                    <tr>
                        <th>Titulo</th><th>Descrição</th><th>Valor</th>
                        <th>Valida Até</th><th>Categoria</th><th width="70">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        CategoriaService categoriaService = new CategoriaService();
                        PromocaoDao pd = new PromocaoDao();
                        List<Promocao> promocoes = pd.selecionarTodos();
                        if (promocoes != null) {
                            for (Promocao promocao : promocoes) {
                    %>
                    <tr>
                        <td><%= promocao.getTitulo()%></td>
                        <td><%= promocao.getDescricao()%></td>
                        <td><%= promocao.getValor()%></td>
                        <td><%= promocao.getTempo()%></td>
                        <td><%= categoriaService.selecionarPorId(promocao.getIdCategoria()).getNome()%></td>
                        <td align="center"><a href="controle?acao=formAlterarPromocao&id=<%= promocao.getIdPromocao()%>"><image src="imagens/editar.png" width="20" heigh="20"></a>
                            <a href="controle?acao=excluirPromocao&id=<%= promocao.getIdPromocao()%>"><image src="imagens/apagar.png" width="20" heigh="20"></a></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
            <p><a href="controle?acao=formIncluirPromocao">Incluir promoção</a></p>
        </div> 
    </body>
</html>
