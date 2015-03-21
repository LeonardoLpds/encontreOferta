<%@page import="br.com.encontreoferta.CategoriaDao"%>
<%@page import="br.com.encontreoferta.PromocaoDao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.encontreoferta.Promocao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Econtre Oferta</title>
        <style type="text/css">
            table{border-collapse: collapse;}
            th{background-color: green; color: whitesmoke;}
            th, td{padding: 10px;}
            table, th, td{border: 2px solid black}
            a{font-weight: bold; color: green;}
            a:link, a:visited{text-decoration: none;}
            a:hover, a:active{text-decoration: underline;}

        </style>
    </head>
    <body>
        <h1>Encontre Oferta</h1>
        <h2>Promoções:</h2>
        <table>
            <thead>
                <tr>
                    <th>Titulo</th><th>Descrição</th><th>Valor</th><th>Valida Até</th><th>Categoria</th>
                </tr>
            </thead>
            <tbody>
                <%
                    PromocaoDao pd = new PromocaoDao();
                    CategoriaDao cd = new CategoriaDao();
                    List<Promocao> promocoes = pd.selecionarTodos();
                    if (promocoes != null) {
                        for (Promocao promocao : promocoes) {
                %>
                <tr>
                    <td><%= promocao.getTitulo() %></td><td><%= promocao.getDescricao()%></td><td><%= promocao.getValor()%></td><td><%= promocao.getTempo() %></td><td><%  %></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
