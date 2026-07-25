/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Ian Suazo Palao
 */
public class PalindromoAir {
    private static Ticket[] asientos = new Ticket[30];

    // ===== Conexion con la interfaz grafica (GUI) =====
    private JButton[] botonesAsientos;
    private JTextArea consolaTexto;

    public void setBotonesAsientos(JButton[] botones) {
        this.botonesAsientos = botones;
    }

    public void setConsolaTexto(JTextArea consola) {
        this.consolaTexto = consola;
    }

     public int FirstAvailable(int index){
        if (index>=30) {
            return -1;
        }
        if (asientos[index]!=null) {
            return FirstAvailable(index+1);
        }
   return index; }
    
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
    
    public double income (int index){
        double monto=0;
        
        if (index >= asientos.length){
            return 0;
        }
        
        if (asientos[index] != null){
            monto=asientos[index].getMontoFinal();
            return monto +income(index+1);
        }
        
        return income(index+1);
    }
    
    public void reset (int index){
        if (index >= asientos.length){
            return;
        }
        
        asientos[index]=null;
        
        reset(index+1);
    }
    public int searchPassenger(String nombre, int index) {
        if (index >= 30) {
            return -1;
        }
        if (asientos[index] == null) {
            return searchPassenger(nombre, index + 1);
        } else if (asientos[index].getNombre().equals(nombre)) {
            return index;
        }
        return searchPassenger(nombre, index + 1);
    }
    public boolean isPalindromo(String nombre) {
        return isPalindromo(nombre, 0, nombre.length() - 1);
    }
    private boolean isPalindromo(String nombre, int inicio, int fin) {
        if (inicio >= fin) {
            return true;
        }
        
        
        
        if (nombre.charAt(inicio) == nombre.charAt(fin)) {
            return isPalindromo(nombre, inicio+1, fin-1);
        }
        return false;
    }

    

    public int sellTicket(String nombre) {
        int pos = FirstAvailable(0);
        if (pos == -1) {
            consolaTexto.append("No hay asientos disponibles. El avion va lleno.\n");
            return -1;
        }
        boolean esPali = isPalindromo(nombre);
        double montoOriginal = 150.00;
        double montoFinal = montoOriginal;
        if (esPali) {
            montoFinal = montoOriginal - (montoOriginal * 0.20);
        }
        Ticket ticket = new Ticket(nombre, montoOriginal, montoFinal, esPali);
        asientos[pos] = ticket;

        botonesAsientos[pos].setText(nombre);
        botonesAsientos[pos].setBackground(esPali ? Color.BLUE : Color.RED);

        consolaTexto.append("Ticket vendido a " + nombre + " en el asiento " + (pos + 1) + "\n");
        consolaTexto.append("Monto pagado: L" + montoFinal + (esPali ? " (con descuento por palindromo)" : "") + "\n");
        return pos;
    }
    public boolean cancelTicket(String nombre) {
        int pos = searchPassenger(nombre, 0);
        if (pos == -1) {
            consolaTexto.append("No se encontro ningun pasajero con el nombre " + nombre + "\n");
            return false;
        }
        asientos[pos] = null;

        botonesAsientos[pos].setText("Asiento " + (pos + 1));
        botonesAsientos[pos].setBackground(Color.GREEN);

        consolaTexto.append("Se cancelo el ticket de " + nombre + ", asiento " + (pos + 1) + " libre.\n");
        return true;
    }
    public void dispatch() {
        double total = income(0);
        consolaTexto.append("Despacho del vuelo\n");
        consolaTexto.append("Ingresos totales: L" + total + "\n");
        reset(0);

        for (int i = 0; i < botonesAsientos.length; i++) {
            botonesAsientos[i].setText("Asiento " + (i + 1));
            botonesAsientos[i].setBackground(Color.GREEN);
        }
        consolaTexto.append("Avion limpio, todos los asientos estan libres otra vez.\n");
    }
    
    
    
}