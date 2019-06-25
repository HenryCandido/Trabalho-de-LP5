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
public class ProdutoEstadoMoradorAusente implements ProdutoEstado {

    @Override
    public String getEstado() {
        return "Morador Ausente";
    }

    @Override
    public String enviar(Produto produto) {
        return "Morador Ausente";
    }

    @Override
    public String sairParaEntregar(Produto produto) {
        produto.setEstado(new ProdutoEstadoSaiuParaEntrega());
        produto.setMemento("Morador Ausente");
        return "Saiu para Entrega";
    }

    @Override
    public String moradorAusente(Produto produto) {
        return "Morador Ausente";
    }

    @Override
    public String finalizarEntrega(Produto produto) {
        return "Morador Ausente";
    }

}
