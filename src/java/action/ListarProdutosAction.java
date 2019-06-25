/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import persistence.ProdutoDAO;
import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListarProdutosAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
       try {
            request.setAttribute("produtos", ProdutoDAO.getInstance().getAll());
            RequestDispatcher view = request.getRequestDispatcher("lerProduto.jsp");
            view.forward(request, response);
        } catch (ServletException | ClassNotFoundException ex) {
            response.sendRedirect("erro.jsp" + ex);

        }
    }
    
}
