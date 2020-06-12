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
 class NodoAVL {
    private Comparable elemento;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;
    public NodoAVL(Comparable elemento,NodoAVL izq,NodoAVL der){
        this.izquierdo=izq;
        this.derecho=der;
        this.elemento=elemento;
        this.altura=0;
    }
    public NodoAVL(Comparable elemento){
        this.elemento=elemento;
        this.altura=0;
    }
    public int getAltura(){
        return this.altura;
    }
    public Comparable getElemento(){
        return this.elemento;
    }
    public NodoAVL getIzquierda(){
        return this.izquierdo;
    }
    public NodoAVL getDerecha(){
        return this.derecho;
    }
    public void setDerecho(NodoAVL der){
        this.derecho=der;
    }
    public void setIzquierdo(NodoAVL izq){
        this.izquierdo=izq;
    }
    public void setElemento(Comparable elem){
        this.elemento=elem;
    }
    public void recalcularAltura(){
        this.altura=(this.derecho.getAltura()-this.izquierdo.getAltura());
    }
}
