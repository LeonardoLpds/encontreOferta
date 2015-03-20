package br.com.encontreoferta;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

public class Promocao implements Serializable{

    int idPromocao;
    String cnpj;
    String titulo;
    String descricao;
    BigDecimal valor;
    String imagem;
    int quantidade;
    Date tempo;

    public Promocao() {
    }

    public Promocao(
            int idPromocao, String cnpj, String titulo, String descricao,
            BigDecimal valor, String imagem, int quantidade, Date tempo
    ) {
        this.idPromocao = idPromocao;
        this.cnpj = cnpj;
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
        this.imagem = imagem;
        this.quantidade = quantidade;
        this.tempo = tempo;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getImagem() {
        return imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }
}
