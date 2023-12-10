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

public class GamePanel extends JPanel implements  Runnable{
     //Configurações da Tela
    
     final int originalTitleSize = 32;
     final int escala = 4;
     
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
    osso os = new osso(this);
    DisplayPonto Dp = new DisplayPonto(this);
    Chocolate Cho = new Chocolate(this);
    Ressuct rs = new Ressuct();

    public GamePanel(){
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
        if(Entity.colisionDeath == true){
            player.update();
            Cho.update();
        }else{
            
            rs.update();
        }
        
            
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D)g;
            if(Entity.colisionDeath == true){
            Tm.draw(g2);
            player.draw(g2);
            os.draw(g2);
            Cho.draw(g2);
            Dp.draw(g2);
            
            }else{
                
                this.setBackground(Color.LIGHT_GRAY);
                rs.paintComponent(g2);
            }

          
            
           
        }
    
    
}
