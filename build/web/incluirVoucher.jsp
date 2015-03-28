<%@page import="br.com.encontreoferta.Promocao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.PromocaoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incluir Voucher</title>
        <link href="estilos.css" rel="stylesheet" type="text/css">

    </head>
    <body>
        <%@ include file="header.jsp" %>
        <div class="boxBranco">
            <h2>Incluir Voucher</h2>
            <hr>
            <form method="post" action="controle">
                <input type="hidden" name="acao" value="incluirVoucher" />
                <p><label>Numero do Voucher: <input type="text" name="numVoucher" required="true"></label></p>
                <p><label>Promoção: 
                        <select name="idPromocao">
                            <%
                                PromocaoDao pd = new PromocaoDao();
                                List<Promocao> promocoes = pd.selecionarTodos();
                                if (promocoes != null) {
                                    for (Promocao promocao : promocoes) {
                            %>
                            <option value="<%= promocao.getIdPromocao()%>"><%= promocao.getTitulo()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </label></p>
                <p><input type="submit" value="incluir"></p>
            </form>
        </div>
        <%@ include file="footer.html" %>
    </body>
</html>
