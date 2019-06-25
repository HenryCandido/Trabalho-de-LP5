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


public class EditarProdutoAction implements Action {

    public EditarProdutoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        String nome = request.getParameter("textNome");
        String peso = request.getParameter("textPeso");
        String remetente = request.getParameter("textRemetente");
        String destino = request.getParameter("textDestinatario");
        String estado = request.getParameter("textEstado");;
        
        
        

        if (request.getParameter("textId").equals("") || nome.equals("") || peso.equals("") || remetente.equals("") || destino.equals("")) {
            response.sendRedirect("erro.jsp");
        } else {
            
            Produto produto = new Produto(parseInt(request.getParameter("textId")));
            produto.setDestino(destino);
            produto.setNome(nome);
            produto.setPeso(peso);
            produto.setRemetente(remetente);
            produto.setState(estado);
            
             try {
                ProdutoDAO.getInstance().editar(produto);
                response.sendRedirect("sucesso.jsp");
            } catch (ClassNotFoundException ex) {
                response.sendRedirect("return.jsp?type=erro&response=" + ex);
            } catch (SQLException ex) {
                response.sendRedirect("return.jsp?type=erro&response=" + ex);
            }
        }
    }
}
