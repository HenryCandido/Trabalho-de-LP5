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
import tipoCliente.Cliente;
import tipoCliente.TipoClienteDestinatario;
import tipoCliente.TipoClienteRemetente;
import persistence.ClienteDAO;


public class PrepararEditarClienteAction implements Action {

    public PrepararEditarClienteAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        
        Cliente cliente;
        String tipoCliente = request.getParameter("textTipoCliente");
            if (tipoCliente.equals("Remetente")) {
                cliente = new TipoClienteRemetente(parseInt(request.getParameter("textIdCliente")));
                //(idCliente, tipoCliente);
                //dependente = new DependenteFilho(nome, nascimento, idFuncionario);
            } else {
                cliente = new TipoClienteDestinatario(parseInt(request.getParameter("textIdCliente")));
            }
        //Cliente cliente = new Cliente(parseInt(request.getParameter("textIdCliente")));
        try {
            request.setAttribute("cliente", ClienteDAO.getInstance().get(cliente));
            //request.setAttribute("cliente", ClienteDAO.getInstance().get(parseInt(request.getParameter("textIdCliente"))));
            RequestDispatcher view = request.getRequestDispatcher("editarCliente.jsp");
            view.forward(request, response);
        } catch (ServletException |ClassNotFoundException ex) {
            response.sendRedirect("erro.jsp");
        }
    }
}
/*
Cliente cliente;
            if (tipoCliente.equals("Remetente")) {
                cliente = new ClienteRemetente(idCliente,nome, cep, cpf);
                //(idCliente, tipoCliente);
                //dependente = new DependenteFilho(nome, nascimento, idFuncionario);
            } else {
                cliente = new ClienteDestinatario(idCliente,nome, cep, cpf);
            }
@Override
        try {
            request.setAttribute("dependente", DependenteDAO.getInstance().get(parseInt(request.getParameter("id"))));
            RequestDispatcher view = request.getRequestDispatcher("./dependente/editar.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            response.sendRedirect("return.jsp?type=erro&response=" + ex);
        } catch (ClassNotFoundException ex) {
            response.sendRedirect("return.jsp?type=erro&response=" + ex);
        }
    }


*/