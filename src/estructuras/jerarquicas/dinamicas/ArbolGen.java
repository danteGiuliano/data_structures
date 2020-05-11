/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.dinamicas;

import estructuras.lineales.dinamicas.Cola;
import estructuras.lineales.dinamicas.Lista;

/**
 *
 * @author Dantesito
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object hijo, Object padre) {
        boolean flag = true;
        NodoGen n = new NodoGen(hijo);
        if (this.raiz == null) {
            this.raiz = n;
        } else {
            NodoGen bus = buscarPadre(this.raiz, padre);
            //Si existe el padre o sea padreBuscado !=null inserta, si no devuelve false
            if (bus != null) {
                if (bus.getHijoIzquierdo() == null) {
                    bus.setHijoIzquierdo(n);
                } else {
                    bus = bus.getHijoIzquierdo();
                    while (bus.getHermanoDerecho() != null) {
                        bus = bus.getHermanoDerecho();
                    }
                    bus.setHermanoDerecho(n);
                }
            } else {
                flag = false;
            }
        }
        return flag;
    }

    private NodoGen buscarPadre(NodoGen ubicacion, Object padre) {
        NodoGen r = null;
        if (ubicacion != null) {
            if (ubicacion.getElement().equals(padre)) {
                r = ubicacion;
            } else {
                r = buscarPadre(ubicacion.getHermanoDerecho(), padre);
                if (r == null) {
                    r = buscarPadre(ubicacion.getHijoIzquierdo(), padre);
                }
            }
        }
        return r;
    }

    public boolean pertenece(Object aux) {
        return perteneceAux(aux, this.raiz);
    }

    private boolean perteneceAux(Object aux, NodoGen padre) {
        boolean flag = false;
        if (padre != null) {
            if (padre.getElement().equals(aux)) {
                flag = true;
            } else {
                flag = perteneceAux(aux, padre.getHermanoDerecho());
                if (flag == false) {
                    flag = perteneceAux(aux, padre.getHijoIzquierdo());
                }
            }
        }
        return flag;
    }

    public Lista ancestros(Object hijo) {
        Lista ls = new Lista();
        if (!hijo.equals(this.raiz.getElement())) {
            recorrido(hijo, this.raiz, ls);
        }
        return ls;
    }

    private boolean recorrido(Object hijo, NodoGen raiz, Lista ls) {
        boolean flag = false;
        if (raiz != null) {
            if (raiz.getElement().equals(hijo)) {
                flag = true;
            } else {
                flag = recorrido(hijo, raiz.getHijoIzquierdo(), ls);
                if (flag) {
                    ls.insertar(raiz.getElement(), ls.longitud() + 1);
                } else {
                    flag = recorrido(hijo, raiz.getHermanoDerecho(), ls);
                }
            }
        }
        return flag;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }
    public int altura() {
        return auxAltura(this.raiz, -1);
    }
    private int auxAltura(NodoGen nodo, int alt) {
        if (nodo != null) {
            int altI = auxAltura(nodo.getHijoIzquierdo(), alt + 1);
            alt = auxAltura(nodo.getHermanoDerecho(), alt);
            if (altI >= alt) {
                alt = altI;
            }
        }
        return alt;
    }

    public int nivel(Object n) {
        return nivelAux(this.raiz, n,0);
    }

    private int nivelAux(NodoGen raiz, Object n,int r) {
        int i=-1;
        if (raiz != null) {
            if (raiz.getElement().equals(n)) {
                i = r;
            } else {
                    i = nivelAux(raiz.getHermanoDerecho(), n,r);
                    if(i==-1&&raiz.getHijoIzquierdo()!=null){
                    i = nivelAux(raiz.getHijoIzquierdo(), n,r+1) ;    
                    }  
                }
            }
        return i;
    }

    public Object padre(Object hijo) {
        Object r = null;
        if (this.raiz != null && !this.raiz.getElement().equals(hijo)) {
            r = padreAux(this.raiz, hijo, this.raiz.getElement());
        }
        return r;
    }

    private Object padreAux(NodoGen aux, Object hijo, Object padre) {
        Object r = null;
        if (aux != null) {
            if (aux.getElement().equals(hijo)) {
                r = padre;
            } else {
                r = padreAux(aux.getHermanoDerecho(), hijo, padre);
                if (r == null) {
                    r = padreAux(aux.getHijoIzquierdo(), hijo, aux.getElement());
                }
            }
        }
        return r;
    }

    public ArbolGen clone() {
        ArbolGen n = new ArbolGen();
        if (this.raiz != null) {
            n.raiz = cloneAux(this.raiz);
        }
        return n;
    }

    private NodoGen cloneAux(NodoGen aux) {
        NodoGen hijo = null;
        if (aux != null) {
            hijo = new NodoGen(aux.getElement(), cloneAux(aux.getHijoIzquierdo()), cloneAux(aux.getHermanoDerecho()));
        }
        return hijo;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            s += n.getElement().toString() + "->";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElement().toString() + ",";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    public Lista listarPreorden() {
        Lista ls = new Lista();
        auxListarPreorden(this.raiz, ls);
        return ls;
    }

    private void auxListarPreorden(NodoGen nodo, Lista ls) {
        if (nodo != null) {
            ls.insertar(nodo.getElement(), ls.longitud() + 1);
            auxListarPreorden(nodo.getHijoIzquierdo(), ls);
            auxListarPreorden(nodo.getHermanoDerecho(), ls);
        }
    }

    public Lista listarInorden() {
        Lista ls = new Lista();
        auxListarInorden(this.raiz, ls);
        return ls;
    }

    private void auxListarInorden(NodoGen nodo, Lista ls) {
        if (nodo != null) {
            auxListarInorden(nodo.getHijoIzquierdo(), ls);
            ls.insertar(nodo.getElement(), ls.longitud() + 1);
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen aux = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (aux != null) {
                    auxListarInorden(aux, ls);
                    aux = aux.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        Lista ls = new Lista();
        auxListarPosorden(this.raiz, ls);
        return ls;
    }

    private void auxListarPosorden(NodoGen nodo, Lista ls) {
        if (nodo != null) {
            auxListarPosorden(nodo.getHijoIzquierdo(), ls);
            ls.insertar(nodo.getElement(), ls.longitud() + 1);
            auxListarPosorden(nodo.getHermanoDerecho(), ls);
        }
    }

    public Lista listarPorNiveles() {
        Lista ls = new Lista();
        Cola cola = new Cola();
        NodoGen nodo;
        int aux = 1;
        cola.poner(this.raiz);
        while (!cola.esVacia()) {
            nodo = (NodoGen) cola.obtenerFrente();
            cola.sacar();
            ls.insertar(nodo.getElement(), aux);
            aux++;
            nodo = nodo.getHijoIzquierdo();
            while (nodo != null) {
                cola.poner(nodo);
                nodo = nodo.getHermanoDerecho();
            }
        }
        return ls;
    }
}
