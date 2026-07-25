/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Ian Suazo Palao
 */
public class PalindromoAir {
    private static Ticket[] asientos = new Ticket[30];
    
    public String printPassengers(int index){
        String as_actual= "";
        
        if (index >= asientos.length){
            return "";
        }
        
        if (asientos[index] != null) {
            // se guarda el tedxto del pas con su num de asiento
            as_actual= "ASIENTO "+(index+1)+":"+asientos[index].getNombre()+"\n";
            // le agregamos el asiento y se llama al metodo nuevamente
            return as_actual + printPassengers(index+1);
        }
        return printPassengers(index+1);
    }
    
    
}
