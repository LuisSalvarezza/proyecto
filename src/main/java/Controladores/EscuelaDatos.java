/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

/**
 *
 * @author Familia
 */
public class EscuelaDatos 
{
     private Boolean idEscuela;
     private Boolean nombre;
     private Boolean direccion;

    public EscuelaDatos() {
    }

    public EscuelaDatos(Boolean idEscuela, Boolean nombre, Boolean direccion) {
        this.idEscuela = idEscuela;
        this.nombre = nombre;
        this.direccion = direccion;
    }

     
     
     
    public Boolean getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Boolean idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Boolean getNombre() {
        return nombre;
    }

    public void setNombre(Boolean nombre) {
        this.nombre = nombre;
    }

    public Boolean getDireccion() {
        return direccion;
    }

    public void setDireccion(Boolean direccion) {
        this.direccion = direccion;
    }
     
     
}
