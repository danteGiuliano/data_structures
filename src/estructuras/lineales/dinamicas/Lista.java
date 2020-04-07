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
        int r = 1;
        if (ind < 1 || ind > this.longitud + 1) {
            flag = false;
        } else {
            if (ind == 1) {
                this.cabecera = new Nodo(elemen, this.cabecera);
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < ind - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elemen, aux.getEnlace());
                aux.setEnlance(nuevo);
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
            if (indice == 1) {
                this.cabecera = r.getEnlace();
            } else {
                while (aux != indice - 1) {
                    r = r.getEnlace();
                    n = n.getEnlace();
                }
                n = n.getEnlace();
                r.setEnlance(n);
            }

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

    public String toString() {
        String cad = "Pila Vacia";
        Nodo aux = this.cabecera;
        int r = 1, i = this.longitud;
        if (this.longitud > 0) {
            cad = "[";
            while (r <= i) {
                cad += aux.getElement().toString() + ",";
                aux = aux.getEnlace();
                r++;
            }
            cad = cad.substring(0, cad.length() - 1);
            cad += "]";
        }
        return cad;
    }

    public Lista clone() {
        Lista aux = new Lista();
        aux = cloneAux(aux, this.cabecera);
        aux.longitud = this.longitud;
        return aux;
    }

    private Lista cloneAux(Lista aux, Nodo ins) {
        if (ins != null) {
            aux = cloneAux(aux, ins.getEnlace());
            Nodo r = new Nodo(ins.getElement(), aux.cabecera);
            aux.cabecera = r;
        }
        return aux;
    }

    public Lista invertirLista() {
        Lista ls = new Lista();
        Nodo n = invertirAux(this.cabecera, null, ls);
        ls.longitud = this.longitud;
        return ls;
    }
   

    private Nodo invertirAux(Nodo aux, Nodo apilado, Lista ls) {
        if (aux.getEnlace() != null) {
            apilado = invertirAux(aux.getEnlace(), apilado, ls);
            Nodo ap = new Nodo(aux.getElement(), null);
            apilado.setEnlance(ap);
            apilado = ap;
        } else {
            apilado = new Nodo(aux.getElement(), null);
            ls.cabecera = apilado;
        }
        return apilado;
    }
 public Lista invertirLista2(){
        Lista ls = new Lista();
        Nodo aux = invertirAux2(this.cabecera,ls);
        ls.longitud=this.longitud;
        return ls;
    }
    private Nodo invertirAux2(Nodo aux,Lista ls) {
        Nodo nuevo=new Nodo(aux.getElement(),null);
       if(aux.getEnlace()!=null){
           aux=invertirAux2(aux.getEnlace(),ls);
           aux.setEnlance(nuevo);
           aux=nuevo;
       }
       else{
           aux=nuevo;
           ls.cabecera=nuevo;
       }
       return aux;
    }
}
