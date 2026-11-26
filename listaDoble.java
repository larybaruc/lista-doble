/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nododoble;

/**
 *
 * @author laryb
 */
public class listaDoble {
    private int tamanio;
    private nodoDoble cabeza;
    private nodoDoble cola;

    public listaDoble() {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }

    public boolean estaVacia() {
        if (cabeza == null && cola == null) {
            return true;
        } else {
            return false;
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean buscar(int dato) {
        nodoDoble aux = cabeza;
        while (aux != null) {
            if (aux.getDato() == dato) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "";
        nodoDoble aux = cabeza;
        while (aux != null) {
            res = res + "<--[" + aux.getDato() + "]-->";
            aux = aux.getSiguiente();
        }
        res = res + "NULL";
        return res;
    }

    // Imprime la lista de cola a cabeza para verificar los enlaces anteriores
    public String toStringInverso() {
        String res = "";
        nodoDoble aux = cola;
        while (aux != null) {
            res = res + "<--[" + aux.getDato() + "]-->";
            aux = aux.getAnterior();
        }
        res = res + "NULL";
        return res;
    }

    public nodoDoble obtenerNodo(int pos) {
        if (pos <= 0 || pos > tamanio) {
            return null;
        }
        nodoDoble aux = cabeza;
        for (int i = 1; i < pos; i++) {
            aux = aux.getSiguiente();
        }
        return aux;
    }

    public void actualizar(int pos, int dato) {
        nodoDoble referencia = obtenerNodo(pos);
        if (referencia != null) {
            referencia.setDato(dato);
        }
    }

    public void insertarAlInicio(int dato) {
        nodoDoble nuevo = new nodoDoble(dato);
        if (estaVacia()) {
            cola = nuevo;
        } else {
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
        }
        tamanio++;
        cabeza = nuevo;
    }

    public void insertarAlFinal(int dato) {
        nodoDoble nuevo = new nodoDoble(dato);
        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
        }
        tamanio++;
        cola = nuevo;
    }

    public int eliminarInicio() {
        if (estaVacia()) {
            throw new IllegalStateException("La lista esta vacia...");
        }
        int dato = cabeza.getDato();
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }

    // 1. Inserta un dato en una posicion especifica (indice desde 0)
    public void insertarEnPosicion(int pos, int dato) {
        if (pos < 0 || pos > tamanio) {
            System.out.println("Posicion invalida: " + pos);
            return;
        }
        if (pos == 0) {
            insertarAlInicio(dato);
            return;
        }
        if (pos == tamanio) {
            insertarAlFinal(dato);
            return;
        }

        nodoDoble aux = cabeza;
        for (int i = 0; i < pos; i++) {
            aux = aux.getSiguiente();
        }

        nodoDoble nuevo = new nodoDoble(dato);
        nodoDoble anterior = aux.getAnterior();

        nuevo.setAnterior(anterior);
        nuevo.setSiguiente(aux);
        anterior.setSiguiente(nuevo);
        aux.setAnterior(nuevo);
        tamanio++;
    }

    // 2. Elimina la primera coincidencia del valor x
    public boolean eliminarPorValor(int x) {
        if (estaVacia()) {
            return false;
        }

        nodoDoble aux = cabeza;
        while (aux != null && aux.getDato() != x) {
            aux = aux.getSiguiente();
        }

        if (aux == null) {
            return false;
        }

        if (aux == cabeza) {
            eliminarInicio();
        } else if (aux == cola) {
            eliminarUltimo();
        } else {
            aux.getAnterior().setSiguiente(aux.getSiguiente());
            aux.getSiguiente().setAnterior(aux.getAnterior());
            tamanio--;
        }
        return true;
    }

    // 3. Elimina el nodo en la posicion indicada y devuelve su dato (indice desde 0)
    public int eliminarEnPosicion(int pos) {
        if (estaVacia() || pos < 0 || pos >= tamanio) {
            System.out.println("Posicion invalida: " + pos);
            return -1;
        }
        if (pos == 0) {
            return eliminarInicio();
        }
        if (pos == tamanio - 1) {
            int dato = cola.getDato();
            eliminarUltimo();
            return dato;
        }

        nodoDoble aux = cabeza;
        for (int i = 0; i < pos; i++) {
            aux = aux.getSiguiente();
        }

        int dato = aux.getDato();
        aux.getAnterior().setSiguiente(aux.getSiguiente());
        aux.getSiguiente().setAnterior(aux.getAnterior());
        tamanio--;
        return dato;
    }

    // 4. Elimina el ultimo nodo de la lista
    public boolean eliminarUltimo() {
        if (estaVacia()) {
            return false;
        }
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return true;
    }

    // 5. Inserta un dato manteniendo la lista ordenada de menor a mayor
    public void insertarOrdenado(int dato) {
        if (estaVacia() || dato <= cabeza.getDato()) {
            insertarAlInicio(dato);
            return;
        }
        if (dato >= cola.getDato()) {
            insertarAlFinal(dato);
            return;
        }

        nodoDoble aux = cabeza;
        while (aux != null && aux.getDato() < dato) {
            aux = aux.getSiguiente();
        }

        nodoDoble nuevo = new nodoDoble(dato);
        nodoDoble anterior = aux.getAnterior();

        nuevo.setAnterior(anterior);
        nuevo.setSiguiente(aux);
        anterior.setSiguiente(nuevo);
        aux.setAnterior(nuevo);
        tamanio++;
    }
}