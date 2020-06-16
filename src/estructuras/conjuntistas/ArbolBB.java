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
     * de si son menores o mayores. la insercicon es de orden O(log n)
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
    private void caso2(Comparable elemento, NodoBB actual, NodoBB padre) {
        int temp = elemento.compareTo(padre.getElemento());
        if (temp < 0) {
            if (actual.getDerecho() != null) {
                padre.setIzquierdo(actual.getDerecho());
            } else {
                if (actual.getIzquierdo() != null) {
                    padre.setDerecho(actual.getIzquierdo());

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
        if (nodoA.getIzquierdo() == null) {
            nodoPadreA.setDerecho(null);
        } else  {
            nodoPadreA.setIzquierdo(nodoA.getDerecho());
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
        return perteneceAux(this.raiz, elemento);
    }

    private boolean perteneceAux(NodoBB node, Comparable var) {
        boolean flag = false;
        if (node != null) {
            if (node.getElemento().compareTo(var) == 0) {
                flag = true;
            } else {
                if (node.getElemento().compareTo(var) > 0) {
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
            aux = aux.getDerecho();
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
            aux = aux.getIzquierdo();
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
                cadena += "Raiz: " + nodo.getElemento();
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
            lista.agregarElem(node.getElemento(), 1);
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
        boolean exito = false;
        if (min != null && max != null) {
            exito = min.compareTo(max) < 0;
        }
        if (this.raiz != null && exito) {
            boolean con = insertarMinMax(this.raiz, max, lista);
            if (con) {
                boolean con1 = insertarMinMax(this.raiz, min, lista);
                if (!con1) {
                    lista.vaciar();
                }
            }
        }
        return lista;
    }

    private boolean insertarMinMax(NodoBB node, Comparable min, Lista lista) {
        boolean flag = false;
        if (node != null) {
            int compare = node.getElemento().compareTo(min);
            if (compare == 0) {
                flag = true;
                lista.insertar(min, 1);
            } else if (compare > 0) {
                insertarMinMax(node.getDerecho(), min, lista);
            } else {
                insertarMinMax(node.getIzquierdo(), min, lista);
            }
            if (flag) {
                lista.insertar(node.getElemento(), 1);
            }
        }
        return flag;
    }

    /**
     * Elimina el minimo elemento del arbol bb Orden O(n log)
     *
     * @return true si elimina , false si el arbol esta vacio
     */
    public boolean eliminarMin() {
        boolean flag = false;
        if (this.raiz != null) {
            if (this.raiz.getIzquierdo() == null) {
                this.raiz = this.raiz.getDerecho();
            } else {
                eliminarMinAux(this.raiz.getIzquierdo(), this.raiz);
            }
            flag = true;
        }
        return flag;
    }

    private void eliminarMinAux(NodoBB hijo, NodoBB padre) {
        if (hijo.getIzquierdo() != null) {
            eliminarMinAux(hijo.getIzquierdo(), hijo);
        } else if (hijo.getDerecho() == null) {
            padre.setIzquierdo(null);
        } else {
            padre.setIzquierdo(hijo.getDerecho());
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
            if (this.raiz.getDerecho() == null) {
                this.raiz = this.raiz.getIzquierdo();
            } else {
                eliminarMinAux(this.raiz.getDerecho(), this.raiz);
            }
            flag = true;
        }
        return flag;
    }

    private void eliminarMaxAux(NodoBB hijo, NodoBB padre) {
        if (hijo.getDerecho() != null) {
            eliminarMinAux(hijo.getDerecho(), hijo);
        } else if (hijo.getIzquierdo() == null) {
            padre.setDerecho(null);
        } else {
            padre.setDerecho(hijo.getIzquierdo());
        }
    }

}
