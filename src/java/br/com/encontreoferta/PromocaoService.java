package br.com.encontreoferta;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PromocaoService {

    private PromocaoDao dao;

    public PromocaoService() {
        this.dao = new PromocaoDao();
    }

    public Promocao selecionarPorId(int id) {
        Promocao promocao = dao.selecionarPorId(id);
        return promocao;
    }

    public List<Promocao> selecionarTodos() {
        List<Promocao> lista = dao.selecionarTodos();
        return lista;
    }
    
    public List<Promocao> selecionarPorCategoria(int id) {
            List<Promocao> lista = dao.selecionarPorCategoria(id);
            return lista;
    }

    public boolean inserir(Promocao promocao) {
        
        if(
                promocao.getCnpj().equals("") ||
                promocao.getDescricao().equals("") ||
                promocao.getIdCategoria() <= 0 ||
                promocao.getImagem().equals("") ||
                promocao.getQuantidade() <= 0 ||
                promocao.getTempo().getTime() <= new Date().getTime() ||
                promocao.getTitulo().equals("") ||
                promocao.getValor().compareTo(BigDecimal.ZERO) < 0
        ){
            return false;
        }
        return dao.inserir(promocao);

    }

    public boolean alterar(Promocao promocao) {
        
        if(
                promocao.getCnpj().equals("") ||
                promocao.getDescricao().equals("") ||
                promocao.getIdCategoria() <= 0 ||
                promocao.getIdPromocao() <= 0 ||
                promocao.getImagem().equals("") ||
                promocao.getQuantidade() <= 0 ||
                promocao.getTempo().getTime() <= new Date().getTime() ||
                promocao.getTitulo().equals("") ||
                promocao.getValor().compareTo(BigDecimal.ZERO) > 0
        ){
            return false;
        }
        return dao.alterar(promocao);

    }

    public boolean apagar(Promocao promocao) {
        return dao.apagar(promocao);
    }
}
