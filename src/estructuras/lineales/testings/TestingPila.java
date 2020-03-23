package estructuras.lineales.testings;

import estructuras.lineales.estaticas.Pila;

/**
 *
 * @author Catedra Estructuras de Datos
 * 
 */


public class TestingPila {

    static String sOk = "OK!", sErr = "ERROR";

    public static void main(String[] arg) {
        testPila();
    }

    public static void testPila() {

        System.out.println("COMIENZO TEST PILA");
        Pila p1 = new Pila();
        System.out.println("\t\t\t\t\t\t\t\t--> " + p1.toString());

        System.out.println("Apila 1:\t\t\t\t\t\t" + ((p1.apilar(1)) ? sOk : sErr));
        System.out.print("Apila 2:\t\t\t\t\t\t" + ((p1.apilar(2)) ? sOk : sErr));
        System.out.println("\t--> " + p1.toString());
        System.out.println("Apila 3:\t\t\t\t\t\t" + ((p1.apilar(3)) ? sOk : sErr));
        System.out.println("Apila 4:\t\t\t\t\t\t" + ((p1.apilar(4)) ? sOk : sErr));
        System.out.println("Apila 5:\t\t\t\t\t\t" + ((p1.apilar(5)) ? sOk : sErr));
        System.out.println("Apila 6:\t\t\t\t\t\t" + ((p1.apilar(6)) ? sOk : sErr));
        System.out.println("Apila 7:\t\t\t\t\t\t" + ((p1.apilar(7)) ? sOk : sErr));
        System.out.println("Apila 8:\t\t\t\t\t\t" + ((p1.apilar(8)) ? sOk : sErr));
        System.out.println("Apila 9:\t\t\t\t\t\t" + ((p1.apilar(9)) ? sOk : sErr));
        System.out.println("Apila 10:\t\t\t\t\t\t" + ((p1.apilar(10)) ? sOk : sErr));
        System.out.println("Apila 11 espera false en estatica true en dinamica:\t" + p1.apilar(11));
        if ((int) p1.obtenerTope() == 11) {
            System.out.println("si apilo el 11, lo saca para continuar");
            p1.desapilar();
        }
        System.out.print("espera \t1,2,3,4,5,6,7,8,9,10");
        System.out.println("\t\t\t\t\t--> " + p1.toString());
        System.out.println("Recupera tope espera 10 recupera: \t\t\t" + (((int) p1.obtenerTope() == 10) ? sOk : sErr));

        System.out.println("Desapila: \t\t\t\t\t\t" + ((p1.desapilar()) ? sOk : sErr));
        System.out.println("espera \t1,2,3,4,5,6,7,8,9 recupera \t\t\t\t--> " + p1.toString());
        System.out.println("Desapila: \t\t\t\t\t\t" + ((p1.desapilar()) ? sOk : sErr));
        System.out.println("espera \t1,2,3,4,5,6,7,8 recupera \t\t\t\t--> " + p1.toString());
        System.out.println("Apila 6: \t\t\t\t\t\t" + ((p1.apilar(6)) ? sOk : sErr));
        System.out.println("espera \t1,2,3,4,5,6,7,8,6 recupera \t\t\t\t--> " + p1.toString());
        System.out.println("Recupera tope, espera 6: \t\t\t\t" + (((int) p1.obtenerTope() == 6) ? sOk : sErr));

        Pila p2 = p1.clone();
        System.out.println("Copia espera 1,2,3,4,5,6,7,8,6: \t\t\t\t--> " + p2.toString());

        while (!p1.esVacia()) {
            System.out.print("Desapila espera true: \t\t\t\t\t" + ((p1.desapilar()) ? sOk : sErr));
            System.out.println("\t--> " + p1.toString());
        }
        System.out.print("Se vacio la pila p1");
        System.out.println("\t\t\t\t\t\t--> " + p1.toString());
        System.out.println("Desapila en pila vacia espera false: \t\t\t" + ((p1.desapilar()) ? sErr : sOk));
        System.out.println("Verifica tope en pila vacia espera null: \t\t" + ((p1.obtenerTope() == null) ? sOk : sErr));

        System.out.println("Verifica copia 1,2,3,4,5,6,7,8,6: \t\t\t\t-->" + p2.toString());
        System.out.println("Apila 7: \t\t\t\t\t\t" + ((p2.apilar(7)) ? sOk : sErr));
        System.out.println("Verifica copia 1,2,3,4,5,6,7,8,6,7: \t\t\t\t-->" + p2.toString());
        System.out.println("Apila 8 espera false en estatica true en dinamica:\t" + p2.apilar(8));
        System.out.println("Apila 9 espera false en estatica true en dinamica:\t" + p2.apilar(9));

        if ((int) p2.obtenerTope() == 9) {
            System.out.println("si apilo el 8 y el 9, los saca para continuar");
            p2.desapilar();
            p2.desapilar();
        }

        System.out.println("Verifica copia modificada 1,2,3,4,5,6,7,8,6,7: \t\t\t--> " + p2.toString());

        System.out.println("Desapila: \t\t\t\t\t\t" + ((p2.desapilar()) ? sOk : sErr));
        System.out.println("Desapila: \t\t\t\t\t\t" + ((p2.desapilar()) ? sOk : sErr));
        System.out.println("Desapila: \t\t\t\t\t\t" + ((p2.desapilar()) ? sOk : sErr));
        System.out.println("Desapila: \t\t\t\t\t\t" + ((p2.desapilar()) ? sOk : sErr));
        System.out.println("Verifica copia modificada, espera 1,2,3,4,5,6: \t\t\t--> " + p2.toString());
        p2.vaciar();
        System.out.println("Vacia copia espera pila vacia: \t\t\t\t\t--> " + p2.toString());
    }
}
