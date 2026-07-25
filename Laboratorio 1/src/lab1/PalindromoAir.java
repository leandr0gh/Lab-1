package lab1;
/**
 *
 * @author Leandro
 */
public class PalindromoAir {
    Ticket[] asientos = new Ticket[30];

    public int FirstAvailable(int index) {
        if (index >= 30) {
            return -1;
        }
        if (asientos[index] != null) {
            return FirstAvailable(index + 1);
        }
        return index;
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

    public int sellTicket(String nombre) {
        int pos = FirstAvailable(0);
        if (pos == -1) {
            System.out.println("No hay asientos disponibles. El avion va lleno.");
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
        System.out.println("Ticket vendido a " + nombre + " en el asiento " + (pos + 1));
        System.out.println("Monto pagado: L" + montoFinal + (esPali ? " (con descuento por palindromo)" : ""));
        return pos;
    }

    public boolean cancelTicket(String nombre) {
        int pos = searchPassenger(nombre, 0);
        if (pos == -1) {
            System.out.println("No se encontro ningun pasajero con el nombre " + nombre);
            return false;
        }
        asientos[pos] = null;
        System.out.println("Se cancelo el ticket de " + nombre + ", asiento " + (pos + 1) + " libre.");
        return true;
    }

    public void dispatch() {
        double total = income(0);
        System.out.println("Despacho del vuelo");
        System.out.println("Ingresos totales: L" + total);
        reset(0);
        System.out.println("Avion limpio, todos los asientos estan libres otra vez.");
    }
}