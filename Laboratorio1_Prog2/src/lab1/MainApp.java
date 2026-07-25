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
public class MainApp {
    
    private JFrame vent;
    private JTextField txtNom;
    private JTextField txt_a;
    private JCheckBox es_pal;
    // crear y colocar todos los espacios de texto para el interfaz
    public void creacionFormulario(){
        
        //creacion del panel para el texto
        JPanel p_form=new JPanel(new GridLayout (3,2,6,6));
        p_form.setBorder(BorderFactory.createTitledBorder("DATOS DEL PASAJERO"));
        
        //nombre
        p_form.add(new JLabel(" Nombre del Pasajero: "));
        txtNom=new JTextField();
        p_form.add(txtNom);
        
        //num de asiento
        p_form.add(new JLabel(" Nunmero de Asiento: "));
        txt_a=new JTextField();
        p_form.add(txt_a);
        
        
        
        //es palindromo
        p_form.add(new JLabel(" Es nombre Palindromo?: "));
        es_pal=new JCheckBox("Aplicar descuento.");
        p_form.add(es_pal);
        
        // ahora el panel solo se agrega todo junto al centro de la ventana
        vent.add(p_form, BorderLayout.CENTER);
    }
    public static void main(String[] args){
        //nueva instancia y arranque de aplic.
        new MainApp();
    }
}
