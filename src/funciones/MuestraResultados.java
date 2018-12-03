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
public class MuestraResultados {

    ConexionDb Db = new ConexionDb();
    Statement St = Db.Conecxion();
    ResultSet Consulta;

    public void Resultados(JTable TablaResultados, Object[] NombreColumnas) {
        try {
            Consulta = Db.realizarConsulta("SELECT * FROM Consulta_resultados ORDER BY ACIERTOS DESC, DURACION ASC", St);

            DefaultTableModel tabla = new DefaultTableModel(NombreColumnas, WIDTH);
            TablaResultados.setModel(tabla);
            while (Consulta.next()) {
                tabla.addRow(new Object[]{Consulta.getString("ID"), Consulta.getString("CONCURSO"), Consulta.getString("EQUIPO"),
                    Consulta.getString("CAPITAN"), Consulta.getString("ACIERTOS"), Consulta.getString("ERRORES"), Consulta.getString("PROMEDIO"), Consulta.getString("DURACION")});
            }
            tabla.removeRow(0);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaConcurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
