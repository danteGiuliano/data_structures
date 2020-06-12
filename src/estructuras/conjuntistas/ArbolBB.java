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
 * Este metodo se encarga de insertar y acomodar los elementos dependiendo de 
 * si son menores o mayores. la insercicon es de orden O(log n)
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
            flag = auxEliminar(elem,this.raiz, null);
        }
        return flag;
    }

     private boolean auxEliminar(Comparable elemento, NodoBB actual, NodoBB padre) {
        boolean flag = false;
        if (actual != null) {  
            //Esto es para no recorrer todo el arbol O(log n).
            if (actual.getElemento().compareTo(elemento) > 0) {
                flag = auxEliminar(elemento, actual.getIzquierdo(), actual);
            }
            if (!flag && actual.getElemento().compareTo(elemento) < 0) {
                flag = auxEliminar(elemento, actual.getDerecho(), actual);
            }
            if (actual.getElemento().compareTo(elemento) == 0) {
                flag = true;
                if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                    padre.getElemento();
                    caso1(elemento, padre);
                } else {
                    if (actual.getIzquierdo() == null || actual.getDerecho() == null) {
                        caso2(elemento,actual,padre);
                    } else {
                        caso3(actual);
                    }
                }
            }
        }

        return flag;
    }

    //Caso 1 de eliminar.
    private void caso1(Comparable elemento, NodoBB padre) {
        if (padre.getIzquierdo() != null) {
            if (padre.getIzquierdo().getElemento().compareTo(elemento) == 0) {
                padre.setIzquierdo(null);
            }
        }
        if (padre.getDerecho() != null) {
            if (padre.getDerecho().getElemento().compareTo(elemento) == 0) {
                padre.setDerecho(null);
            }
        }
    }

    //Caso 2 de eliminar.
    private void caso2(Comparable elemento, NodoBB actual, NodoBB padre) {
        if (padre.getElemento().compareTo(elemento) > 0) {
            if (actual.getIzquierdo() != null) {
                padre.setIzquierdo(actual.getIzquierdo());
            } else {
                padre.setIzquierdo(actual.getDerecho());
            }
        } else {
            if (padre.getElemento().compareTo(elemento) < 0) {
                if (actual.getIzquierdo() != null) {
                    padre.setDerecho(actual.getIzquierdo());
                } else {
                    padre.setDerecho(actual.getDerecho());
                }
            }
        }
    }
    /**
     * Usar el candidato A (El mayor del subarbol izquierdo de N, siendo N el nodo a eliminar).
     * @param actual envia el nodo a eliminar.
     */
    private void caso3(NodoBB actual){
        
        NodoBB nodoA=actual.getIzquierdo(),nodoPadreA=actual;
        while (nodoA.getDerecho() != null){
            nodoPadreA=nodoA;
            nodoA=nodoA.getDerecho();
        }
        actual.setElemento(nodoA.getElemento());
        if (nodoA.getIzquierdo() == null && nodoA.getDerecho() == null){
            caso1(nodoA.getElemento(),nodoPadreA);
        } else {
            caso2(nodoA.getElemento(),nodoA,nodoPadreA);
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

    public Comparable minimoElem() {
        return minimoElemAux(this.raiz);
    }

    private Comparable minimoElemAux(NodoBB aux) {
        return aux.getElemento();
    }

    /**
     * Reutilizacion del metodo toString de Arbol Binario. metodo de
     * debug.!!!!!!!!!!!!!!!! Orden  O(n)
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
     * Reutilizo el clone de Arbol Binario 
     * Orden O(n)
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
}
