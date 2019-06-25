/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;
import persistence.ProdutoDAO;



public class PrepararEditarProdutoAction implements Action {

    public PrepararEditarProdutoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        Produto produto = new Produto(parseInt(request.getParameter("textIdProduto")));
        try {
            request.setAttribute("produto", ProdutoDAO.getInstance().get(produto));
            RequestDispatcher view = request.getRequestDispatcher("editarProduto.jsp");
            view.forward(request, response);
        } catch (ServletException|ClassNotFoundException ex) {
            response.sendRedirect("erro.jsp");
          }
    }
}
