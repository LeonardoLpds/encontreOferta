<%@page import="br.com.encontreoferta.Vendedor"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.VendedorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendedores</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@ include file="header.html" %>
        <!-- Lista todos os vendedores -->
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
    </body>
</html>
