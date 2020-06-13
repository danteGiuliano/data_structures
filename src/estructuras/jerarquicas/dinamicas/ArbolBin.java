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

    /**
     * Realiza una insercion buscando al padre del elemento,si la posicion esta
     * disponible entonces inserta y devuelve true, si no devuelve false.
     *
     * @param elem elemento a insertar
     * @param padre nodo padre del elemento
     * @param lugar rama para insertar el hijo Derecho o izquierdo
     * @return
     */
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

    /**
     * Devuelve la maxima altura de un Arbol Binario.
     *
     * @return
     */
    public int altura() {
        return alturaAux(this.raiz) - 1;
    }

    private int alturaAux(NodoArbol aux) {
        int altD = 0;
        int altIzq = 0; //Variable auxiliar.
        if (aux != null) {
            altD = alturaAux(aux.getDerecho()) + 1;
            altIzq = alturaAux(aux.getIzquierdo()) + 1;
            if (altIzq >= altD) {
                altD = altIzq;
            }
        }
        return altD;
    }

    /**
     * Metodo vaciar, simplificado por funcionalidades de Java, Garbare
     * collector
     */
    public void vaciar() {
        this.raiz = null;
    }

    /**
     * toString metodo especial para debugear la clase Arbol Binario. dejar en
     * private para el usuario
     *
     * @return un String simulando la estructura de un Arbol Binario
     */
    public String toString() {
        return imprimir(this.raiz);
    }

    private String imprimir(NodoArbol nodo) {
        String cadena = "Arbol vacio";
        if (nodo != null) {
            cadena = "";
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

    /**
     * Estructura basica de una clonacion, **IMPORTANTE** el algoritmo funciona
     * dependiendo como este el constructor de NodoArbol.
     *
     * @return un Arbol Binario igual.
     */
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

    /**
     * busca el nivel de profundidad de un elemento que pertenesca al arbol
     *
     * @param aux elemento a buscar
     * @return -1 en caso de no estar , x >=0 si lo encontro
     */
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

    /**
     * Version diferente de obtenerPadre pasando por parametro al padre del
     * nodo.
     *
     * @param hijo
     * @return
     */
    public Object padre(Object hijo) {
        Object aux = null;
        if (this.raiz != null) {
            aux = padreAux(this.raiz, hijo, null);

        }
        return aux;
    }

    private Object padreAux(NodoArbol aux, Object hijo, Object padre) {
        Object r = null;
        if (aux != null) {
            if (aux.getElemet().equals(hijo)) {
                r = padre;
            } else {
                r = padreAux(aux.getIzquierdo(), hijo, aux.getElemet());
                if (r == null) {
                    r = padreAux(aux.getDerecho(), hijo, aux.getElemet());
                }
            }
        }
        return r;
    }

    /**
     * Recorrido como niveles en un Arbol,Nivel 0 Raiz, nivel 1 hijos de
     * raiz.etc
     *
     * @return una Lista en forma descendente
     */
    public Lista listarNiveles() {
        Lista lista = new Lista();
        Cola aux = new <NodoArbol>Cola();
        NodoArbol node = this.raiz;
        int index = 1;
        if (node != null) {
            aux.poner(node);
            while (!aux.esVacia()) {
                NodoArbol actual = (NodoArbol) aux.obtenerFrente();
                lista.insertar(actual.getElemet(), index);
                aux.sacar();
                index++;
                if (actual.getIzquierdo() != null) {
                    aux.poner(actual.getIzquierdo());
                }
                if (actual.getDerecho() != null) {
                    aux.poner(actual.getDerecho());
                }
            }
        }
        return lista;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    /**
     * recorrido en inorden en un formato de Lista Raiz-Izquierdo-derecho
     *
     * @return una lista
     */
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

    /**
     * recorrido en pos Orden en un formato de Lista, Derecha-Raiz-Izquierda
     *
     * @return una lista
     */
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

    /**
     * recorrido en pre Orden en un formato de Lista Izquierda-Raiz-Derecha
     *
     * @return
     */
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

    /**
     * Ejercicio 3.1 obtener ancestros. devuelve en un formato de Lista todos
     * los padres de la primera ocurrencia del elemento
     * desde la Raiz hasta el nodo del elemento("Excluyente").
     */
    public Lista obtenerAncestros(Object hijo) {
        Lista lista = new Lista();
        obtenerAncestrosAux(lista, hijo, this.raiz);
        return lista;
    }

    /**
     * Se usa una condicion booleana para claridad del modulo
     *
     * @param lista lista que se retorna, pasada por referencia
     * @param hijo elemento a buscar cuando se encuentra comienza a insertar
     * @param padre Nodo de busqueda.
     */
    private boolean obtenerAncestrosAux(Lista lista, Object hijo, NodoArbol padre) {
        boolean flag = false;
        if (padre != null) {
            if (padre.getElemet().equals(hijo)) {
                flag = true;
            } else {
                //La rama izquierda o derecha es equivalente.
                flag = obtenerAncestrosAux(lista, hijo, padre.getIzquierdo());
                //Esta condicion indica el comportamiento del modulo y evita 
                //llamadas extras.
                if (!flag) {
                    flag = obtenerAncestrosAux(lista, hijo, padre.getDerecho());
                }
                if (flag) {
                    lista.insertar(padre.getElemet(), 1);
                }
            }
        }
        return flag;
    }


    //Ejercicios de parcial ------------------------------------------
    public boolean equals(ArbolBin otro) {
        boolean compare = false;
        if (this.raiz != null && otro.raiz != null) {
            compare = equalsAux(this.raiz, otro.raiz, true);
        }
        return compare;
    }
    private boolean equalsAux(NodoArbol own, NodoArbol other, boolean flag) {
        //Uso un metodo auxiliar para corroborar
        if (compare(own, other)) {
            flag = equalsAux(own.getDerecho(), other.getDerecho(), true);
            //En el caso que no sean iguales y queden acoplados llamados.
            if (flag == true) {
                flag = equalsAux(own.getIzquierdo(), other.getIzquierdo(), true);
            }
        } else {
            //Compare devuelve si alguno de los 2 es falso, pero si ambos nodos
            //Son falsos entonces se interpreta que son iguales
            if (own == null && other == null) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
    private boolean compare(NodoArbol a, NodoArbol b) {
        boolean exito = false;
        if (a != null && b != null) {
            exito = a.getElemet().equals(b.getElemet());
        }
        return exito;
    }

}
