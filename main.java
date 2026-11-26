/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nododoble;

/**
 *
 * @author laryb
 */
public class main {
    public static void main(String[] args) {
        listaDoble lista = new listaDoble();

        System.out.println("1. prueba con insertarOrdenado");
        int[] valores = {30, 10, 50, 20, 40, 10, 5};
        for (int i = 0; i < valores.length; i++) {
            lista.insertarOrdenado(valores[i]);
        }
        System.out.println("Adelante: " + lista);
        System.out.println("Atras:    " + lista.toStringInverso());
        System.out.println("Tamaño:  " + lista.getTamanio());

        System.out.println("2. prueba con insertarEnPosicion");
        lista.insertarEnPosicion(0, 1);
        lista.insertarEnPosicion(4, 25);
        lista.insertarEnPosicion(lista.getTamanio(), 60);
        lista.insertarEnPosicion(50, 99);
        System.out.println("Adelante: " + lista);
        System.out.println("Atras:    " + lista.toStringInverso());

        System.out.println("3. prueba con eliminarPorValor");
        System.out.println("Eliminar 25: " + lista.eliminarPorValor(25));
        System.out.println("Eliminar 999 (no existe): " + lista.eliminarPorValor(999));
        System.out.println("Adelante: " + lista);

        System.out.println("4. prueba con eliminarEnPosicion");
        System.out.println("Eliminado en pos 0: " + lista.eliminarEnPosicion(0));
        System.out.println("Eliminado en pos 3: " + lista.eliminarEnPosicion(3));
        System.out.println("Eliminado en pos 99: " + lista.eliminarEnPosicion(99));
        System.out.println("Adelante: " + lista);

        System.out.println("5. prueba con eliminarUltimo");
        System.out.println("Eliminar ultimo: " + lista.eliminarUltimo());
        System.out.println("Adelante: " + lista);
        System.out.println("Atras:    " + lista.toStringInverso());
        System.out.println("Tamaño final: " + lista.getTamanio());
    }
}