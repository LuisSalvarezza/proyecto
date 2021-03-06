package Entidades;
// Generated 28-feb-2019 17:26:11 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Inscripcion generated by hbm2java
 */
public class Inscripcion  implements java.io.Serializable {


     private InscripcionId id;
     private Aspirante aspirante;
     private Competencia competencia;
     private Date fechaInscripcion;
     private Character estado;

    public Inscripcion() {
    }

	
    public Inscripcion(InscripcionId id, Aspirante aspirante, Competencia competencia, Date fechaInscripcion) {
        this.id = id;
        this.aspirante = aspirante;
        this.competencia = competencia;
        this.fechaInscripcion = fechaInscripcion;
    }
    public Inscripcion(InscripcionId id, Aspirante aspirante, Competencia competencia, Date fechaInscripcion, Character estado) {
       this.id = id;
       this.aspirante = aspirante;
       this.competencia = competencia;
       this.fechaInscripcion = fechaInscripcion;
       this.estado = estado;
    }
   
    public InscripcionId getId() {
        return this.id;
    }
    
    public void setId(InscripcionId id) {
        this.id = id;
    }
    public Aspirante getAspirante() {
        return this.aspirante;
    }
    
    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }
    public Competencia getCompetencia() {
        return this.competencia;
    }
    
    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }
    public Date getFechaInscripcion() {
        return this.fechaInscripcion;
    }
    
    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }




}


