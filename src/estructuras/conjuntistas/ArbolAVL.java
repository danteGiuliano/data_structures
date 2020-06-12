/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.conjuntistas;

/**
 *
 * @author Dan
 */
public class ArbolAVL {

    private NodoAVL raiz;

    public ArbolAVL() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elem) {
        boolean flag = true;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elem);
        } else {
            flag=insertarAux(this.raiz, elem, null);
        }
        return flag;
    }

    private boolean insertarAux(NodoAVL hijo, Comparable elem, NodoAVL padre) {
        boolean flag = false;
        if (!hijo.getElemento().equals(elem)) {
            int comparar = hijo.getElemento().compareTo(elem);
            if (comparar == 0) {

            } else if (comparar > 0 && hijo.getDerecha() != null) {
                flag=insertarAux(hijo.getDerecha(), elem, hijo);
            } else {
                if (hijo.getIzquierda() != null) {
                    flag=insertarAux(hijo.getIzquierda(), elem, hijo);
                }
            }
        }
        return flag;
    }

}
