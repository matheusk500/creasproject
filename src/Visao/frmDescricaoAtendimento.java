/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Conexao;
import Controle.ControleFamilia;
import Modelo.ModeloFamilia;
import java.sql.Timestamp;

/**
 *
 * @author Matheus Moura
 */
public class frmDescricaoAtendimento extends javax.swing.JFrame {
    private Conexao con = new Conexao();
    /**
     * Creates new form frmDescricaoAtendimento
     */
    public frmDescricaoAtendimento() {
        initComponents();
    }

    public frmDescricaoAtendimento(String cod, String data, String usuario, String tipo, String descricao, String situacao) {
        initComponents();
        con.conectar();
        jTextFieldCOD.setText(cod);
        jTextField5.setText(data);
        jTextField2.setText(usuario);
        jComboBoxTipoAtendimento.setSelectedItem(tipo);
        jTextArea1.setText(descricao);
        jTextField4.setText(situacao);
        if (situacao.equals("PENDENTE")) {
            jButton1.setEnabled(true);
            jButton3.setEnabled(true);
            jTextArea1.setEnabled(true);
            jTextArea1.setEditable(true);
            jComboBoxTipoAtendimento.setEnabled(true);
        } else {
            jButton1.setEnabled(false);
            jButton3.setEnabled(false);
            jTextArea1.setEnabled(false);
            jTextArea1.setEditable(false);
            jComboBoxTipoAtendimento.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField4 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextFieldCOD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBoxTipoAtendimento = new javax.swing.JComboBox<>();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DESCRICA DE ATENDIMENTO");
        setResizable(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(15);
        jTextArea1.setTabSize(15);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("DESCRICAO"));
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField4.setEditable(false);
        jTextField4.setText("jTextField1");
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder("SITUACAO"));
        jTextField4.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField4.setOpaque(false);

        jTextField2.setEditable(false);
        jTextField2.setText("jTextField2");
        jTextField2.setBorder(javax.swing.BorderFactory.createTitledBorder("USUARIO ATENDIDO"));
        jTextField2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField2.setOpaque(false);

        jTextField5.setEditable(false);
        jTextField5.setText("jTextField1");
        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA DO ATENDIMENTO"));
        jTextField5.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField5.setOpaque(false);

        jTextFieldCOD.setEditable(false);
        jTextFieldCOD.setText("jTextField1");
        jTextFieldCOD.setBorder(javax.swing.BorderFactory.createTitledBorder("CODIGO"));
        jTextFieldCOD.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldCOD.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1486504366-check-clipboard-select-list-success-ok-tasks_81314.png"))); // NOI18N
        jButton1.setToolTipText("REALIZAR ATENDIMENTO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ic_cancel_128_28318.png"))); // NOI18N
        jButton3.setToolTipText("REALIZAR ATENDIMENTO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBoxTipoAtendimento.setBackground(new java.awt.Color(240, 240, 240));
        jComboBoxTipoAtendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "01 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO", "02 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA O SCFV", "03 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA O CRAS", "04 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA OS SERVICOS DO SUS", "05 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA O CAPS", "06 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA O CONSELHO TUTELAR", "07 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA A DEFENSORIA PUBLICA", "08 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA O MINISTERIO PUBLICO", "09 - ATENDIMENTO SOCIOASSISTENCIAL INDIVIDUALIZADO E ENCAMINHAMENTO PARA A DELEGACIA", "10 - ATENDIMENTO EM ATIVIDADE COLETIVA DE CARATER CONTINUADO", "11 - PARTICIPACAO EM ATIVIDADE COLETIVA DE CARATER NAO CONTINUADO", "12 - CADASTRAMENTO/ATUALIZACAO CADASTRAL", "13 - ACOMPANHAMENTO DE MSE", "14 - SOLICITACAO/CONCESSAO DE BENEFÍCIO EVENTUAL", "15 - VISITA DOMICILIAR", "99 - OUTROS" }));
        jComboBoxTipoAtendimento.setBorder(javax.swing.BorderFactory.createTitledBorder("TIPO DE ATENDIMENTO"));
        jComboBoxTipoAtendimento.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldCOD, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField2)
                    .addComponent(jComboBoxTipoAtendimento, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCOD, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxTipoAtendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(855, 344));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        con.conectar();
        ModeloFamilia modFamilia = new ModeloFamilia();
        modFamilia.setSituacao_atendimento("REALIZADO");
        String textoAnterior = jTextArea1.getText().toUpperCase();
        modFamilia.setDescricao_tendimento(textoAnterior);
        modFamilia.setTipo_atendimento(String.valueOf(jComboBoxTipoAtendimento.getSelectedItem()));
        modFamilia.setUltimo_registro(getDataSistema());
        modFamilia.setId_atendimento(Integer.parseInt(jTextFieldCOD.getText()));
        
        jTextArea1.setText(textoAnterior);
        jTextField4.setText("REALIZADO");
        
        ControleFamilia controlFamilia = new ControleFamilia();
        controlFamilia.AtualizarSituacaoAtendimento(modFamilia);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        con.conectar();
        ModeloFamilia modFamilia = new ModeloFamilia();
        modFamilia.setSituacao_atendimento("CANCELADO");
        String textoAnterior = jTextArea1.getText().toUpperCase();
        modFamilia.setUltimo_registro(getDataSistema());
        modFamilia.setId_atendimento(Integer.parseInt(jTextFieldCOD.getText()));
        
        jTextArea1.setText(textoAnterior);
        jTextField4.setText("CANCELADO");
        
        ControleFamilia controlFamilia = new ControleFamilia();
        controlFamilia.AtualizarSituacaoAtendimento(modFamilia);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    private String getDataSistema() {
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        return "" + dataDeHoje + " - " + System.getProperty("login");
    }
    

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
            java.util.logging.Logger.getLogger(frmDescricaoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDescricaoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDescricaoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDescricaoAtendimento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDescricaoAtendimento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxTipoAtendimento;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldCOD;
    // End of variables declaration//GEN-END:variables
}
