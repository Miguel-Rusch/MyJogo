package src;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Entity.Entity;


public class MyJogo {

     public static void main(String[] args) {
         
       criarTela();
    
      
        
   
         
     }
     public static void criarTela(){
  
          JFrame janela = new JFrame();
          
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gp = new GamePanel();
      MouseHandler Mh = new MouseHandler();

        janela.add(gp);
        
       gp.addMouseListener(Mh);
          janela.pack();
        janela.setResizable(true);
        janela.setTitle("jOGO DA vELHA");
        janela.setLocationRelativeTo(null);
        
       if(Ressuct.open){
         janela.setVisible(true);
       }else{
         janela.setVisible(false);
       }
     }
}
