/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales;

/**
 *
 * @author Dantesito
 */
public class PilaDinamica {
    private Nodo tope;
    public PilaDinamica(){
        this.tope=null;
    }
    //La estructura en si misma el tope apunta siempre SIEMPRE A null;  
    public void apilar(Object aux){
        Nodo t = new Nodo(aux,this.tope);
        this.tope=t;
        // el tope va de derecha a izquierda. tope siempre esta en el final
    }
    public void desapilar(){
        Nodo aux= this.tope;
        while(aux!=null){
            aux.setEnlance(aux);
        }
        this.tope=aux;
    }
    public Object obtenerTope(){
        return this.tope.getElement();
    }
}
