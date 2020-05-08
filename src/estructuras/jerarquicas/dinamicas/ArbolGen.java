/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.dinamicas;

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
                    //Con bus = bus.getHijoIzq bajo a la hoja y el nuevo nodo.
                    //sera el nuevo hijo izquierdo no importa la posicion de los
                    //hermanos
                    NodoGen aux = bus.getHijoIzquierdo();
                    bus.setHijoIzquierdo(n);
                    n.setHermanoDerecho(aux);
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
//Arreglar este metodo.

    public int altura() {
        return alturaAux(this.raiz, -1);
    }

    private int alturaAux(NodoGen raiz, int alt) {
        if (raiz != null) {
            while (raiz.getHermanoDerecho()!= null) {
                raiz = raiz.getHermanoDerecho();
                if (raiz.getHijoIzquierdo() != null) {
                    alt = alturaAux(raiz.getHijoIzquierdo(), alt + 1);
                } 
            }
            alt = alturaAux(raiz.getHijoIzquierdo(), alt + 1);
        }
        return alt;
    }

    public int nivel(Object n) {
        return nivelAux(this.raiz, n);
    }

    private int nivelAux(NodoGen raiz, Object n) {
        int r = -1;
        if (raiz != null) {
            if (raiz.getElement().equals(n)) {
                r = 0;
            } else {
                r = nivelAux(raiz.getHermanoDerecho(), n);
                if (r == -1) {
                    r = nivelAux(raiz.getHijoIzquierdo(), n) + 1;
                }
            }
        }
        return r;
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

    //Ejercicios auxiliares ---------------------------------------------------
    public Lista listaQueJustificaLaAltura() {
        Lista n = new Lista();
        Lista b = new Lista();
        n = caminoAux(this.raiz, n, b);
        return n;
    }

    private Lista caminoAux(NodoGen aux, Lista actual, Lista larga) {
        if (aux != null) {
            actual.insertar(aux.getElement(), 1);
            larga.insertar(aux.getElement(), 1);
            if (actual.longitud() <= larga.longitud()) {
                larga = actual;
            }
            larga = caminoAux(aux.getHijoIzquierdo(), actual, larga);
            larga = caminoAux(aux.getHermanoDerecho(), actual, larga);
        }
        return larga;
    }
}