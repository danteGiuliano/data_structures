/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.conjuntistas.test;
import estructuras.conjuntistas.ArbolBB;

/**
 *
 * @author Dan
 */
public class TestArbolBB {

    static String sOk = "\u001B[32m OK! \u001B[0m", sErr = " \u001B[31m ERROR \u001B[0m";
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String RESET = "\u001B[0m";

    public static void main(String args[]) {
        String fondo = ANSI_BLUE_BACKGROUND;
        String fondo2 = ANSI_GREEN_BACKGROUND;
        String fondo3 = ANSI_PURPLE_BACKGROUND;
        String ok = sOk;
//Arboles.
        ArbolBB a = new ArbolBB();
        ArbolBB b = new ArbolBB();
        ArbolBB c = new ArbolBB();

        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "*********************************************************************");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "*                  Test Arbol Busqueda binaria                      *");
        System.out.println(ANSI_CYAN_BACKGROUND + ROJO + "*********************************************************************" + "\n\n" + RESET);

        System.out.println(fondo2 + AZUL + "Test Echo por Dante Giuliano FAI-2062");
        System.out.println("\n");
        System.out.println(fondo + "********************************");
        System.out.println(fondo + "*    Metodos con arbol vacio   *");
        System.out.println(fondo + "********************************");
        System.out.println(RESET);
        System.out.println("Checkeo si es vacio " + ((a.esVacio()) ? sOk : sErr));
        System.out.println(fondo3 + NEGRO + "!!!!!!!!!!!!!Obtener elementos minimos y maximos con arbol vacio!!!!!!!!!!!!!!!" + RESET);
        System.out.println("Trato de obtener el minimo elemento de un arbol vacio debe dar" + ok + "--->" + ((a.minimoElem() == null) ? ok : sErr));
        System.out.println("Trato de obtener el maximo elemento de un arbol vacio debe dar" + ok + "--->" + ((a.maximoElem() == null) ? ok : sErr));
        System.out.println("Trato de eliminar con arbol vacio debe dar " + sErr + "--->" + (a.eliminar(null) ? ok : sErr));
        System.out.println(fondo3 + NEGRO + "!!!!!!!!!!!!!Tratar de eliminar!!!!!!!!!!!!!!!" + RESET);
        System.out.println("Trato de eliminar  el maximo elemento de un arbol vacio debe dar" + sErr + "--->" + ((a.eliminarMax()) ? ok : sErr));
        System.out.println("Trato de eliminar  el minimo elemento de un arbol vacio debe dar" + sErr + "--->" + ((a.eliminarMax()) ? ok : sErr));
        System.out.println("Mostrar arbol vacio debe dar Arbol vacio---> " + a.toString());
        System.out.println(fondo3 + NEGRO + "!!!!!!!!!!!!!Tratar de Listar!!!!!!!!!!!!!!!" + RESET);
        System.out.println("Listar con Arbol vacio debe dar Lista vacia --->" + a.listar().toString());
        System.out.println("Listar con 3 y null  con Arbol vacio debe dar Lista vacia --->" + a.listarRango(3, null).toString());
        System.out.println("Listar con null y 3  con Arbol vacio debe dar Lista vacia --->" + a.listarRango(null, 3).toString());
        System.out.println("Listar con null y null  con Arbol vacio debe dar Lista vacia --->" + a.listarRango(null, null).toString());
        System.out.println("Listar con 3 y 6  con Arbol vacio debe dar Lista vacia --->" + a.listarRango(3, 6).toString());
        System.out.println(fondo3 + NEGRO + "!!!!!!!!!!!!!Buscar!!!!!!!!!!!!!!!" + RESET);
        System.out.println("Busco elemento 10  con Arbol vacio debe dar" + sErr + "--->" + ((a.pertenece(10)) ? ok : sErr));
        System.out.println("Busco null  con Arbol vacio debe dar" + sErr + "--->" + ((a.pertenece(null)) ? ok : sErr));
        System.out.println("\n");
        System.out.println(fondo + "********************************");
        System.out.println(fondo + "*       Insercion basica       *");
        System.out.println(fondo + "********************************");
        System.out.println(RESET);
        System.out.println("Trato de insertar 5 como raiz " + ok + "--->" + ((a.insertar(5)) ? ok : sErr));
        System.out.println("Trato de insertar 2  " + ok + "--->" + ((a.insertar(2)) ? ok : sErr));
        System.out.println("Trato de insertar 7 " + ok + "--->" + ((a.insertar(7)) ? ok : sErr));
        System.out.println("Trato de insertar 4  " + ok + "--->" + ((a.insertar(4)) ? ok : sErr));
        System.out.println("Trato de insertar 3  " + ok + "--->" + ((a.insertar(3)) ? ok : sErr));
        System.out.println("Trato de insertar 6  " + ok + "--->" + ((a.insertar(6)) ? ok : sErr));
        System.out.println("Trato de insertar 9  " + ok + "--->" + ((a.insertar(9)) ? ok : sErr));
        System.out.println("Trato de insertar 10  " + ok + "--->" + ((a.insertar(10)) ? ok : sErr));
        System.out.println("Trato de insertar null debe dar " + sErr + "--->" + ((a.insertar(10)) ? ok : sErr));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[5]────┐             ");
        System.out.println("           [2]──┐     ┌─[7]─┐         ");
        System.out.println("             ┌─[4]    [6]     [9]─┐     ");
        System.out.println("            [3]                    [10]    ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        b = a.clone();
        System.out.println(fondo + "*********************************");
        System.out.println(fondo + "*       Metodos eliminar        *");
        System.out.println(fondo + "*********************************"+RESET);
        System.out.println("Elimino 3 debe dar " + ok + "--->" + ((a.eliminar(3)) ? ok : sErr));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[5]────┐             ");
        System.out.println("           [2]──┐     ┌─[7]─┐         ");
        System.out.println("                 [4]    [6]     [9]─┐     ");
        System.out.println("                                    [10]    ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 2 debe dar " + ok + "--->" + ((a.eliminar(2)) ? ok : sErr));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[5]────┐             ");
        System.out.println("           [4]          ┌─[7]─┐         ");
        System.out.println("                       [6]     [9]─┐     ");
        System.out.println("                                   [10]    ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 10 debe dar " + ok + "--->" + ((a.eliminar(10)) ? ok : sErr));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("            ┌───[5]────┐             ");
        System.out.println("           [4]          ┌─[7]─┐         ");
        System.out.println("                       [6]     [9]         ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 5 debe dar " + ok + "--->" + ((a.eliminar(5)) ? ok : sErr));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("                [2]────┐             ");
        System.out.println("                     ┌─[7]─┐         ");
        System.out.println("                    [6]      [9]     ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());
        System.out.println("Elimino 7 debe dar " + ok + "--->" + ((a.eliminar(7)) ? ok : sErr));
        System.out.println("Arbol resultante-------------------- debe ser:");
        System.out.println("                [2]─┐             ");
        System.out.println("                    [6]─┐         ");
        System.out.println("                        [9]     ");
        System.out.println("toString devuelve -->" + "\n" + a.toString());

    }

}
