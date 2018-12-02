/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import conmat.AdministradorEquipos;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JLUIS
 */
public class Equipo {

    public void GuardaEquipo(String Equipo, String Universidad, String Capitan) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            db.insertaDatos("INSERT INTO EQUIPOS VALUES("
                    + "'" + Equipo + "',"
                    + Universidad + ","
                    + Capitan + ", NULL)", st);

        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(SEVERE, null, ex);
        }
    }

    public void ModificaEquipo(String Id, String Equipo, String Universidad, String Capitan) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            db.insertaDatos("UPDATE EQUIPOS SET NOMBRE = '" + Equipo + "',"
                    + "UNIVERSIDAD = '" + Universidad + "',"
                    + "CAPITAN = " + Capitan + ", WHERE ID = " + Id, st);


        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(SEVERE, null, ex);
        }
    }

    public int ConsultaCursos(String Id) {
        int Concursos = 0;
        ConexionDb Db = new ConexionDb();
        Statement St = Db.Conecxion();
        try {
            ResultSet Consulta = Db.realizarConsulta("SELECT Concursos = COUNT( *) FROM ConcursosRealizados WHERE Equipo = " + Id, St);
            Consulta.next();
            Concursos = Integer.parseInt(Consulta.getString("Concursos"));
        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Concursos;
    }

    public void EliminaUsuario(String Id) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            db.insertaDatos("DELETE Equipos WHERE ID = " + Id, st);
        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(SEVERE, null, ex);
        }
    }

    public void BusquedaEquipo(String text, JTable TablaEquipos, Object[] NombreColumnas) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            ResultSet consulta = db.realizarConsulta("SELECT ID, NOMBRE, UNIVERSIDAD, CAPITAN FROM Consulta_Equipo WHERE "
                    + "ID LIKE '%" + text + "%' OR "
                    + "NOMBRE LIKE '%" + text + "%' OR "
                    + "UNIVERSIDAD LIKE '%" + text + "%' OR "
                    + "CAPITAN LIKE '%" + text + "%'", st);

            DefaultTableModel tabla = new DefaultTableModel(NombreColumnas, WIDTH);
            TablaEquipos.setModel(tabla);
            while (consulta.next()) {
                tabla.addRow(new Object[]{consulta.getString("ID"), consulta.getString("NOMBRE"), consulta.getString("UNIVERSIDAD"),
                    consulta.getString("CAPITAN")});
            }
            tabla.removeRow(0);
        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(SEVERE, null, ex);
        }
    }

    public String ConsultaUniversidad(String Universidad) {
        String IdUniversidad = null;
        ConexionDb Db = new ConexionDb();
        Statement St = Db.Conecxion();
        try {
            ResultSet Consulta = Db.realizarConsulta("SELECT * FROM UNIVERSIDADES WHERE Universidad = '" + Universidad + "'", St);
            Consulta.next();
            IdUniversidad = Consulta.getString("Id");
        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IdUniversidad;
    }

    public String ConsultaCapitan(String Capitan) {
        String IdCapitan = null;
        ConexionDb Db = new ConexionDb();
        Statement St = Db.Conecxion();
        try {
            ResultSet Consulta = Db.realizarConsulta("SELECT * FROM USUARIOS WHERE Asignacion = '" + Capitan + "'", St);
            Consulta.next();
            IdCapitan = Consulta.getString("Id");
        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IdCapitan;
    }

}
