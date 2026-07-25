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

        return searchPassenger(nombre, index+1);
    }
}
