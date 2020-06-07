/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.conjuntistas.test;

import estructuras.conjuntistas.ArbolBB;
import estructuras.lineales.dinamicas.Lista;
import java.util.Random;
/**
 *
 * @author Dan
 */
public class testDanteV1 {
    public static void main(String[] args) {
        ArbolBB n1= new ArbolBB();
        ArbolBB n2= new ArbolBB();
        System.out.println("Testeo de inserciones");
        System.out.println("Inserto 4 "+n1.insertar(4));
        System.out.println("Inserto 3 "+n1.insertar(3));
        System.out.println("Inserto 2 "+n1.insertar(2));
        System.out.println("Inserto 1 "+n1.insertar(1));
        System.out.println("Inserto 6 "+n1.insertar(6));
        System.out.println("Inserto 8 "+n1.insertar(8));
        System.out.println("Prueba toString");
        System.out.println("Prueba listar ");
        Lista ls = n1.listar();
        System.out.println(ls.toString());
        System.out.println(n1.toString());
        n2=n1.clone();
        System.out.println("Probar eliminar ");
        System.out.println("Elimino el elemento 1 "+n1.eliminar(1));
         System.out.println("Elimino el elemento 6 "+n1.eliminar(6));
         System.out.println("Elimino el elemento 6 "+n1.eliminar(4));
        System.out.println(n1.toString());
        System.out.println("Eliminar 33 "+n2.eliminar(33));
        
        System.out.println("");
        
        
    }
}
