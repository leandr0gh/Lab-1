package lab1;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {

    private PalindromoAir avion = new PalindromoAir();
    private JButton[] botonesAsiento = new JButton[30];
    private JTextField campoNombre = new JTextField(15);
    private JTextArea consola = new JTextArea();

    public MainApp() {
        setTitle("PALINDROMO AIR");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panelAsiento = new JPanel(new GridLayout(6, 5, 5, 5));
        for (int i = 0; i < 30; i++) {
            JButton boton = new JButton("Asiento " + (i + 1));
            botonesAsiento[i] = boton;
            panelAsiento.add(boton);
        }
        add(panelAsiento, BorderLayout.WEST);

        JPanel panelArriba = new JPanel();
        panelArriba.add(new JLabel("Nombre del pasajero:"));
        panelArriba.add(campoNombre);

        JButton venderButton = new JButton("Sell ticket");
        JButton cancelButton = new JButton("Cancel Ticket");
        JButton dispatchButton = new JButton("Dispatch");
        JButton printButton = new JButton("Print Passengers");
        JButton incomeButton = new JButton("View Income");
        JButton searchButton = new JButton("Search Passenger");

        panelArriba.add(venderButton);
        panelArriba.add(cancelButton);
        panelArriba.add(dispatchButton);
        panelArriba.add(printButton);
        panelArriba.add(incomeButton);
        panelArriba.add(searchButton);
        add(panelArriba, BorderLayout.NORTH);

        consola.setEditable(false);
        JScrollPane scroll = new JScrollPane(consola);
        scroll.setPreferredSize(new Dimension(400, 400));
        add(scroll, BorderLayout.CENTER);

        //botones events
        venderButton.addActionListener(e -> venderTicket());
        cancelButton.addActionListener(e -> cancelarTicket());
        dispatchButton.addActionListener(e -> despachar());
        printButton.addActionListener(e -> imprimirPasajeros());
        incomeButton.addActionListener(e -> verIngresos());
        searchButton.addActionListener(e -> buscarPasajero());

        setVisible(true);
    }

    private void log(String mensaje) {
        consola.append(mensaje + "\n");
    }

    private void venderTicket() {
        String nombre = campoNombre.getText().trim();
        if (nombre.isEmpty()) {
            log("Error: ingresa un nombre antes de vender.");
            return;
        }
        int asiento = avion.sellTicket(nombre);
        if (asiento == -1) {
            log("No hay asientos disponibles. Avión lleno.");
        } else {
            boolean esPalindromo = avion.isPalindromo(nombre);
            botonesAsiento[asiento].setBackground(esPalindromo ? Color.BLUE : Color.RED);
            log("Boleto vendido a " + nombre + " en asiento " + (asiento + 1)
                    + (esPalindromo ? " (con descuento por palíndromo)" : ""));
        }
        campoNombre.setText("");
    }

    private void cancelarTicket() {
        String nombre = campoNombre.getText().trim();
        boolean cancelado = avion.cancelTicket(nombre);
        if (cancelado) {
            int asiento = avion.searchPassenger(nombre, 0);
            log("Boleto de " + nombre + " cancelado.");
        } else {
            log("No se encontró un pasajero con ese nombre.");
        }
    }

    private void despachar() {
        avion.dispatch();
        for (JButton b : botonesAsiento) {
            b.setBackground(Color.GREEN);
        }
        log("Vuelo despachado. Ingresos totales reiniciados y asientos liberados.");
    }

    private void imprimirPasajeros() {
        log(avion.printPassengers(0));
    }

    private void verIngresos() {
        log("Ingresos totales: " + avion.income(0));
    }

    private void buscarPasajero() {
        String nombre = campoNombre.getText().trim();
        int pos = avion.searchPassenger(nombre, 0);
        if (pos == -1) {
            log(nombre + " no se encuentra en el avión.");
        } else {
            log(nombre + " está en el asiento " + (pos + 1) + ".");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::new);

    }
}
