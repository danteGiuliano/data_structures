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
        System.out.println("Ingresar elemento hola en la lista pos 0");
        System.out.println("Insertar en pos 1 " + n1.insertar("programando", 1));
        System.out.println("Insertar en pos 2 " + n1.insertar("hola", 2));
        System.out.println("Insertar en pos 3 " + n1.insertar("1", 3));
        System.out.println("Insertar en pos 4 " + n1.insertar("2", 4));
        System.out.println("Insertar en pos 4 " + n1.insertar("jeje", 4));
        System.out.println("Insertar en pos 0 " + n1.insertar("jeje", 0));
        System.out.println(n1.toString());
        System.out.println("Eliminar en pos 2 "+n1.eliminar(2));
        System.out.println(n1.toString());
        System.out.println(n1.toString());
        System.out.println("Probar la longitud");
        System.out.println(n1.longitud());
        System.out.println("Recuperar el elemento 2 " + n1.recuperar(2));
        System.out.println("Clonar n2 ");
        n2=n1.clone();
        System.out.println("Mostrar n2 "+n2.toString());
        System.out.println("Localiza 2 "+n2.localizar("2"));
        System.out.println("Vaciar n1 ");
        n1.vaciar();
        System.out.println(" n1 es vacia? "+n1.esVacia());
        System.out.println("Mostrar lista n1 "+n1.toString());
        System.out.println("Mostrar lista n2 "+n2.toString());
        
    }
}
