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
public class ProdutoEstadoSaiuParaEntrega implements ProdutoEstado {

    @Override
    public String getEstado() {
        return "Saiu para Entrega";
    }

    @Override
    public String enviar(Produto produto) {
        return "Saiu para Entrega";
    }

    @Override
    public String sairParaEntregar(Produto produto) {
        return "Saiu para Entrega";
    }

    @Override
    public String moradorAusente(Produto produto) {
        produto.setEstado(new ProdutoEstadoMoradorAusente());
        produto.setMemento("Saiu para entrega");
        return "Morador Ausente";
    }

    @Override
    public String finalizarEntrega(Produto produto) {
        produto.setEstado(new ProdutoEstadoEntregue());
        produto.setMemento("Saiu para entrega");
        return "Entregue";

    }
}
