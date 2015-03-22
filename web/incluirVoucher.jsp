<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Voucher</title>
    </head>
    <body>
        <h1>Incluir Voucher</h1>
        <form method="post" action="controle">
            <input type="hidden" name="acao" value="incluirVoucher" />
            <p><label>Numero do Voucher: <input type="text" name="numVoucher" required="true"></label></p>
            <p><label>Id da promoção: <input type="text" name="idPromocao" required="true"></label></p>
            <p><input type="submit" value="incluir"></p>
        </form>
    </body>
</html>
