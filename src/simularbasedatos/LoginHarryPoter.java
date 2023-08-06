package simularbasedatos;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Yan
 */
public class LoginHarryPoter extends javax.swing.JFrame {

    //Declara e instanciar un HashMap que simulará una base de datos 
    public static HashMap<String, String[]> usuarios = new HashMap<String, String[]>();
    String[] usuario;   //Guarda los datos del usuario correspondiente
    boolean usuarioEncontrado;
    
    public LoginHarryPoter() {
        initComponents();
        
        cargarUsuarios();   
                
    }

    //Se llenan los datos de los usuarios a través de arrays y se accederán a ellos con un string que su ID
    private static void cargarUsuarios(){
        usuarios.put("HarryP", new String[]{"HarryP123","Harry Potter","harry.jpg"});
        usuarios.put("HermioneG", new String[]{"HermioneG123", "Hermione Granger","hermione.jpeg"});
        usuarios.put("RonW", new String[]{"RonW123","Ron Weasley", "ron.jpg"});
        usuarios.put("DracoM", new String[]{"DracoM123","Draco Malfoy", "draco.jpg"});
        usuarios.put("MinervaM", new String[]{"MinervaM123","Minerva McGonagall", "mcgonagall.jpg" });
        usuarios.put("CedricD", new String[]{"CedricD123", "Cedric Diggory", "cedric.png" });
        usuarios.put("ChoC", new String[]{"ChoC123", "Cho Chang", "cho.jpg" });
        usuarios.put("SeverusS", new String[]{"SeverusS123", "Severus Snape", "snape.jpg"});
        usuarios.put("RubeusH", new String[]{"RubeusH123", "Rubeus Hagrid", "hagrid.png"});
        usuarios.put("NevilleL", new String[]{"NevilleL123", "Neville Longbottom","neville.jpg" });
        usuarios.put("LunaL", new String[]{"LunaL123", "Luna Lovegood", "luna.jpg"});
        usuarios.put("GinnyW", new String[]{"GinnyW123", "Ginny Weasley", "ginny.jpg"});
        usuarios.put("RemusL", new String[]{"RemusL123", "Remus Lupin", "lupin.jpg" });
        usuarios.put("ArthurW", new String[]{"Arthur123", "Arthur Weasley", "arthur.jpg" });
        usuarios.put("BellatrixL", new String[]{"BellatrixL123", "Bellatrix Lestrange", "arthur.jpg"});
        usuarios.put("LordV", new String[]{"LordV123","Lord Voldemort" ,"voldemort.jpg"});
    }

    //Método busca y verifica al usuario si existe, coloca en un label el resultado y modifica 
    //la variable "usuarioEncontrado"
    public void buscarUsuario(String idUsuario){
        
        this.usuario = usuarios.get(idUsuario); 
        if(usuario==null){
            lblValidarUsuario.setText("Usuario no encontrado");
            usuarioEncontrado = false;
        }else{
            lblValidarUsuario.setText("Usuario encontrado");
            usuarioEncontrado = true;
        } 
    }
    
    //Se valida el password, primero verificando que el usuario ha sido encontrado en un if
    //y de ser asi se compara la entrada en el jPassword con la contraseña en el array
    //y regresa un true si concide o false si no
    public boolean validarPassword(String usuario[]){
        if(!usuarioEncontrado){
            return false;
        }
        return (String.valueOf(jPasswordFieldContraseña.getPassword()).equals(usuario[0]));       
    }
    
    //Método para mostrar la imagen del usuario en un JDialog y darle la bienvenida
    public void mostrarUsuarioDialog(String[] idUsuario){
        String imgUser = idUsuario[2];
        String codeHtml = "<html><img src='https://ik.imagekit.io/hpapi/"+imgUser+"' width='125' height='125'></html>";
        JOptionPane.showMessageDialog(null, codeHtml, "¡Bienvenido "+idUsuario[1]+"!", JOptionPane.INFORMATION_MESSAGE);

    }
    
    //Método que muestra los datos del usuario en consola
    public void mostrarUsuarioConsola(String[] idUsuario){
        System.out.println("Hola "+idUsuario[1] );
        
        System.out.println("Tu IdUsuario: "+txtFieldIdUsuario.getText());

        System.out.println("Tu Contrasenia: "+idUsuario[0] );   
    }
    
    
    //Se valida o no login, dependiendo del método validarPassword. Se llaman los metodos
    //mostrarUsuarioDialog y mostrarUsuarioConsola. O se envia una mensaje de que la contraseña es incorrecta
    public void loginUsuario(){
        if( validarPassword(usuario) ){
            mostrarUsuarioDialog(usuario);
            mostrarUsuarioConsola(usuario);
        }else{
            JOptionPane.showMessageDialog(null,"Contraseña incorrecta, pruebe de nuevo");
        }
    }
 
    //Método simula el cerrado de sesion, el cual muestra un mensaje de esto, y reseetea 
    //el panel login
    public void cerrarSesion(){
        txtFieldIdUsuario.setText("Ingrese su ID Usuario");
        jPasswordFieldContraseña.setText("************");
        lblValidarUsuario.setText("");
        JOptionPane.showMessageDialog(null, "Se ha cerrado sesion", "", JOptionPane.WARNING_MESSAGE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        panelIniciarSesion = new javax.swing.JPanel();
        lblIniciarSesion = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        lbl_IdUsuario = new javax.swing.JLabel();
        txtFieldIdUsuario = new javax.swing.JTextField();
        lblContraseña = new javax.swing.JLabel();
        jPasswordFieldContraseña = new javax.swing.JPasswordField();
        lblValidarUsuario = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondo.setBackground(new java.awt.Color(0, 51, 51));

        panelIniciarSesion.setBackground(new java.awt.Color(204, 255, 204));
        panelIniciarSesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));

        lblIniciarSesion.setFont(new java.awt.Font("Lucida Fax", 1, 20)); // NOI18N
        lblIniciarSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIniciarSesion.setText("¡Inicia Sesión!");
        lblIniciarSesion.setToolTipText("");

        btnAceptar.setBackground(new java.awt.Color(0, 0, 0));
        btnAceptar.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAceptar.setBorderPainted(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });

        lbl_IdUsuario.setFont(new java.awt.Font("Lucida Fax", 1, 15)); // NOI18N
        lbl_IdUsuario.setText("IdUsuario");

        txtFieldIdUsuario.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        txtFieldIdUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtFieldIdUsuario.setText("Ingrese su ID Usuario");
        txtFieldIdUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFieldIdUsuario.setCaretColor(new java.awt.Color(204, 204, 204));
        txtFieldIdUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFieldIdUsuarioFocusLost(evt);
            }
        });
        txtFieldIdUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldIdUsuarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtFieldIdUsuarioMouseExited(evt);
            }
        });

        lblContraseña.setFont(new java.awt.Font("Lucida Fax", 1, 15)); // NOI18N
        lblContraseña.setText("Contraseña");

        jPasswordFieldContraseña.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jPasswordFieldContraseña.setForeground(new java.awt.Color(204, 204, 204));
        jPasswordFieldContraseña.setText("************");
        jPasswordFieldContraseña.setToolTipText("");
        jPasswordFieldContraseña.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPasswordFieldContraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPasswordFieldContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordFieldContraseñaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPasswordFieldContraseñaMouseExited(evt);
            }
        });

        lblValidarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblValidarUsuario.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setBorderPainted(false);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Static/hogwarts.png"))); // NOI18N

        javax.swing.GroupLayout panelIniciarSesionLayout = new javax.swing.GroupLayout(panelIniciarSesion);
        panelIniciarSesion.setLayout(panelIniciarSesionLayout);
        panelIniciarSesionLayout.setHorizontalGroup(
            panelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIniciarSesionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarSesionLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFieldIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelIniciarSesionLayout.createSequentialGroup()
                                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(97, 97, 97))
                    .addGroup(panelIniciarSesionLayout.createSequentialGroup()
                        .addGroup(panelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContraseña)
                            .addGroup(panelIniciarSesionLayout.createSequentialGroup()
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblValidarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_IdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelIniciarSesionLayout.setVerticalGroup(
            panelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelIniciarSesionLayout.createSequentialGroup()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_IdUsuario)
                .addGap(12, 12, 12)
                .addComponent(txtFieldIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblValidarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelIniciarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(panelIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(panelIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Métodos para cambiar de color de los astediscos del JPassword
    private void jPasswordFieldContraseñaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldContraseñaMouseExited
        if (String.valueOf(jPasswordFieldContraseña.getPassword()).equals("************") ||
            String.valueOf(jPasswordFieldContraseña.getPassword()).isEmpty()){
            jPasswordFieldContraseña.setText("************");
            jPasswordFieldContraseña.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jPasswordFieldContraseñaMouseExited

    private void jPasswordFieldContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordFieldContraseñaMouseClicked
        if (String.valueOf(jPasswordFieldContraseña.getPassword()).equals("************")){
            jPasswordFieldContraseña.setText("");
            jPasswordFieldContraseña.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jPasswordFieldContraseñaMouseClicked
    
    //Métodos para cambiar de color cuando se ingresa texto txtEdit de IdUsuario
    private void txtFieldIdUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldIdUsuarioMouseExited
        if (txtFieldIdUsuario.getText().equals("Ingrese su ID Usuario") ||
            txtFieldIdUsuario.getText().isEmpty()){
            txtFieldIdUsuario.setText("Ingrese su ID Usuario");
            txtFieldIdUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtFieldIdUsuarioMouseExited

    private void txtFieldIdUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldIdUsuarioMouseClicked
        if (txtFieldIdUsuario.getText().equals("Ingrese su ID Usuario")){
            txtFieldIdUsuario.setText("");
            txtFieldIdUsuario.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtFieldIdUsuarioMouseClicked
    
    //Métodos para cambiar de color el boton aceptar cuando se pasa el cursor sobre el
    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setBackground(Color.BLACK);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_btnAceptarMouseEntered

    //Al hacer click en el botón aceptar se llama el método login 
    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        if(usuarioEncontrado){
            loginUsuario();
        }else{
            JOptionPane.showMessageDialog(null,"Porfavor ingrese un usuario valido");
            }
    }//GEN-LAST:event_btnAceptarMouseClicked

    //Se llama el método buscarUsuario cuando el textEdit del nombre de usuario pierde el foco
    private void txtFieldIdUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFieldIdUsuarioFocusLost
        buscarUsuario(txtFieldIdUsuario.getText());
    }//GEN-LAST:event_txtFieldIdUsuarioFocusLost

    //Se llama al método cerrarSesion al dar click en el botón cancelar
    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        cerrarSesion();
    }//GEN-LAST:event_btnCancelarMouseClicked
    
    //Métodos para cambiar de color el boton "cancelar" cuando se pasa el cursor sobre el
    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setBackground(Color.BLACK);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed


    
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
            java.util.logging.Logger.getLogger(LoginHarryPoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginHarryPoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginHarryPoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginHarryPoter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginHarryPoter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPasswordField jPasswordFieldContraseña;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblIniciarSesion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblValidarUsuario;
    private javax.swing.JLabel lbl_IdUsuario;
    private javax.swing.JPanel panelIniciarSesion;
    private javax.swing.JTextField txtFieldIdUsuario;
    // End of variables declaration//GEN-END:variables


   
}
