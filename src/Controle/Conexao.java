/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus Moura
 */
public class Conexao {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/fastflowcreas"; 
    private String user = "postgres";
    private String password = "123456";
    public Connection conect;
    
    public void conectar(){        
        try {
            System.setProperty("jdbc,Drivers", driver);
            conect = DriverManager.getConnection(url,user,password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR BANCO DE DADOS!\n"+ex);
        } 
    }
    
    public void desconecta(){
        try {
            conect.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AS DESCONECTAR BANCO DE DADOS!\n"+ex);
        } 
    }
    public void excutaSQL(String sql) throws SQLException{
            stm = (Statement) conect.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);      
    } 
    
}
