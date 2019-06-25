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


public class ExcluirProdutoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        Produto produto = new Produto();
        produto.setId(parseInt(request.getParameter("textIdProduto")));

        try {
            ProdutoDAO.getInstance().delete(produto);
            response.sendRedirect("sucesso.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("erro.jsp");
        }
    }
}
