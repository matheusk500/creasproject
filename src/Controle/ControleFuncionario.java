/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModeloFuncionario;
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
public class ControleFuncionario {

    Conexao con = new Conexao();

    public int autenticarFuncionario(String login, String senha) {
        con.conectar();
        try {
            con.excutaSQL("select * from fastflowcreas.funcionario where login = '" + login + "'");
            con.rs.first();
            if (con.rs.getString("senha").equals(senha)) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "USUARIO E/OU SENHA INCORRETOS");
            return 0;
        }
    }

    public void InserirFuncionario(ModeloFuncionario modFuncionario) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("INSERT INTO fastflowcreas.funcionario(nome_funcionario) VALUES (?);");
            pst.setString(1, modFuncionario.getNome_funcionario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "INFORME OS DADOS DO FUNCIONARIO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO CRIAR FUNCIONARIO\n" + ex);
        }
    }

    public void AtualizarFuncionario(ModeloFuncionario modFuncionario) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("UPDATE fastflowcreas.funcionario\n"
                    + "	SET nome_funcionario=?, funcao=?, formacao=?, situacao=?, login=?, senha=?, "
                    + "ultimo_registro=?\n"
                    + "	WHERE id_funcionario =?;");
            pst.setString(1, modFuncionario.getNome_funcionario());
            pst.setString(2, modFuncionario.getFuncao());
            pst.setString(3, modFuncionario.getFormacao());
            pst.setString(4, modFuncionario.getSituacao());
            pst.setString(5, modFuncionario.getLogin());
            pst.setString(6, modFuncionario.getSenha());
            pst.setString(7, modFuncionario.getUltimo_registro());
            pst.setInt(8, modFuncionario.getId_funcionario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "FUNCIONARIO CADASTRADO!");
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO INSERIR FUNCIONARIO\n" + ex);
        }
    }

    public void DeletaFuncionario(ModeloFuncionario modFuncionario) {
        con.conectar();
        try {
            PreparedStatement pst = con.conect.prepareStatement("DELETE FROM fastflowcreas.funcionario WHERE id_funcionario = ?;");
            pst.setInt(1, modFuncionario.getId_funcionario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "REGISTRO CANCELADO");
        } catch (SQLException ex) {
            Logger.getLogger(ControleUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERRO AO APAGAR REGISTRO\n" + ex);
        }
    }
}
