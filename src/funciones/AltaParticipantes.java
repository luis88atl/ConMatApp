/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eluli
 */
public class AltaParticipantes {
      public void guardarDatosParticipante(String instruccionSql) throws SQLException{
        
        
        funciones.ConexionDb db = new ConexionDb();
        Statement st = db.Conecxion();
        db.insertaDatos(instruccionSql, st);
    
   
}
    
}
