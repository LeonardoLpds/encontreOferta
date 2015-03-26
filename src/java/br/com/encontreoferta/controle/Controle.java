package br.com.encontreoferta.controle;

import br.com.encontreoferta.Categoria;
import br.com.encontreoferta.CategoriaDao;
import br.com.encontreoferta.CategoriaService;
import br.com.encontreoferta.Promocao;
import br.com.encontreoferta.PromocaoDao;
import br.com.encontreoferta.Vendedor;
import br.com.encontreoferta.VendedorDao;
import br.com.encontreoferta.Voucher;
import br.com.encontreoferta.VoucherDao;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controle", urlPatterns = {"/controle"})
public class Controle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        //Declarando variavel de redirecionamento
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        
        //Declarando varival de formato de Data
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        //Declarando variaveis de referencia de objetos
        int id;
        String cnpj;
        BigDecimal valor;
        
        //Declarando objetos DAOs
        CategoriaDao categoriaDao = new CategoriaDao();
        PromocaoDao promocaoDao = new PromocaoDao();
        VendedorDao vendedorDao = new VendedorDao();
        VoucherDao voucherDao = new VoucherDao();
        
        //Declarando objetos a serem manipulados
        Categoria categoria = new Categoria();
        Vendedor vendedor = new Vendedor();
        Promocao promocao = new Promocao();
        Voucher voucher = new Voucher();
        
        
        //Declarando services
        CategoriaService categoriaService = new CategoriaService();
        
        //Declarando variavel que definira a ação a ser tomada
        String acao = request.getParameter("acao");
        
        //Verifico se existe realmente alguma ação
        if (acao == null || acao.equals("")) {
            acao = "default";
        }

        switch (acao) {
            //Chamando formulários de inclusão
            case "formIncluirCategoria":
                rd = request.getRequestDispatcher("incluirCategoria.jsp");
                break;
            case "formIncluirVendedor":
                rd = request.getRequestDispatcher("incluirVendedor.jsp");
                break;
            case "formIncluirPromocao":
                rd = request.getRequestDispatcher("incluirPromocao.jsp");
                break;
            case "formIncluirVoucher":
                rd = request.getRequestDispatcher("incluirVoucher.jsp");
                break;
            
            //Executando ações de inclusão
            case "incluirVendedor":
                vendedor.setCnpj(request.getParameter("cnpj"));
                vendedor.setNomeFantasia(request.getParameter("nome"));
                vendedor.setDescricao(request.getParameter("descricao"));
                vendedor.setTelefone(request.getParameter("telefone"));
                vendedor.setEndereco(request.getParameter("endereco"));
                vendedor.setEmail(request.getParameter("email"));
                vendedorDao.inserir(vendedor);
                break;
                
            case "incluirCategoria":
                categoria.setNome(request.getParameter("nome"));
                categoria.setDescricao(request.getParameter("descricao"));
                categoriaService.inserir(categoria);
                break;
                
            case "incluirPromocao":
                try {
                    promocao.setCnpj(request.getParameter("cnpj"));
                    id = Integer.parseInt(request.getParameter("idCategoria"));
                    promocao.setIdCategoria(id);
                    promocao.setTitulo(request.getParameter("titulo"));
                    promocao.setDescricao(request.getParameter("descricao"));
                    valor = BigDecimal.valueOf(Double.parseDouble(request.getParameter("valor")));
                    promocao.setValor(valor);
                    promocao.setImagem(request.getParameter("imagem"));
                    promocao.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                    promocao.setTempo(formato.parse(request.getParameter("tempo")));
                    
                    promocaoDao.inserir(promocao);
                } catch (ParseException ex) {
                    Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "incluirVoucher":
                voucher.setIdVoucher(request.getParameter("numVoucher"));
                id = Integer.parseInt(request.getParameter("idPromocao"));
                voucher.setIdPromocao(id);
                voucherDao.inserir(voucher);
                break;
            
            //Chamando formulários de alteração
            case "formAlterarCategoria":
                id = Integer.parseInt(request.getParameter("id"));
                categoria = categoriaService.selecionarPorId(id);
                rd = request.getRequestDispatcher("alterarCategoria.jsp");
                request.setAttribute("categoria", categoria);
                break;
            case "formAlterarPromocao":
                id = Integer.parseInt(request.getParameter("id"));
                promocao = promocaoDao.selecionarPorId(id);
                rd = request.getRequestDispatcher("alterarPromocao.jsp");
                request.setAttribute("promocao", promocao);
                break;
            case "formAlterarVendedor":
                cnpj = request.getParameter("cnpj");
                vendedor = vendedorDao.selecionarPorCnpj(cnpj);
                rd = request.getRequestDispatcher("alterarVendedor.jsp");
                request.setAttribute("vendedor", vendedor);
                break;
            
            //Executando ações de alteração    
            case "alterarPromocao":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                    promocao.setIdPromocao(id);
                    promocao.setCnpj(request.getParameter("cnpj"));
                    promocao.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
                    promocao.setTitulo(request.getParameter("titulo"));
                    promocao.setDescricao(request.getParameter("descricao"));
                    valor = BigDecimal.valueOf(Double.parseDouble(request.getParameter("valor")));
                    promocao.setValor(valor);
                    promocao.setImagem(request.getParameter("imagem"));
                    promocao.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                    promocao.setTempo(formato.parse(request.getParameter("tempo")));
                    promocaoDao.alterar(promocao);
                } catch (ParseException ex){
                    Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "alterarCategoria":
                    id = Integer.parseInt(request.getParameter("id"));
                    categoria.setIdCategoria(id);
                    categoria.setNome(request.getParameter("nome"));
                    categoria.setDescricao(request.getParameter("descricao"));
                    categoriaService.alterar(categoria);
                break;
                
            case "alterarVendedor":
                cnpj = request.getParameter("cnpj");
                vendedor.setCnpj(cnpj);
                vendedor.setNomeFantasia(request.getParameter("nome"));
                vendedor.setDescricao(request.getParameter("descricao"));
                vendedor.setTelefone(request.getParameter("telefone"));
                vendedor.setEndereco(request.getParameter("endereco"));
                vendedor.setEmail(request.getParameter("email"));
                vendedorDao.alterar(vendedor);
                break;
                
            //Executando ações de exclusão
            case "excluirCategoria":
                id = Integer.parseInt(request.getParameter("id"));
                categoria = categoriaDao.selecionarPorId(id);
                categoriaService.apagar(categoria);
                break;
            case "excluirPromocao":
                id = Integer.parseInt(request.getParameter("id"));
                promocao = promocaoDao.selecionarPorId(id);
                promocaoDao.apagar(promocao);
                break;
            case "excluirVendedor":
                cnpj = request.getParameter("cnpj");
                vendedor = vendedorDao.selecionarPorCnpj(cnpj);
                vendedorDao.apagar(vendedor);
                break;
            case "excluirVoucher":
                voucher = voucherDao.selecionarPorNumeroDoVoucher(request.getParameter("numVoucher"));
                voucherDao.apagar(voucher);
                break;
            case "default":
            default:
                break;
        }
        
        //Redireciona o usuário conforme requisição
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
