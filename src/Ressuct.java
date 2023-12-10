package src;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import Entity.Entity;
import Entity.Player;
import tile1.Chocolate;
import tile1.DisplayPonto;
import tile1.Chocolate;
import tile1.osso;
import tile1.tileMa;

public class Ressuct extends JPanel implements  Runnable{
     //Configurações da Tela
    
     final int originalTitleSize = 32;
     final int escala = 4;
     
     public int titleSize = originalTitleSize * escala;  //128
     public final int maxScreenCo1 = 18;
     public final int maxScreenRow1 = 9;
     public final int ScreenWitdh = titleSize * maxScreenCo1;//2304 
     public final int ScreenHeight = titleSize * maxScreenRow1;//1296

     Thread gameThread;

   

    //FPS
    int FPS = 60;
    KeyHandler Kh = new KeyHandler();
  

    public Ressuct(){
        this.setPreferredSize(new Dimension(ScreenWitdh,ScreenHeight));
        this.setBackground(Color.CYAN);
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
          
           
            
            
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D)g;
            
            g2.draw(Player.playerRect);
           
        }
    
    
}
