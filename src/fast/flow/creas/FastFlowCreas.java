/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fast.flow.creas;

import Visao.jfrmLogin;
import Visao.jfrmTelaInicial;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author Matheus Moura
 */
import com.jtattoo.plaf.texture.TextureLookAndFeel;
//import net.sourceforge.napkinlaf.NapkinLookAndFeel;
public class FastFlowCreas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nome = "";
        
        try {   
            
            UIManager.setLookAndFeel(new TextureLookAndFeel()); 
            jfrmLogin frmLogin = new jfrmLogin();
            frmLogin.setVisible(true);
 
        } catch (Exception erro) {  
            erro.printStackTrace();  
        }
    /*try {  
        UIManager.setLookAndFeel(new NapkinLookAndFeel());  
        jfrmTelaInicial frmTelaInicial = new jfrmTelaInicial();
        frmTelaInicial.setVisible(true);
     } catch (Exception erro) {  
       erro.printStackTrace();  
     } */ 
    }
}
