/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.testings;
import estructuras.jerarquicas.dinamicas.ArbolBin;

/**
 *
 * @author Dan
 */
public class testParcial {
    public static void main(String[] args) {
          ArbolBin n1 = new ArbolBin();
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
          ArbolBin n2 = new ArbolBin();
        System.out.println(n2.insertar(1, null, ' '));
        System.out.println(n2.insertar(2, 1, 'D'));
        System.out.println(n2.insertar(3, 2, 'I'));
        System.out.println(n2.insertar(4, 3, 'D'));
        System.out.println(n2.insertar(7, 4, 'D'));
      
        System.out.println(n2.insertar(9, 5, 'D'));
         System.out.println(n2.insertar(10, 5, 'I'));
        System.out.println(n2.insertar(6, 7, 'D'));
        System.out.println(n2.toString());
        System.out.println("Probar un arbol igual a otro");
        System.out.println(n1.equals(n2));
    }
}
