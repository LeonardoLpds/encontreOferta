<%@page import="br.com.encontreoferta.Voucher"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parabens</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
            Voucher voucher = (Voucher) request.getAttribute("voucher");
        %>
        <%@ include file="header.jsp" %>
        <div class="boxBranco">
            <h2>Parabens pela sua aquisição</h2>
            <p>
                O número do seu voucher é <%= voucher.getIdVoucher() %>
            </p>
        </div>
        <%@ include file="footer.html" %>
    </body>
</html>
