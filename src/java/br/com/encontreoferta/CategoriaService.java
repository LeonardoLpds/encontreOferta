package br.com.encontreoferta;
import java.util.List;

public class CategoriaService {
    private CategoriaDao dao;
    
    public CategoriaService(){
        this.dao = new CategoriaDao();
    }
    
    public Categoria selecionarPorId(int id){
        Categoria categoria = dao.selecionarPorId(id);
        return categoria;
    }
    
    public List<Categoria> selecionarTodos(){
        List<Categoria> lista = dao.selecionarTodos();
        return lista;
    }
    
    public boolean inserir(Categoria categoria){
        if(categoria.getNome.equals("") || categoria.getDescricao.equals("")){
            return false
        }
        dao.inserir(categoria);
        return true
    }
    
    public boolean alterar(Categoria categoria){
        if(categoria.getNome.equals("") || categoria.getDescricao.equals("")){
            return false
        }
        dao.alterar(categoria);
        return true;
    }
    
    public void apagar(Categoria categoria){
        dao.apagar(ensaio);
    }
}
