package com.kevintx;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JTable;

import java.util.ArrayList;

public class App {
    // INICIO declarar elementos para dentro del evento
    public static JTextField cajaDeTexto;
    public static JTable tabla;
    public static ArrayList<String> listaDePendientes = new ArrayList<>(); // -> []  ->   ["LAvar", "Cocinar", "hacerr ejercico"]

    // public static JButton boton;
    // INICIO declarar elementos

    public static void main(String[] args) {

        // INICIO construir ventana
        JFrame ventana = new JFrame("Notas/Apuntes");
        

        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.pack();

        // FIN construir ventana

        // INICIO Definir ancho y alto
        ventana.setSize(300, 350);
        // FIN Definir ancho y alto

        // INICIO Agregar layout a la ventana
        ventana.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        // FIN Agregar layout a la ventana

        // INICIO inicializar elementos del contenido de la ventana

        cajaDeTexto = new JTextField(20);
        JButton boton = new JButton("Agregar");
        tabla = new JTable();
        // FIN inicializar elementos del contenido de la ventana

        // INICIO Agregar elementos como contenido de ventana
        ventana.getContentPane().add(cajaDeTexto);
        ventana.getContentPane().add(boton);
        ventana.getContentPane().add(tabla);
        // FIN Agregar componentes como contenido de ventana

        // hacer accciones
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Limpiar la caja de texto luego de insertar valor de la caja en una lista

                listaDePendientes.add(cajaDeTexto.getText()); // recuperando valor de caja a la lista

                cajaDeTexto.setText(null); // limpiando  caja

                String matriz[][] = new String[listaDePendientes.size()][1]; // definir el tamaño de la matriz

                for (int i = 0; i < listaDePendientes.size(); i++) {
                    // recuperar el valor de la lista de pendientes y asignar a la matriz en la misma posicion
                    matriz[i][0] = listaDePendientes.get(i);
                }

                // reconstruyendo la tabla con valores de la lista de pendientes
                tabla.setModel(new javax.swing.table.DefaultTableModel(matriz, new String[] { "#" }));
            }
        });

        ventana.setVisible(true);

    }

}
