/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author eluli
 */
public class ProcedimientoAlmacenadoEvaluarRespuestas {
        public void InsertarResultados(int id , int aciertos) throws SQLException{
        System.out.println("estas en store :"+id+aciertos);
        CallableStatement entrada = ConexionDb.getConexion().prepareCall("{call InsertarResultadosConcurso(?,?)}");
        entrada.setInt(1, id);
        entrada.setInt(2, aciertos);
        entrada.execute();
        
    }
 
}
