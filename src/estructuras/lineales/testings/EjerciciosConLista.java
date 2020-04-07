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
public class EjerciciosConLista {
    public static void main(String[] args) {
        Lista n1 = new Lista();
        Lista n2 = new Lista();
        System.out.println("Cargar elementos en la lista");
        for (int i = 1; i < 11; i++) {
            System.out.println(n1.insertar(i, i));
        }
        System.out.println("Elemetnos en L1 "+n1.toString());
        System.out.println("Invertir Lista");
        n2=n1.invertirLista2();
        System.out.println("Mostrar lista invertida "+n2.toString());
    }
}
