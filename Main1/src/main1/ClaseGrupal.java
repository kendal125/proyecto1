/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main1;

/**
 *
 * @author Kendall Lopéz
 */
public class ClaseGrupal {
    private String nombre;
    private String horario;
    private int capacidad;
    private int inscritos;

    public ClaseGrupal(String nombre, String horario, int capacidad) {
        this.nombre = nombre;
        this.horario = horario;
        this.capacidad = capacidad;
        this.inscritos = 0;
    }

    public boolean reservar() {
        if (inscritos < capacidad) {
            inscritos++;
            return true;
        }
        return false;
    }

    public String getInfo() {
        return nombre + " - " + horario + " - Cupos: " + inscritos + "/" + capacidad;
    }
}

