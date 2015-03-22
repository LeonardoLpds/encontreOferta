<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Vendedor</title>
    </head>
    <body>
        <h1>Incluir Vendedor</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="incluirVendedor" />
            <p><label>CNPJ: <input type="text" name="cnpj" required="true"></label></p>
            <p><label>Nome Fantasia: <input type="text" name="nome" required="true"></label></p>
            <p><label>Descrição: <input type="text" name="descricao" required="true"></label></p>
            <p><label>Telefone: <input type="text" name="telefone" required="true"></label></p>
            <p><label>Email: <input type="email" name="email" required="true"></label></p>
            <p><label>Endereço: <input type="text" name="endereco" required="true"></label></p>
            <p><input type="submit" value="incluir"></p>
        </form>
    </body>
</html>
