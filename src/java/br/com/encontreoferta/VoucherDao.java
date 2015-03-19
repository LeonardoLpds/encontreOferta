package br.com.encontreoferta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VoucherDao {

    private Conexao conexao;
    private ResultSet resultado;

    Voucher selecionarPorNumeroDoVoucher(String num) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }

        this.resultado = conexao.consultar("Select * from voucher where idVoucher = " + num);
        try {
            resultado.next();
            Voucher voucher = new Voucher(
                    num, resultado.getInt("idPromocao")
            );
            return voucher;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    List<Voucher> selecionarTodos() {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        this.resultado = conexao.consultar("Select * from voucher");
        try {
            List<Voucher> lista = new ArrayList<>();
            while (resultado.next()) {
                Voucher voucher = new Voucher(
                        resultado.getString("idVoucher"), resultado.getInt("idPromocao")
                );
                lista.add(voucher);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

    boolean inserir(Voucher voucher) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar(String.format(
                "Insert into voucher(idVoucher, idPromocao) values('%s', %d)",
                voucher.getIdVoucher(), voucher.getIdPromocao()
        ));
    }

    boolean apagar(Voucher voucher) {
        if (this.conexao == null) {
            this.conexao = new Conexao();
        }
        return conexao.executar("delete from voucher where idvoucher = " + voucher.getIdVoucher());
    }
}
