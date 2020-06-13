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
        //Si se ingresa un null como hijo derecho o izquierdo va a tomar 
       // una altura erronea
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
        //Si seteo un nulo como elemento el tda se rompera. ya que la altura
        //deberia ser -1 (Nodo vacio) pero puede tener hijos .
        this.elemento=elem;
    }
    public void recalcularAltura(){
        if(this.derecho!=null||this.izquierdo!=null){
        int altD=0,altI=0;     
        if(this.derecho!=null){
            altD=this.derecho.getAltura();
        }
        if(this.izquierdo!=null){
            altI=this.getAltura();
        }
        this.altura=Math.max(altD,altI)+1;
    }
      
    }
}
