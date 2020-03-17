/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.estaticas;

/**
 *
 * @author Dantesito
 */
public class Pila {

    private Object array[];
    private final int tamanio = 10;
    private int tope;

    public Pila() {
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
        Object aux = null;
        if (this.tope != -1) {
            aux = this.array[this.tope];
        }
        return aux;
    }

    public Pila clone() {
        Pila aux = new Pila();
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
        int con=0;
        boolean flag = this.tope == -1;
        if (!flag) {
            aux = " ";
            while (con <= this.tope) {
                aux +=","+this.array[con].toString();
                con++;
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
