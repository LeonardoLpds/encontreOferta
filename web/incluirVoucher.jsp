<%@page import="br.com.encontreoferta.Promocao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.PromocaoDao"%>
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
            <p><label>Promoção: 
                    <select name="idPromocao">
                        <%
                            PromocaoDao pd = new PromocaoDao();
                            List<Promocao> promocoes = pd.selecionarTodos();
                            if (promocoes != null) {
                                for (Promocao promocao : promocoes) {
                        %>
                            <option value="<%= promocao.getIdPromocao() %>"><%= promocao.getTitulo() %></option>
                        <%
                                }
                            }
                        %>
                    </select>
                </label></p>
            <p><input type="submit" value="incluir"></p>
        </form>
    </body>
</html>
