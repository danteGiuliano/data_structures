/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.testings;

import estructuras.jerarquicas.dinamicas.ArbolGen;
import estructuras.lineales.dinamicas.Lista;

/**
 *
 * @author Dantesito
 */
public class testingArbolGenerico {
    public static void main(String[] args) {
        ArbolGen n= new ArbolGen();
        ArbolGen n2= new ArbolGen();
        Lista a = new Lista();
        n.insertar(1, null);
        n.insertar(2, 1);
        n.insertar(3, 2);
         n.insertar(9, 2);
        n.insertar(4, 2);
        n.insertar(7, 4);
        n.insertar(8, 4);
        n.insertar(10, 8);
        System.out.println(n.toString());
        System.out.println("Buscar nivel de 3 "+n.nivel(7));
        System.out.println("Clonar ");
        n2=n.clone();
        System.out.println("cual es elñ padre de 7 "+n2.padre(7));
        System.out.println(n2.toString());
        System.out.println("El elemento 3 pertenece "+n.pertenece(10));
        a=n.ancestros(10);
        System.out.println(a.toString());
        System.out.println(a.toString());
}
}