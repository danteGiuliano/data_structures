/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.TDA;

/**
 *
 * @author Dantesito
 */
public class Nodo {
    private Object element;
    private Nodo enlace;
    public Nodo(Object aux,Nodo sig){
        this.element=aux;
        this.enlace=sig;
    }
    public void setElement(Object aux){
        this.element=aux;
        
    }
    public void setEnlance(Nodo sig){
        this.enlace=sig;
    }
    public Object getElement(){
        return this.element;
    }
    public Nodo getEnlace(){
        return this.enlace;
    }
}
