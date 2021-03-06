/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conmat;

import funciones.BusquedaResultados;
import funciones.Usuario;
import funciones.ConexionDb;
import funciones.MuestraResultados;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Administrador
 */
public class AdministradorResultados extends javax.swing.JFrame {

    public String usuarioactivo;
    public String idusuarioactivo;
    public String textomonitor = "Resultados";
    private FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Imagen", "JPG");
    Object[] NombreColumnas = {
        "ID",
        "CONCURSO",
        "EQUIPO",
        "CAPITAN",
        "ACIERTOS",
        "ERRORES",
        "PROMEDIO",
        "DURACION"
    };

    /**
     * Creates new form Contenedor
     */
    public AdministradorResultados() {
        initComponents();
        this.setLocationRelativeTo(null);
        JlMonitorNombre.setText(textomonitor);
        monitorinformacion.setText(usuarioactivo);
        MuestraResultados Tabla = new MuestraResultados();
        Tabla.Resultados(TablaResultados, NombreColumnas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        JlMonitorNombre = new javax.swing.JLabel();
        BtnUsuarios = new javax.swing.JButton();
        BtnEquipos = new javax.swing.JButton();
        BtnResultados = new javax.swing.JButton();
        BtnConcursos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaResultados = new javax.swing.JTable();
        IdUsuarioAlta = new javax.swing.JLabel();
        ImprimeReporteUsuarios = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BusquedaResultados = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        monitorinformacion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 58, 170, -1));

        JlMonitorNombre.setBackground(new java.awt.Color(255, 255, 255));
        JlMonitorNombre.setFont(new java.awt.Font("Decker", 1, 22)); // NOI18N
        JlMonitorNombre.setForeground(new java.awt.Color(102, 102, 102));
        JlMonitorNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(JlMonitorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 40));

        BtnUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        BtnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        BtnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        BtnUsuarios.setBorder(null);
        BtnUsuarios.setContentAreaFilled(false);
        BtnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnUsuarios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnUsuarios.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnUsuariosMouseClicked(evt);
            }
        });
        jPanel1.add(BtnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        BtnEquipos.setBackground(new java.awt.Color(255, 255, 255));
        BtnEquipos.setForeground(new java.awt.Color(255, 255, 255));
        BtnEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Proveedores.png"))); // NOI18N
        BtnEquipos.setBorder(null);
        BtnEquipos.setContentAreaFilled(false);
        BtnEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEquipos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnEquipos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnEquipos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEquiposMouseClicked(evt);
            }
        });
        jPanel1.add(BtnEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        BtnResultados.setBackground(new java.awt.Color(255, 255, 255));
        BtnResultados.setForeground(new java.awt.Color(255, 255, 255));
        BtnResultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Inventario.png"))); // NOI18N
        BtnResultados.setBorder(null);
        BtnResultados.setContentAreaFilled(false);
        BtnResultados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnResultados.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnResultados.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnResultados.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnResultadosMouseClicked(evt);
            }
        });
        jPanel1.add(BtnResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        BtnConcursos.setBackground(new java.awt.Color(255, 255, 255));
        BtnConcursos.setForeground(new java.awt.Color(255, 255, 255));
        BtnConcursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icono_concurso_100.png"))); // NOI18N
        BtnConcursos.setBorder(null);
        BtnConcursos.setContentAreaFilled(false);
        BtnConcursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnConcursos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnConcursos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnConcursos.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/select.png"))); // NOI18N
        BtnConcursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnConcursosMouseClicked(evt);
            }
        });
        jPanel1.add(BtnConcursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 710));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel2MouseMoved(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        TablaResultados.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        TablaResultados.setForeground(new java.awt.Color(153, 153, 153));
        TablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaResultados);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 930, 490));

        IdUsuarioAlta.setBackground(new java.awt.Color(255, 255, 255));
        IdUsuarioAlta.setFont(new java.awt.Font("Decker", 1, 18)); // NOI18N
        IdUsuarioAlta.setForeground(new java.awt.Color(102, 102, 102));
        IdUsuarioAlta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel2.add(IdUsuarioAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 150, 20));

        ImprimeReporteUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        ImprimeReporteUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Btn_Imprimir.png"))); // NOI18N
        ImprimeReporteUsuarios.setBorder(null);
        ImprimeReporteUsuarios.setBorderPainted(false);
        ImprimeReporteUsuarios.setContentAreaFilled(false);
        ImprimeReporteUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ImprimeReporteUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Btn_Check_Verde.png"))); // NOI18N
        ImprimeReporteUsuarios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Btn_Check_Verde.png"))); // NOI18N
        ImprimeReporteUsuarios.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Btn_Check_Verde.png"))); // NOI18N
        ImprimeReporteUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimeReporteUsuariosActionPerformed(evt);
            }
        });
        jPanel2.add(ImprimeReporteUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_Search_32px.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 30));

        BusquedaResultados.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        BusquedaResultados.setForeground(new java.awt.Color(153, 153, 153));
        BusquedaResultados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BusquedaResultados.setText("Realizar Busqueda");
        BusquedaResultados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        BusquedaResultados.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                BusquedaResultadosFocusLost(evt);
            }
        });
        BusquedaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BusquedaResultadosMouseClicked(evt);
            }
        });
        BusquedaResultados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BusquedaResultadosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BusquedaResultadosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BusquedaResultadosKeyTyped(evt);
            }
        });
        jPanel2.add(BusquedaResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 360, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 1010, 670));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel3MouseMoved(evt);
            }
        });

        monitorinformacion.setBackground(new java.awt.Color(255, 255, 255));
        monitorinformacion.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        monitorinformacion.setForeground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_minimisar_32px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icon_cerrar_32px.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(monitorinformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(monitorinformacion, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1010, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        mandadatos();
    }//GEN-LAST:event_jPanel1MouseMoved

    private void BtnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnUsuariosMouseClicked
        JlMonitorNombre.setText("Usuarios");
        AdministradorResultados pantallausuarios = new AdministradorResultados();
        pantallausuarios.recibeusuario(idusuarioactivo, usuarioactivo);
        pantallausuarios.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnUsuariosMouseClicked

    private void BtnResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnResultadosMouseClicked
        JlMonitorNombre.setText("Inventario");
        AdministradorResultados pantallaresultados = new AdministradorResultados();
        pantallaresultados.recibeusuario(idusuarioactivo, usuarioactivo);
        pantallaresultados.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnResultadosMouseClicked

    private void jPanel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseMoved
        mandadatos();
    }//GEN-LAST:event_jPanel3MouseMoved

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea Cerrar Esta Ventana?", "Salir", dialog);
        if (result == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseMoved
        mandadatos();
    }//GEN-LAST:event_jPanel2MouseMoved

    private void BusquedaResultadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusquedaResultadosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaResultadosKeyTyped

    private void BusquedaResultadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusquedaResultadosKeyReleased
        BusquedaResultados Busqueda = new BusquedaResultados();
        Busqueda.Resultados(BusquedaResultados.getText(), TablaResultados, NombreColumnas);
    }//GEN-LAST:event_BusquedaResultadosKeyReleased

    private void BusquedaResultadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BusquedaResultadosKeyPressed
        BusquedaResultados Busqueda = new BusquedaResultados();
        Busqueda.Resultados(BusquedaResultados.getText(), TablaResultados, NombreColumnas);
    }//GEN-LAST:event_BusquedaResultadosKeyPressed

    private void BusquedaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusquedaResultadosMouseClicked
        BusquedaResultados.setText("");
        BusquedaResultados Busqueda = new BusquedaResultados();
        Busqueda.Resultados(BusquedaResultados.getText(), TablaResultados, NombreColumnas);
    }//GEN-LAST:event_BusquedaResultadosMouseClicked

    private void BusquedaResultadosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BusquedaResultadosFocusLost
        BusquedaResultados.setText("Realizar Busqueda");
    }//GEN-LAST:event_BusquedaResultadosFocusLost

    private void ImprimeReporteUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimeReporteUsuariosActionPerformed
        /**
        * PDFusuarios imprimepdf = new PDFusuarios();
        Date fecha = new Date();
        fecha.getTime();
        imprimepdf.GeneraPDF("REPORTE DE USUARIOS", "ESTE ES EL REPORTE DE USUARIOS", "Guadalajara Jal " + fecha,
            "C:\\Users\\Administrador.LAPTOP-A8U540A4\\Documents\\NetBeansProjects\\OnlineStore\\src\\Imagenes\\logo.png",
            "C:\\Users\\Administrador.LAPTOP-A8U540A4\\Desktop\\Prueba.pdf", null, TablaUsuarios);
        **/
        try {
            ConexionDb cn = new ConexionDb();
            Connection cnsql = DriverManager.getConnection(cn.urlconexion, cn.usuario, cn.password);
            JasperReport reporte;
            String path = (getClass().getResource("../Reportes/ERP-Usuarios.jasper").getPath());
            Map parametros = new HashMap();
            parametros.put("tabla","Usuarios");
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, parametros, cnsql);
            JasperViewer vistareporte = new JasperViewer(jprint, false);
            vistareporte.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            vistareporte.setVisible(true);
        } catch (JRException | SQLException ex) {
            Logger.getLogger(AdministradorResultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ImprimeReporteUsuariosActionPerformed

    private void TablaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaResultadosMouseClicked
        if (evt.getButton() == 1) {
            int id = TablaResultados.getSelectedRow();
            try {
                ResultSet consulta;
                ConexionDb db = new ConexionDb();
                Statement st = db.Conecxion();
                consulta = db.realizarConsulta("SELECT * FROM Consulta_Usuarios WHERE ID = "
                    + TablaResultados.getValueAt(id, 0), st);
                consulta.next();

            } catch (SQLException e) {
            }
        }
    }//GEN-LAST:event_TablaResultadosMouseClicked

    private void BtnEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEquiposMouseClicked
        JlMonitorNombre.setText("Equipos");
        AdministradorEquipos pantallaclientes = new AdministradorEquipos();
        pantallaclientes.recibeusuario(idusuarioactivo, usuarioactivo);
        pantallaclientes.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnEquiposMouseClicked

    private void BtnConcursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnConcursosMouseClicked
        JlMonitorNombre.setText("Concursos");
        AdministradorConcursos pantallaconcursos = new AdministradorConcursos();
        pantallaconcursos.recibeusuario(idusuarioactivo, usuarioactivo);
        pantallaconcursos.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnConcursosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministradorResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorResultados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradorResultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConcursos;
    private javax.swing.JButton BtnEquipos;
    private javax.swing.JButton BtnResultados;
    private javax.swing.JButton BtnUsuarios;
    private javax.swing.JTextField BusquedaResultados;
    private javax.swing.JLabel IdUsuarioAlta;
    private javax.swing.JButton ImprimeReporteUsuarios;
    private javax.swing.JLabel JlMonitorNombre;
    private javax.swing.JTable TablaResultados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel monitorinformacion;
    // End of variables declaration//GEN-END:variables

    public void recibeusuario(String idusuario, String usuario) {
        idusuarioactivo = idusuario;
        usuarioactivo = usuario;
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        String informacion = "Bienvenido " + usuarioactivo + " " + date.format(now) + " " + hour.format(now);
        monitorinformacion.setText(informacion);
    }

    public void mandadatos() {
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
        String informacion = "Bienvenido " + usuarioactivo + " " + date.format(now) + " " + hour.format(now);
        monitorinformacion.setText(informacion);
    }

    private void CargaTabla() {
        try {
            String activo;
            ResultSet consulta;
            ConexionDb db = new ConexionDb();
            Statement st = db.Conecxion();
            consulta = db.realizarConsulta("SELECT ID, USUARIO, CONTRASEÑA = '******'"
                    + ",PERFIL, ACTIVO, ASIGNACION FROM USUARIOS", st);
            DefaultTableModel tabla = new DefaultTableModel(NombreColumnas, WIDTH);
            TablaResultados.setModel(tabla);
            while (consulta.next()) {
                activo = consulta.getString("ACTIVO");
                if ("1".equals(activo)) {
                    activo = "ACTIVO";
                } else {
                    activo = "DESACTIVADO";
                }
                tabla.addRow(new Object[]{consulta.getString("ID"), consulta.getString("USUARIO"), consulta.getString("CONTRASEÑA"),
                    consulta.getString("PERFIL"), consulta.getString("ASIGNACION"), activo});
            }
            tabla.removeRow(0);
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorResultados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
