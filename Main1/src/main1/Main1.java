/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main1;

import javax.swing.JOptionPane;

/**
 *
 * @author Kendall Lopéz
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          // Opcional: inicializar el parqueo si ParqueoApp.main() no se llama primero
        // Aunque ParqueoApp.parqueo ya es estático y se inicializa al cargar la clase.
        // Si quieres que el menú de inicialización de ParqueoApp se ejecute,
        // podrías llamar a ParqueoApp.main(args); aquí o copiar la lógica de inicialización.
        // Para este ejemplo, asumimos que ParqueoApp ya está configurado.

        int opcion;
        do {
            String menu = "Sistema de Parqueo (controlado desde main1)\n"
                        + "1. Ingresar Vehículo\n"
                        + "2. Mostrar Estado del Parqueo\n" // Coincide con la opción en ParqueoApp
                        + "3. Salir\n"
                        + "Seleccione una opción:";
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (opcion) {
                case 1:
                    // Llama al método de la clase ParqueoApp para ingresar un vehículo
                    Parqueo.ingresarVehiculo(); 
                    break;
                case 2:
                    // Llama al nuevo método de la clase ParqueoApp para mostrar la matriz del parqueo
                    Parqueo.mostrarEstadoParqueo(); 
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema de parqueo. ¡Hasta pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }
}