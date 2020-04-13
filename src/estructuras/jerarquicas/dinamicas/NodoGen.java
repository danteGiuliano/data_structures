/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.dinamicas;

/**
 *
 * @author Dantesito
 */
public class NodoGen {
    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;
    public NodoGen(Object aux){
        this.elem=aux;
        this.hermanoDerecho=null;
        this.hijoIzquierdo=null;
    }
    public NodoGen(Object aux,NodoGen der,NodoGen izq){
        this.elem=aux;
        this.hermanoDerecho=der;
        this.hijoIzquierdo=izq;
    }
    public void setHijoIzquierdo(NodoGen hI){
        this.hijoIzquierdo=hI;
    }
    public void setHermanoDerecho(NodoGen hD){
        this.hermanoDerecho=hD;
    }
    public void setElement(Object aux){
        this.elem=aux;
    }
    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }
    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }
    public Object getElement(){
        return this.elem;
    }
}
