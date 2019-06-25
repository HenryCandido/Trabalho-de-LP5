/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author @author Ramon
 */
public class ClienteEstadoRemetente implements ClienteEstado{

    @Override
    public String getEstado() {
        return "Remetente";
    }
    
}
