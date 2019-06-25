/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import persistence.ProdutoDAO;
import controller.Action;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;



public class SalvarProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = parseInt(request.getParameter("textId"));
        String nome = request.getParameter("textNome");
        String peso = request.getParameter("textPeso");
        String remetente = request.getParameter("textRemetente");
        String destino = request.getParameter("textDestinatario");
        String estado = request.getParameter("textEstado");
        

        if (request.getParameter("textId").equals("") || nome.equals("") || peso.equals("") || remetente.equals("") || destino.equals("")) {
            response.sendRedirect("erro.jsp");
        } else {
            Produto produto = new Produto(id, nome, peso, remetente, destino,estado);
            try {
                ProdutoDAO.getInstance().save(produto, estado);
                response.sendRedirect("sucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("erro.jsp" + ex);
            }
            /* } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }*/
        }
    }
}
