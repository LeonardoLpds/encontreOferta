<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Promoção</title>
    </head>
    <body>
        <h1>Incluir Promoção</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="incluirPromocao" />
            <p><label>Titulo: <input type="text" name="titulo" required="true"></label></p>
            <p><label>Descrição: <input type="text" name="descricao" required="true"></label></p>
            <p><label>CNPJ do Vendedor: <input type="text" name="cnpj" required="true"></label></p>
            <p><label>Nome da imagem: <input type="text" name="imagem" required="true"></label></p>
            <p><label>Id da categoria: <input type="text" name="idCategoria" required="true"></label></p>
            <p><label>Quantidade: <input type="number" name="quantidade" required="true"></label></p>
            <p><label>Data de termino: <input type="date" name="tempo" required="true"></label></p>
            <p><label>Valor: <input type="number" name="valor" required="true"></label></p>
            <p><input type="submit" value="Incluir"></p>
        </form>
    </body>
</html>
