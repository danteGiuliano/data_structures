/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.estatica;

/**
 *
 * @author Dantesito
 */
public class ArbolBin {

    private static final int TAM = 20;
    private CeldaBin[] arbol;
    private int raiz;

    public ArbolBin() {
        this.arbol = new CeldaBin[TAM];
        for (int i = 0; i < TAM; i++) {
            this.arbol[i] = new CeldaBin();
        }
        this.raiz = -1;
    }

    public boolean insertar(Object elem, Object padre, int posicion) {
        boolean flag = false;
        //Caso Base la variable padre no sirve para nada.
        if (this.raiz == -1) {
            this.arbol[posicion].setElement(elem);
            this.raiz = posicion;
            flag = true;
        } else if (!this.arbol[posicion].estaEnUso()) {
            int r = 0;
            boolean esPadre=this.arbol[r].getElement().equals(padre);
            while (!esPadre && r < TAM) {
                r++;
            }
            if (this.arbol[r].getDerecho() != 1 && esPadre) {
                this.arbol[r].setDerecho(posicion);
                flag = true;
            } else if (this.arbol[r].getIzquierdo() != 1&&esPadre) {
                this.arbol[r].setIzquierdo(posicion);
                flag = true;
            }
        }
        return flag;
    }
    public boolean esVacio(){
        return this.raiz!=-1;
    }
    public int altura(){
        int izq,alt=-1;
        //para despues
        return alt;
    }
    private CeldaBin obtenerHijo(int pos){
        return this.arbol[pos];
    }
}
