/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Conexao;
import Controle.JBackupController;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Matheus Moura
 */
public class jfrmTelaInicial extends javax.swing.JFrame {

    Conexao con = new Conexao();

    /**
     * Creates new form jfrmTelaInicial
     */
    public jfrmTelaInicial() {
        initComponents();
        con.conectar();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon imagem = new ImageIcon(getClass().getResource("/Imagens/fastflow.png"));
        Image img = imagem.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(img));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("FAST FLOW CREAS - VERSAO 1.0");
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setFocusable(false);
        new javax.swing.ImageIcon(getClass().getResource("/Imagens/fat flow.jpg"));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add_icon-icons.com_74429.png"))); // NOI18N
        jMenu1.setText("CADASTROS");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user_accounts_15362 (1).png"))); // NOI18N
        jMenuItem1.setText("USUARIO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/family256_24779.png"))); // NOI18N
        jMenuItem2.setText("FAMILIA");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/userkdmfemale_person_woman_5920.png"))); // NOI18N
        jMenuItem6.setText("FUNCIONARIO");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/businessregistration_signpen_negocio_inscripcio_2358.png"))); // NOI18N
        jMenu5.setText("REGISTROS");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/user_accounts_15362 (1).png"))); // NOI18N
        jMenuItem7.setText("USUARIOS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/userkdmfemale_person_woman_5920.png"))); // NOI18N
        jMenuItem9.setText("FUNCIONARIOS");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edit_paste_15696.png"))); // NOI18N
        jMenuItem8.setText("PRONTUARIO");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book-bookmark-icon_34486.png"))); // NOI18N
        jMenuItem3.setText("ATENDIMENTOS");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search_book_open_search_locate_6178 (1).png"))); // NOI18N
        jMenu3.setText("CONSULTAS");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/family256_24779.png"))); // NOI18N
        jMenuItem5.setText("FAMILIA");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/book-bookmark-icon_34486.png"))); // NOI18N
        jMenuItem10.setText("ATENDIMENTOS AGENDADOS");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/table_graph_6191.png"))); // NOI18N
        jMenu2.setText("RELATORIOS");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem4.setText("REGISTRO MENSAL DE ATENDIMENTOS");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/securebackup_security_safety_storage_6952.png"))); // NOI18N
        jMenu4.setText("BACKUP");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/shutdown_off_close_exit_15253.png"))); // NOI18N
        jMenuSair.setText("SAIR");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jfrmCadastroUsuario frmCadastroUsuario = new jfrmCadastroUsuario();
        frmCadastroUsuario.setTitle("CADASTRO DE USUARIO - " + System.getProperty("login"));
        frmCadastroUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jfrmCadastroFamilia frmCadastroFamilia = new jfrmCadastroFamilia();
        frmCadastroFamilia.setTitle("CADASTRO DE FAMILIA - " + System.getProperty("login"));
        frmCadastroFamilia.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        jfrmRegistroUsuario frmRegistroUsuario = new jfrmRegistroUsuario();
        frmRegistroUsuario.setTitle("REGISTRO DE USUARIO - " + System.getProperty("login"));
        frmRegistroUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        jfrmRegistroFamilia frmRegistroFamilia = new jfrmRegistroFamilia();
        frmRegistroFamilia.setTitle("REGISTRO DE FAMILIA - " + System.getProperty("login"));
        frmRegistroFamilia.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jfrmCadastroFuncionario frmCadastroFuncionario = new jfrmCadastroFuncionario();
        frmCadastroFuncionario.setTitle("CADASTRO DE FUNCIONARIO - " + System.getProperty("login"));
        frmCadastroFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        jfrmRegistroFuncionario frmRegistroFuncionario = new jfrmRegistroFuncionario();
        frmRegistroFuncionario.setTitle("REGISTRO DE FUNCIONARIO - " + System.getProperty("login"));
        frmRegistroFuncionario.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        frmAtendimentoExpontaneo frmAgendarVisita = new frmAtendimentoExpontaneo();
        frmAgendarVisita.setTitle("AGENDAR VISITA - " + System.getProperty("login"));
        frmAgendarVisita.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        frmConsultaFamilia frmConsultaFamilia = new frmConsultaFamilia();
        frmConsultaFamilia.setTitle("CONSULTA DE FAMILIA - " + System.getProperty("login"));
        frmConsultaFamilia.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        Object[] options = {"SIM", "NAO"};
        int op = JOptionPane.showOptionDialog(null, "         DESEJA SAIR   ", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (op == 0) {
            JOptionPane.showMessageDialog(null, "USUARIO " + System.getProperty("login").toUpperCase() + " DESCONECTADO");
            System.clearProperty("login");
            con.desconecta();
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        frmAtendimentoAgendado frmAtenAgend = new frmAtendimentoAgendado();
        frmAtenAgend.setTitle("CONSULTA DE ATENDIMENTOS - " + System.getProperty("login"));
        frmAtenAgend.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            con.excutaSQL("select * from fastflowcreas.usuario");
            JRResultSetDataSource relat =  new JRResultSetDataSource(con.rs);
            JasperPrint jp = JasperFillManager.fillReport("C:\\Users\\Matheus Moura\\Documents\\teste.jasper", new HashMap(), relat);
            JasperViewer jv = new JasperViewer(jp,false);
            jv.setVisible(true);
            jv.toFront();
            
            /*
            frmRelatorioRMA frmRMA = new frmRelatorioRMA();
            frmRMA.setTitle("REGISTRO MENSAL DE ATENDIMENTOS - " + System.getProperty("login"));
            frmRMA.setVisible(true);*/
        } catch (SQLException ex) {
            Logger.getLogger(jfrmTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(jfrmTelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed

    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        JBackupController jb = new JBackupController();
        jb.executeCommand("fastflowcreas", "123456", "backup");
    }//GEN-LAST:event_jMenu4MouseClicked

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
            java.util.logging.Logger.getLogger(jfrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfrmTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfrmTelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMenuSair;
    // End of variables declaration//GEN-END:variables
}
