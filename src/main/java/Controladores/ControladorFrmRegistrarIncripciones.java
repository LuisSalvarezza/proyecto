/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Validaciones;
import Entidades.Aspirante;
import Entidades.Categoria;
import Entidades.Competencia;
import Entidades.Escuela;
import Repositorios.DAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Familia
 */
public class ControladorFrmRegistrarIncripciones {

    DAO _dao;

    public ControladorFrmRegistrarIncripciones(DAO dao) {
        this._dao = dao;
    }

    public ControladorFrmRegistrarIncripciones() {
        _dao = new DAO();
    }

    public DefaultTableModel ListarEscuelas(EscuelaDatos escuelaDatos) {
        DefaultTableModel datos = new DefaultTableModel();

        if (escuelaDatos == null) {
            escuelaDatos = new EscuelaDatos();
            escuelaDatos.setNombre(Boolean.TRUE);
            escuelaDatos.setDireccion(Boolean.TRUE);
        }

        if (escuelaDatos.getIdEscuela() == true) {
            datos.addColumn("Identificador");
        }

        if (escuelaDatos.getNombre() == true) {
            datos.addColumn("Nombre");
        }

        if (escuelaDatos.getDireccion() == true) {
            datos.addColumn("Dirección");
        }

        List<Escuela> lista = _dao.ListarEscuelas();

        if (lista != null && lista.size() > 0) {

            for (Escuela escuela : lista) {
                datos.addRow(CargarEscuelas(escuela, escuelaDatos));
            }

            return datos;

        } else {
            return null;

        }

    }

    private String[] CargarEscuelas(Escuela elemento, EscuelaDatos datos) {
        Integer numeroColumas = 0;

        if (datos.getIdEscuela() == true) {
            numeroColumas += 1;
        }

        if (datos.getNombre() == true) {
            numeroColumas += 1;
        }

        if (datos.getDireccion() == true) {
            numeroColumas += 1;
        }

        String[] dato = new String[numeroColumas];

        Integer posicion = 0;

        if (datos.getIdEscuela() == true) {
            dato[posicion] = elemento.getIdEscuela().toString();
            posicion += 1;
        }

        if (datos.getNombre() == true) {
            dato[posicion] = elemento.getNombre();
            posicion += 1;
        }

        if (datos.getDireccion() == true) {
            dato[posicion] = elemento.getDireccion();
        }

        return dato;

    }

    public DefaultListModel ListarCategorias() {
        DefaultListModel datos = new DefaultListModel();

        List<Categoria> lista = _dao.ListarCategorias();

        if (lista != null && lista.size() > 0) {

            for (Categoria categoria : lista) {
                datos.addElement(categoria.getNombre());
            }

            return datos;

        } else {
            return null;

        }

    }

    public DefaultTableModel ListarCompetencias() {
        DefaultTableModel datos = new DefaultTableModel();

        datos.addColumn("Selección");
        datos.addColumn("Nombre");

        
        
        List<Competencia> lista = _dao.ListarCompetencias();

        if (lista != null && lista.size() > 0) {

            for (Competencia competencia : lista) {

                Object[] filas = new Object[2];
                filas[0] = false;
                filas[1] = competencia.getNombre();

                datos.addRow(filas);
            }

            return datos;

        } else {
            return null;

        }

    }

    public Escuela ObtenerEscuelaPorNombre(String nombreEscuela) {
        return _dao.ObtenerEscuelaPorNombre(nombreEscuela);

    }

    public Categoria ObtenerCategoria(Integer id) {
        return _dao.ObtenerCategoria(id);

    }

    public Aspirante ValidarEntidad(String nombre, String apellido, String direccion,
            String dia, String mes, String año, char sexo, String dni) {
        Aspirante entidad = new Aspirante();
        try {

            String validacion = "";
            Integer idCategoria = 0;
            Integer edad = 0;
            String fechaNacimineto = "";

            if (Validaciones.validarInt(año) && Validaciones.validarInt(mes) && Validaciones.validarInt(dia)) {
                Integer dayOfMonth = Integer.parseInt(dia);
                Integer month = Integer.parseInt(mes);
                Integer year = Integer.parseInt(año);

                if ((dayOfMonth <= 31) && (month <= 12) && (year >= 1900 && (year <= 2050))) {

                    Calendar calendar = Calendar.getInstance();
                    calendar.setLenient(false);
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month - 1); // [0,...,11]
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                    Date date = calendar.getTime();
                    Date fehchaActual = new Date();

                    int diasDiferencia = (int) ((fehchaActual.getTime() - date.getTime()) / 86400000);

                    edad = diasDiferencia / 365;

                    if (edad <= 8 && sexo == 'F') {
                        idCategoria = 1;
                    } else if (edad > 8 && sexo == 'F') {
                        idCategoria = 3;
                    } else if (edad <= 8 && sexo == 'M') {
                        idCategoria = 2;
                    } else {
                        idCategoria = 4;
                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    fechaNacimineto = sdf.format(date);

                    entidad.setEdad(fechaNacimineto);
                    entidad.setEd(edad);
                } else {
                    validacion += "Hay un error en la numeracion de la fecha controlar .\n";
                }

            } else {
                validacion += "los datos de la fecha no son correctos recuerde que el"
                        + " formato es dd para los dias, mm para el mes y aaaa para el año .\n";

            }

            if (Validaciones.IsNull_Empty(nombre)) {
                validacion += "El nombre no puede ser nulo.\n";
            } else {
                if (nombre.length() > 70) {
                    validacion += "El nombre ingresado es muy grande, supero los 70 caracteres.\n";
                } else {

                    entidad.setNombre(nombre);
                }

            }

            if (Validaciones.IsNull_Empty(apellido)) {
                validacion += "El apellido no puede ser nulo.\n";
            } else {
                if (apellido.length() > 50) {
                    validacion += "El apellido ingresado es muy grande, supero los 50 caracteres.\n";
                } else {
                    entidad.setApellido(apellido);
                }

            }

            if (!Validaciones.IsNull_Empty(direccion)) {
                if (direccion.length() > 120) {
                    validacion += "La dirección ingresada es muy grande supera los 120 caracteres.\n";
                } else {
                    entidad.setDireccion(apellido);
                }
            }

            if (!Validaciones.validarInt(dni)) {
                validacion += "El formato del dni es numerico sin puntos.\n";

            } else {
                if (!(dni.length() >= 7 && dni.length() <= 9)) {
                    validacion += "la cantidad de numeros no parece correcta.\n";
                } else {
                    entidad.setDni(edad);
                }

            }

            if (Validaciones.IsNull_Empty(validacion)) {
                entidad.setSexo(sexo);

                if (idCategoria > 0) {
                    Categoria cat = ObtenerCategoria(idCategoria);
                    if (cat != null) {
                        entidad.setCategoria(cat);
                    }

                }

            } else {
                entidad.setMsj(validacion);

            }

            return entidad;

        } catch (Exception e) {

            entidad.setMsj(e.getMessage());

            return entidad;
        }

    }

    public Boolean AgregarAspirante(Aspirante entidad) {

        return _dao.NuevoAspirante(entidad);

    }
    
    
    public void OcultarIdJTable(JTable jt)
    {
        jt.getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getColumnModel().getColumn(0).setMinWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jt.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
    
    
    }

    public DefaultTableModel ListarAspirantesPorEscuela(Escuela escuelita) {

        DefaultTableModel datos = new DefaultTableModel();

        try {
            List<Aspirante> lista = _dao.ListarAspirantesPorEscuela(escuelita.getIdEscuela());

            datos.addColumn("Id");
            datos.addColumn("Nombre");
            datos.addColumn("Apellido");

            if (lista != null && lista.size() > 0) {
                for (Aspirante aspirante : lista) {
                    String[] row = new String[3];
                    row[0] = aspirante.getIdAspirante().toString();
                    row[1] = aspirante.getNombre();
                    row[2] = aspirante.getApellido();

                    datos.addRow(row);

                }

            }

            return datos;

        } catch (Exception e) {

            return null;
        }

    }

    public Competencia ObtenerCompetenciaPorNombre(String nombre) {
        
        return _dao.ObtenerCompetenciaPorNombre(nombre);

    }

    public Aspirante ObtenerAspirante(Integer idAspirante) {
        return _dao.ObtenerAspirante(idAspirante);
    }

}
