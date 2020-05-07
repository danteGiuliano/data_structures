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
    private int ultimo = 0;

    public Heap() {
        heap = new Comparable[TAM];
    }

    public boolean insertar(Comparable aux) {
        boolean flag = false;
        if (ultimo + 1 <= TAM - 1) {
            flag = true;
            ultimo++;
            if (ultimo == 1) {
                heap[1] = aux;
            } else {
                heap[ultimo] = aux;
                subir(aux);
            }
        }
        return flag;
    }

    private void subir(Comparable h) {
        boolean flag = false;
        int aux = this.ultimo;
        Comparable temp;
        while (!flag && aux > 1) {
            //Busco entre los padres si es menor
            temp = this.heap[aux / 2];
            if (h.compareTo(temp) > 0) {
                this.heap[aux / 2] = h;
                this.heap[aux] = temp;
                aux = aux / 2;
            }
            {
                flag = true;
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

    private void hacerBajar(int posPad) {
        int posH = posPad;
        Comparable temp = this.heap[posPad];
        boolean flag = false;
        while (!flag && posH <= this.ultimo) {
            posH = posPad * 2;
            if (posH < this.ultimo) {
                if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                    posH++;
                }
            }
            if (this.heap[posH].compareTo(temp) < 0) {
                this.heap[posPad] = this.heap[posH];
                this.heap[posH] = temp;
            } else {
                flag = false;
            }
        }
    }
    public boolean esVacio(){
        return this.ultimo==0;
    }
    public Object recuperarCima(){
        Object aux=null;
        if(this.ultimo!=0){
            aux=this.heap[1];
        }
        return aux;
    }
    public String toString(){
        String cad="Arbol Heap vacio";
        if(this.ultimo!=0){
            cad="";
            for (int i = 0; i < this.ultimo; i++) {
                cad+=this.heap[i];
            }
        }
        return cad;
    }
    @Override
    public Heap clone(){
        Heap n = new Heap();
        n.heap= this.heap.clone();
        n.ultimo=this.ultimo;
        return n;
    } 
}
