/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.testings;
import estructuras.lineales.dinamicas.Lista;
public class testinListaCatedra {

	
	
	 static String sOk = "OK!", sErr = "ERROR";

	    public static void main(String[] arg) {

	        testLista();
	        System.out.println("==================================================================================== ");
	        
	    }

	    public static void testLista() {
	        System.out.println("***************COMIENZO TEST LISTA***************");
	        Lista l1 = new Lista();
	        System.out.println("Muestra lista vacia: \t\t\t\t\t--> " + l1.toString());
	        System.out.println("Longitud de lista vacia:\t\t\t" + l1.longitud());
	        System.out.print("Inserta 5 pos 5 espera FALSE: \t\t\t" + ((l1.insertar(5, 5) == false) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Inserta 2 pos 1 espera TRUE: \t\t\t" + ((l1.insertar(2, 1) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Inserta 1 pos 1 espera TRUE: \t\t\t" + ((l1.insertar(1, 1) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Inserta 3 pos long+1 espera TRUE: \t\t" + ((l1.insertar(3, l1.longitud() + 1) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Inserta 5 pos 4 espera TRUE: \t\t\t" + ((l1.insertar(5, 4) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Inserta 4 pos 4 espera TRUE: \t\t\t" + ((l1.insertar(4, 4) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.println("Inserta 10 pos 0 espera FALSE: \t\t\t" + ((l1.insertar(10, -1) == false) ? sOk : sErr));
	        System.out.println("Inserta 10 pos -1 espera FALSE: \t\t" + ((l1.insertar(10, -1) == false) ? sOk : sErr));
	        System.out.print("Inserta 10 pos long+2 espera FALSE: \t\t" + ((l1.insertar(10, l1.longitud() + 2) == false) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());

	        int longi = l1.longitud();
	        for (int i = -1; i <= longi + 2; i++) {
	            if (i > 0 && i <= longi) {
	                System.out.println("Recupera " + i + " \tespera " + i + " retorna " + l1.recuperar(i) + ":\t\t" + (((int) l1.recuperar(i) == i) ? sOk : sErr));
	            } else {
	                System.out.println("Recupera " + i + " \tespera NULL retorna " + l1.recuperar(i) + ":\t" + ((l1.recuperar(i) == null) ? sOk : sErr));
	            }
	        }

	        longi = l1.longitud();
	        for (int i = -1; i <= longi + 2; i++) {
	            if (i > 0 && i <= longi) {
	                System.out.println("Localiza " + i + " \tespera " + i + " retorna " + l1.localizar(i) + ":\t\t" + ((l1.localizar(i) == i) ? sOk : sErr));
	            } else {
	                System.out.println("Localiza " + i + " \tespera -1 retorna " + l1.localizar(i) + ":\t\t" + ((l1.localizar(i) == -1) ? sOk : sErr));
	            }
	        }

	        System.out.print("Elimina pos -1 espera FALSE: \t\t\t" + ((l1.eliminar(-1) == false) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Elimina pos 0 espera FALSE: \t\t\t" + ((l1.eliminar(0) == false) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Elimina pos 10 espera FALSE: \t\t\t" + ((l1.eliminar(10) == false) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Elimina pos 1 espera TRUE y 2,3,4,5: \t\t" + ((l1.eliminar(1) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Elimina pos 3 espera TRUE y 2,3,5: \t\t" + ((l1.eliminar(3) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Elimina ultimo espera TRUE y 2,3: \t\t" + ((l1.eliminar(l1.longitud()) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Inserta 9 pos 2 espera TRUE y 2,9,3: \t\t" + ((l1.insertar(9, 2) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.println("Recupera pos 5 espera NULL: \t\t\t" + ((l1.recuperar(5) == null) ? sOk : sErr));

	        Lista l2 = l1.clone();
	        System.out.println("Copia espera [2,9,3]: \t\t\t\t\t--> " + l2.toString());

	        System.out.print("Inserta 10 pos 1 espera [10,2,9,3]: \t\t" + ((l1.insertar(10, 1) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());
	        System.out.print("Elimina pos 4 espera true y 10,2,9: \t\t" + ((l1.eliminar(4) == true) ? sOk : sErr));
	        System.out.println("\t--> " + l1.toString());

	        while (!l1.esVacia()) {
	            System.out.print("Elimina cabecera varias veces hasta vaciar: \t" + ((l1.eliminar(1) == true) ? sOk : sErr));
	            System.out.println("\t--> " + l1.toString());
	        }

	        System.out.print("Se vacio la lista l1, espera ver lista vacia");
	        System.out.println("\t\t--> " + l1.toString());
	        System.out.println("Eliminar pos 1 en lista vacia espera FALSE: \t" + ((l1.eliminar(1) == false) ? sOk : sErr));
	        System.out.println("Eliminar pos 5 en lista vacia espera FALSE: \t" + ((l1.eliminar(5) == false) ? sOk : sErr));
	        System.out.println("Sacar en lista vacia espera FALSE: \t\t" + ((l1.eliminar(1) == false) ? sOk : sErr));
	        System.out.println("Recupera pos 1 en lista vacia espera NULL: \t" + ((l1.recuperar(1) == null) ? sOk : sErr));
	        System.out.println("Recupera pos 5 en lista vacia espera NULL: \t" + ((l1.recuperar(5) == null) ? sOk : sErr));
	        System.out.println("Localiza 1 en vacia espera -1, retorna " + l1.localizar(1) + ": \t" + ((l1.localizar(1) == -1) ? sOk : sErr));

	        System.out.println("Verifica copia anterior espera [2,9,3]: \t--> " + l2.toString());
	        System.out.println("Inserta 7,1 espera true : \t\t\t" + ((l2.insertar(7, 1) == true) ? sOk : sErr));
	        System.out.println("Copia modificada espera [7,2,9,3]: \t\t--> " + l2.toString());
	        System.out.println("Inserta 6,3 espera true: \t\t\t" + ((l2.insertar(6, 3) == true) ? sOk : sErr));
	        System.out.println("Copia modificada espera [7,2,6,9,3]: \t\t--> " + l2.toString());
	        System.out.println("Inserta 90,ultimo espera true: \t\t\t" + ((l2.insertar(90, l2.longitud() + 1) == true) ? sOk : sErr));
	        System.out.println("Copia modificada espera [7,2,6,9,3,90]: \t--> " + l2.toString());

	        System.out.println("Elimina pos 3 espera true: \t\t\t" + ((l2.eliminar(3) == true) ? sOk : sErr));
	        System.out.println("Copia modificada espera [7,2,9,3,90]: \t\t--> " + l2.toString());
	        System.out.println("Elimina elemento 90 : \t\t\t\t" + ((l2.eliminar(l2.localizar(90)) == true) ? sOk : sErr));
	        System.out.println("Copia modificada espera [7,2,9,3]: \t\t--> " + l2.toString());
	        l2.vaciar();
	        System.out.println("Vacia copia: \t\t\t\t\t--> " + l2.toString());

	    }

}

