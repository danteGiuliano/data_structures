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
 class NodoBB {
 private   Comparable elem ;
 private    NodoBB izquierdo;
 private  NodoBB derecho;

public NodoBB(Comparable unElemento,NodoBB der,NodoBB izq){
    this.elem=unElemento;
    this.derecho=der;
    this.izquierdo=izq;
}
public NodoBB(Comparable ele){
    this.elem=ele;
    this.izquierdo=null;
    this.derecho=null;
}
public void setElemento(Comparable aux){
    this.elem=aux;
}
public void setDerecho(NodoBB der){
    this.derecho=der;    
}
public void setIzquierdo(NodoBB izq){
    this.izquierdo=izq;    
}
public Comparable getElemento(){
    return this.elem;
}
public NodoBB getIzquierdo(){
    return this.izquierdo;
}
public NodoBB getDerecho(){
    return this.derecho;
}
        }