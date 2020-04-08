/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.dinamicas;

/**
 *
 * @author Dantesito
 */
public class ArbolBinario {

    private NodoArbol raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public boolean insertar(Object elem, Object padre, char lugar) {
        boolean flag = true;
        if (raiz == null) {
            this.raiz = new NodoArbol(elem);
        } else {
            NodoArbol aux = obtenerPadre(this.raiz, padre);
            if (aux != null) {
                if (aux.getDerecho() == null && lugar == 'D') {
                    aux.setDerecho(new NodoArbol(elem));
                } else if (aux.getIzquierdo() == null && lugar == 'I') {
                    aux.setIzquierdo(new NodoArbol(elem));
                }
            } else {
                flag = false;
            }
        }
        return flag;
    }

    NodoArbol obtenerPadre(NodoArbol aux, Object elem) {
        NodoArbol resultado = null;
        if (aux != null) {
            if (aux.getElemet().equals(elem)) {
                resultado = aux;
            } else {
                resultado = obtenerPadre(aux.getIzquierdo(), elem);
                if (resultado == null) {
                    resultado = obtenerPadre(aux.getDerecho(), elem);
                }
            }
        }
        return resultado;
    }

    public int alturaArbol() {
        NodoArbol aux = this.raiz;
        return recorrido(aux) - 1;
    }

    private int recorrido(NodoArbol aux) {
        int altD = 0;
        int altIzq = 0;
        if (aux != null) {
            altD = +recorrido(aux.getDerecho()) + 1;
            altIzq = altIzq + recorrido(aux.getIzquierdo()) + 1;
            if (altIzq >= altD) {
                altD = altIzq;
            }
        }
        return altD;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        String cadena;
        cadena = imprimir(this.raiz);
        return cadena;
    }

    //Metodo auxiliar que crea un String con cada nodo del arbol.
    private String imprimir(NodoArbol nodo) {
        String cadena = "";
        if (nodo != null) {
            if (nodo.getDerecho() != null || nodo.getIzquierdo() != null) {
                cadena += "Raiz: " + nodo.getElemet();
                if (nodo.getIzquierdo() != null) {
                    cadena += "[ HI: " + nodo.getIzquierdo().getElemet() + " ]";
                } else {
                    cadena += "[ HI: null ]";
                }
                if (nodo.getDerecho() != null) {
                    cadena += "[ HD: " + nodo.getDerecho().getElemet() + " ]" + "\n";
                } else {
                    cadena += "[ HD: null ] \n";
                }
                cadena += imprimir(nodo.getIzquierdo());
                cadena += imprimir(nodo.getDerecho());
            } else {
                cadena += "[ Hoja: " + nodo.getElemet() + "]" + "\n";
            }
        }
        return cadena;
    }

    public ArbolBinario clone() {
        ArbolBinario nuevo = new ArbolBinario();
        nuevo.raiz = clonarAux(this.raiz);
        return nuevo;
    }

    private NodoArbol clonarAux(NodoArbol aux) {
        NodoArbol hijo = null;
        if (aux != null) {
            hijo = new NodoArbol(aux.elem, clonarAux(aux.derecho), clonarAux(aux.izquierdo));
        }
        return hijo;
    }

}
