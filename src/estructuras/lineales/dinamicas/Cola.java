/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras.lineales.dinamicas;
import estructuras.lineales.TDA.Nodo;
/**
 *
 * @author Dantesito
 */
public class Cola {
  private Nodo in ;
  private Nodo out;
  public Cola(){
      this.in=null;
      this.out=null;
  }
  public boolean poner(Object aux){
      boolean flag=true;
      Nodo n =new Nodo(aux,null);
      if(this.in!=null){
          this.in.setEnlance(n);
          this.in=n;     
      }
      else{
          this.in=n;
          this.out=n;
      }
      return flag;
  }
  public Object obtenerFrente(){
      Object aux = null;
      if(this.out!=null){
          aux=out.getElement();
      }
      return aux;
  }
  public boolean sacar(){
      boolean flag=false;
      if(this.out!=null){
          this.out=out.getEnlace();
          flag=true;
          //preguto si el enlace es nulo por que aunque saque el nodo si in lo 
          //sigue apuntando no se va a borrar out apunta a null y In apuntaa un nodo
          if(this.out==null){
              this.in=null;
          }
      }
      return flag;
  }
}
