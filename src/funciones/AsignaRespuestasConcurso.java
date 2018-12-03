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

/**
 *
 * @author JLUIS
 */
public class AsignaRespuestasConcurso {

    ConexionDb Db = new ConexionDb();
    Statement St = Db.Conecxion();
    String IdConcurso;
    String R1;
    String R2;
    String R3;
    String R4;
    String R5;
    String R6;
    String R7;
    String R8;
    String R9;
    String R10;

    public void AsignarRespuestasCorrectas(String IdConcurso, String R1, String R2, String R3, String R4,
            String R5, String R6, String R7, String R8, String R9, String R10) {
        
        this.IdConcurso = IdConcurso;
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
        this.R4 = R4;
        this.R5 = R5;
        this.R6 = R6;
        this.R7 = R7;
        this.R8 = R8;
        this.R9 = R9;
        this.R10 = R10;
        
        try {
            Db.insertaDatos("INSERT INTO Respuestas VALUES ("
                    + this.IdConcurso + ","
                    + "'" + this.R1 + "',"
                    + "'" + this.R2 + "',"
                    + "'" + this.R3 + "',"
                    + "'" + this.R4 + "',"
                    + "'" + this.R5 + "',"
                    + "'" + this.R6 + "',"
                    + "'" + this.R7 + "',"
                    + "'" + this.R8 + "',"
                    + "'" + this.R9 + "',"
                    + "'" + this.R10 + "')", St);
        } catch (SQLException ex) {
            Logger.getLogger(AsignaRespuestasConcurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
