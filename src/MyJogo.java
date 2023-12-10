package src;

import javax.swing.JFrame;

import Entity.Entity;

public class MyJogo {

     public static void main(String[] args) {
         
       criarTela();
        
      
        
   
         
     }
     public static void criarTela(){
          JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel gp = new GamePanel();
      
        
        janela.add(gp);
          janela.pack();
        janela.setResizable(true);
        janela.setTitle("jOGO DA vELHA");
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
     }
}
