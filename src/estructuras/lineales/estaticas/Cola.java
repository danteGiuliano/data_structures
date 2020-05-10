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
public class Cola {

    private static final int tamanio = 10;
    private Object array[];
    private int in, out;

    public Cola() {
        this.array = new Object[tamanio];
        in = 0;
        out = 0;
    }

    public boolean poner(Object aux) {
        boolean flag = false;
        if ((this.in + 1) % tamanio != out) {
            this.array[in] = aux;
            this.in = (this.in + 1) % tamanio;
            flag = true;
        }
        return flag;
    }

    public boolean sacar() {
        boolean flag = false;
        if (this.in != this.out) {
            this.array[out] = null;
            this.out = (this.out + 1) % tamanio;
            flag = true;
        }
        return flag;
    }

    public boolean esVacia() {
        return this.in == this.out;
    }

    public Cola clone() {
        Cola aux = new Cola();
        int der = this.out;
        while (this.in != der) {
            aux.array[der] = this.array[der];
            der = (der + 1) % tamanio;
        }
        aux.in = this.in;
        aux.out = this.out;
        return aux;
    }

    public String toString() {
        String aux = "Pila vacia";
        if (this.in != this.out) {
            aux = "[";
            for (int i = this.out; i != this.in; i = (i + 1) % tamanio) {
                aux += this.array[i].toString() + ",";
            }
            aux += "]";
        }
        return aux;

    }

    public Object obtenerFrente() {
        Object aux = null;
        if (this.in != this.out) {
            aux = this.array[out];
        }
        return aux;
    }

    public void vaciar() {
        for (Object aux : this.array) {
            aux = null;
        }
        this.out = 0;
        this.in = 0;

    }
}
