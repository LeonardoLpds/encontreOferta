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
            
            
            EnsaioService service = new EnsaioService();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat formatoNumero = new DecimalFormat("R$ #,##0.00");
            List<Ensaio> ensaios = service.selecionarTodos();
            String msg = service.getMsg();
            if (!msg.equals("Sucesso")) {
                response.sendRedirect(String.format("controle?acao=exibirErro&msg=%s", msg));
            }
        %>
    </body>
</html>
