/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import model.Produto;

/**
 *
 * @author @author Ramon
 */
public class ProdutoEstadoEnviado implements ProdutoEstado {

    @Override
    public String getEstado() {
        return "Enviado";

    }

    @Override
    public String enviar(Produto produto) {
        return "Enviado";

    }

    @Override
    public String sairParaEntregar(Produto produto) {
        
        produto.setEstado(new ProdutoEstadoSaiuParaEntrega());
        produto.setMemento("Enviado");
        return "Saiu para Entrega";
    }

    @Override
    public String moradorAusente(Produto produto) {
        return "Enviado";
    }

    @Override
    public String finalizarEntrega(Produto produto) {
        return "Enviado";
    }

}
