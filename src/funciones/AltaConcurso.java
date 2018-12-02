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
public class AltaConcurso {

    ConexionDb db = new ConexionDb();
    Statement st = db.Conecxion();
    int HoraInicio;
    int HoraFinal;
    int Estatus;
    String Concurso;
    String HoraInicioTxt;
    String HoraFinalTxt;

    public void NuevoConcurso(String Concurso, String HoraInicio, String AmPmInicio, String HoraFinal, String AmPmFinal, int Estatus) {

        ConexionDb db = new ConexionDb();
        Statement st = db.Conecxion();
        this.Concurso = Concurso;
        this.Estatus = Estatus;

        if (HoraInicio.substring(1, 2).equals(":")) {
            this.HoraInicio = Integer.parseInt(HoraInicio.substring(0, 1));
        } else {
            this.HoraInicio = Integer.parseInt(HoraInicio.substring(0, 2));
        }

        if (HoraFinal.substring(1, 2).equals(":")) {
            this.HoraFinal = Integer.parseInt(HoraFinal.substring(0, 1));
        } else {
            this.HoraFinal = Integer.parseInt(HoraFinal.substring(0, 2));
        }

        if (AmPmInicio.equals("pm")) {
            this.HoraInicio = this.HoraInicio + 12;
        }

        HoraInicioTxt = Integer.toString(this.HoraInicio) + ":00";

        if (AmPmFinal.equals("pm")) {
            this.HoraFinal = this.HoraFinal + 12;
        }

        HoraFinalTxt = Integer.toString(this.HoraFinal) + ":00";

        try {
            db.insertaDatos("INSERT INTO Concursos VALUES ("
                    + "'" + this.Concurso + "',"
                    + this.Estatus + ","
                    + "CAST('" + HoraInicioTxt + "' AS TIME),"
                    + "CAST('" + HoraFinalTxt + "' AS TIME), GETDATE())", st);
        } catch (SQLException ex) {
            Logger.getLogger(AltaConcurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}