package br.com.encontreoferta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDao {

    private Conexao conexao;
    private ResultSet resultado;

    public Promocao selecionarPorId(int id) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }

        this.resultado = conexao.consultar("Select * from app.promocao where idPromocao = " + id);
        try {
            resultado.next();
            Promocao promocao = new Promocao(
                    id, resultado.getString("cnpj"), resultado.getInt("idCategoria"),
                    resultado.getString("titulo"), resultado.getString("descricao"),
                    resultado.getBigDecimal("valor"), resultado.getString("imagem"),
                    resultado.getInt("quantidade"), resultado.getDate("tempo")
            );
            return promocao;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<Promocao> selecionarTodos(){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        this.resultado = conexao.consultar("Select * from app.promocao");
        try {
            List<Promocao> lista = new ArrayList<>();
            while (resultado.next()) {
                Promocao promocao = new Promocao(
                        resultado.getInt("idPromocao"), resultado.getString("cnpj"), resultado.getInt("idCategoria"),
                        resultado.getString("titulo"), resultado.getString("descricao"),
                        resultado.getBigDecimal("valor"), resultado.getString("imagem"),
                        resultado.getInt("quantidade"), resultado.getDate("tempo")
                );
                lista.add(promocao);
            }
            return lista;
        } catch (Exception ex) {
            return null;
        }
    }

    public boolean inserir(Promocao promocao) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return conexao.executar(String.format(
                "Insert into app.promocao(cnpj, titulo, descricao, valor, "
                + "imagem, quantidade, tempo) values('%s', '%s', '%s', %d, '%s', %d, '%s')",
                promocao.getCnpj(), promocao.getTitulo(), promocao.getDescricao(),
                promocao.getValor(), promocao.getImagem(), promocao.getQuantidade(),
                formato.format(promocao.getTempo())
        ));
    }

    public boolean alterar(Promocao promocao) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        return conexao.executar(String.format(
                "Update app.promocao set cnpj = '%s', titulo = '%s', descricao = '%s', "
                + "valor = %d, imagem = '%s', quantidade = %d, tempo = '%s'"
                + "where idPromocao = %d",
                promocao.getCnpj(), promocao.getTitulo(), promocao.getDescricao(),
                promocao.getValor(), promocao.getImagem(), promocao.getQuantidade(),
                formato.format(promocao.getTempo()), promocao.getIdPromocao()
        ));
    }
    
    public boolean apagar(Promocao promocao){
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar("delete from app.promocao where idPromocao = "+promocao.getIdPromocao());
    }
}
