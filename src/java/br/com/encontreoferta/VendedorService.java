package br.com.encontreoferta;

import java.math.BigDecimal;
import java.util.List;

public class VendedorService {

    private final VendedorDao dao;

    public VendedorService() {
        this.dao = new VendedorDao();
    }

    public Vendedor selecionarPorCnpj(String cnpj) {
        Vendedor vendedor = dao.selecionarPorCnpj(cnpj);
        return vendedor;
    }

    public List<Vendedor> selecionarTodos() {
        List<Vendedor> lista = dao.selecionarTodos();
        return lista;
    }

    public boolean inserir(Vendedor vendedor) {
        if(
                vendedor.getCnpj().equals("") ||
                vendedor.getDescricao().equals("") ||
                vendedor.getEmail().equals("") ||
                vendedor.getEndereco().equals("") ||
                vendedor.getLogin().equals("") ||
                vendedor.getSenha().equals("") ||
                vendedor.getNomeFantasia().equals("")
        ){
            return false;
        }
        return dao.inserir(vendedor);
    }

    public boolean alterar(Vendedor vendedor) {
        if(
                vendedor.getCnpj().equals("") ||
                vendedor.getDescricao().equals("") ||
                vendedor.getEmail().equals("") ||
                vendedor.getEndereco().equals("") ||
                vendedor.getLogin().equals("") ||
                vendedor.getSenha().equals("") ||
                vendedor.getNomeFantasia().equals("") ||
                vendedor.getTelefone().equals("")
        ){
            return false;
        }
        return dao.alterar(vendedor);
    }

    public boolean apagar(Vendedor vendedor) {
        return dao.apagar(vendedor);
    }
    
    public Vendedor logar(String user, String pass){
        if(user.equals("") || pass.equals("")){
            return null;
        }
        return dao.logar(user, pass);
    }
}
