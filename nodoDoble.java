/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nododoble;

/**
 *
 * @author laryb
 */
public class nodoDoble {
    private int dato;
    private   nodoDoble siguiente;
    private nodoDoble anterior;

    public nodoDoble(int x) {
        dato = x;
        siguiente = null;
        anterior = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public nodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoDoble anterior) {
        this.anterior = anterior;
    }
}