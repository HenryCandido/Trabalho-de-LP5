/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import persistence.ClienteDAO;
import controller.Action;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tipoCliente.Cliente;
import tipoCliente.TipoClienteDestinatario;
import tipoCliente.TipoClienteRemetente;


public class ExcluirClienteAction implements Action {

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

        try {
            ClienteDAO.getInstance().delete(cliente);
            response.sendRedirect("sucesso.jsp");
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("erro.jsp");
        }
    }
}
