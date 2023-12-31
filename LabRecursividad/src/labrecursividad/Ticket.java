/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labrecursividad;

public class Ticket {
    //Atributos 
   private Main main;
   public String nombrePasajero;
   public double totalPagado;
   
   public Ticket(String nombrePasajero,double totalPagado,Main main){
       this.nombrePasajero=nombrePasajero;
       this.totalPagado=totalPagado;
       this.main=main;
   }
   
    //Set y get
   public void setNombrePaasajero(String nombrePasajero){
       this.nombrePasajero=nombrePasajero;
   }
   
   public String getNombrePasajero(){
       return nombrePasajero;
   }
   
   public void setTotalPagado(double totalPagado){
       this.totalPagado=totalPagado;
   }
   
   public double getTotalPagado(){
       return totalPagado;
   }
     
   public void print(){
       String texto="-------Datos de Ticket-------"+"\nNombre del Pasajero: "+nombrePasajero+
       "\nTotal Pagado Ticket: Lps. "+totalPagado;
       
        main.listado(texto);
   }
   
    
}
