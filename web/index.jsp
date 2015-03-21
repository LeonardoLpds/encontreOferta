<%@page import="br.com.encontreoferta.PromocaoDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.Promocao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Econtre Oferta</title>
    </head>
    <body>
        <h1>Encontre Oferta</h1>
        <%
            PromocaoDao pd = new PromocaoDao();
            List<Promocao> promocoes = pd.selecionarTodos();
            if (promocoes != null) {
                for (Promocao promocao : promocoes) {
                    out.print(promocao.getTitulo());
                }
            }
        %>
    </body>
</html>
