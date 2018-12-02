/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JLUIS
 */
public class BuscaConcurso {

    public void BusquedaConcurso(String text, JTable TablaEquipos, Object[] NombreColumnas) {
        ConexionDb db = new ConexionDb();
        Statement st = db.Conecxion();
        ResultSet consulta;
        try {
            consulta = db.realizarConsulta("SELECT * FROM Consulta_Concursos WHERE "
                    + "Id LIKE '%" + text + "%' OR "
                    + "Concurso LIKE '%" + text + "%'", st);

            DefaultTableModel tabla = new DefaultTableModel(NombreColumnas, WIDTH);
            TablaEquipos.setModel(tabla);
            while (consulta.next()) {
                tabla.addRow(new Object[]{consulta.getString("Id"), consulta.getString("Concurso"), consulta.getString("Estatus"),
                    consulta.getString("HoraInicio"), consulta.getString("HoraFinal")});
            }
            tabla.removeRow(0);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaConcurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
