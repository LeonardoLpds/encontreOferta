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
    
    public void inserir(Categoria categoria){
        if(categoria.getNome.equals("") || categoria.getDescricao.equals("")){
            //Msg
        }
        /**
        *if(categoria.getNome().trim().length() > 50){
        *    categoria.setNome(categoria.getNome.trim().substring(0, 50));
        *}
        **/
        
        dao.inserir(categoria);
    }
    
    public void alterar(Categoria categoria){
        if(categoria.getNome.equals("") || categoria.getDescricao.equals("")){
            //Msg
        }
        /**
        *if(categoria.getNome().trim().length() > 50){
        *    categoria.setNome(categoria.getNome.trim().substring(0, 50));
        *}
        **/
        
        dao.alterar(categoria);
    }
    
    public void apagar(Categoria categoria){
        dao.apagar(ensaio);
    }
}
