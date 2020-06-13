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

    /**
     * La insercion deberia ser de orden O(log n) trato de no hacer llamadas
     * extras usando nulls, para hacer un algoritmo mas centrado a las
     * rotaciones. si el elemento esta repetido, debe retornar false.
     *
     * @param elem un elemento comparable
     * @return True si el elemento es unico, false si esta repetido.
     */
    public boolean insertar(Comparable elem) {
        boolean flag = true;
        if (this.raiz == null) {
            this.raiz = new NodoAVL(elem);
        } else {
            flag = insertarAux(this.raiz, elem, null);
        }
        return flag;
    }

    private boolean insertarAux(NodoAVL hijo, Comparable elem, NodoAVL padre) {
        boolean flag = false;
        //Por esto evito llamadas extras, para evitar una sentencia sobrecargada
        int comparar = hijo.getElemento().compareTo(elem);
        if (comparar != 0) {
            if (comparar > 0 && hijo.getDerecha() != null) {
                flag = insertarAux(hijo.getDerecha(), elem, hijo);
            } else {
                if (hijo.getDerecha() == null) {
                    hijo.setDerecho(new NodoAVL(elem));
                    hijo.recalcularAltura();
                } else {
                    if (hijo.getIzquierda() != null) {
                        flag = insertarAux(hijo.getIzquierda(), elem, hijo);
                    }

                }
            }
        }
        return flag;
    }

}
