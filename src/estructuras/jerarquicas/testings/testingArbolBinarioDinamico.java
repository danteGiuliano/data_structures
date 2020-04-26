/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.testings;

import estructuras.jerarquicas.dinamicas.ArbolBin;

/**
 *
 * @author Dantesito
 */
public class testingArbolBinarioDinamico {

    public static void main(String[] args) {
        ArbolBin n1 = new ArbolBin();
        ArbolBin n2 = new ArbolBin();
        System.out.println(n1.insertar(1, null, ' '));
        System.out.println(n1.insertar(2, 1, 'D'));
        System.out.println(n1.insertar(3, 2, 'I'));
        System.out.println(n1.insertar(4, 3, 'D'));
        System.out.println(n1.insertar(7, 4, 'D'));
        System.out.println(n1.insertar(5, 4, 'I'));
        System.out.println(n1.insertar(9, 5, 'D'));
         System.out.println(n1.insertar(10, 5, 'I'));
        System.out.println(n1.insertar(6, 7, 'D'));
        System.out.println(n1.toString());
        System.out.println(n1.toString());
        System.out.println("Altura de 7 " +n1.nivel(7));
        System.out.println("La altura del arbol es " + n1.altura());
        System.out.println("Clonar arbol");
        n2=n1.clone();
        System.out.println("Mostrar n2 ");
        System.out.println(n2.toString());
        System.out.println("Altura del nodo 4 "+n1.nivel(4));
        System.out.println("Buscar el padre de 5 "+n1.padre(5));
        System.out.println("Testin toString 2");
    
    }

}
