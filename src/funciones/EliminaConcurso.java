/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import conmat.AdministradorEquipos;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;

/**
 *
 * @author JLUIS
 */
public class EliminaConcurso {

    ConexionDb db = new ConexionDb();
    Statement st = db.Conecxion();

    public void EliminarConcurso(String Id) {
        try {
            db.insertaDatos("DELETE Concursos WHERE ID = " + Id, st);
        } catch (SQLException ex) {
            getLogger(AdministradorEquipos.class.getName()).log(SEVERE, null, ex);
        }
    }

}
