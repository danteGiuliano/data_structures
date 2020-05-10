/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuas.jerarquicas.estaticas;

/**
 *
 * @author Dantesito
 */
 class CeldaBin {
    private Object elemen;
    private int izquerdo;
    private int derecho;
    private boolean enUso;
    public CeldaBin(Object unElemento,int izq,int der){
        this.elemen = unElemento;
        this.izquerdo = izq;
        this.derecho = der;
        this.enUso = true;
    }
    public CeldaBin(){
        this.elemen = null;
        this.izquerdo = -1;
        this.derecho = -1;
        this.enUso = false;
    }
    public void setIzquierdo(int izq){
        this.izquerdo=izq;
    }
     public void setDerecho(int der){
        this.derecho=der;
    }
      public void setUso(boolean uso){
        this.enUso=uso;
    }
    public int getDerecho(){
        return this.derecho;
    }
     public int getIzquierdo(){
        return this.izquerdo;
    }
      public boolean estaEnUso(){
        return this.enUso;
    }
      public Object getElement(){
          return this.elemen;
      }
      public void setElement(Object aux){
          this.elemen=aux;
      }
    
    
}
