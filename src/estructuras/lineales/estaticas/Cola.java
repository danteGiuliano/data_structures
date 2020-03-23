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
    private static final int tamanio=10;
    private Object array[];
    private int in,out;
    public Cola(){
        this.array=new Object [tamanio];
        in=0;
        out=0;
    }
    public boolean apilar(Object aux){
        boolean flag=false;
        if((this.in+1)%tamanio!=out){
            this.array[in]=aux;
            this.in=(this.in+1)%tamanio;
            flag=true;
        }
        return flag;
    }
    public boolean desapilar(){
        boolean flag=false;
        if(this.in!=this.out){
            this.array[out]=null;
            this.out=(this.out+1)%tamanio;
            flag=true;
        }
        return flag;
    }
    public boolean esVacia(){
        return this.in==this.out;
    }
    public Cola clone(){
        Cola aux = new Cola();
        int der=this.out,izq=this.in-1;
        while(izq!=der){
            aux.array[izq]=this.array[izq];
            aux.array[der]=this.array[der];
            izq=Math.abs(izq-1)%tamanio;
            der=(der+1)%tamanio;
        }
        aux.array[der]=this.array[der];
        aux.in=this.in;
        aux.out=this.out;
        return aux;
    }
    public String toString(){
        String aux ="Cola vacia",aux2;
        if(this.in!=this.out){
            aux="[";
            aux2="]";
            int der=this.out,izq=this.in-1;
            while(der!=izq){
                aux2=","+this.array[izq].toString()+aux2;
                aux+=this.array[der].toString()+",";
                der=(der+1)%tamanio;
                izq=Math.abs(izq-1)%tamanio;
            }
            aux=aux+this.array[der].toString()+aux2;
        }
        return aux;
    }
    public Object obtenerFrente(){
        Object aux=null;
        if(this.in!=this.out){
            aux=this.array[out];
        }
        return aux;
    }
}
