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
public class PilaEstatica {

    private Object array[];
    private final int tamanio = 20;
    private int tope;

    public PilaEstatica() {
        this.array = new Object[this.tamanio];
        this.tope = -1;

    }

    public boolean apilar(Object unElemento) {
        boolean flag = false, push = this.tope < tamanio - 1;
        if (push) {
            this.tope++;
            this.array[this.tope] = unElemento;
            flag = true;
        }
        return flag;
    }

    public boolean desapilar() {
        boolean flag = false, peek = this.tope > -1;
        if (peek) {
            this.array[this.tope] = null;
            this.tope--;
            flag = true;
        }
        return flag;
    }

    public Object obtenerTope() {
        Object aux = -1;
        if (this.tope != -1) {
            aux = this.array[this.tope];
        }
        return aux;
    }

    public PilaEstatica clone() {
        PilaEstatica aux = new PilaEstatica();
        aux.tope = this.tope;
        int ind = this.tope;
        while (ind > -1) {
            aux.array[ind] = this.array[ind];
            ind--;
        }
        return aux;

    }

    public String toString() {
        String aux = "pilaVacia";
        int ind = this.tope;
        boolean flag = ind == -1;
        if (!flag) {
            aux = " ";
            while (ind > -1) {
                aux += this.array[ind].toString();
                ind--;
            }
        }
        return aux;
    }

    public boolean esVacia() {
        return this.tope == -1;
    }

    public void vaciar() {
        Object aux[] = new Object[tamanio];
        this.tope = -1;
        this.array = aux;
    }

}
