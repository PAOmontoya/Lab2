/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.labsemana2;

/**
 *
 * @author danie
 */
public class PalindromoAir {
    
    public static Ticket[] ticket= new Ticket[30];
    public int posicion;
    public double totalIngresos;
    public double totalPago;
    
    
    public PalindromoAir(){
        
    }

    public int firstAvailable(){
        return firstAvailableRecursiva(0);
    }
    
    private int firstAvailableRecursiva(int posicion){
       
        if(posicion>=ticket.length){
            return -1;
        }
        if(ticket[posicion]==null){
            return posicion;
        }
       
        else{
            return firstAvailableRecursiva(posicion+1);
        }
        
    }

    public int buscarPasajeros(String namePasajero){
       return buscarPasajero(namePasajero,0) ;
    }
    private int buscarPasajero(String namePasajero,int posicion){
        
       if(posicion>=ticket.length){
            return -1;
        }
       if (ticket[posicion] != null && ticket[posicion].getName().equals(namePasajero)) {
                return posicion; 
        }
        else{
           return buscarPasajero(namePasajero,posicion+1);
        }
    }

    public static boolean isPalindromo(String namePasajero){
       return isPalindromo(namePasajero,0,namePasajero.length()-1);
    }
    
    private static boolean isPalindromo(String namePasajero,int inicio,int fin){
        if(inicio<fin){
            if(namePasajero.charAt(inicio)==namePasajero.charAt(fin))
                return isPalindromo(namePasajero,inicio+1,fin-1);
                return false;
        }
        return true;
      }
    
   //d)Print Passengers
    public String printPassengers(String list){
       return printPassengers(0,list);
    }
    private String printPassengers(int posicion, String list){
        if(posicion>=ticket.length){
            return list;
        } 
        if(ticket[posicion]!=null){
           list+=ticket[posicion].print();
           
        }
         return printPassengers(posicion+1,list);
    }

    public double income(){
        return income(totalIngresos,0);
    }
    private double income(double totalIngresos,int posicion){
       if(posicion>=ticket.length){
            return totalIngresos+=0;
        } 
       if(ticket[posicion]!=null){
            totalIngresos+= ticket[posicion].getPago();
        }
        return income(totalIngresos,posicion+1);
    }

    public void sellTicket(String namePasajero){
       
        totalPago=0;
        posicion = firstAvailable(); 
        if(posicion!=-1){
            if(isPalindromo(namePasajero)==false){
                totalPago=800;
            }
            else{
               totalPago=800-(800*0.2);
            }
            ticket[firstAvailable()] = new Ticket(namePasajero, totalPago);
            
            System.out.println("Monto a Pagar"+"\nNombre: "+ticket[posicion].getName()+
                    "Monto a pagar: $. "+ticket[posicion].getPago());      
        }   
    }

    public void reset(){
      totalIngresos = 0;
        reset(0);
    }
    private void reset(int posicion){
         if(posicion>=ticket.length){  
             return;
        }
         ticket[posicion]=null;
          reset(posicion+1);      
    }
    

     public boolean cancelTicket(String namePasajero){
        
         if (buscarPasajero(namePasajero,0)!=-1){
         ticket [posicion]=null;
     }else{
             return false;
         }
         return true;
     }

     public void dispatch(){
         
         System.out.println("Ingreso total: "+income());
         reset(0);
         totalIngresos=0;
     }
    }