<div class="boxBranco">
    <h1>Encontre Oferta</h1>
    <ul>
        <li>
            <a href="index.jsp">Inicio</a>
        </li>
        <li>
            <a href="categorias.jsp">Categorias</a>
        </li>
        <li>
            <a href="promocoes.jsp">Promocoes</a>
        </li>
        <li>
            <a href="vendedores.jsp">Vendedores</a>
        </li>
        <%
            if (session.getAttribute("vendedor") == null) {
        %>
        <li>
            <a href="loginOuCadastro.jsp">Login | Cadastro</a>
        </li>
        <%
        } else {
        %>
        <li>
            <a href="logout.jsp">Sair</a>
        </li>
        <%
            }
        %>
    </ul>
</div>