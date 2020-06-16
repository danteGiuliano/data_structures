/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.conjuntistas;

import estructuras.lineales.dinamicas.Lista;

/**
 *
 * @author Dantesito
 */
public class ArbolBB {

    private NodoBB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    /**
     * Este metodo se encarga de insertar y acomodar los elementos dependiendo
     * de si son menores o mayores. la insercicon es de orden O(log n) el Arbol
     * BB asegura que el menor elemento estara en la rama izquierda, y el mayor
     * en la rama derecha
     *
     * @param elem representa el elemento que se quiera insertar en el arbol
     * @return devuelve true o false por cuestiones de performance
     */
    public boolean insertar(Comparable elem) {
        boolean flag = true;
        if (this.raiz == null) {
            this.raiz = new NodoBB(elem);
        } else {
            flag = insertarAux(this.raiz, elem);
        }
        return flag;
    }

    private boolean insertarAux(NodoBB aux, Comparable elem) {
        boolean flag = true;
        //Comparo que no sean iguales
        if (elem.compareTo(aux.getElemento()) == 0) {
            flag = false;
            //Coomo el arbol es minimo verifico que sea menor
        } else if (elem.compareTo(aux.getElemento()) < 0) {
            if (aux.getIzquierdo() != null) {
                flag = insertarAux(aux.getIzquierdo(), elem);
            } else {
                aux.setIzquierdo(new NodoBB(elem));
            }
        } else {
            if (aux.getDerecho() != null) {
                flag = insertarAux(aux.getDerecho(), elem);
            } else {
                aux.setDerecho(new NodoBB(elem));
            }
        }
        return flag;
    }

    public boolean eliminar(Comparable elem) {
        boolean flag = false;
        if (this.raiz != null) {
            flag = auxEliminar(elem, this.raiz, null);
        }
        return flag;
    }

    private boolean auxEliminar(Comparable elemento, NodoBB actual, NodoBB padre) {
        boolean flag = false;
        if (actual != null) {
            int temp = elemento.compareTo(actual.getElemento());
            //Esto es para no recorrer todo el arbol O(log n).
            if (temp < 0) {
                flag = auxEliminar(elemento, actual.getIzquierdo(), actual);
            } else if (temp > 0) {
                flag = auxEliminar(elemento, actual.getDerecho(), actual);
            } else {
                //Encontro al nodo.     
                if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                    caso1(elemento, padre);
                } else {
                    if (actual.getIzquierdo() == null || actual.getDerecho() == null) {
                        caso2(elemento, actual, padre);
                    } else {
                        caso3(actual);
                    }
                }
                flag = true;
            }
        }
        return flag;
    }

    //Caso 1 de eliminar.
    private void caso1(Comparable elemento, NodoBB padre) {
        if (padre == null) {
            //Caso especial al intentar eliminar la raiz
            this.raiz = null;
        } else {
            int temp = elemento.compareTo(padre.getElemento());
            if (temp < 0) {
                padre.setIzquierdo(null);
            } else {
                padre.setDerecho(null);
            }
        }

    }

    //Caso 2 de eliminar.
    private void caso2(Comparable elem, NodoBB hijo, NodoBB padre) {
        //Busco al candidato para reemplazar al nodo
        //almenos 1 sera null.
        NodoBB der = hijo.getDerecho();
        NodoBB izq = hijo.getIzquierdo();
        if (padre == null) {
            //Caso especial.
            if (der == null) {
                this.raiz = izq;
            } else {
                this.raiz = der;
            }
        } else {
            //Verifico la rama derecha o izquierda.
            int temp = elem.compareTo(padre.getElemento());
            if (temp < 0) {
                if (izq == null) {
                    padre.setIzquierdo(der);
                } else {
                    padre.setIzquierdo(izq);
                }
            } else {
                if (izq == null) {
                    padre.setDerecho(der);
                } else {
                    padre.setDerecho(izq);
                }
            }
        }

    }

    /**
     * Usar el candidato A (El mayor del subarbol izquierdo de N, siendo N el
     * nodo a eliminar).
     *
     * @param actual envia el nodo a eliminar.
     */
    private void caso3(NodoBB actual) {
        NodoBB nodoA = actual.getIzquierdo(), nodoPadreA = actual;
        while (nodoA.getDerecho() != null) {
            nodoPadreA = nodoA;
            nodoA = nodoA.getDerecho();
        }
        actual.setElemento(nodoA.getElemento());
        NodoBB hijoDer = nodoA.getDerecho();
        if (actual.getIzquierdo() == nodoA) {
            actual.setIzquierdo(hijoDer);
        } else {
            nodoPadreA.setIzquierdo(hijoDer);
        }
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    /**
     * este metodo se encarga de buscar un elemento identico en el arbol
     * devuelve la primer ocurrencia. Orden O(n log)
     *
     * @param elemento que pertenesca al arbol
     * @return true o false dependiendo de si lo encontro o no.
     */
    public boolean pertenece(Comparable elemento) {
        boolean flag = false;
        if (this.raiz != null && elemento != null) {
            flag = perteneceAux(this.raiz, elemento);
        }
        return flag;
    }

    private boolean perteneceAux(NodoBB node, Comparable var) {
        boolean flag = false;
        if (node != null) {
            if (node.getElemento().compareTo(var) == 0) {
                flag = true;
            } else {
                if (node.getElemento().compareTo(var) < 0) {
                    flag = perteneceAux(node.getDerecho(), var);
                } else {
                    flag = perteneceAux(node.getIzquierdo(), var);
                }
            }
        }
        return flag;
    }

    /**
     * Busquedas de minimo y maximos elementos /Con polimorfismo seria mejor.
     * Orden O(n log)
     *
     * @return Null arbol vacio, un Comparable min, max. respectivamente.
     */
    public Comparable minimoElem() {
        Comparable r = null;
        if (this.raiz != null) {
            r = minimoElemAux(this.raiz);
        }
        return r;
    }

    private Comparable minimoElemAux(NodoBB aux) {
        while (aux.getIzquierdo() != null) {
            aux = aux.getIzquierdo();
        }
        return aux.getElemento();
    }

    public Comparable maximoElem() {
        Comparable r = null;
        if (this.raiz != null) {
            r = maximoElemAux(this.raiz);
        }
        return r;
    }

    private Comparable maximoElemAux(NodoBB aux) {
        while (aux.getDerecho() != null) {
            aux = aux.getDerecho();
        }
        return aux.getElemento();
    }

    /**
     * Reutilizacion del metodo toString de Arbol Binario. metodo de
     * debug.!!!!!!!!!!!!!!!! Orden O(n)
     */
    public String toString() {
        String cadena;
        cadena = imprimir(this.raiz);
        return cadena;
    }

    private String imprimir(NodoBB nodo) {
        String cadena = "";
        if (nodo != null) {
            if (nodo.getDerecho() != null || nodo.getIzquierdo() != null) {
                cadena += "Nodo: " + nodo.getElemento();
                if (nodo.getIzquierdo() != null) {
                    cadena += "[ HI: " + nodo.getIzquierdo().getElemento() + " ]";
                } else {
                    cadena += "[ HI: null ]";
                }
                if (nodo.getDerecho() != null) {
                    cadena += "[ HD: " + nodo.getDerecho().getElemento() + " ]" + "\n";
                } else {
                    cadena += "[ HD: null ] \n";
                }
                cadena += imprimir(nodo.getIzquierdo());
                cadena += imprimir(nodo.getDerecho());
            } else {
                cadena += "[ Hoja: " + nodo.getElemento() + "]" + "\n";
            }
        }
        return cadena;
    }

    /**
     * Reutilizo el clone de Arbol Binario Orden O(n)
     */
    public ArbolBB clone() {
        ArbolBB nuevo = new ArbolBB();
        nuevo.raiz = clonarAux(this.raiz);
        return nuevo;
    }

    private NodoBB clonarAux(NodoBB aux) {
        NodoBB hijo = null;
        if (aux != null) {
            hijo = new NodoBB(aux.getElemento(), clonarAux(aux.getDerecho()), clonarAux(aux.getIzquierdo()));
        }
        return hijo;
    }

    /**
     * El metodo listar accede a la ultima posicion de la rama izquierda del
     * arbol para poder obtener el minimo elemento y listarlo en inorden
     * izquierdo-Padre-Derecho.
     *
     * Orden O(n)
     *
     * @return una lista con los minimos elementos en inorden
     */
    public Lista listar() {
        Lista lista = new Lista();
        if (this.raiz != null) {
            listarAux(this.raiz, lista);
        }
        return lista;
    }

    private void listarAux(NodoBB node, Lista lista) {
        if (node != null) {
            listarAux(node.getDerecho(), lista);
            lista.insertar(node.getElemento(), 1);
            listarAux(node.getIzquierdo(), lista);
        }
    }

    /**
     * Devuelve una lista tomando desde el menor elemento (Si lo encuentra)
     * hasta el mayor elemento (Si lo encuetra)
     *
     * @param min un elemento perteneciente al Arbol
     * @param max un elemento perteneciente al Arbol
     * @return una lista vacia o de elementos de [Menor,Mayor]
     */
    public Lista listarRango(Comparable min, Comparable max) {
        Lista lista = new Lista();
        //Caso especial.
        if (min != null && max != null) {
            listarRangoAux(this.raiz, lista, min, max);
        }
        return lista;
    }

    private void listarRangoAux(NodoBB node, Lista lista, Comparable min, Comparable max) {
        if (node != null) {
            Comparable elemento = node.getElemento();
            int izq = elemento.compareTo(max);
            int der = elemento.compareTo(min);
            if (izq < 0) {
                listarRangoAux(node.getDerecho(), lista, min, max);
            }
            if (der >= 0 && izq <= 0) {
                lista.insertar(elemento, 1);
            }
            if (der > 0) {
                listarRangoAux(node.getIzquierdo(), lista, min, max);
            }
        }
    }

    /**
     * Elimina el minimo elemento del arbol bb Orden O(n log)
     *
     * @return true si elimina , false si el arbol esta vacio
     */
    public boolean eliminarMin() {
        boolean flag = false;
        if (this.raiz != null) {
            eliminarMinAux(this.raiz, null);
            flag = true;
        }
        return flag;
    }

    private void eliminarMinAux(NodoBB hijo, NodoBB padre) {
        while (hijo.getIzquierdo() != null) {
            padre = hijo;
            hijo = hijo.getIzquierdo();
        }
        if (hijo.getDerecho() == null) {
            caso1(hijo.getElemento(), padre);
        } else {
            caso2(hijo.getElemento(), hijo, padre);
        }
    }

    /**
     * Elimina el maximo elemento de un arbol bb Orden O(n log)
     *
     * @return true si elimina false si arbol es vacio
     */
    public boolean eliminarMax() {
        boolean flag = false;
        if (this.raiz != null) {
            eliminarMaxAux(this.raiz, null);
            flag = true;
        }
        return flag;
    }

    private void eliminarMaxAux(NodoBB hijo, NodoBB padre) {
        while (hijo.getDerecho() != null) {
            padre = hijo;
            hijo = hijo.getDerecho();
        }
        if (hijo.getDerecho() == null) {
            caso1(hijo.getElemento(), padre);
        } else {
            caso2(hijo.getElemento(), hijo, padre);
        }
    }

}
