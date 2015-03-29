package br.com.encontreoferta;

import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class VendedorService {

    private VendedorDao dao;

    public VendedorService() {
        this.dao = new VendedorDao();
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public Vendedor selecionarPorCnpj(String cnpj) {
        Vendedor vendedor = dao.selecionarPorCnpj(cnpj);
        return vendedor;
    }

    public List<Vendedor> selecionarTodos() {
        List<Vendedor> lista = dao.selecionarTodos();
        return lista;
    }

    public boolean inserir(Vendedor vend) {

        String cnpj = vend.getCnpj();
        String nomeFantasia = vend.getNomeFantasia();
        String descricao = vend.getDescricao();
        String telefone = vend.getTelefone();
        String endereco = vend.getEndereco();
        String email = vend.getEmail();
        String login = vend.getLogin();
        String senha = vend.getSenha();

        dao = new VendedorDao();
        Vendedor vendedor = new Vendedor();

        if (cnpj.equals("")) {
            return false;
        } else {
            vendedor.setCnpj(cnpj);
        }
        if (nomeFantasia.equals("")) {
            return false;
        } else {
            vendedor.setNomeFantasia(nomeFantasia);
        }
        if (descricao.equals("")) {
            return false;
        } else {
            vendedor.setDescricao(descricao);
        }

        if (telefone.equals("")) {
            return false;
        } else {
            vendedor.setTelefone(telefone);
        }
        if (endereco.equals("")) {
            return false;
        } else {
            vendedor.setEndereco(endereco);
        }

        if (isValidEmailAddress(email)) {
            vendedor.setEmail(email);
        } else {
            return false;
        }

        if (login.equals("")) {
            return false;
        } else {
            vendedor.setLogin(login);
        }

        if (senha.equals("")) {
            return false;
        } else {
            vendedor.setSenha(senha);
        }

        dao.inserir(vendedor);

        return true;

    }

    public boolean alterar(Vendedor vend) {

        String cnpj = vend.getCnpj();
        String nomeFantasia = vend.getNomeFantasia();
        String descricao = vend.getDescricao();
        String telefone = vend.getTelefone();
        String endereco = vend.getEndereco();
        String email = vend.getEmail();
        String login = vend.getLogin();
        String senha = vend.getSenha();

        dao = new VendedorDao();
        Vendedor vendedor = new Vendedor();

        if (cnpj.equals("") || cnpj.length() != 14) {
            return false;
        } else {
            vendedor.setCnpj(cnpj);
        }
        if (nomeFantasia.equals("")) {
            return false;
        } else {
            vendedor.setNomeFantasia(nomeFantasia);
        }
        if (descricao.equals("")) {
            return false;
        } else {
            vendedor.setDescricao(descricao);
        }

        if (telefone.equals("")) {
            return false;
        } else {
            vendedor.setTelefone(telefone);
        }
        if (endereco.equals("")) {
            return false;
        } else {
            vendedor.setEndereco(endereco);
        }

        if (isValidEmailAddress(email)) {
            vendedor.setEmail(email);
        } else {
            return false;
        }

        if (login.equals("")) {
            return false;
        } else {
            vendedor.setLogin(login);
        }

        if (senha.equals("")) {
            return false;
        } else {
            vendedor.setSenha(senha);
        }

        dao.alterar(vendedor);

        return true;

    }

    public void apagar(Vendedor vendedor) {

        dao = new VendedorDao();
        Vendedor vendedor1 = new Vendedor();
        vendedor1.setCnpj("");
        vendedor1.setDescricao("");
        vendedor1.setEmail("");
        vendedor1.setEndereco("");
        vendedor1.setNomeFantasia("");
        vendedor1.setTelefone("");
        vendedor1.setLogin("");
        vendedor1.setSenha("");

        dao.apagar(vendedor);
    }
}
