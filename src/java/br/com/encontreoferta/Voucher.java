package br.com.encontreoferta;

public class Voucher {
    int idVoucher;
    int idPromocao;

    public Voucher() {
    }

    public Voucher(int idVoucher, int idPromocao) {
        this.idVoucher = idVoucher;
        this.idPromocao = idPromocao;
    }
    
    public int getIdVoucher() {
        return idVoucher;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }
}
