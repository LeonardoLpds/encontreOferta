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
            <div class="boxleft">
                <h2>Login</h2>
                <form method="post" action="loginOuCadastro.jsp">
                    <p><label>Nome de Usuário:</label> <input name="usuario" type="text" required="true" /></p>
                    <p><label>Senha:</label> <input name="senha" type="password" required="true" /></p>
                    <input type="submit" readonly="true" value="Acessar" />
                </form>

                <%                    if (request.getParameter("usuario") != null) {
                        VendedorDao vendedorDao = new VendedorDao();
                        Vendedor vendedor = vendedorDao.logar(request.getParameter("usuario"), request.getParameter("senha"));
                        if (vendedor != null) {
                            session.setAttribute("vendedor", vendedor);
                            response.sendRedirect("index.jsp");
                        } else {
                %>
                <div class="alertaErro">
                    Usuário ou senha inválidos.<br>Verifique os dados digitados.
                </div>
                <%
                        }
                    }
                %>

            </div>
            <div class="boxright">
                <%
                    if(request.getAttribute("error") != null){
                %>
                <div class="alertaErro">
                    <%= request.getAttribute("error")%>
                </div>
                <%
                    }
                %>
                <h2>Cadastro</h2>
                <form method="post" action="controle">
                    <input type="hidden" name="acao" value="incluirVendedor" />
                    <p><label>Nome de Usuário: </label><input type="text" name="usuario" required="true"></p>
                    <p><label>Senha: </label><input type="password" name="senha" required="true"></p>
                    <p><label>CNPJ: </label><input type="text" name="cnpj" required="true"></p>
                    <p><label>Nome Fantasia: </label><input type="text" name="nome" required="true"></p>
                    <p><label>Descrição: </label><input type="text" name="descricao" required="true"></p>
                    <p><label>Telefone: </label><input type="text" name="telefone" required="true"></p>
                    <p><label>Email: </label><input type="email" name="email" required="true"></p>
                    <p><label>Endereço: </label><input type="text" name="endereco" required="true"></p>
                    <p><input type="submit" value="incluir"></p>
                </form>
            </div>
            <div class="clear"></div>
        </div>
    </body>
</html>
