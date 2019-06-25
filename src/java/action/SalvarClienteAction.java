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



public class SalvarClienteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int idCliente = parseInt(request.getParameter("textId"));
        String nome = request.getParameter("textNome");
        String cep = request.getParameter("textCep");
        String cpf = request.getParameter("textCpf");
        String tipoCliente = request.getParameter("textTipo");

        if (request.getParameter("textNome").equals("") || nome.equals("") || cep.equals("") || cpf.equals("")) {
            response.sendRedirect("erro.jsp");
        } else {

             Cliente cliente;
            if (tipoCliente.equals("Remetente")) {
                cliente = new TipoClienteRemetente(idCliente);
                cliente.setNome(nome);
                cliente.setCep(cep);
                cliente.setCpf(cpf);
                //(idCliente, tipoCliente);
                //dependente = new DependenteFilho(nome, nascimento, idFuncionario);
            } else {
                cliente = new TipoClienteDestinatario(idCliente);
                cliente.setNome(nome);
                cliente.setCep(cep);
                cliente.setCpf(cpf);
            }
            try {
               
                ClienteDAO.getInstance().save(cliente);

                response.sendRedirect("sucesso.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                response.sendRedirect("erro.jsp" + ex);
            }
        }
    }
}
