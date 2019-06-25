/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoCliente;

/**
 *
 * @author Ramon
 */
public class TipoClienteDestinatario extends Cliente implements TipoCliente {
    
    public TipoClienteDestinatario() {
    }

    public TipoClienteDestinatario(int parseInt) {
        this.idCliente = idCliente;
    }


    @Override
    public String getTipoCliente() {
        return "Destinatario";
    }

}
