package src;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import Entity.Player;
import tile1.tileMa;

public class GamePanel extends JPanel implements  Runnable{
     //Configurações da Tela
    
     final int originalTitleSize = 16;
     final int escala = 8;
     
     public int titleSize = originalTitleSize * escala;  //128
     public final int maxScreenCo1 = 18;
     public final int maxScreenRow1 = 9;
     public final int ScreenWitdh = titleSize * maxScreenCo1;//2304 
     public final int ScreenHeight = titleSize * maxScreenRow1;//1296

     Thread gameThread;

     //position of the square temporario
    
    int playerX =100;
    int playerY = 100;
    int playerSpeed = 4;

    //FPS
    int FPS = 60;

    tileMa Tm = new tileMa(this); 
    KeyHandler Kh = new KeyHandler();
    Player player = new Player(this, Kh);

    public GamePanel(){
        this.setPreferredSize(new Dimension(ScreenWitdh,ScreenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addKeyListener(Kh);
        this.setFocusable(true);
        startGameThread();
        
    }

    public void startGameThread(){
        gameThread  = new Thread(this);
        gameThread.start();
        
    }

    @Override
    public void run() {
        
         double drawInterval = 1000000000 /FPS;
         double nextDrawTime = System.nanoTime() + drawInterval;
        
        while(gameThread != null){
            
           
            
            
            
            
            update();
            
            repaint();
            
          
            
             try {
                 double remainTime = nextDrawTime - System.nanoTime();
                 remainTime = remainTime/1000000;
                 if(remainTime < 0){
                     remainTime = 0;
                 }
                 Thread.sleep((long) remainTime);
                 nextDrawTime += drawInterval;
             } catch (InterruptedException ex) {
                 Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
             
                }
            }
    }

        public void update(){
            player.update();
            
            
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D)g;
            
            Tm.draw(g2);
            player.draw(g2);
           
        }
    
    
}
