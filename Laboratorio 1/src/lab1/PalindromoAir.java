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
}
