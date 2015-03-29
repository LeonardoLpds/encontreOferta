package br.com.encontreoferta;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PromocaoService {

    private PromocaoDao dao;
    int idPromocao = 0;
    String cnpj = "";
    int idCategoria = 0;
    String titulo = "";
    String descricao = "";
    BigDecimal valor;
    String imagem = "";
    int quantidade = 0;
    Date dataMinima = new Date();

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

    public boolean inserir(int idPromocao, String cnpj, int idCategoria, String titulo, String descricao,
        BigDecimal valor, String imagem, int quantidade, Date tempo) {

        dao = new PromocaoDao();
        Promocao promocao = new Promocao();
        Categoria categoria = new Categoria();
        if (idCategoria <= 0) {
            return false;
        } else {
            promocao.setIdCategoria(categoria.getIdCategoria());
        }

        if (cnpj.equals("") || cnpj.length() != 14) {
            return false;
        } else {
            promocao.setCnpj(cnpj);
        }
        if (descricao.equals("")) {
            return false;
        } else {
            promocao.setDescricao(descricao);
        }
        if (idPromocao == 0 || idPromocao <= 0) {
            return false;
        } else {
            promocao.setIdPromocao(idPromocao);
        }

        if (imagem.equals("")) {
            return false;
        } else {
            promocao.setImagem(imagem);
        }
        if (quantidade <= 0) {
            return false;
        } else {
            promocao.setQuantidade(quantidade);
        }
        if (tempo.getTime() < dataMinima.getTime()) {
            return false;
        } else {
            promocao.setTempo(tempo);
        }
        if (titulo.equals("")) {
            return false;
        } else {
            promocao.setTitulo(titulo);
        }
        
        if(valor.compareTo(BigDecimal.ZERO) < 0){
            return false;
        }else{
            promocao.setValor(valor);
        }
        
        dao.inserir(promocao);
        return true;

    }

    public boolean alterar(int idPromocao, String cnpj, int idCategoria, String titulo, String descricao,
            BigDecimal valor, String imagem, int quantidade, Date tempo) {
        dao = new PromocaoDao();
        Promocao promocao1 = new Promocao();
        Categoria categoria = new Categoria();
        if (idCategoria <= 0) {
            return false;
        } else {
            promocao1.setIdCategoria(categoria.getIdCategoria());
        }

        if (cnpj.equals("") || cnpj.length() != 14) {
            return false;
        } else {
            promocao1.setCnpj(cnpj);
        }
        if (descricao.equals("")) {
            return false;
        } else {
            promocao1.setDescricao(descricao);
        }
        if (idPromocao == 0 || idPromocao <= 0) {
            return false;
        } else {
            promocao1.setIdPromocao(idPromocao);
        }

        if (imagem.equals("")) {
            return false;
        } else {
            promocao1.setImagem(imagem);
        }
        if (quantidade <= 0) {
            return false;
        } else {
            promocao1.setQuantidade(quantidade);
        }
        if (tempo.getTime() < dataMinima.getTime()) {
            return false;
        } else {
            promocao1.setTempo(tempo);
        }
        if (titulo.equals("")) {
            return false;
        } else {
            promocao1.setTitulo(titulo);
        }
        
        if(valor.compareTo(BigDecimal.ZERO) < 0){
            return false;
        }else{
            promocao1.setValor(valor);
        }

        dao.alterar(promocao1);
        return true;
    }

    public void apagar(int idPromocao) {
        
        dao = new PromocaoDao();
        Promocao promocao = new Promocao();
        promocao.setIdPromocao(idPromocao);
        promocao.setCnpj("");
        promocao.setDescricao("");
        promocao.setIdCategoria(0);
        promocao.setImagem("");
        promocao.setQuantidade(0);
        promocao.setTempo(dataMinima);
        promocao.setTitulo("");
        promocao.setValor(BigDecimal.ZERO);
        
        dao.apagar(promocao);
    }
}
