/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import conmat.CapitanContenedorFinal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eluli
 */
public class EliminarParticipantes {
    ResultSet consulta;
    int val;
    public void eliminar (int idParticipante){
                    
            try {
                ConexionDb db = new ConexionDb();
                Statement st = db.Conecxion();
                db.insertaDatos("delete  from Participantes where id = "
                        + idParticipante, st);
                
            } catch (SQLException ex) {
                Logger.getLogger(CapitanContenedorFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
