package br.com.encontreoferta;
import java.io.Serializable;

public class Voucher implements Serializable{
    String idVoucher;
    int idPromocao;

    public Voucher() {
    }

    public Voucher(String idVoucher, int idPromocao) {
        this.idVoucher = idVoucher;
        this.idPromocao = idPromocao;
    }
    
    public String getIdVoucher() {
        return idVoucher;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdVoucher(String idVoucher) {
        this.idVoucher = idVoucher;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }
}
