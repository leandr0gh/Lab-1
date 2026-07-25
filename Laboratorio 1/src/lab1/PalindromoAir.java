
package lab1;

/**
 *
 * @author Leandro
 */
public class PalindromoAir {
    Ticket[] asientos=new Ticket[30];
    
    public int FirstAvailable(int index){
        if (index>=30) {
            return -1;
        }
        if (asientos[index]!=null) {
            return FirstAvailable(index+1);
        }
   return index; }
}
