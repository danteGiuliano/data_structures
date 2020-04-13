/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.jerarquicas.testings;

import estructuras.jerarquicas.dinamicas.ArbolGen;

/**
 *
 * @author Dantesito
 */
public class testingArbolGenerico {
    public static void main(String[] args) {
        ArbolGen n= new ArbolGen();
        n.insertar(1, null);
        n.insertar(2, 1);
        n.insertar(3, 2);
        n.insertar(4, 2);
        n.insertar(7, 4);
        n.insertar(8, 4);
        System.out.println(n.toString());
    }
}
