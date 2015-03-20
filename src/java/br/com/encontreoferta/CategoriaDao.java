package br.com.encontreoferta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private Conexao conexao;
    private ResultSet resultado;
    
    Categoria SelecionarPorId(int id){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }

        this.resultado = conexao.consultar("Select * from categoria where id = " + id);
        try {
            resultado.next();
            Categoria categoria = new Categoria(id, resultado.getString("nome"), resultado.getString("descricao"));
            return categoria;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    List<Categoria> selecionarTodos() {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        this.resultado = conexao.consultar("Select * from categoria");
        try {
            List<Categoria> lista = new ArrayList<>();
            while (resultado.next()) {
                Categoria categoria = new Categoria(
                        resultado.getInt("id"), resultado.getString("nome"), 
                        resultado.getString("descricao")
                );
                lista.add(categoria);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    boolean inserir(Categoria categoria) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar(String.format(
                "Insert into categoria(nome, descricao) values('%s', '%s')",
                categoria.getNome(), categoria.getDescricao()
        ));
    }
    
    boolean alterar(Categoria categoria) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar(String.format(
                "Update categoria set idCategoria = %d, nome = '%s', descricao = '%s'",
                categoria.getIdCategoria(), categoria.getNome(), categoria.getDescricao()
        ));
    }
    
    boolean apagar(Categoria categoria){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar("delete from categoria where idCategoria = "+categoria.getIdCategoria());
    }
}
