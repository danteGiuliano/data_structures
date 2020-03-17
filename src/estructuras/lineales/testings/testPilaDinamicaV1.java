/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.testings;

import estructuras.lineales.dinamicas.Pila;

/**
 *
 * @author Dantesito
 */
public class testPilaDinamicaV1 {

    public static void main(String[] args) {
        Pila aux = new Pila();
        Pila aux1 = new Pila();
        Pila aux2 = new Pila();
        Pila aux3 = new Pila();
        
        System.out.println("Prueba de carga aux");
        for (int i = 0; i < 10; i++) {
            aux.apilar(i);
            System.out.print(aux.obtenerTope().toString()+" ");
        }
        System.out.println("Metodo Tu String "+aux.toString());
         aux1=aux.clone();
        System.out.println(" ");
        System.out.println("Prueba aux desapilar");
        System.out.println(" ");
        for (int i = 0; i < 10; i++) {
            aux.desapilar();
            System.out.print(aux.obtenerTope().toString()+" ");
        }
        System.out.println(" ");
        System.out.println("Voy a clonar");
        System.out.println("Pila aux1 clonada? "+aux1.esVacia());
        if(aux1.esVacia()){
            System.out.println(aux1.toString());
        }
    }
}
