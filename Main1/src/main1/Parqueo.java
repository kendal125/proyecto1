/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main1;

import javax.swing.JOptionPane;

/**
 *
 * @author Kendall Lopéz
 */
public class Parqueo {
   // Definimos las dimensiones del parqueo (por ejemplo, 3 filas x 5 columnas para un nivel)
    static final int FILAS = 3;
    static final int COLUMNAS = 5;
    
    // Declaración e inicialización del arreglo bidimensional de objetos Vehiculo
    static Vehiculo[][] parqueo = new Vehiculo[FILAS][COLUMNAS];

    // Este contador no es estrictamente necesario para la visualización de la matriz,
    // pero podría usarse para llevar un total de vehículos si fuera necesario.
    // static int contadorVehiculos = 0; 

    // El método 'main' de esta clase puede ser usado para probarla directamente,
    // o puedes confiar en 'main1' para ser el punto de entrada.
    public static void main(String[] args) {
        // Inicializar todas las posiciones del parqueo como vacías (null)
        // Esto ya lo hace Java por defecto para arreglos de objetos, pero se puede explicitar.
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                parqueo[i][j] = null; // null significa espacio libre
            }
        }

        int opcion;
        do {
            String menu = "Sistema de Parqueo\n"
                        + "1. Ingresar Vehículo\n"
                        + "2. Mostrar Estado del Parqueo\n" // Nuevo nombre de opción
                        + "3. Salir\n"
                        + "Seleccione una opción:";
            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

            switch (opcion) {
                case 1:
                    ingresarVehiculo();
                    break;
                case 2:
                    mostrarEstadoParqueo(); // Llama al nuevo método para mostrar la matriz
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema de parqueo. ¡Hasta pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    // Método para ingresar un nuevo vehículo al parqueo
    public static void ingresarVehiculo() {
        // Se solicita la fila y columna al usuario para estacionar el vehículo
        int fila = -1;
        int columna = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                fila = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la fila (0 a " + (FILAS - 1) + "):"));
                columna = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la columna (0 a " + (COLUMNAS - 1) + "):"));

                if (fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS) {
                    if (parqueo[fila][columna] == null) {
                        entradaValida = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ese espacio (" + fila + "," + columna + ") ya está ocupado. Elija otro.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fila o columna fuera de los límites. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número.");
            }
        }

        JOptionPane.showMessageDialog(null, "Se solicitarán los datos del vehículo para la posición (" + fila + "," + columna + ")");
        String placa = JOptionPane.showInputDialog(null, "Escriba la placa:");
        String marca = JOptionPane.showInputDialog(null, "Escriba la marca:");
        String modelo = JOptionPane.showInputDialog(null, "Escriba el modelo:");

        parqueo[fila][columna] = new Vehiculo(placa, marca, modelo); // Asigna el objeto Vehiculo a la posición
        JOptionPane.showMessageDialog(null, "Vehículo registrado exitosamente en (" + fila + "," + columna + ").");
    }

    // Nuevo método para mostrar el estado actual del parqueo como una matriz
    public static void mostrarEstadoParqueo() {
        String estadoVisual = "Estado del Parqueo (Nivel 1):\n\n";

        // Encabezado de columnas
        estadoVisual += "   ";
        for (int j = 0; j < COLUMNAS; j++) {
            estadoVisual += "C" + j + " ";
        }
        estadoVisual += "\n";

        // Filas y contenido
        for (int i = 0; i < FILAS; i++) {
            estadoVisual += "F" + i + " "; // Etiqueta de fila
            for (int j = 0; j < COLUMNAS; j++) {
                if (parqueo[i][j] == null) {
                    estadoVisual += "[L]"; // 'L' para Libre (disponible)
                } else {
                    estadoVisual += "[O]"; // 'O' para Ocupado
                }
                estadoVisual += " "; // Espacio entre celdas
            }
            estadoVisual += "\n"; // Nueva línea para la siguiente fila
        }
        
        // También puedes añadir una leyenda
        estadoVisual += "\nParqueo: [L] = Libre, [O] = Ocupado\n";

        JOptionPane.showMessageDialog(null, estadoVisual);

        // Opcional: mostrar detalles de vehículos ocupados
        int vehiculosContados = 0;
        String detallesVehiculos = "Detalles de Vehículos Parqueados:\n";
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (parqueo[i][j] != null) {
                    vehiculosContados++;
                    detallesVehiculos += "Posición (" + i + "," + j + "):\n"
                                        + "  Placa: " + parqueo[i][j].getPlaca() + "\n"
                                        + "  Marca: " + parqueo[i][j].getMarca() + "\n"
                                        + "  Modelo: " + parqueo[i][j].getModelo() + "\n\n";
                }
            }
        }
        if (vehiculosContados > 0) {
            JOptionPane.showMessageDialog(null, detallesVehiculos);
        } else {
            JOptionPane.showMessageDialog(null, "No hay vehículos parqueados con detalles para mostrar.");
        }
    }
}