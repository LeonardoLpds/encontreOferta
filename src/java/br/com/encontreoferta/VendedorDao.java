package br.com.encontreoferta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDao {

    private Conexao conexao;
    private ResultSet resultado;

    public Vendedor selecionarPorCnpj(String cnpj) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }

        this.resultado = conexao.consultar("Select * from app.vendedor where cnpj = '" + cnpj+"'");
        try {
            resultado.next();
            Vendedor vendedor = new Vendedor(
                    cnpj,
                    resultado.getString("nomeFantasia"), resultado.getString("descricao"),
                    resultado.getString("tel"), resultado.getString("endereco"),
                    resultado.getString("email"), resultado.getString("login"),
                    resultado.getString("senha")
            );
            return vendedor;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<Vendedor> selecionarTodos(){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        this.resultado = conexao.consultar("Select * from app.vendedor");
        try {
            List<Vendedor> lista = new ArrayList<>();
            while (resultado.next()) {
                Vendedor vendedor = new Vendedor(
                        resultado.getString("cnpj"), resultado.getString("nomeFantasia"),
                        resultado.getString("descricao"),
                        resultado.getString("tel"), resultado.getString("endereco"),
                        resultado.getString("email"), resultado.getString("login"),
                        resultado.getString("senha")
                );
                lista.add(vendedor);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean inserir(Vendedor vendedor) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar(String.format(
                "Insert into app.vendedor(cnpj, nomeFantasia, descricao, tel, "
                + "endereco, email, login, senha) values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                vendedor.getCnpj(), vendedor.getNomeFantasia(), vendedor.getDescricao(),
                vendedor.getTelefone(), vendedor.getEndereco(), vendedor.getEmail(),
                vendedor.getLogin(), vendedor.getSenha()
        ));
    }

    public boolean alterar(Vendedor vendedor) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar(String.format(
                "Update app.vendedor set nomeFantasia = '%s', descricao = '%s', "
                + "tel = '%s', endereco = '%s', email = '%s'"
                + " where cnpj = '%s'",
                vendedor.getNomeFantasia(), vendedor.getDescricao(),
                vendedor.getTelefone(), vendedor.getEndereco(), vendedor.getEmail(),
                vendedor.getCnpj()
        ));
    }
    
    public Vendedor logar(String user, String pass){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        this.resultado = conexao.consultar("Select * from app.vendedor where login = '"+user+"' and senha = '"+pass+"'");
        try{
            if(resultado.next()){
                Vendedor vendedor = new Vendedor(
                        resultado.getString("cnpj"), resultado.getString("nomeFantasia"),
                        resultado.getString("descricao"),
                        resultado.getString("tel"), resultado.getString("endereco"),
                        resultado.getString("email"), resultado.getString("login"),
                        resultado.getString("senha")
                );
                return vendedor;
            }
            return null;
        }catch(SQLException ex){
            return null;
        }
    }

    public boolean apagar(Vendedor vendedor) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar("delete from app.vendedor where cnpj = '" + vendedor.getCnpj()+"'");
    }
}
