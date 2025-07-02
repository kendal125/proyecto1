/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main1;

/**
 *
 * @author Kendall Lopéz
 */
public class Socio {
    private String id;// id del socio
    private String nombre;//nombre del socio
    private boolean membresiaActiva;//aqui se verifica si la membresia sigue activa

    public Socio(String id, String nombre, boolean membresiaActiva) {
        this.id = id;
        this.nombre = nombre;
        this.membresiaActiva = membresiaActiva;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMembresiaActiva() {
        return membresiaActiva;
    }

    public void setMembresiaActiva(boolean membresiaActiva) {
        this.membresiaActiva = membresiaActiva;
    }
    
    
}
