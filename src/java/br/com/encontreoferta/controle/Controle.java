package br.com.encontreoferta.controle;

import br.com.encontreoferta.Promocao;
import br.com.encontreoferta.PromocaoDao;
import br.com.encontreoferta.Vendedor;
import br.com.encontreoferta.VendedorDao;
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
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        int id = 0;
        String cnpj = "";
        PromocaoDao pd = new PromocaoDao();
        VendedorDao vd = new VendedorDao();
        String acao = request.getParameter("acao");

        if (acao == null || acao.equals("")) {
            acao = "default";
        }

        switch (acao) {
            case "formIncluirPromocao":
                rd = request.getRequestDispatcher("incluirPromocao.jsp");
                break;
            case "incluirPromocao":
                try {
                    Promocao promo = new Promocao(request.getParameter("cnpj"),
                            Integer.parseInt(request.getParameter("idCategoria")),
                            request.getParameter("titulo"), request.getParameter("descricao"),
                            BigDecimal.valueOf(Double.parseDouble(request.getParameter("valor"))),
                            request.getParameter("imagem"), Integer.parseInt(request.getParameter("quantidade")),
                            formato.parse(request.getParameter("tempo"))
                    );
                    pd.inserir(promo);
                } catch (ParseException ex) {
                    Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "formAlterarPromocao":
                id = Integer.parseInt(request.getParameter("id"));
                Promocao promocao = pd.selecionarPorId(id);
                rd = request.getRequestDispatcher("alterarPromocao.jsp");
                request.setAttribute("promocao", promocao);
                break;
            case "alterarPromocao":
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                    Promocao promoAlter = new Promocao(id, request.getParameter("cnpj"),
                            Integer.parseInt(request.getParameter("idCategoria")),
                            request.getParameter("titulo"), request.getParameter("descricao"),
                            BigDecimal.valueOf(Double.parseDouble(request.getParameter("valor"))),
                            request.getParameter("imagem"), Integer.parseInt(request.getParameter("quantidade")),
                            formato.parse(request.getParameter("tempo"))
                    );
                    pd.alterar(promoAlter);
                } catch (ParseException ex) {
                    Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
                }
            case "excluirPromocao":
                id = Integer.parseInt(request.getParameter("id"));
                Promocao promocaoex = pd.selecionarPorId(id);
                pd.apagar(promocaoex);

            case "formIncluirVendedor":
                rd = request.getRequestDispatcher("incluirVendedor.jsp");
                break;
            case "formAlterarVendedor":
                cnpj = request.getParameter("cnpj");
                Vendedor vendedor = vd.selecionarPorCnpj(cnpj);
                rd = request.getRequestDispatcher("alterarVendedor.jsp");
                request.setAttribute("vendedor", vendedor);
                break;
            case "alterarVendedor":
                cnpj = request.getParameter("cnpj");
                Vendedor vendedorAlter = new Vendedor(cnpj, request.getParameter("nome"),
                        request.getParameter("descricao"), request.getParameter("telefone"),
                        request.getParameter("endereco"), request.getParameter("email"),
                        request.getParameter("login"), request.getParameter("senha")
                );
                vd.alterar(vendedorAlter);
            case "default":
            default:
                break;
        }
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
