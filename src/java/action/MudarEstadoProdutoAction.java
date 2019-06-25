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
import static javax.xml.bind.DatatypeConverter.parseString;
import model.Produto;
import state.ProdutoEstado;



public class MudarEstadoProdutoAction implements Action {

    public MudarEstadoProdutoAction() {
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

        int id = parseInt(request.getParameter("textIdProduto"));
        String estado = request.getParameter("estado");
        String op = parseString(request.getParameter("op"));
        String memento = request.getParameter("memento");

        Produto produto = new Produto(id);
        produto.setMemento(memento);
        produto.setEstadoFromString(estado);
        
        //  produto.getEstado();
        ProdutoEstado estadoProduto = produto.getEstado();

        String result = "";

        if (op.equals("entregar")) {
            result = estadoProduto.finalizarEntrega(produto);
        } else if (op.equals("moradorAusente")) {
            result = estadoProduto.moradorAusente(produto);
        } else if (op.equals("sairParaEntregar")) {
            result = estadoProduto.sairParaEntregar(produto);
        } else if (op.equals("enviar")) {
            result = estadoProduto.enviar(produto);
        }
        /* if (op.equals("entregar")) {
            result = estadoProduto.finalizarEntrega(produto);
        } else if (op.equals("moradorAusente")) {
            result = estadoProduto.moradorAusente(produto);
        } else if (op.equals("sairParaEntregar")) {
            result = estadoProduto.sairParaEntregar(produto);
        } else if (op.equals("enviar")) {
            result = estadoProduto.enviar(produto);*/
        try {
            if (op.equals("atualizarMemento")) {
                result = produto.getMemento();
                result = produto.atualizarState(memento);
                ProdutoDAO.getInstance().updateMemento(produto);
            } else {

                ProdutoDAO.getInstance().updateEstado(produto);
            }

            response.sendRedirect("sucesso.jsp" + result);
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("erro.jsp" + ex);
        }

    }
}
