package br.com.encontreoferta.controle;

import br.com.encontreoferta.Categoria;
import br.com.encontreoferta.CategoriaService;
import br.com.encontreoferta.Promocao;
import br.com.encontreoferta.PromocaoService;
import br.com.encontreoferta.Vendedor;
import br.com.encontreoferta.VendedorService;
import br.com.encontreoferta.Voucher;
import br.com.encontreoferta.VoucherService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
        
        //Declarando objetos a serem manipulados
        Categoria categoria = new Categoria();
        Vendedor vendedor = new Vendedor();
        Promocao promocao = new Promocao();
        Voucher voucher = new Voucher();
        
        
        //Declarando services
        CategoriaService categoriaService = new CategoriaService();
        VoucherService voucherService = new VoucherService();
        PromocaoService promocaoService = new PromocaoService();
        VendedorService vendedorService = new VendedorService();
        
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
            case "formIncluirPromocao":
                rd = request.getRequestDispatcher("incluirPromocao.jsp");
                break;
                
            //Verificando produtos dependendo da categoria
            case "verPromocoesPorCategoria":
                id = Integer.parseInt(request.getParameter("id"));
                List<Promocao> lista = new ArrayList<>();
                lista = promocaoService.selecionarPorCategoria(id);
                rd = request.getRequestDispatcher("promocoes.jsp");
                request.setAttribute("lista", lista);
                break;
            
            //Executando ações de inclusão
            case "incluirVendedor":
                vendedor.setCnpj(request.getParameter("cnpj"));
                vendedor.setNomeFantasia(request.getParameter("nome"));
                vendedor.setDescricao(request.getParameter("descricao"));
                vendedor.setTelefone(request.getParameter("telefone"));
                vendedor.setEndereco(request.getParameter("endereco"));
                vendedor.setEmail(request.getParameter("email"));
                vendedor.setLogin(request.getParameter("usuario"));
                vendedor.setSenha(request.getParameter("senha"));
                vendedorService.inserir(vendedor);
                rd = request.getRequestDispatcher("vendedores.jsp");
                break;
                
            case "incluirCategoria":
                categoria.setNome(request.getParameter("nome"));
                categoria.setDescricao(request.getParameter("descricao"));
                categoriaService.inserir(categoria);
                rd = request.getRequestDispatcher("categorias.jsp");
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
                    
                    promocaoService.inserir(promocao);
                    rd = request.getRequestDispatcher("promocoes.jsp");
                } catch (ParseException ex) {
                    Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case "incluirVoucher":
                id = Integer.parseInt(request.getParameter("id"));
                String nomePromocao = promocaoService.selecionarPorId(id).getTitulo();
                int num = (int) (Math.random() * 10000);
                nomePromocao = nomePromocao.substring(0, 2);
                String idVoucher = nomePromocao+String.valueOf(num);
                voucher.setIdVoucher(idVoucher);
                voucher.setIdPromocao(id);
                voucherService.inserir(voucher);
                request.setAttribute("voucher", voucher);
                rd = request.getRequestDispatcher("finishVoucher.jsp");
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
                promocao = promocaoService.selecionarPorId(id);
                rd = request.getRequestDispatcher("alterarPromocao.jsp");
                request.setAttribute("promocao", promocao);
                break;
            case "formAlterarVendedor":
                cnpj = request.getParameter("cnpj");
                vendedor = vendedorService.selecionarPorCnpj(cnpj);
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
                    promocaoService.alterar(promocao);
                    rd = request.getRequestDispatcher("promocoes.jsp");
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
                    rd = request.getRequestDispatcher("categorias.jsp");
                break;
                
            case "alterarVendedor":
                cnpj = request.getParameter("cnpj");
                vendedor.setCnpj(cnpj);
                vendedor.setNomeFantasia(request.getParameter("nome"));
                vendedor.setDescricao(request.getParameter("descricao"));
                vendedor.setTelefone(request.getParameter("telefone"));
                vendedor.setEndereco(request.getParameter("endereco"));
                vendedor.setEmail(request.getParameter("email"));
                vendedor.setLogin(request.getParameter("usuario"));
                vendedorService.alterar(vendedor);
                rd = request.getRequestDispatcher("vendedores.jsp");
                break;
                
            //Executando ações de exclusão
            case "excluirCategoria":
                id = Integer.parseInt(request.getParameter("id"));
                categoria = categoriaService.selecionarPorId(id);
                categoriaService.apagar(categoria);
                break;
            case "excluirPromocao":
                id = Integer.parseInt(request.getParameter("id"));
                promocaoService.apagar(id);
                break;
            case "excluirVendedor":
                cnpj = request.getParameter("cnpj");
                vendedor = vendedorService.selecionarPorCnpj(cnpj);
                vendedorService.apagar(vendedor);
                break;
            case "excluirVoucher":
                voucher = voucherService.selecionarPorNumeroDoVoucher(request.getParameter("numVoucher"));
                voucherService.apagar(voucher);
                break;
                
            case "default":
            default:
                break;
        }
        
        //Verificando produtos por categoria
        
        
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
