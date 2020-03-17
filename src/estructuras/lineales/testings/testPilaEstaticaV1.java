/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.testings;

import estructuras.lineales.estaticas.Pila;

/**
 *
 * @author Dantesito
 */
public class testPilaEstaticaV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pila p= new Pila();
        Pila c= new Pila();
        Pila e= new Pila();
        System.out.println("Test con 3 pilas P C E");
        System.out.println("Clonando pilas e con P");
        e=p.clone();     
        System.out.println("Apilando pila p");
        for (int i = 0; i < 29; i++) {
            System.out.print(p.apilar(i+100)+" ");
            System.out.print(p.obtenerTope());
        }
        System.out.println(" ");
        System.out.println("apilar pila C");
        for (int i = 0; i < 19; i++) {
            System.out.print(c.apilar(i+10)+" ");      
            System.out.print(c.obtenerTope());
        }
        System.out.println(" ");
        System.out.println("Clonar pila e con C");
          e=c.clone();
        System.out.print("pila e Vacia? ");
        System.out.println(e.esVacia());
        System.out.println(e.toString());
        System.out.println(" Desapilo la pila E");
        for (int i = 0; i < 25; i++) {
            System.out.print(e.desapilar()+" ");
        }
        System.out.println("Metodo toString");
        System.out.println(e.toString());
        System.out.println("Pila e vacia?? "+e.esVacia());
        
        
    
    }
    
}
