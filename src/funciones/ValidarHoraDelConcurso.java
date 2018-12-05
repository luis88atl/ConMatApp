/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eluli
 */
public class ValidarHoraDelConcurso {

    int status = 0;

    public int statusConcurso(String nombreConcurso) {
        String concursoEnTiempo = null;
        try {
            ResultSet consulta;
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();

            consulta = db.realizarConsulta("select concurso from Concursos where "
                    + "Concurso = '" + nombreConcurso + "' and HoraInicio < (SELECT Convert(varchar(7),GetDate(), 108)) and HoraFinal >(SELECT Convert(varchar(7),GetDate(), 108))", st);
            while (consulta.next()) {
                concursoEnTiempo = consulta.getString(1);
                System.out.println(concursoEnTiempo + "con en tiempo");

            }

        } catch (SQLException e) {
            System.out.println(" exeption concursoentiempo <");
        }
        System.out.println("fuera catch" + concursoEnTiempo);

        if (concursoEnTiempo == null) {
            System.out.println("el concurso " + nombreConcurso+ " no esta en tiempo");
            
        } else {
            System.out.println("si esta en tiempo");
            status=1;
        }

        return status;
    }
}
