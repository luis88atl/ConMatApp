/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.*;
import static java.sql.DriverManager.getConnection;
import static java.sql.ResultSet.CONCUR_READ_ONLY;
import static java.sql.ResultSet.TYPE_SCROLL_SENSITIVE;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Administrador
 */
public class ConexionDb {
    public String usuario;
    public String password;
    public String urlconexion;
    
    public Connection cnxion;
    public Statement st;
    
    public ConexionDb(){
        this.usuario = "sa";
        this.password = "sql123";
        this.urlconexion = "jdbc:sqlserver://localhost:1433;databaseName=ConMatAPP";
    }
    
    public Statement Conecxion(){
        try {
            Connection cnxion = getConnection(urlconexion,usuario,password);
            st = cnxion.createStatement(TYPE_SCROLL_SENSITIVE, CONCUR_READ_ONLY);
            return st;
        } catch (SQLException ex) {
            getLogger(ConexionDb.class.getName()).log(SEVERE, null, ex);
            showMessageDialog(null, ex);
        }
        return st;
    }
    
    public ResultSet realizarConsulta(String consulta, Statement st) throws SQLException{        
        ResultSet rs = st.executeQuery(consulta);        
        return rs;
    }
    
    public void insertaDatos (String consulta, Statement st) throws SQLException{
         st.executeUpdate(consulta);
    }
}
