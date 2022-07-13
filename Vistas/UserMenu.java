/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class UserMenu extends javax.swing.JFrame {
    //1. Instancia de la clase conexion
    Conexion conexion = new Conexion();
    Connection connection;
    //2. La libreria Statement permite ejecutar los query SQL
    Statement st;
    ResultSet rs;
    //3. Creamos una instaacia de la tabla de la interfaz
    DefaultTableModel contenidoTablaEmpleados;
    

    public UserMenu() {
        initComponents();
        setLocationRelativeTo(null);
        listarEmpleados();
    }

    //4. Metodo que trae todos los empleados existentes en la base de datos
    private void listarEmpleados(){
        String nombre = txtBuscarEmp.getText();
        if (nombre.isEmpty()) {
            String queryConsulta = "SELECT * FROM empleados";
        try{
            connection = conexion.getConnection();
            //Creamos el queryConsulta
            st = connection.createStatement();
            // Ejecutamos el query que contiene la variable queryConsulta
            rs = st.executeQuery(queryConsulta);
            //Creamos un objeto que alamacene todos los registros de empleado
            Object[] empleados = new Object [6];
            //7. Actualizar la propiedad Model de la tabla
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            //Mientras el resultado del queryConsulta encuentre registros en la
            //base de datos ingresa al while
            while(rs.next()){
                empleados[0] = rs.getInt("idEmp");
                empleados[1] = rs.getString("nombreEmp");
                empleados[2] = rs.getString("apellidos");
                empleados[3] = rs.getString("tipoDocumento");
                empleados[4] = rs.getString("documento");
                empleados[5] = rs.getString("correo");
                //9. Creamos una fila dentro de la tabla por cada empleado de la consulta
                // el query
                contenidoTablaEmpleados.addRow(empleados);
                System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1]
                        + ", apellidos: " + empleados[2] + ", documento " + empleados[3] + " " + empleados[4]+ " correo: "
                        + empleados[5]);
                tblEmpleados.setModel(contenidoTablaEmpleados);
            }
            
        }catch(SQLException e){
            System.out.println("Error");
        }
    } else {
            String queryConsulta = "SELECT * FROM empleados WHERE nombreEmp LIKE '%" + nombre + "%' OR apellidos LIKE '%" + nombre + "%';";
            try{
            connection = conexion.getConnection();
            //Creamos el queryConsulta
            st = connection.createStatement();
            // Ejecutamos el query que contiene la variable queryConsulta
            rs = st.executeQuery(queryConsulta);
            //Creamos un objeto que alamacene todos los registros de empleado
            Object[] empleados = new Object [6];
            //7. Actualizar la propiedad Model de la tabla
            contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
            //Mientras el resultado del queryConsulta encuentre registros en la
            //base de datos ingresa al while
            while(rs.next()){
                empleados[0] = rs.getInt("idEmp");
                empleados[1] = rs.getString("nombreEmp");
                empleados[2] = rs.getString("apellidos");
                empleados[3] = rs.getString("tipoDocumento");
                empleados[4] = rs.getString("documento");
                empleados[5] = rs.getString("correo");
                //9. Creamos una fila dentro de la tabla por cada empleado de la consulta
                // el query
                contenidoTablaEmpleados.addRow(empleados);
                System.out.println("id: " + empleados[0] + ", nombre: " + empleados[1]
                        + ", apellidos: " + empleados[2] + ", documento " + empleados[3] + " " + empleados[4]+ " correo: "
                        + empleados[5]);
                tblEmpleados.setModel(contenidoTablaEmpleados);
            }
            
        }catch(SQLException e){
            System.out.println("Error");
        }
        }   
        }
        
    
    //Cuando añado un nuevo empleado el proceso background es el siguiente
    //1. Se almacena el nuevo empleado en la base de datos
    //2. Se eliminan los datos que tiene la tabla tblEmpleados
    //3. Se llama el metodo listarEmpleados para consultar nuevamente la bd
    //4. Se cargan los empleados en la tabla incluyendo el recien creado
    
    private void borrarDatosTabla(){
        //El metodo getRowCount devuelve la cantidad de registros existentes
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            contenidoTablaEmpleados.removeRow(i);
            i -= 1;
        }
    }
    
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAddUser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscarEmp = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane2.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Home", jPanel1);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido(s)", "Tipo de documento", "Documento", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("INFORMACION EMPLEADO");

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/NewUser (2).png"))); // NOI18N
        btnAddUser.setText("Crear empleado");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/logo2.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Buscar");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assest/showUser.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddUser)
                .addGap(45, 45, 45))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddUser)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        jTabbedPane2.addTab("Empleado", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        // Creamos una instancia del dialogo
        AddUserForm addUserF = new AddUserForm(this, true);
        addUserF.setVisible(true);
        borrarDatosTabla();
        listarEmpleados();
        
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        //1.Capturar el numero de fila seleccionada 
        int row = tblEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada " + row);
        //2. Validar si el usuario no ha seleccionado una fila 
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado", "",JOptionPane.WARNING_MESSAGE);
      }else {
            //Indicamos de la fila del empleado (id, nombre, tipo doc,doc,correo)
            //fila 0 columna 0 = id
            int id = Integer.parseInt(tblEmpleados.getValueAt(row, 0).toString());
            //Tener en cuenta que los datos de la tabla estan en tipo Object
            //fila 0 columna 1 = nombre empleado
            String nombre = (String) tblEmpleados.getValueAt(row, 1);
            String apellidos = (String) tblEmpleados.getValueAt(row, 2);
            String tipoDocumento = (String) tblEmpleados.getValueAt(row, 3);
            String documento = (String) tblEmpleados.getValueAt(row, 4);
            String correo = (String) tblEmpleados.getValueAt(row, 5);
            System.out.println("Id: " + id + ", empleado: " + nombre + " "
            + apellidos + ", tipo documento: " + tipoDocumento + ",  numero: "
            + documento + ", correo: " + correo);
            //4. Instanciamos el JDialog para mostrar la informacion del empleado seleccionado
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            showUserForm.recibeDatos(id, nombre, apellidos, tipoDocumento, documento, correo);
            showUserForm.setVisible(true);
            //5. Actualizamos la informacion de la tabla en caso de que hubiese editado el empleado
            borrarDatosTabla();
            listarEmpleados();
            
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
       borrarDatosTabla();
       listarEmpleados();
    }//GEN-LAST:event_btnSearchActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscarEmp;
    // End of variables declaration//GEN-END:variables
}
