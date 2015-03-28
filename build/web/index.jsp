<%@page import="br.com.encontreoferta.VoucherService"%>
<%@page import="br.com.encontreoferta.Voucher"%>
<%@page import="br.com.encontreoferta.CategoriaService"%>
<%@page import="br.com.encontreoferta.Vendedor"%>
<%@page import="br.com.encontreoferta.VendedorDao"%>
<%@page import="br.com.encontreoferta.Categoria"%>
<%@page import="br.com.encontreoferta.CategoriaService"%>
<%@page import="br.com.encontreoferta.PromocaoDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.Promocao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Econtre Oferta</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <!-- Lista todas as ultimas promoções -->
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
                        Vendedor vendedor = null;
                        if(session.getAttribute("vendedor") != null){
                            vendedor = (Vendedor) session.getAttribute("vendedor");
                        }
                        
                        CategoriaService categoriaService = new CategoriaService();
                        PromocaoDao pd = new PromocaoDao();
                        List<Promocao> promocoes = pd.selecionarTodos();
                        if (promocoes != null) {
                            int limit = 3;
                            if (promocoes.size() < 3) {
                                limit = promocoes.size();
                            }
                            for (int i = 0; i < limit; i++) {
                                Promocao promocao = promocoes.get(i);
                    %>
                    <tr>
                        <td><%= promocao.getTitulo()%></td>
                        <td><%= promocao.getDescricao()%></td>
                        <td><%= promocao.getValor()%></td>
                        <td><%= promocao.getTempo()%></td>
                        <% Categoria categoria = categoriaService.selecionarPorId(promocao.getIdCategoria());%>
                        <td>
                            <a href="controle?acao=verPromocoesPorCategoria&id=<%= categoria.getIdCategoria()%>">
                                <%= categoria.getNome()%>
                            </a>
                        </td>
                        <td align="center">
                            <%
                                if (vendedor != null && vendedor.getCnpj().equals(promocao.getCnpj())) {
                            %>
                            <a href="controle?acao=formAlterarPromocao&id=<%= promocao.getIdPromocao()%>">
                                <image src="imagens/editar.png" width="20" heigh="20">
                            </a>
                            <a href="controle?acao=excluirPromocao&id=<%= promocao.getIdPromocao()%>">
                                <image src="imagens/apagar.png" width="20" heigh="20">
                            </a>
                            <%
                            } if(vendedor == null) {
                            %>
                                <a href="controle?acao=incluirVoucher&id=<%= promocao.getIdPromocao()%>">
                                    Pegar Voucher
                                </a>
                            <%
                                }
                            %>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div> 
    </body>
</html>
