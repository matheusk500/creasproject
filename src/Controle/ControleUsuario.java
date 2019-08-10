/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

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
public class ControleUsuario {
    Conexao con = new Conexao();
    
    public void AtualizarUsuario(ModeloUsuario modUsuario){
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("UPDATE fastflowcreas.usuario\n" +
"	SET nome_usuario=?, sexo=?, sabe_ler=?, frequenta_escola=?, escolaridade=?, possui_ctps=?, condicao_ocupacao=?, renda_mensal=?, cpf=?, rg=?, nis=?, qualificacao_profissional=?, data_nascimento=?,\n" +
"	ultimo_registro=?, bairro=?, endereco=?, numero=? WHERE id_usuario =?;");
                pst.setString(1, modUsuario.getNome_usuario());
                pst.setString(2, modUsuario.getSexo());
                pst.setString(3, modUsuario.getSabe_ler());
                pst.setString(4, modUsuario.getFequenta_escola());
                pst.setString(5, modUsuario.getEscolaridade());
                pst.setString(6, modUsuario.getPossui_ctps());
                pst.setString(7, modUsuario.getCondicao_ocupacao());
                pst.setDouble(8, modUsuario.getRenda_mensal());
                pst.setString(9, modUsuario.getCpf());
                pst.setString(10, modUsuario.getRg());
                pst.setString(11, modUsuario.getNis());
                pst.setString(12, modUsuario.getQualificacao_profissional());
                pst.setString(13, modUsuario.getData_nascimento());
                pst.setString(14, modUsuario.getUltimo_registro());
                pst.setString(15, modUsuario.getBairro());
                pst.setString(16, modUsuario.getEndereco());
                pst.setString(17, modUsuario.getNumero());
                pst.setInt(18, modUsuario.getId_usuario());
                pst.execute();
                JOptionPane.showMessageDialog(null, "USUARIO REGISTRADO!");
            } catch (SQLException ex) {
            
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO REGISTRAR USUARIO\n"+ex);
            }
    }
    public void InserirUsuario(ModeloUsuario modUsuario){
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.usuario(nome_usuario) VALUES (?);");
                pst.setString(1, modUsuario.getNome_usuario());
                pst.execute();
                JOptionPane.showMessageDialog(null, "INFORME OS DADOS DO USUARIO");
            } catch (SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO CRIAR USUARIO \n"+ex);
            }
    }
    public void DeletaUsuario(ModeloUsuario modUsuario){
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.usuario WHERE id_usuario = ?;");
                pst.setInt(1, modUsuario.getId_usuario());
                pst.execute();
                JOptionPane.showMessageDialog(null, "REGISTRO CANCELADO");
            } catch (SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO \n"+ex);
            }
    }
    public void InserirUsuarioDeficiencia(ModeloUsuario modUsuario){
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.usuario_deficiencia(id_usuario, nome_deficiencia, cuidador, ultimo_registro) VALUES (?, ?, ?,?);");
                pst.setInt(1, modUsuario.getId_usuario());
                pst.setString(2, modUsuario.getDeficiencia());
                pst.setString(3, modUsuario.getCuidador());
                pst.setString(4, modUsuario.getUltimo_registro());
                pst.execute();
                JOptionPane.showMessageDialog(null, "DEFICIENCIA INSERIDA");
            } catch (SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO INSERIR DEFICIENCIA \n"+ex);
            }
    }
    public void DeletaUsuarioDeficiencia(ModeloUsuario modUsuario){
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.usuario_deficiencia WHERE id_usuario = ?;");
                pst.setInt(1, modUsuario.getId_usuario());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO \n"+ex);
            }
    }
    public void InserirUsuarioRelato(ModeloUsuario modUsuario){
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.usuario_relato(id_usuario, relato, descricao, situacao_persiste,data_relato, ultimo_registro) VALUES (?, ?, ?, ?, ?, ?);");
                pst.setInt(1, modUsuario.getId_usuario());
                pst.setString(2, modUsuario.getRelato());
                pst.setString(3, modUsuario.getDescricao());
                pst.setString(4, modUsuario.getSituacao());
                pst.setString(5, modUsuario.getData_relato());
                pst.setString(6, modUsuario.getUltimo_registro());
                pst.execute();
                JOptionPane.showMessageDialog(null, "RELATO INSERIDO");
            } catch (SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO INSERIR RELATO \n"+ex);
            }
    }
    public void DeletaUsuarioRelato(ModeloUsuario modUsuario){
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.usuario_relato WHERE id_usuario = ?;");
                pst.setInt(1, modUsuario.getId_usuario());
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO \n"+ex);
            }
    }
    public void AtualizaUsuarioRelato(ModeloUsuario modUsuario){
    con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("UPDATE fastflowcreas.usuario_relato\n" +
"	SET descricao=?, situacao_persiste=?, ultimo_registro=? WHERE id_usuario_relato =?;");
                pst.setString(1, modUsuario.getDescricao());
                pst.setString(2, modUsuario.getSituacao());
                pst.setString(3, modUsuario.getUltimo_registro());
                pst.setInt(4, modUsuario.getId_usuario_relato());
                pst.execute();
                JOptionPane.showMessageDialog(null, "RELATO ALTERADO!");
            } catch (SQLException ex) {
            
                Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR RELATO\n"+ex);
            }
    }
    
    
}
