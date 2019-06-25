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
public class ProdutoEstadoEntregue implements ProdutoEstado {

    @Override
    public String getEstado() {
        return "Entregue";
    }

    @Override
    public String enviar(Produto produto) {
        return "Entregue";
    }

    @Override
    public String sairParaEntregar(Produto produto) {
        return "Entregue";
    }

    @Override
    public String moradorAusente(Produto produto) {
        return "Entregue";
    }

    @Override
    public String finalizarEntrega(Produto produto) {
        return "Entregue";
    }

}
