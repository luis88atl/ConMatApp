/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author JLUIS
 */
public class AsignaCapitanesConcurso {

    ConexionDb Db = new ConexionDb();
    Statement St = Db.Conecxion();
    String IdConcurso;
    String IdEquipo;
    String IdCapitan;
    public void AsignarCapitan(String IdCurso, String IdEquipo, String IdCapitan) {
        
        this.IdConcurso = IdCurso;
        this.IdEquipo = IdEquipo;
        this.IdCapitan = IdCapitan;

        try {
            Db.insertaDatos("INSERT INTO ConcursosRealizados (Concurso,Equipo,Capitan) VALUES ( "
                    + IdConcurso + ","
                    + this.IdEquipo + ","
                    + this.IdCapitan +")", St);
        } catch (SQLException ex) {
            Logger.getLogger(AsignaCapitanesConcurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
