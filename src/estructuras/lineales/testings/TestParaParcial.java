/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.testings;
import estructuras.lineales.dinamicas.Lista;

/**
 *
 * @author Dan
 */
public class TestParaParcial {
    public static void main(String[] args) {
        Lista ls = new Lista();
           for (int i = 0; i < 10; i++) {
            System.out.println("Insertar elem pos "+i+" "+ls.insertar(i+5, i));
        }
           System.out.println("Metodo agregar elemento");
           ls.agregarElem("Holi", 3);
           System.out.println(ls.toString());
    }
}
