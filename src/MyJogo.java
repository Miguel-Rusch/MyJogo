package src;

import javax.swing.JFrame;

public class MyJogo {

     public static void main(String[] args) {
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
