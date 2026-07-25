package lab1;

import javax.swing.JOptionPane;

public class Ticket {
    private String nombre;
    private double montoOriginal;
    private double montoFinal;
    private boolean esPalindromo;

    public Ticket(String nombre, double montoOriginal, double montoFinal, boolean esPalindromo) {
        this.nombre = nombre;
        this.montoOriginal = montoOriginal;
        this.montoFinal = montoFinal;
        this.esPalindromo = esPalindromo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public boolean isEsPalindromo() {
        return esPalindromo;
    }
    
    public void print(){
    String info="INFORMACION DE BOLETO"+"\n"
    + "Pasajero: "+nombre+"\n"
    + "Monto Original: "+montoOriginal+"/n"
    + "Descuento: "+esPalindromo+"\n"
    + "Monto Final Pagado: "+montoFinal;
    
        JOptionPane.showMessageDialog(null, info, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    
    
}
