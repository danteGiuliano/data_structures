/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.dinamicas;

/**
 *
 * @author Dantesito
 */
public class Lista {

    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object elemen, int ind) {
        boolean flag = true;
        if (ind < 1 || ind <= this.longitud) {
            flag = false;
        } else {
            Nodo add = new Nodo(elemen, null);
            if (ind == 1) {
                this.cabecera = add;
            } else {
                Nodo aux = this.cabecera;
                while (aux.getEnlace() != null) {
                    aux = aux.getEnlace();
                }
                aux.setEnlance(add);
            }
            this.longitud++;
        }
        return flag;
    }
//Longitud devuelve la posicion actual en el caso base longitud es 0.

    public int longitud() {
        return this.longitud;
    }

    public boolean eliminar(int indice) {
        boolean flag = true;
        if (indice > 0 && indice <= this.longitud) {
            int aux = 1;//suponiendo la lista tiene al menos un elemento
            Nodo r = this.cabecera;
            Nodo n = r.getEnlace();
            while (aux != indice - 1) {
                r = r.getEnlace();
                n = n.getEnlace();
            }
            n=n.getEnlace();
            r.setEnlance(n);
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean esVacia() {
        return this.longitud == 0;
    }

    public Object recuperar(int indice) {
        int r = 1;//Supongo que la lista ya tiene un elemento
        Object obtener = null;
        if (indice > 0 && indice <= this.longitud) {
            Nodo aux = this.cabecera;
            while (indice != r) {
                aux = aux.getEnlace();
                r++;
            }
            obtener = aux.getElement();
        }
        return obtener;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public int localizar(Object elem) {
        int r = -1;
        int flag = 1;//Supongo que la lista tiene 1 elemento. 
         Nodo aux = this.cabecera;
        while (flag <= this.longitud && r == -1) {
            if (aux.getElement().equals(elem)) {
                r = flag;
            } else {
                aux = aux.getEnlace();
                flag++;
            }
        }
        return r;
    }
    public String toString(){
        String cad="Pila Vacia";
        Nodo aux=this.cabecera;
        if(this.longitud>0){
            cad="[";
            while(aux!=null){
                cad+=aux.getElement().toString()+",";
                aux=aux.getEnlace();
            }
            cad=cad.substring(0,cad.length()-1);
            cad+="]";
        }
        return cad;
    }
    public Lista clone(){
        Lista aux = new Lista();
        aux=cloneAux(aux,this.cabecera);
        aux.longitud=this.longitud;
        return aux;
    }
    private Lista cloneAux(Lista aux,Nodo ins){        
        if(ins!=null){
           aux=cloneAux(aux,ins.getEnlace());
           Nodo r =new Nodo(ins.getElement(),aux.cabecera);
           aux.cabecera=r;
        }
        return aux;
    }
}
