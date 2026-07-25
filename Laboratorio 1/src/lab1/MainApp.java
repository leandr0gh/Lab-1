
package lab1;

import javax.swing.*;
import java.awt.*;
public class MainApp extends JFrame {
    
    private PalindromoAir avion=new PalindromoAir();
    private JButton[] botonesAsiento=new JButton[30];
    private JTextField campoNombre=new JTextField(15);
    private JTextArea consola=new JTextArea();
    
    


    public MainApp() {
        setTitle("PALINDROMO AIR");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panelAsiento=new JPanel(new GridLayout(6,5,5,5));
        for (int i = 0; i < 30; i++) {
            JButton boton=new JButton("Asiento "+(i+1));
            botonesAsiento[i]= boton;
            panelAsiento.add(boton);
        }
        add(panelAsiento, BorderLayout.WEST);
        
        
        JPanel panelArriba=new JPanel();
        panelArriba.add(new JLabel("Nombre del pasajero:"));
        panelArriba.add(campoNombre);
        
        JButton venderButton=new JButton("Sell ticket");
        JButton cancelButton=new JButton("Cancel Ticket");
        JButton dispatchButton=new JButton("Dispatch");
        JButton printButton=new JButton("Print Passengers");
        JButton incomeButton=new JButton("View Income");
        JButton searchButton=new JButton("Search Passenger");
        
        panelArriba.add(venderButton);
        panelArriba.add(cancelButton);
        panelArriba.add(dispatchButton);
        panelArriba.add(printButton);
        panelArriba.add(incomeButton);
        panelArriba.add(searchButton);
        add(panelArriba, BorderLayout.NORTH);
        
        
        //botones
       
        
        setVisible(true);
    }
    

    public static void main(String[] args){
    
    }
}
