package br.com.encontreoferta;

public class Voucher {
    int idVoucher;
    int idPromocao;
    int idCliente;

    public Voucher() {
    }

    public Voucher(int idVoucher, int idPromocao, int idCliente) {
        this.idVoucher = idVoucher;
        this.idPromocao = idPromocao;
        this.idCliente = idCliente;
    }
    
    public int getIdVoucher() {
        return idVoucher;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
