/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Entidades.Escuela;
import Formularios.frmInicio;
import Repositorios.DAO;
import java.util.List;

/**
 *
 * @author Familia
 */
public class Inicio 
{
    public static void main(String[] args) 
    {
        frmInicio inicio = new frmInicio();
        inicio.setVisible(true);
        
        
        // Prueba de Hibernate
       /* DAO dao = new DAO();
        List<Escuela> lista = dao.ListarEscuelas();
        
        for (Escuela escuela : lista) {
            System.out.println("Nombre :"+escuela.getNombre());
        }
        */
    }
}
