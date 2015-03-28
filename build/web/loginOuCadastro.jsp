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
            <form method="post" action="loginOuCadastro.jsp">
                <h2>Login</h2>
                <label>Nome de Usuário:</label> <input name="usuario" type="text" required="true" />
                <label>Senha:</label> <input name="senha" type="password" style="border: 1px solid #000" required="true" />
                <input type="submit" readonly="true" value="Acessar" />
            </form>
            <form>
                <h2>Cadastro</h2>
                <label>Nome de Usuário:</label> <input type="text" />
                <label>Senha:</label> <input type="password" style="border: 1px solid #000"/>
                <label>Nome Fantasia:</label> <input type="text" />
                <label>CNPJ:</label> <input type="text" />
                <label>Email:</label> <input type="email" />
                <label>Telefone:</label> <input type="text" />
                <label>Endereco:</label> <input type="text" />
                <label>Descrição:</label> <input type="text" />
                <input type="submit" readonly="true" value="Cadastrar" />
            </form>
        </div>
    </body>
</html>
