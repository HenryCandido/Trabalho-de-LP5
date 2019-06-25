/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import state.ProdutoEstado;

public class TesteObserver {
    
    public static void main(String[] args) {
    Produto produto = new Produto();
    ProdutoEstado entregue = null;
    produto.setEstado(entregue);
    }
}

