/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import conmat.AdministradorUsuarios;
import static java.awt.image.ImageObserver.WIDTH;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JTable;
import static javax.swing.JTable.PrintMode.NORMAL;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class Usuario {

    public void GuardaUsuario(String Usuario, String Contrasena, String Perfil, String Activado,
            String Asignacion) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            db.insertaDatos("INSERT INTO USUARIOS VALUES("
                    + "'" + Usuario + "',"
                    + "'" + Contrasena + "',"
                    + Perfil + ","
                    + Activado + ","
                    + "GETDATE(),"
                    + "'" + Asignacion + "', NULL,NULL)" , st);

        } catch (SQLException ex) {
            getLogger(AdministradorUsuarios.class.getName()).log(SEVERE, null, ex);
        }
    }

    public void ModificaUsuario(String Id, String Usuario, String Contrasena, String Perfil, String Activado, String Asignacion) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            db.insertaDatos("UPDATE USUARIOS SET USUARIO = '" + Usuario + "',"
                    + "CONTRASEÑA = '" + Contrasena + "',"
                    + "perfil = " + Perfil + ","
                    + "ACTIVO = " + Activado +  " WHERE ID = " + Id, st);


        } catch (SQLException ex) {
            getLogger(AdministradorUsuarios.class.getName()).log(SEVERE, null, ex);
        }
    }

    public void EliminaUsuario(String Id) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            db.insertaDatos("DELETE USUARIOS WHERE ID = " + Id, st);
        } catch (SQLException ex) {
            getLogger(Usuario.class.getName()).log(SEVERE, null, ex);
        }
    }

    void ImprimeReporteUsuario(JTable Tabla) {
        try {

            MessageFormat encabezado = new MessageFormat("REPORTE DE USUARIOS");
            MessageFormat piepagina = new MessageFormat("Aqui se puede imprimir la fecha");
            Tabla.print(NORMAL, encabezado, piepagina);
        } catch (PrinterException e) {
            getLogger(AdministradorUsuarios.class.getName()).log(SEVERE, null, e);
        }
    }

    public void SinContrasena(String id, String Usuario, String Perfil, String Activado, String Asignacion) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            db.insertaDatos("UPDATE USUARIOS SET USUARIO = '" + Usuario + "',"
                    + "perfil = " + Perfil + ","
                    + "ACTIVO = " + Activado + " WHERE ID = " + id, st);


        } catch (SQLException ex) {
            getLogger(AdministradorUsuarios.class.getName()).log(SEVERE, null, ex);
        }
    }

    public void BusquedaUsuario(String text, JTable TablaUsuarios, Object[] NombreColumnas) {
        try {
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            ResultSet consulta = db.realizarConsulta("SELECT ID, USUARIO, CONTRASEÑA = '*****', PERFIL, ASIGNACION, ACTIVO FROM USUARIOS WHERE "
                    + "ID LIKE '%" + text + "%' OR "
                    + "USUARIO LIKE '%" + text + "%' OR "
                    + "PERFIL LIKE '%" + text + "%' OR "
                    + "ACTIVO LIKE '%" + text + "%' OR "
                    + "ASIGNACION LIKE '%" + text + "%'", st);

            DefaultTableModel tabla = new DefaultTableModel(NombreColumnas, WIDTH);
            TablaUsuarios.setModel(tabla);
            while (consulta.next()) {
                String activo = consulta.getString("ACTIVO");
                if ("1".equals(activo)) {
                    activo = "ACTIVO";
                } else {
                    activo = "DESACTIVADO";
                }
                tabla.addRow(new Object[]{consulta.getString("ID"), consulta.getString("USUARIO"), consulta.getString("CONTRASEÑA"),
                    consulta.getString("PERFIL"), consulta.getString("ASIGNACION"), activo});
            }
            tabla.removeRow(0);
        } catch (SQLException ex) {
            getLogger(AdministradorUsuarios.class.getName()).log(SEVERE, null, ex);
        }
    }

    public String ConsultaPerfil(String Perfil) {
        String IdPerfil = null;
        ConexionDb Db = new ConexionDb();
        Statement St = Db.Conecxion();
        try {
            ResultSet Consulta = Db.realizarConsulta("SELECT * FROM Perfiles WHERE Perfil = '" + Perfil + "'", St);
            Consulta.next();
            IdPerfil = Consulta.getString("Id");
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IdPerfil;
    }

}
