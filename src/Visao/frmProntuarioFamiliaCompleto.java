/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.Conexao;
import Controle.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Matheus Moura
 */
public class frmProntuarioFamiliaCompleto extends javax.swing.JFrame {
    Conexao con = new Conexao();
    /**
     * Creates new form frmProntuarioFamiliaCompleto
     */
    public frmProntuarioFamiliaCompleto() {
        con.conectar();
        initComponents();
    }
    public frmProntuarioFamiliaCompleto(int id_familia) {
        initComponents();
        con.conectar();
        try {
            preencherTabelaUsuarioVinculado("select * from fastflowcreas.familia_usuario, fastflowcreas.usuario where fastflowcreas.familia_usuario.id_usuario = fastflowcreas.usuario.id_usuario and fastflowcreas.familia_usuario.id_familia = " + id_familia + " order by parentesco");
            preencherTabelaDeficiencia("SELECT * FROM fastflowcreas.usuario_deficiencia, fastflowcreas.usuario, fastflowcreas.familia_usuario where fastflowcreas.usuario_deficiencia.id_usuario = fastflowcreas.usuario.id_usuario and fastflowcreas.familia_usuario.id_usuario = fastflowcreas.usuario.id_usuario and fastflowcreas.familia_usuario.id_familia = "+id_familia+" order by parentesco");
            preencherTabelaEducacao("SELECT * FROM fastflowcreas.usuario, fastflowcreas.familia_usuario where fastflowcreas.usuario.id_usuario = fastflowcreas.familia_usuario.id_usuario and fastflowcreas.familia_usuario.id_familia = "+id_familia+" order by parentesco");
            preencherTabelaHabitacao("select * from fastflowcreas.familia where id_familia = "+id_familia);
            preencherTabelaTrabalho("select * from fastflowcreas.usuario, fastflowcreas.familia_usuario where fastflowcreas.usuario.id_usuario = fastflowcreas.familia_usuario.id_usuario and fastflowcreas.familia_usuario.id_familia = "+id_familia+" order by parentesco");
            preencherTabelaBeneficio("select * from fastflowcreas.familia_beneficio where id_familia = "+id_familia);
            preencherTabelaRelato("SELECT * FROM fastflowcreas.usuario_relato, fastflowcreas.usuario, fastflowcreas.familia_usuario where fastflowcreas.usuario_relato.id_usuario = fastflowcreas.usuario.id_usuario and fastflowcreas.familia_usuario.id_usuario = fastflowcreas.usuario.id_usuario and fastflowcreas.familia_usuario.id_familia = "+id_familia+" order by parentesco");
            preencherTabelaServico("select * from fastflowcreas.familia_servico where id_familia = "+id_familia);
            preencherTabelaAtendimentos("select * from fastflowcreas.familia_acompanhamento, fastflowcreas.familia_atendimento, fastflowcreas.usuario where fastflowcreas.familia_acompanhamento.id_familia_acompanhamento = fastflowcreas.familia_atendimento.id_familia_acompanhamento and fastflowcreas.familia_atendimento.id_usuario = fastflowcreas.usuario.id_usuario and fastflowcreas.familia_acompanhamento.id_familia = "+id_familia);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }        
    }
    public void preencherTabelaUsuarioVinculado(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"NOME", "USUARIO","PARENTESCO", "CPF", "RG", "NIS"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getInt("id_usuario"), con.rs.getString("nome_usuario"), con.rs.getString("parentesco"), con.rs.getString("cpf"), con.rs.getString("rg"), con.rs.getString("nis")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "USUARIO NAO ENCONTRADO");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableUsuarioVinculados.setModel(modelo);
        jTableUsuarioVinculados.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTableUsuarioVinculados.getColumnModel().getColumn(0).setResizable(true);
        jTableUsuarioVinculados.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableUsuarioVinculados.getColumnModel().getColumn(1).setResizable(true);
        jTableUsuarioVinculados.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableUsuarioVinculados.getColumnModel().getColumn(2).setResizable(true);
        jTableUsuarioVinculados.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTableUsuarioVinculados.getColumnModel().getColumn(3).setResizable(true);
        jTableUsuarioVinculados.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTableUsuarioVinculados.getColumnModel().getColumn(4).setResizable(true);
        jTableUsuarioVinculados.getColumnModel().getColumn(5).setPreferredWidth(135);
        jTableUsuarioVinculados.getColumnModel().getColumn(5).setResizable(true);
        jTableUsuarioVinculados.getTableHeader().setReorderingAllowed(false);
        jTableUsuarioVinculados.setAutoResizeMode(jTableUsuarioVinculados.AUTO_RESIZE_ALL_COLUMNS);
        jTableUsuarioVinculados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    public void preencherTabelaDeficiencia(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"USUARIO", "DEFICIENCIA", "CUIDADOR"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getString("nome_usuario"), con.rs.getString("nome_deficiencia"), con.rs.getString("cuidador")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableDeficiencia.setModel(modelo);
        jTableDeficiencia.getColumnModel().getColumn(0).setPreferredWidth(350);
        jTableDeficiencia.getColumnModel().getColumn(0).setResizable(true);
        jTableDeficiencia.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableDeficiencia.getColumnModel().getColumn(1).setResizable(true);
        jTableDeficiencia.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTableDeficiencia.getColumnModel().getColumn(2).setResizable(true);
        jTableDeficiencia.getTableHeader().setReorderingAllowed(false);
        jTableDeficiencia.setAutoResizeMode(jTableDeficiencia.AUTO_RESIZE_ALL_COLUMNS);
        jTableDeficiencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    public void preencherTabelaEducacao(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"USUARIO", "SABE LER?", "FREQUENTA ESCOLA?", "ESCOLARIDADE"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getString("nome_usuario"), con.rs.getString("sabe_ler"), con.rs.getString("frequenta_escola"), con.rs.getString("escolaridade")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableEducacao.setModel(modelo);
        jTableEducacao.getColumnModel().getColumn(0).setPreferredWidth(350);
        jTableEducacao.getColumnModel().getColumn(0).setResizable(true);
        jTableEducacao.getColumnModel().getColumn(1).setPreferredWidth(140);
        jTableEducacao.getColumnModel().getColumn(1).setResizable(true);
        jTableEducacao.getColumnModel().getColumn(2).setPreferredWidth(160);
        jTableEducacao.getColumnModel().getColumn(2).setResizable(true);
        jTableEducacao.getColumnModel().getColumn(3).setPreferredWidth(240);
        jTableEducacao.getColumnModel().getColumn(3).setResizable(true);
        jTableEducacao.getTableHeader().setReorderingAllowed(false);
        jTableEducacao.setAutoResizeMode(jTableEducacao.AUTO_RESIZE_ALL_COLUMNS);
        jTableEducacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    public void preencherTabelaHabitacao(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ESPECIFICIDADE", "TIPO DE RESIDENTENCIA", "MATERIAL DA RESIDENCIA", "ACESSO A ENERGIA?", "AGUA CANALIZADA?", "TIPO DE ABASTECIMENTO", "POUSSI COLETA DE LIXO?", "ZONA DE RISCO?", "DIFICIL ACESSO?", "PRESENCA DE VIOLENCIA?"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getString("especificidade"), con.rs.getString("tipo_residencia"), con.rs.getString("material_parede"), con.rs.getString("acesso_energia"), con.rs.getString("agua_canalizada"), con.rs.getString("abastecimento_agua"), con.rs.getString("coleta_lixo"), con.rs.getString("zona_risco"), con.rs.getString("dificil_acesso"), con.rs.getString("presenca_violencia")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableHabitacao.setModel(modelo);
        jTableHabitacao.getColumnModel().getColumn(0).setPreferredWidth(350);
        jTableHabitacao.getColumnModel().getColumn(0).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTableHabitacao.getColumnModel().getColumn(1).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(2).setPreferredWidth(260);
        jTableHabitacao.getColumnModel().getColumn(2).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(3).setPreferredWidth(180);
        jTableHabitacao.getColumnModel().getColumn(3).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(4).setPreferredWidth(180);
        jTableHabitacao.getColumnModel().getColumn(4).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(5).setPreferredWidth(210);
        jTableHabitacao.getColumnModel().getColumn(5).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(6).setPreferredWidth(180);
        jTableHabitacao.getColumnModel().getColumn(6).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(7).setPreferredWidth(150);
        jTableHabitacao.getColumnModel().getColumn(7).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(8).setPreferredWidth(150);
        jTableHabitacao.getColumnModel().getColumn(8).setResizable(true);
        jTableHabitacao.getColumnModel().getColumn(9).setPreferredWidth(180);
        jTableHabitacao.getColumnModel().getColumn(9).setResizable(true);
        jTableHabitacao.getTableHeader().setReorderingAllowed(true);
        jTableHabitacao.setAutoResizeMode(jTableHabitacao.AUTO_RESIZE_ALL_COLUMNS);
        jTableHabitacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableHabitacao.getToolTipText();
        
    }
    public void preencherTabelaTrabalho(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"USUARIO", "POSSUI CTPS?", "CONDICAO DE OCUPACAO", "RENDA MENSAL"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getString("nome_usuario"), con.rs.getString("possui_ctps"), con.rs.getString("condicao_ocupacao"), con.rs.getString("renda_mensal")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableTrabalho.setModel(modelo);
        jTableTrabalho.getColumnModel().getColumn(0).setPreferredWidth(350);
        jTableTrabalho.getColumnModel().getColumn(0).setResizable(true);
        jTableTrabalho.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableTrabalho.getColumnModel().getColumn(1).setResizable(true);
        jTableTrabalho.getColumnModel().getColumn(2).setPreferredWidth(310);
        jTableTrabalho.getColumnModel().getColumn(2).setResizable(true);
        jTableTrabalho.getColumnModel().getColumn(3).setPreferredWidth(140);
        jTableTrabalho.getColumnModel().getColumn(3).setResizable(true);
        jTableTrabalho.getTableHeader().setReorderingAllowed(false);
        jTableTrabalho.setAutoResizeMode(jTableTrabalho.AUTO_RESIZE_ALL_COLUMNS);
        jTableTrabalho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preencherTabelaBeneficio(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"BENEFICIO", "DATA DE RECEBIMENTO"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getString("beneficio"), con.rs.getString("data_recebimento")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableBeneficio.setModel(modelo);
        jTableBeneficio.getColumnModel().getColumn(0).setPreferredWidth(700);
        jTableBeneficio.getColumnModel().getColumn(0).setResizable(false);
        jTableBeneficio.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTableBeneficio.getColumnModel().getColumn(1).setResizable(false);
        jTableBeneficio.getTableHeader().setReorderingAllowed(false);
        jTableBeneficio.setAutoResizeMode(jTableBeneficio.AUTO_RESIZE_ALL_COLUMNS);
        jTableBeneficio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    public void preencherTabelaRelato(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"USUARIO", "RELATO", "DESCRICAO", "PERSISTE?", "REGISTRO"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getString("nome_usuario"), con.rs.getString("relato"), con.rs.getString("descricao"), con.rs.getString("situacao_persiste"), con.rs.getString("data_relato")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SEM RELATOS CADASTRADOS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableRelatos.setModel(modelo);
        jTableRelatos.getColumnModel().getColumn(0).setPreferredWidth(350);
        jTableRelatos.getColumnModel().getColumn(0).setResizable(false);
        jTableRelatos.getColumnModel().getColumn(1).setPreferredWidth(300);
        jTableRelatos.getColumnModel().getColumn(1).setResizable(false);
        jTableRelatos.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTableRelatos.getColumnModel().getColumn(2).setResizable(false);
        jTableRelatos.getColumnModel().getColumn(3).setPreferredWidth(95);
        jTableRelatos.getColumnModel().getColumn(3).setResizable(false);
        jTableRelatos.getColumnModel().getColumn(4).setPreferredWidth(95);
        jTableRelatos.getColumnModel().getColumn(4).setResizable(false);
        jTableRelatos.getTableHeader().setReorderingAllowed(false);
        jTableRelatos.setAutoResizeMode(jTableRelatos.AUTO_RESIZE_ALL_COLUMNS);
        jTableRelatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void preencherTabelaServico(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"SERVICO/PROGRAMA", "DATA INGRESSO", "DATA DESLIGAMENTO"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getString("servico_programa"), con.rs.getString("data_ingresso"), con.rs.getString("data_desligamento")});
            } while (con.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "SEM REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableServ.setModel(modelo);
        jTableServ.getColumnModel().getColumn(0).setPreferredWidth(650);
        jTableServ.getColumnModel().getColumn(0).setResizable(false);
        jTableServ.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableServ.getColumnModel().getColumn(1).setResizable(false);
        jTableServ.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTableServ.getColumnModel().getColumn(2).setResizable(false);
        jTableServ.setAutoResizeMode(jTableServ.AUTO_RESIZE_ALL_COLUMNS);
        jTableServ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    public void preencherTabelaAtendimentos(String sql) throws SQLException {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"COD ACOMP", "SITUACAO ACOMP.", "USUARIO", "TIPO ATENDIMENTO", "DESCRICAO", " SITUACAO ATEND"};
        con.excutaSQL(sql);
        try {
            con.rs.first();
            do {
                dados.add(new Object[]{con.rs.getInt("id_familia_acompanhamento"),
                    con.rs.getString("situacao"),
                    con.rs.getString("nome_usuario"),
                    con.rs.getString("tipo_atendimento"),
                    con.rs.getString("descricao_atendimento"),
                    con.rs.getString("situacao_atendimento")});

            } while (con.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "SEM REGISTROS");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableAtendimento.setModel(modelo);
        jTableAtendimento.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTableAtendimento.getColumnModel().getColumn(0).setResizable(false);
        jTableAtendimento.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableAtendimento.getColumnModel().getColumn(1).setResizable(false);
        jTableAtendimento.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTableAtendimento.getColumnModel().getColumn(2).setResizable(false);
        jTableAtendimento.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTableAtendimento.getColumnModel().getColumn(3).setResizable(false);
        jTableAtendimento.getColumnModel().getColumn(4).setPreferredWidth(300);
        jTableAtendimento.getColumnModel().getColumn(4).setResizable(false);
        jTableAtendimento.getColumnModel().getColumn(5).setPreferredWidth(150);
        jTableAtendimento.getColumnModel().getColumn(5).setResizable(false);
        jTableAtendimento.setAutoResizeMode(jTableAtendimento.AUTO_RESIZE_ALL_COLUMNS);
        jTableAtendimento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableHabitacao = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableUsuarioVinculados = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTrabalho = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableEducacao = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableDeficiencia = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableBeneficio = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableRelatos = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableServ = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTableAtendimento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRONTUARIO");
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("HABITACAO");
        jLabel13.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableHabitacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableHabitacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableHabitacaoMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(jTableHabitacao);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("COMPOSICAO FAMILIAR");
        jLabel14.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableUsuarioVinculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableUsuarioVinculados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTableUsuarioVinculadosMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(jTableUsuarioVinculados);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CONDICOES DE TRABALHO E RENDIMENTOS DA FAMILIA");
        jLabel15.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableTrabalho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(jTableTrabalho);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("CONDIÇÕES EDUCACIONAIS DA FAMILIA");
        jLabel16.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableEducacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(jTableEducacao);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("CONDIÇÕES DE SAÚDE DA FAMILIA");
        jLabel17.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableDeficiencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(jTableDeficiencia);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ACESSO A BENEFICIOS EVENTUAIS");
        jLabel18.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableBeneficio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(jTableBeneficio);

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("RELATOS DOS USUARIOS");
        jLabel19.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableRelatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane9.setViewportView(jTableRelatos);

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("LISTA DE SERVICOS E PROGRAMAS");
        jLabel20.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableServ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane10.setViewportView(jTableServ);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("ACOMPANHAMENTOS E ATENDIMENTOS DA FAMILIA");
        jLabel21.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));

        jTableAtendimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane11.setViewportView(jTableAtendimento);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableUsuarioVinculadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuarioVinculadosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableUsuarioVinculadosMouseEntered

    private void jTableHabitacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHabitacaoMouseEntered
        
    }//GEN-LAST:event_jTableHabitacaoMouseEntered

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
            java.util.logging.Logger.getLogger(frmProntuarioFamiliaCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProntuarioFamiliaCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProntuarioFamiliaCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProntuarioFamiliaCompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProntuarioFamiliaCompleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableAtendimento;
    private javax.swing.JTable jTableBeneficio;
    private javax.swing.JTable jTableDeficiencia;
    private javax.swing.JTable jTableEducacao;
    private javax.swing.JTable jTableHabitacao;
    private javax.swing.JTable jTableRelatos;
    private javax.swing.JTable jTableServ;
    private javax.swing.JTable jTableTrabalho;
    private javax.swing.JTable jTableUsuarioVinculados;
    // End of variables declaration//GEN-END:variables
}
