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
 class NodoArbol {
    Object elem ;
    NodoArbol izquierdo;
    NodoArbol derecho;

public NodoArbol(Object unElemento,NodoArbol der,NodoArbol izq){
    this.elem=unElemento;
    this.derecho=der;
    this.izquierdo=izq;
}
public NodoArbol(Object ele){
    this.elem=ele;
    this.izquierdo=null;
    this.derecho=null;
}
public void setElement(Object aux){
    this.elem=aux;
}
public void setDerecho(NodoArbol der){
    this.derecho=der;    
}
public void setIzquierdo(NodoArbol izq){
    this.izquierdo=izq;    
}
public Object getElemet(){
    return this.elem;
}
public NodoArbol getIzquierdo(){
    return this.izquierdo;
}
public NodoArbol getDerecho(){
    return this.derecho;
}
        }