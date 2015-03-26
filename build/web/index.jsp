<%@page import="br.com.encontreoferta.Voucher"%>
<%@page import="br.com.encontreoferta.VoucherDao"%>
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
        <%@ include file="header.html" %>
        <div class="boxBranco">
          <h2>Categorias:</h2>
          <hr>
          <table>
            <thead>
              <tr>
                <th>Nome</th><th>Descrição</th><th width="70">Ações</th>
                </tr>
              </thead>
            <tbody>
              <%
                    CategoriaService categoriaService = new CategoriaService();
                    List<Categoria> categorias = categoriaService.selecionarTodos();
                    if (categorias != null) {
                        for (Categoria categoria : categorias) {
                %>
              <tr>
                <td><%= categoria.getNome()%></td>
                <td><%= categoria.getDescricao()%></td>
                <td align="center"><a href="controle?acao=formAlterarCategoria&id=<%= categoria.getIdCategoria()%>"><image src="imagens/editar.png" width="20" heigh="20"></a>
                  <a href="controle?acao=excluirCategoria&id=<%= categoria.getIdCategoria()%>"><image src="imagens/apagar.png" width="20" heigh="20"></a></td>
                </tr>
              <%
                        }
                    }
                %>
              </tbody>
            </table>
          <p><a href="controle?acao=formIncluirCategoria">Incluir categoria</a></p>
        </div>
        <div class="boxBranco">
          <h2>Promoções:</h2>
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
        <div class="boxBranco">
          <h2>Vendedores:</h2>
          <hr>
          <table>
            <thead>
              <tr>
                <th>Nome</th><th>CNPJ</th><th>Descrição</th>
                <th>Telefone</th><th>Endereço</th><th>Email</th><th width="70">Ações</th>
                </tr>
              </thead>
            <tbody>
              <%
                    VendedorDao vd = new VendedorDao();
                    List<Vendedor> vendedores = vd.selecionarTodos();
                    if (vendedores != null) {
                        for (Vendedor vendedor : vendedores) {
                %>
              <tr>
                <td><%= vendedor.getNomeFantasia()%></td>
                <td><%= vendedor.getCnpj()%></td>
                <td><%= vendedor.getDescricao()%></td>
                <td><%= vendedor.getTelefone()%></td>
                <td><%= vendedor.getEndereco()%></td>
                <td><%= vendedor.getEmail()%></td>
                <td align="center"><a href="controle?acao=formAlterarVendedor&cnpj=<%= vendedor.getCnpj()%>"><image src="imagens/editar.png" width="20" heigh="20"></a>
                  <a href="controle?acao=excluirVendedor&cnpj=<%= vendedor.getCnpj()%>"><image src="imagens/apagar.png" width="20" heigh="20"></a></td>
                </tr>
              <%
                        }
                    }
                %>
              </tbody>
            </table>
          <p><a href="controle?acao=formIncluirVendedor">Incluir vendedor</a></p>
        </div>
        <div class="boxBranco">
          <h2>Vouchers:</h2>
          <hr>
          <table>
            <thead>
              <tr>
                <th width="70">Voucher n&ordm;</th><th>Promoção</th><th width="70">Ação</th>
                </tr>
              </thead>
            <tbody>
              <%
                    VoucherDao vod = new VoucherDao();
                    List<Voucher> vouchers = vod.selecionarTodos();
                    if (vouchers != null) {
                        for (Voucher voucher : vouchers) {
                %>
              <tr>
                <td align="center"><%= voucher.getIdVoucher()%></td>
                <td><%= pd.selecionarPorId(voucher.getIdPromocao()).getTitulo() %></td>
                <td align="center"><a href="controle?acao=excluirVoucher&numVoucher=<%= voucher.getIdVoucher()%>"><image src="imagens/apagar.png" width="20" heigh="20"></a></td>
                </tr>
              <%
                        }
                    }
                %>
              </tbody>
            </table>
          <p><a href="controle?acao=formIncluirVoucher">Incluir voucher</a></p>
        </div>
</body>
</html>
