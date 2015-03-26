package br.com.encontreoferta;
import java.util.List;

public class VoucherService {
    private VoucherDao dao;
    
    public VoucherService(){
        this.dao = new VoucherDao();
    }
    
    public Voucher selecionarPorNumeroDoVoucher(String num){
        Voucher voucher = dao.selecionarPorNumeroDoVoucher(num);
        return voucher;
    }
    
    public List<Voucher> selecionarTodos(){
        List<Voucher> lista = dao.selecionarTodos();
        return lista;
    }
    
    public boolean inserir(Voucher voucher){
        if(voucher.getIdVoucher().equals("") || voucher.getIdPromocao() <= 0){
            return false;
        }
        dao.inserir(voucher);
        return true;
    }
    
    public boolean alterar(Voucher voucher){
        if(voucher.getIdVoucher().equals("") || voucher.getIdPromocao() <= 0){
            return false;
        }
        dao.inserir(voucher);
        return true;
    }
    
    public void apagar(Voucher voucher){
        dao.apagar(voucher);
    }
}
