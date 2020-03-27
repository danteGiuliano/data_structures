/*
 * To change this license header, choose License Headers fin Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template fin the editor.
 */
package estructuras.lineales.dinamicas;

/**
 *
 * @author Dantesito
 */
public class Cola {

    private Nodo fin;
    private Nodo frente;

    public Cola() {
        this.fin = null;
        this.frente = null;
    }

    public boolean poner(Object aux) {
        boolean flag = true;
        Nodo n = new Nodo(aux, null);
        if (this.fin != null) {
            this.fin.setEnlance(n);
            this.fin = n;
        } else {
            this.fin = n;
            this.frente = n;
        }
        return flag;
    }

    public Object obtenerFrente() {
        Object aux = null;
        if (this.frente != null) {
            aux = frente.getElement();
        }
        return aux;
    }

    public boolean sacar() {
        boolean flag = false;
        if (this.frente != null) {
            this.frente = frente.getEnlace();
            flag = true;
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return flag;
    }

    public Cola clone() {
        Cola n = new Cola();
        if (this.frente != null) {
            Nodo frente = this.frente;
            n = cloneAux(n, frente);
        }
        return n;
    }

    private Cola cloneAux(Cola aux, Nodo ins) {
        Object elem;
        if (ins.getEnlace() != null) {
            elem = ins.getElement();
            aux = cloneAux(aux, ins.getEnlace());
            Nodo n = new Nodo(elem, aux.frente);
            aux.frente = n;
        } else {
            elem = ins.getElement();
            Nodo n = new Nodo(elem, null);
            aux.fin = n;
            aux.frente=n;
        }
        return aux;
    }
    public String toString(){
        String cad ="Cola vacia";
        if(this.frente!=null){
            Nodo aux =this.frente;
            cad="|";
            while(aux!=null){
            cad+=aux.getElement().toString()+",";
            aux=aux.getEnlace();
        } 
            cad=cad.substring(0, cad.length()-1);
             cad+="|";
        }
        return cad;
    }
    public void vaciar(){
        this.fin=null;
        this.frente=null;
    }
    public boolean esVacia(){
        boolean flag=true;
        if(this.frente!=null){
            flag=false;
        }
        return flag;
    }
}
