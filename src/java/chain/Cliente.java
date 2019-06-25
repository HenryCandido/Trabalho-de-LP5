/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chain;

import chain.TipoCliente;
import chain.TipoClienteDestinatario;
import chain.TipoClienteRemetente;
import java.util.Observable;
import java.util.Observer;
import model.Produto;
import strategy.ClienteStrategy;

/**
 *
 * @author dyhre
 */
public abstract class Cliente extends ClienteStrategy implements Observer{

    protected int idCliente;
    protected String nome;
    protected String cep;
    protected String cpf;
    private Observable produto;

    public Cliente(Observable produto, int idCliente, String nome, String cep, String cpf, String tipoCliente) {
        this.produto = produto;
        this.idCliente = idCliente;
        this.nome = nome;
        this.cep = cep;
        this.cpf = cpf;
        this.tipoCliente = tipoCliente;
        produto.addObserver(this);
    }
    
    @Override
    public void update(Observable produto, Object arg) {
        if (produto instanceof Produto) {
            Produto estado = (Produto) produto;
            System.out.println("O estado da entrega foi alterado para " + estado.getEstado());
        }
    }

  
    public Cliente() {
        
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public abstract String getTipoCliente();
    
    public void setTipoCliente(String tipoCliente){
        this.tipoCliente = tipoCliente;
    }

    public static TipoCliente getObjectFromString(String tipoCliente) {
        switch (tipoCliente) {
            case "Destinatario":
                return RolTipoCliente.getInstance().getDestinatario();
            case "Remetente":
                return RolTipoCliente.getInstance().getRemetente();
        }
        return null;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        this.idCliente = id;
    }
    
    public Observable getProduto() {
        return produto;
    }

    public void setProduto(Observable produto) {
        this.produto = produto;
    }

}
