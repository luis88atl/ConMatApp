/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import conmat.AdministradorConcursos;

/**
 *
 * @author JLUIS
 */
public class ListaAsignarConcurso {
    
    AdministradorConcursos Asignar = new AdministradorConcursos();
    ConexionDb Db = new ConexionDb();
    Statement St = Db.Conecxion();
    ResultSet Consulta;
    

    public void MuestraParticipantes() {

    }
    
    
}
