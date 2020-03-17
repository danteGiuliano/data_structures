/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.dinamicas;

import estructuras.lineales.TDA.Nodo;

/**
 *
 * @author Dantesito
 */
public class Pila {
    private Nodo tope;
    public Pila(){
        this.tope=null;
    }
    //La estructura en si misma el tope apunta siempre SIEMPRE A null;  
    public boolean apilar(Object aux){
        Nodo t = new Nodo(aux,this.tope);
        this.tope=t;
        // el tope va de derecha a izquierda. tope siempre esta en el final
        return true;
    }
    public boolean desapilar(){
        boolean flag=false;
        if(this.tope!=null){
            Nodo aux =this.tope.getEnlace();
            this.tope=aux;
            flag=true;
        }
        return flag;
    }
    public Object obtenerTope(){
       Object aux=null;
       if(this.tope!=null){
       aux= this.tope.getElement();
       }
        return aux;
    }
    public void vaciar(){
        this.tope=null;
    }
    public boolean esVacia(){
        boolean flag=true;
        if(this.tope!=null){
            flag=false;
        }
        return flag;
    }
    public String toString(){
        String aux = "Pila vacia";
        Nodo index=this.tope;
        if(this.tope!=null){
            aux="";
            while(index!=null){
                aux+=index.getElement().toString();
                index=index.getEnlace();
            }
        }
        return aux;
    }
    public Pila clone() {
         return cloneAux(this.tope);   
        }
    private Pila cloneAux(Nodo aux) {
        Pila r = new Pila();
        if (aux != null) {
            cloneAux(aux.getEnlace());
        }
        r.tope = new Nodo(aux.getElement(), aux.getEnlace());
        return r;
    }

}
   

