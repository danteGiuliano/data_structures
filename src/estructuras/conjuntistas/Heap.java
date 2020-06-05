/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.conjuntistas;

/**
 *
 * @author Dantesito
 */
public class Heap {

    private static final int TAM = 20;
    private Comparable[] heap;
    private int ultimo;

    public Heap() {
        this.ultimo = 0;
        this.heap = new Comparable[TAM];
    }

    public boolean insertar(Comparable aux) {
        boolean flag = false;
        if (ultimo + 1 < TAM) {
            flag = true;
            ultimo++;
            heap[ultimo] = aux;
            hacerSubir(ultimo);
        }
        return flag;
    }

    private void hacerSubir(int posHijo) {
        int posP;
        Comparable temp = this.heap[posHijo];
        boolean flag = true;
        while (flag) {
            posP = posHijo / 2;
            if (posP >= 1) {
                if (this.heap[posP].compareTo(temp) > 0) {
                    //intercambio
                    this.heap[posHijo] = this.heap[posP];
                    this.heap[posP] = temp;
                    posHijo = posP;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }
    }

    public boolean eliminarCima() {
        boolean flag = true;
        if (this.ultimo == 0) {
            flag = false;
        } else {
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            hacerBajar(1);
        }
        return flag;
    }

    private void hacerBajar(int posPadre) {
        int posH = posPadre * 2;
        Comparable temp = this.heap[posPadre];
        boolean flag = true;
        while (flag && posH <= this.ultimo) {
            //Caso 1
            if (posH < this.ultimo) {
                if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) 
                    posH++;              
            }
            //Caso 2
            if (this.heap[posH].compareTo(temp) < 0) {
                // el hijo es menor que el padre, los intercambia
                this.heap[posPadre] = this.heap[posH];
                this.heap[posH] = temp;
                posPadre = posH;
            } else {
                flag = false;
            }
            posH = posPadre * 2;
        }
    }

    public boolean esVacio() {
        return this.ultimo == 0;
    }

    public Comparable recuperarCima() {
        Comparable aux = null;
        if (this.ultimo != 0) {
            aux = this.heap[1];
        }
        return aux;
    }

    @Override
    public Heap clone() {
        Heap n = new Heap();
        n.heap = this.heap.clone();
        n.ultimo = this.ultimo;
        return n;
    }

    public void vaciar() {
        this.heap = new Comparable[TAM];
        this.ultimo = 0;
    }

    public String toString() {
        String cad = "Arbol Heap Vacio";
        if (this.ultimo != 0) {
            cad = "";
            for (int i = 1; i <= this.ultimo; i++) {
                cad += this.heap[i].toString() + " :";
                if (2 * i <= this.ultimo) {
                    cad += " HI->" + this.heap[2 * i].toString();
                }
                if (2 * i + 1 <= this.ultimo) {
                    cad += " HD->" + this.heap[2 * i + 1].toString();
                }
                cad += "\n";
            }
        }
        return cad;
    }
}
