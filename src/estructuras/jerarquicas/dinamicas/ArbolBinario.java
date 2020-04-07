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
            this.raiz = new NodoArbol(padre, null, null);
        } else {
            NodoArbol aux = obtenerPadre(this.raiz, padre);
            if (aux.derecho == null && lugar == 'D') {
                aux.derecho = new NodoArbol(elem);
            } else if (aux.izquierdo == null && lugar == 'I') {
                aux.izquierdo = new NodoArbol(elem);
            }
            {
                flag = false;
            }
        }
        return flag;
    }

    public NodoArbol obtenerPadre(NodoArbol aux, Object elem) {
        NodoArbol resultado = null;
        if (aux != null) {
            if (!aux.elem.equals(elem)) {
                resultado = obtenerPadre(aux.derecho, elem);
                if (resultado == null) {
                    resultado = obtenerPadre(aux.izquierdo, elem);
                }
            }
            resultado = aux;
        }
        return resultado;
    }
}
