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
import model.Produto;
import persistence.ClienteDAO;
import persistence.ProdutoDAO;


public class EditarClienteAction implements Action {

    public EditarClienteAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        String nome = request.getParameter("textNome");
        String cep = request.getParameter("textCep");
        String cpf = request.getParameter("textCpf");
        String tipo = request.getParameter("textTipo");        

        if (request.getParameter("textId").equals("")) {
            response.sendRedirect("erro.jsp");
        } else {
            
            
            Cliente cliente;
        
            if (tipo.equals("Remetente")) {
                cliente = new TipoClienteRemetente(parseInt(request.getParameter("textId")));
                //(idCliente, tipoCliente);
                //dependente = new DependenteFilho(nome, nascimento, idFuncionario);
            } else {
                cliente = new TipoClienteDestinatario(parseInt(request.getParameter("textId")));
            }
            cliente.setNome(nome);
            cliente.setCep(cep);
            cliente.setCpf(cpf);
            cliente.setTipoCliente(tipo);            
           
             try {
                ClienteDAO.getInstance().editar(cliente);
                response.sendRedirect("sucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("erro.jsp"+ex);
            }
        }
    }
}
