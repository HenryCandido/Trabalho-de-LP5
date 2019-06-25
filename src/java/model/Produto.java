package model;

import java.util.Observable;
import state.ProdutoEstado;
import state.ProdutoEstadoEntregue;
import state.ProdutoEstadoEnviado;
import state.ProdutoEstadoMoradorAusente;
import state.ProdutoEstadoSaiuParaEntrega;

public class Produto extends Observable {

    private int id;
    private String nome;
    private String peso;
    private String remetente;
    private String destino;
    public String memento;
    private ProdutoEstado estado;
    private String state;

    public Produto(int id, String nome, String peso, String remetente, String destino) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.remetente = remetente;
        this.destino = destino;

    }

    public Produto(int id, String nome, String peso, String remetente, String destino, String state) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.remetente = remetente;
        this.destino = destino;
        this.state = state;

    }

    public Produto() {
    }

    public Produto(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ProdutoEstado getEstado() {
        return estado;
    }

    public void setEstado(ProdutoEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
    }

    public String getState() {

        return state;
    }

    public void setState(String string) {
        this.state = string;
    }

    public void setEstadoFromString(String estado) {
        if (estado.equals("Enviado")) {
            this.estado = new ProdutoEstadoEnviado();
        } else if (estado.equals("Morador Ausente")) {
            this.estado = new ProdutoEstadoMoradorAusente();
        } else if (estado.equals("Entregue")) {
            this.estado = new ProdutoEstadoEntregue();
        } else if (estado.equals("Saiu para Entrega")) {
            this.estado = new ProdutoEstadoSaiuParaEntrega();
        }
    }

    public String SetEstadoString() {
        return this.estado.getEstado();
    }

    public String getMemento() {
        return memento;
    }

    public void setMemento(String memento) {
        this.memento = memento;
    }

    public String atualizarState(String memento) {
        this.state = memento;
        return state;
    }

}
