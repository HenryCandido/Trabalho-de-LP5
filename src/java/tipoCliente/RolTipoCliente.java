/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipoCliente;



public class RolTipoCliente {
        private static RolTipoCliente rolTipoCliente = new RolTipoCliente();
        private TipoClienteDestinatario destinatario;
        private TipoClienteRemetente remetente;
        
        public RolTipoCliente(){
            this.destinatario = new TipoClienteDestinatario();
            this.remetente = new TipoClienteRemetente();
        }
        
        public static RolTipoCliente getInstance() {
          return rolTipoCliente;
        }

        public static RolTipoCliente getRolTipoCliente() {
            return rolTipoCliente;
        }

        public static void setRolTipoCliente(RolTipoCliente rolTipoCliente) {
            RolTipoCliente.rolTipoCliente = rolTipoCliente;
        }

        public TipoClienteDestinatario getDestinatario() {
            return destinatario;
        }

        public void setDestinatario(TipoClienteDestinatario destinatario) {
            this.destinatario = destinatario;
        }

        public TipoClienteRemetente getRemetente() {
            return remetente;
        }

        public void setRemetente(TipoClienteRemetente remetente) {
            this.remetente = remetente;
        }        
}
