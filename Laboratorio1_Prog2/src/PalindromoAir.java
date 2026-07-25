
import javax.swing.JTextArea;
/**
 *
 * @author Ian Suazo Palao
 */
public class PalindromoAir {
    
    private static Ticket[] asientos = new Ticket[30];
    
    
    public String printPassengers(int index){
        String as_actual="";
        // caso base en caso de llegar a los 30 asientos
        if (index >= asientos.length){
            return "";
        }

        // revision del asienta en la pos
        if (asientos[index] != null) {
            // se guarda el tedxto del pas con su num de asiento
            as_actual= "ASIENTO "+(index+1)+":"+asientos[index].getNombre()+"\n";
            // le agregamos el asiento y se llama al metodo nuevamente
            return as_actual + printPassengers(index+1);
        }
        
        // por si acaso sei esta vacio entonces se llama al metodo nuevamente y se pasa al sig
        return printPassengers(index+1);
    }
    
    public double income (int index){
        double monto=0;
        
        // caso base
        if (index >= asientos.length){
            return 0;
        }
        
        //por si el asiento ya se encuentra ocupado
        if (asientos[index] != null){
            monto=asientos[index].getMontoFinal();
            return monto +income(index+1);
        }
        
        // en caso de estar vacio solo se llama nuevamente para la recursividad
        return income(index+1);
    }
    
    public void reset (int index){
        if (index >= asientos.length){
            return;
        }
        
        asientos[index]=null;
        
        reset(index+1);
    }
    
}
