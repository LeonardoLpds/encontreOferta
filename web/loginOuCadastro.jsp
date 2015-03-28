<%@page import="br.com.encontreoferta.Vendedor"%>
<%@page import="br.com.encontreoferta.VendedorDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | Cadastro</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="boxBranco">
            <div>
                <%
                    if (request.getParameter("usuario") != null) {
                        VendedorDao vendedorDao = new VendedorDao();
                        Vendedor vendedor = vendedorDao.logar(request.getParameter("usuario"), request.getParameter("senha"));
                        if (vendedor != null) {
                            session.setAttribute("vendedor", vendedor);
                            response.sendRedirect("index.jsp");
                        } else {
                            out.print("Usuário ou senha inválido");
                        }
                    }
                %>
            </div>
            <h2>Login</h2>
            <form method="post" action="loginOuCadastro.jsp">
                <label>Nome de Usuário:</label> <input name="usuario" type="text" required="true" />
                <label>Senha:</label> <input name="senha" type="password" style="border: 1px solid #000" required="true" />
                <input type="submit" readonly="true" value="Acessar" />
            </form>
            <h2>Cadastro</h2>
            <form method="post" action="controle">
                <input type="hidden" name="acao" value="incluirVendedor" />
                <p><label>Nome de Usuário: <input type="text" name="usuario" required="true"></label></p>
                <p><label>Senha: <input type="password" name="senha" required="true" style="border: 1px solid;"></label></p>
                <p><label>CNPJ: <input type="text" name="cnpj" required="true"></label></p>
                <p><label>Nome Fantasia: <input type="text" name="nome" required="true"></label></p>
                <p><label>Descrição: <input type="text" name="descricao" required="true"></label></p>
                <p><label>Telefone: <input type="text" name="telefone" required="true"></label></p>
                <p><label>Email: <input type="email" name="email" required="true"></label></p>
                <p><label>Endereço: <input type="text" name="endereco" required="true"></label></p>
                <p><input type="submit" value="incluir"></p>
            </form>
        </div>
    </body>
</html>
