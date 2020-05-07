/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.conjuntistas;

import estructuras.jerarquicas.dinamicas.*;

/**
 *
 * @author Dantesito
 */
 class NodoBB {
 private   Object elem ;
 private    NodoBB izquierdo;
 private  NodoBB derecho;

public NodoBB(Object unElemento,NodoBB der,NodoBB izq){
    this.elem=unElemento;
    this.derecho=der;
    this.izquierdo=izq;
}
public NodoBB(Object ele){
    this.elem=ele;
    this.izquierdo=null;
    this.derecho=null;
}
public void setElement(Object aux){
    this.elem=aux;
}
public void setDerecho(NodoBB der){
    this.derecho=der;    
}
public void setIzquierdo(NodoBB izq){
    this.izquierdo=izq;    
}
public Object getElemet(){
    return this.elem;
}
public NodoBB getIzquierdo(){
    return this.izquierdo;
}
public NodoBB getDerecho(){
    return this.derecho;
}
        }