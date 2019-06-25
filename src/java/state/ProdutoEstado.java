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
public interface ProdutoEstado {

    public String getEstado();

    public String enviar(Produto produto);

    public String sairParaEntregar(Produto produto);

    public String moradorAusente(Produto produto);
    
     public String finalizarEntrega(Produto produto);
}
