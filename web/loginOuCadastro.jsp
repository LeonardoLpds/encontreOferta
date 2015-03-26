<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | Cadastro</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@ include file="header.html" %>
        <div class="boxBranco">
            <form>
                <h2>Login</h2>
                <label>Nome de Usuário:</label> <input type="text" />
                <label>Senha:</label> <input type="password" style="border: 1px solid #000"/>
                <input type="submit" readonly="true" />
            </form>
            <form>
                <h2>Cadastro</h2>
                <label>Nome de Usuário:</label> <input type="text" />
                <label>Senha:</label> <input type="password" style="border: 1px solid #000"/>
                <label>Nome Fantasia:</label> <input type="text" />
                <label>CNPJ:</label> <input type="text" />
                <label>Email:</label> <input type="email" />
                <label>Telefone:</label> <input type="text" />
                <label>Telefone:</label> <input type="text" />
                <label>Descrição:</label> <input type="text" />
                <input type="submit" readonly="true" />
            </form>
        </div>
    </body>
</html>
