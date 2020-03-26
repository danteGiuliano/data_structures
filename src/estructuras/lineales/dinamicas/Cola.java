/*
 * To change this license header, choose License Headers fin Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template fin the editor.
 */
package estructuras.lineales.dinamicas;

import estructuras.lineales.TDA.Nodo;

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
            //preguto si el enlace es nulo por que aunque saque el nodo si fin lo 
            //sigue apuntando no se va a borrar frente apunta a null y In apuntaa un nodo
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

    public Cola cloneAux(Cola aux, Nodo ins) {
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
        }
        return aux;
    }
}
