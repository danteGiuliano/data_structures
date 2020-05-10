/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.testings;

import estructuras.lineales.dinamicas.Lista;

/**
 *
 * @author Dantesito
 */
public class TestListaV1 {

    public static void main(String[] args) {
        Lista n1 = new Lista();
        Lista n2 = new Lista();
        for (int i = 0; i < 10; i++) {
            System.out.println("Insertar elem pos "+i+" "+n1.insertar(i+5, i));
        }
        System.out.println("Mostrar n1 "+n1.toString());
        System.out.println("Insertar en pos 3 "+n1.insertar("insertando", 3)+"|"+n1.toString());
        
    }
}
