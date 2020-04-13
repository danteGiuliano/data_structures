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
                    //Con bus = bus.getHijoIzq bajo a la hoja.
                    bus = bus.getHijoIzquierdo();
                    //Si ya tiene un hijo debo enlazarlo con el hijo izquierdo.
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
        if (this.raiz != null) {
            ls = recorrido(hijo, this.raiz, ls);
        }
        return ls;
    }

    private Lista recorrido(Object hijo, NodoGen raiz, Lista ls) {
        if (raiz != null) {
            if (raiz.equals(hijo)) {
                ls.insertar(hijo, 0);
            }
            ls = recorrido(hijo, raiz.getHermanoDerecho(), ls);
            if (!ls.esVacia()) {
                ls.insertar(raiz.getElement(), 0);
            }
            ls = recorrido(hijo, raiz.getHijoIzquierdo(), ls);
            if (!ls.esVacia()) {
                ls.insertar(raiz.getElement(), 0);
            }
        }
        return ls;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura(Object n) {
        int r = -1;
        if (this.raiz != null) {
            r = alturaAux(this.raiz, n) - r;
        }
        return r;
    }

    private int alturaAux(NodoGen raiz, Object aux) {
        int r = 0;
        if (raiz != null) {
            if (raiz.getElement().equals(aux)) {
                r = 1;
            } else {
                r = alturaAux(raiz.getHermanoDerecho(), aux) + r;
                if (r == 0) {
                    r = alturaAux(raiz.getHijoIzquierdo(), aux) + r;
                }
            }
        }
        return r;
    }

    public int nivel(Object n) {
        int r = -1;
        if (this.raiz != null) {
            r = nivelAux(this.raiz, n);
        }
        return r;
    }

    private int nivelAux(NodoGen raiz, Object n) {
        int r = 0;
        if (raiz != null) {
            if (raiz.getElement().equals(n)) {
                r = 1;
            } else {
                r = nivelAux(raiz.getHermanoDerecho(), n);
                if (r == 0) {
                    r = nivelAux(raiz.getHijoIzquierdo(), n) + 1;
                }
            }
        }
        return r;
    }

    public Object padre(Object hijo) {
        Object r = null;
        if (this.raiz != null) {
            r = padreAux(this.raiz, hijo, this.raiz.getElement());
        }
        return r;
    }

    private Object padreAux(NodoGen aux, Object hijo, Object padre) {
        Object r = null;
        if (aux != null) {
            if (aux.getHijoIzquierdo().getElement().equals(hijo)) {
                r = padre;
            } else {
                r = padreAux(aux.getHermanoDerecho(), hijo, aux.getElement());
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
            hijo = new NodoGen(aux.getElement(), cloneAux(aux.getHermanoDerecho()), cloneAux(aux.getHijoIzquierdo()));
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
            s += n.getElement().toString()+"->";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s +=hijo.getElement().toString()+",";
                hijo = hijo.getHermanoDerecho();
            }
            hijo =hijo.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }
}
