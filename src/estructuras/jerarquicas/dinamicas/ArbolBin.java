/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.dinamicas;

import estructuras.lineales.dinamicas.Lista;
import estructuras.lineales.dinamicas.Cola;

/**
 *
 * @author Dantesito
 */
public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
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
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }
        return flag;
    }

    private NodoArbol obtenerPadre(NodoArbol aux, Object elem) {
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

    public int altura() {
        return recorrido(this.raiz) - 1;
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

    public ArbolBin clone() {
        ArbolBin nuevo = new ArbolBin();
        nuevo.raiz = clonarAux(this.raiz);
        return nuevo;
    }

    private NodoArbol clonarAux(NodoArbol aux) {
        NodoArbol hijo = null;
        if (aux != null) {
            hijo = new NodoArbol(aux.getElemet(), clonarAux(aux.getDerecho()), clonarAux(aux.getIzquierdo()));
        }
        return hijo;
    }

    public int nivel(Object aux) {
        int r = -1;
        if (this.raiz != null) {
            r = nivelAux(this.raiz, aux, 0);
        }
        return r;
    }

    private int nivelAux(NodoArbol aux, Object nNodo, int altura) {
        int resultado = -1;
        if (aux != null) {
            if (aux.getElemet().equals(nNodo)) {
                resultado = altura;
            } else {
                resultado = nivelAux(aux.getIzquierdo(), nNodo, altura + 1);
                if (resultado == -1) {
                    resultado = nivelAux(aux.getDerecho(), nNodo, altura + 1);
                }
            }
        }
        return resultado;
    }

    public Object padre(Object hijo) {
        Object aux = null;
        if (this.raiz != null) {
            if (!raiz.getElemet().equals(hijo)) {
                aux = busPadre(this.raiz, hijo, this.raiz.getElemet());
            }
        }
        return aux;
    }

    private Object busPadre(NodoArbol aux, Object hijo, Object padre) {
        Object r = null;
        if (aux != null) {
            if (aux.getElemet().equals(hijo)) {
                r = padre;
            } else {
                r = busPadre(aux.getIzquierdo(), hijo, aux.getElemet());
                if (r == null) {
                    r = busPadre(aux.getDerecho(), hijo, aux.getElemet());
                }
            }
        }
        return r;
    }

    public Lista listarNiveles() {
        Lista lista = new Lista();
        Cola aux = new <NodoArbol>Cola();
        NodoArbol raiz = this.raiz;
        int index = 1;
        if (raiz != null) {
            aux.poner(raiz);
            while (aux.esVacia()) {
                NodoArbol actual = (NodoArbol) aux.obtenerFrente();
                lista.insertar(actual, index);
                aux.sacar();
                index++;
                if (actual.getDerecho() != null) {
                    aux.poner(actual.getDerecho());
                }
                if (actual.getIzquierdo() != null) {
                    aux.poner(actual.getIzquierdo());
                }
            }
        }
        return lista;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista listarInorden() {
        Lista lista = new Lista();
        inOrdenAux(this.raiz, lista);
        return lista;
    }

    private void inOrdenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            inOrdenAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElemet(), 1);
            inOrdenAux(nodo.getIzquierdo(), lista);
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        posOrdenAux(this.raiz, lista);
        return lista;
    }

    private void posOrdenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            lista.insertar(nodo.getElemet(), 1);
            posOrdenAux(nodo.getDerecho(), lista);
            posOrdenAux(nodo.getIzquierdo(), lista);
        }
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        preOrdenAux(this.raiz, lista, 1);
        return lista;
    }

    private void preOrdenAux(NodoArbol nodo, Lista lista, int pos) {
        if (nodo != null) {
            lista.insertar(nodo.getElemet(), pos);
            pos++;
            preOrdenAux(nodo.getDerecho(), lista, pos);
            preOrdenAux(nodo.getIzquierdo(), lista, pos);
        }
    }
}
