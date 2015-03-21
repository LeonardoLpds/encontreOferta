package br.com.encontreoferta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private Conexao conexao;
    private ResultSet resultado;
    
    public Categoria SelecionarPorId(int id){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }

        this.resultado = conexao.consultar("Select * from app.categoria where idCategoria = " + id);
        try {
            resultado.next();
            Categoria categoria = new Categoria(id, resultado.getString("nome"), resultado.getString("descricao"));
            return categoria;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public List<Categoria> selecionarTodos() {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        this.resultado = conexao.consultar("Select * from app.categoria");
        try {
            List<Categoria> lista = new ArrayList<>();
            while (resultado.next()) {
                Categoria categoria = new Categoria(
                        resultado.getInt("idCategoria"), resultado.getString("nome"), 
                        resultado.getString("descricao")
                );
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean inserir(Categoria categoria) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar(String.format(
                "Insert into app.categoria(nome, descricao) values('%s', '%s')",
                categoria.getNome(), categoria.getDescricao()
        ));
    }
    
    public boolean alterar(Categoria categoria) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar(String.format(
                "Update app.categoria set nome = '%s', descricao = '%s' where idCategoria = %d",
                categoria.getNome(), categoria.getDescricao(), categoria.getIdCategoria()
        ));
    }
    
    public boolean apagar(Categoria categoria){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar("delete from app.categoria where idCategoria = "+categoria.getIdCategoria());
    }
}
