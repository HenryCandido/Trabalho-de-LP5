/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoCliente;

/**
 *
 * @author @author Ramon
 */
public class TipoClienteRemetente extends Cliente implements TipoCliente {

   
    public TipoClienteRemetente() {
    }

    public TipoClienteRemetente(int parseInt) {
        this.idCliente = idCliente;
    }


    @Override
    public String getTipoCliente() {

        return "Remetente";
    }

}
