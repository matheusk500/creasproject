/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloFamilia;
import Modelo.ModeloUsuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Moura
 */
public class ControleFamilia {

    Conexao con = new Conexao();

    public void InserirFamilia(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia(especificidade) VALUES (?);");
            pst.setString(1, modFamilia.getEspecificidade());
            pst.execute();
            JOptionPane.showMessageDialog(null, "INFORME OS DADOS DA FAMILIA");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO CRIAR FAMILIA \n" + ex);
        }
    }

    public void InserirFamiliaBeneficio(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia_beneficio(id_familia, beneficio, data_recebimento, ultimo_registro) VALUES (?, ?, ?, ?);");
            pst.setInt(1, modFamilia.getId_familia());
            pst.setString(2, modFamilia.getBeneficio());
            pst.setString(3, modFamilia.getData_recebimento());
            pst.setString(4, modFamilia.getUltimo_registro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "BENEFICIO INSERIDA");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR BENEFICIO \n" + ex);
        }
    }

    public void InserirFamiliaServico(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia_servico(id_familia, data_ingresso, data_desligamento, servico_programa, ultimo_registro) VALUES (?, ?, ?, ?, ?);");
            pst.setInt(1, modFamilia.getId_familia());
            pst.setString(2, modFamilia.getData_ingresso());
            pst.setString(3, modFamilia.getData_desligamento());
            pst.setString(4, modFamilia.getServico_programa());
            pst.setString(5, modFamilia.getUltimo_registro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "SERVICO/PROGRAMA INSERIDA");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR SERVICO/PROGRAMA \n" + ex);
        }
    }

    public int InserirFamiliaUsuario(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia_usuario(id_familia, id_usuario, parentesco) VALUES (?, ?, ?);");
            pst.setInt(1, modFamilia.getId_familia());
            pst.setInt(2, modFamilia.getId_usuario());
            pst.setString(3, modFamilia.getParentesco());
            pst.execute();
            JOptionPane.showMessageDialog(null, "USUARIO VINCULADO A FAMILIA");
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO VINCULAR USUARIO A FAMILIA!\nUSUARIO JA VINCULADO.");
            return 1;
        }
    }

    public void DesvincularUsuario(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.familia_usuario WHERE id_usuario = ?;");
            pst.setInt(1, modFamilia.getId_usuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "USUARIO DESVINCULADO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO DESVINCULAR USUARIO\n" + ex);
        }
    }

    public void DeletaFamilia(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.familia WHERE id_familia = ?;");
            pst.setInt(1, modFamilia.getId_familia());
            pst.execute();
            JOptionPane.showMessageDialog(null, "REGISTRO CANCELADO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO \n" + ex);
        }
    }

    public void AtualizarFamilia(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("UPDATE fastflowcreas.familia\n"
                    + "	SET especificidade=?, tipo_residencia=?, material_parede=?, acesso_energia=?, agua_canalizada=?, abastecimento_agua=?, coleta_lixo=?, zona_risco=?, dificil_acesso=?, presenca_violencia=?, ultimo_registro=? WHERE id_familia =?;");
            pst.setString(1, modFamilia.getEspecificidade());
            pst.setString(2, modFamilia.getTipo_residencia());
            pst.setString(3, modFamilia.getMaterial_parede());
            pst.setString(4, modFamilia.getAcesso_energia());
            pst.setString(5, modFamilia.getAgua_canalizada());
            pst.setString(6, modFamilia.getAbastecimento_agua());
            pst.setString(7, modFamilia.getColeta_lixo());
            pst.setString(8, modFamilia.getZona_risco());
            pst.setString(9, modFamilia.getDificil_acesso());
            pst.setString(10, modFamilia.getPresenca_violencia());
            pst.setString(11, modFamilia.getUltimo_registro());
            pst.setInt(12, modFamilia.getId_familia());
            pst.execute();
            JOptionPane.showMessageDialog(null, "FAMILIA CADASTRADO!");
        } catch (SQLException ex) {

            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR FAMILIA\n" + ex);
        }
    }

    public void DeletaFamiliaServico(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.familia_servico WHERE id_familia = ?;");
            pst.setInt(1, modFamilia.getId_familia());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO \n" + ex);
        }
    }

    public void AtualizarFamiliaServico(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("UPDATE fastflowcreas.familia_servico\n"
                    + "	SET data_ingresso=?, data_desligamento=? WHERE id_familia_servico =?;");
            pst.setString(1, modFamilia.getData_ingresso());
            pst.setString(2, modFamilia.getData_desligamento());
            pst.setInt(3, modFamilia.getId_familia_servico());
            pst.execute();
            JOptionPane.showMessageDialog(null, "DATA ALTERADA!");
        } catch (SQLException ex) {

            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO ALTERAR DATA!\n" + ex);
        }
    }

    public void DeletaFamiliaBeneficio(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.familia_beneficio WHERE id_familia = ?;");
            pst.setInt(1, modFamilia.getId_familia());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO \n" + ex);
        }
    }

    public void DeletaFamiliaUsuario(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.familia_usuario WHERE id_familia = ?;");
            pst.setInt(1, modFamilia.getId_familia());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO \n" + ex);
        }
    }

    public void InserirAcompanhamento(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia_acompanhamento(id_familia, data_ingresso_acompanhamento, "
                    + "forma_ingresso, descricao,situacao,ultimo_registro) VALUES ( ?, ?, ?, ?, ?, ?);");
            pst.setInt(1, modFamilia.getId_familia());
            pst.setString(2, modFamilia.getData_ingresso_acompanhamento());
            pst.setString(3, modFamilia.getForma_ingresso());
            pst.setString(4, modFamilia.getDescricao_acompanhamento());
            pst.setString(5, modFamilia.getSituacao_acompanhamento());
            pst.setString(6, modFamilia.getUltimo_registro());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "ACOMPANHAMENTO INSERIDO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR ACOMPANHAMENTO \n" + ex);
        }
    }

    public void DesligarAcompanhamento(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("UPDATE fastflowcreas.familia_acompanhamento\n"
                    + "	SET situacao=?,data_desligamento_acompanhamento=?, ultimo_registro =? WHERE id_familia_acompanhamento =?;");
            pst.setString(1, modFamilia.getSituacao_acompanhamento());
            pst.setString(2, modFamilia.getData_desligamento_acompanhamento());
            pst.setString(3, modFamilia.getUltimo_registro());
            pst.setInt(4, modFamilia.getId_acompanhamento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "FAMILIA DESLIGADA DO ACOMPANHAMENTO!!");
        } catch (SQLException ex) {

            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO DESLIGAR FAMILIA\n" + ex);
        }
    }

    public void InserirAtendimento(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia_atendimento(id_familia_acompanhamento, "
                    + "data_atendimento, "
                    + "id_usuario, "
                    + "tipo_atendimento, "
                    + "descricao_atendimento, "
                    + "ultimo_registro,"
                    + "situacao_atendimento) VALUES (?, ?, ?, ?, ?, ?, ?);");
            pst.setInt(1, modFamilia.getId_acompanhamento());
            pst.setString(2, modFamilia.getData_atendimento());
            pst.setInt(3, modFamilia.getId_usuario());
            pst.setString(4, modFamilia.getTipo_atendimento());
            pst.setString(5, modFamilia.getDescricao_tendimento());
            pst.setString(6, modFamilia.getUltimo_registro());
            pst.setString(7, modFamilia.getSituacao_atendimento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "ATENDIMENTO INSERIDO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR ATENDIMENTO \n" + ex);
        }
    }

    public int AchaCodUsuario(String nome, int id_familia) {
        con.conectar();
        int cod = 0;
        String sql = "select * from fastflowcreas.usuario, fastflowcreas.familia_usuario where nome_usuario = '" + nome + "' and fastflowcreas.usuario.id_usuario = fastflowcreas.familia_usuario.id_usuario and id_familia = " + id_familia;

        try {
            con.excutaSQL(sql);
            con.rs.first();
            cod = con.rs.getInt("id_usuario");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cod;
    }

    public void InserirAtendimentoEspontaneo(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia_atendimento( "
                    + "data_atendimento, "
                    + "id_usuario, "
                    + "tipo_atendimento, "
                    + "descricao_atendimento, "
                    + "ultimo_registro,"
                    + "situacao_atendimento) VALUES (?, ?, ?, ?, ?, ?);");
            pst.setString(1, modFamilia.getData_atendimento());
            pst.setInt(2, modFamilia.getId_usuario());
            pst.setString(3, modFamilia.getTipo_atendimento());
            pst.setString(4, modFamilia.getDescricao_tendimento());
            pst.setString(5, modFamilia.getUltimo_registro());
            pst.setString(6, modFamilia.getSituacao_atendimento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "ATENDIMENTO INSERIDO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR ATENDIMENTO \n" + ex);
        }
    }
    
    public void InserirAnexo(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.familia_anexo( "
                    + "id_familia, "
                    + "data_registro, "
                    + "caminho, "
                    + "ultimo_registro, "
                    + "tipo_anexo"
                    + " VALUES (?, ?, ?, ?, ?);");
            pst.setInt(1, modFamilia.getId_familia());
            pst.setString(2, modFamilia.getData_anexo());
            pst.setString(3, modFamilia.getCaminho());
            pst.setString(4, modFamilia.getTipo_anexo());
            pst.setString(5, modFamilia.getUltimo_registro());
            pst.execute();
            JOptionPane.showMessageDialog(null, "ANEXO INSERIDO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleFamilia.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR ANEXO\n" + ex);
        }
    }
    
    public void AtualizarSituacaoAtendimento(ModeloFamilia modFamilia) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("UPDATE fastflowcreas.familia_atendimento\n"
                    + "	SET situacao_atendimento=?,descricao_atendimento=?,tipo_atendimento=?, ultimo_registro=? WHERE id_familia_atendimento=?");
            pst.setString(1, modFamilia.getSituacao_atendimento());
            pst.setString(2, modFamilia.getDescricao_tendimento());
            pst.setString(3, modFamilia.getTipo_atendimento());
            pst.setString(4, modFamilia.getUltimo_registro());
            pst.setInt(5, modFamilia.getId_atendimento());
            pst.execute();
            JOptionPane.showMessageDialog(null, "ATENDIMENTO ATUALIZADO!");
        } catch (SQLException ex) {

            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR ATENIDMENTO\n" + ex);
        }
    }

}
