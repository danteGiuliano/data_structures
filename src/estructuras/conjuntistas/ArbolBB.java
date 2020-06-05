/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.conjuntistas;

/**
 *
 * @author Dantesito
 */
public class ArbolBB {
//arbolito

    private NodoBB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

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
            flag = eliminarAux(this.raiz, elem, null);
        }
        return flag;
    }

    private boolean eliminarAux(NodoBB arbol, Comparable elem, NodoBB padre) {
        boolean flag = false;
        if (elem.compareTo(arbol.getElemento()) == 0) {
            flag = true;
            //Caso 1 no tiene hojas
            if (arbol.getIzquierdo() == null && arbol.getDerecho() == null) {
                padre.setDerecho(null);
                padre.setIzquierdo(null);
            } else {
                //Busco  si es el caso 2
                if (arbol.getIzquierdo() == null) {
                    padre.setDerecho(arbol.getDerecho());
                } else if (arbol.getDerecho() == null) {
                    padre.setIzquierdo(arbol.getIzquierdo());
                } else {
                    //Caso especial 3 tiene hijos.
                    eliminarCasoEspecial(arbol);
                }
            }
        } else {
            flag = eliminarAux(arbol.getIzquierdo(), elem, arbol);
            if (flag == false) {
                flag = eliminarAux(arbol.getDerecho(), elem, arbol);
            }
        }
        return flag;
    }

    private void eliminarCasoEspecial(NodoBB arbol) {
        NodoBB candidato = arbol.getIzquierdo();
        NodoBB padreCan = arbol;
        while (candidato.getDerecho() != null) {
            padreCan = candidato;
            candidato = candidato.getDerecho();
        }
        arbol.setDerecho(new NodoBB(candidato.getElemento()));
        if (candidato.getIzquierdo() == null) {
            candidato = null;
        } else {
            padreCan.setDerecho(candidato.getIzquierdo());
        }
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

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
    public Comparable minimoElem(){
        return minimoElemAux(this.raiz);
    }
    private Comparable minimoElemAux(NodoBB aux){
   return aux.getElemento();
    }
}
