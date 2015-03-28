<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Categoria</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="boxBranco">
            <h2>Incluir Categoria</h2>
            <hr>
            <form method="post" action="controle">
                <input type="hidden" name="acao" value="incluirCategoria" />
                <p><label>Nome: <input type="text" name="nome" required="true" maxlength="50" ></label></p>
                <p><label>Descrição: <input type="text" name="descricao" required="true" maxlength="100" ></label></p>
                <p><input type="submit" value="incluir"></p>     
            </form>
        </div>
        <%@ include file="footer.html" %>
    </body>
</html>
