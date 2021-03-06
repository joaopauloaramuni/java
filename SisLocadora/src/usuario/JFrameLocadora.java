/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JFrameLocadora.java
 *
 * Created on 26/10/2011, 22:54:06
 */
package usuario;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author JP
 */
public class JFrameLocadora extends javax.swing.JFrame {

    /** Creates new form JFrameLocadora */
    public JFrameLocadora() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon icone = new ImageIcon(getClass().getResource("recursos/switchuser.png"));
        setIconImage(icone.getImage());
        setVisible(true);
        Thread horario = new Thread(new Runnable() {

            public void run() {
                while (true) {
                    jLabelhora.setText(new SimpleDateFormat("HH:mm:ss").format(new GregorianCalendar().getTime()));
                    try {
                        Thread.sleep(1000); // Interromper por 1000 milisegundos
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        horario.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonClientes = new javax.swing.JButton();
        jButtonFilmes = new javax.swing.JButton();
        jButtonLocacao = new javax.swing.JButton();
        jButton3D = new javax.swing.JButton();
        jLabelClientes = new javax.swing.JLabel();
        jLabelFilmes = new javax.swing.JLabel();
        jLabelLocacao = new javax.swing.JLabel();
        jLabel3D = new javax.swing.JLabel();
        jLabelhora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArquivo = new javax.swing.JMenu();
        jMenuItemFechar = new javax.swing.JMenuItem();
        jMenuTemas = new javax.swing.JMenu();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Locadora LTDA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(233, 233, 247));

        jButtonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario/recursos/User-Clients-icon.png"))); // NOI18N
        jButtonClientes.setFocusPainted(false);
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonFilmes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario/recursos/Movies-icon.png"))); // NOI18N
        jButtonFilmes.setFocusPainted(false);
        jButtonFilmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFilmesActionPerformed(evt);
            }
        });

        jButtonLocacao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario/recursos/Film-Maker-Male-Light-icon.png"))); // NOI18N
        jButtonLocacao.setFocusPainted(false);
        jButtonLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLocacaoActionPerformed(evt);
            }
        });

        jButton3D.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario/recursos/3D-Penguins-icon.png"))); // NOI18N
        jButton3D.setFocusPainted(false);
        jButton3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3DActionPerformed(evt);
            }
        });

        jLabelClientes.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelClientes.setForeground(new java.awt.Color(153, 153, 153));
        jLabelClientes.setText("Clientes");

        jLabelFilmes.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelFilmes.setForeground(new java.awt.Color(153, 153, 153));
        jLabelFilmes.setText("Filmes");

        jLabelLocacao.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabelLocacao.setForeground(new java.awt.Color(153, 153, 153));
        jLabelLocacao.setText("Loca��o");

        jLabel3D.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3D.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3D.setText("3D");

        jLabelhora.setFont(new java.awt.Font("Comic Sans MS", 1, 12));
        jLabelhora.setForeground(new java.awt.Color(204, 204, 204));
        jLabelhora.setText("Hora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFilmes, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3D, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabelClientes)
                .addGap(115, 115, 115)
                .addComponent(jLabelFilmes)
                .addGap(116, 116, 116)
                .addComponent(jLabelLocacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jLabel3D)
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(615, Short.MAX_VALUE)
                .addComponent(jLabelhora)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonClientes)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton3D, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonLocacao)
                        .addComponent(jButtonFilmes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClientes)
                    .addComponent(jLabelFilmes)
                    .addComponent(jLabelLocacao)
                    .addComponent(jLabel3D))
                .addGap(8, 8, 8)
                .addComponent(jLabelhora))
        );

        jMenuArquivo.setText("Arquivo");

        jMenuItemFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario/recursos/button_cancel.png"))); // NOI18N
        jMenuItemFechar.setText("Fechar");
        jMenuItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharActionPerformed(evt);
            }
        });
        jMenuArquivo.add(jMenuItemFechar);

        jMenuBar1.add(jMenuArquivo);

        jMenuTemas.setText("Temas");
        jMenuBar1.add(jMenuTemas);

        jMenuAjuda.setText("Ajuda");

        jMenuItemSobre.setText("Sobre o aplicativo...");
        jMenuItemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSobreActionPerformed(evt);
            }
        });
        jMenuAjuda.add(jMenuItemSobre);

        jMenuBar1.add(jMenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        utilitarios.UsarSustance.substanceLtpUtil(jMenuTemas);
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSobreActionPerformed
        new jDialogSobre(this, true);
}//GEN-LAST:event_jMenuItemSobreActionPerformed

    private void jMenuItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharActionPerformed
        fechar();
}//GEN-LAST:event_jMenuItemFecharActionPerformed

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        JFrameClientes JF_Clientes = new JFrameClientes();
        JF_Clientes.setVisible(true);
        this.dispose();
}//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonFilmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFilmesActionPerformed
        JFrameFilmes JF_Filmes = new JFrameFilmes();
        JF_Filmes.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonFilmesActionPerformed

    private void jButtonLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLocacaoActionPerformed
        JFrameLocar JF_Locar = new JFrameLocar();
        JF_Locar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonLocacaoActionPerformed

    private void jButton3DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3DActionPerformed
        JFrame3D JF_3D = new JFrame3D(this, true);
        JF_3D.setVisible(true);
    }//GEN-LAST:event_jButton3DActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3D;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonFilmes;
    private javax.swing.JButton jButtonLocacao;
    private javax.swing.JLabel jLabel3D;
    private javax.swing.JLabel jLabelClientes;
    private javax.swing.JLabel jLabelFilmes;
    private javax.swing.JLabel jLabelLocacao;
    private javax.swing.JLabel jLabelhora;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenu jMenuArquivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemFechar;
    private javax.swing.JMenuItem jMenuItemSobre;
    private javax.swing.JMenu jMenuTemas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    private void fechar() {
        if (JOptionPane.showConfirmDialog(
                this,
                "Confirma a sa�da?",
                "Locadora",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                bdlocadora.BDLocadora.fecharConexao();
                dispose();
                System.exit(0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                System.exit(1);
            }

        }
    }
}
