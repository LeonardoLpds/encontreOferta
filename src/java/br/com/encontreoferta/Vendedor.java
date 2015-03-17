package br.com.encontreoferta;

public class Vendedor {

    int cnpj;
    String nomeFantasia;
    String descricao;
    String telefone;
    String endereco;
    String email;
    String login;
    String senha;

    public Vendedor() {
    }

    public Vendedor(
            int cnpj, String nomeFantasia, String descricao, String telefone,
            String endereco, String email, String login, String senha
    ) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.descricao = descricao;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public int getCnpj() {
        return cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
