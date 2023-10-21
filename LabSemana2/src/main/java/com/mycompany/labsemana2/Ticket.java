/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labsemana2;

/**
 *
 * @author danie
 */
public class Ticket {
    
   private String nombre;
   private double pago;
   
   public Ticket(String nombre,double pago){
       this.nombre=nombre;
       this.pago=pago;
   }
   public String getName(){
       return nombre;
   }
   public double getPago(){
       return pago;
   }
   public String print(){
       return "Nombre: "+nombre+" Pago: "+pago+"\n";
   }
    
}
