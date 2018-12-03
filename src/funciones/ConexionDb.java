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
import javax.swing.JOptionPane;
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
    
    static Connection contacto = null;
    public static String usuarioS="sa";
    public static String passwordS="sql123";
    public static boolean status = false;
    
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
    
    public static Connection getConexion() {
        status=false;
        
        String url = "jdbc:sqlserver://LAPTOP-RAABRTCN:1433;databaseName=ConMatAPP";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "no se pudo establecer conección revisar driver" + e.getMessage(),
                    "error de conexión", JOptionPane.ERROR_MESSAGE);
        }

        try {
            contacto = DriverManager.getConnection(url,ConexionDb.usuarioS ,ConexionDb.passwordS);
            status=true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage(),
                    "error de conexión", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    public ResultSet realizarConsulta(String consulta, Statement st) throws SQLException{        
        ResultSet rs = st.executeQuery(consulta);        
        return rs;
    }
    
    public void insertaDatos (String consulta, Statement st) throws SQLException{
         st.executeUpdate(consulta);
    }
}
