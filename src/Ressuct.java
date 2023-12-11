package src;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.RootPaneContainer;

import Entity.Entity;
import Entity.Player;
import java.awt.Font;
import tile1.Chocolate;
import tile1.DisplayPonto;
import tile1.Chocolate;
import tile1.osso;
import tile1.tileMa;


public class Ressuct extends JPanel implements  Runnable{
     //Configurações da Tela
    JLabel label;
     final int originalTitleSize = 32;
     final int escala = 4;
     
     public int titleSize = originalTitleSize * escala;  //128
     public final int maxScreenCo1 = 18;
     public final int maxScreenRow1 = 9;
     public final int ScreenWitdh = titleSize * maxScreenCo1;//2304 
     public final int ScreenHeight = titleSize * maxScreenRow1;//1296
     public static boolean open = true;
    public Rectangle btn1;
     Thread gameThread;

   

    //FPS
    int FPS = 60;
    KeyHandler Kh = new KeyHandler();
   MouseHandler Mh = new MouseHandler();
  MouseHandler mh = new MouseHandler();

    public Ressuct(){
        this.setPreferredSize(new Dimension(ScreenWitdh,ScreenHeight));
        this.setBackground(Color.GREEN);
        this.setDoubleBuffered(true);
        this.addKeyListener(Kh);
        this.setFocusable(true);
        startGameThread();
        

        addMouseListener(new MouseAdapter() { 
            public void mousePressed(MouseEvent me) { 
              System.out.println(me); 
            }
            public void mouseEntered(MouseEvent me){
                System.out.println(me);}
          }); 
                     btn1 = new Rectangle(ScreenWitdh/4 + 50, 250 + ScreenHeight/4, 500, 100);
        


        
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

          if(mh.mouseX >= 625 && mh.mouseX < 625 + btn1.getWidth() &&
            mh.mouseY >= 536 && mh.mouseY < 537 + btn1.getHeight()  && Entity.colisionDeath == true){
            
             
           mh.mouseX = 0;
           mh.mouseY = 0;
           
          if(open){
            for(int i = 0; i != 1; i++){
            
             MyJogo mg = new MyJogo();
             
           mg.criarTela();
           Entity.colisionDeath = false;
           open = false;
           osso.pontuacao = 0;
           osso.pontos = "";
             }
            }
           
          }
            
        
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            Graphics2D g2 = (Graphics2D)g;
        g2.setBackground(Color.green);
        Font f = new Font("Dialog", Font.BOLD, 100);
        g2.setFont(f);
        g2.setColor(Color.BLACK);  
        g2.drawString("Pontuação: " +osso.pontos, ScreenWitdh/4, ScreenHeight/4);
      

        //Button

         
      // g2.fillRect(ScreenWitdh/4 + 50, 250 + ScreenHeight/4, 500, 100);
      
        Font novo = new Font("Dialog", Font.BOLD, 75);
        g2.setFont(novo);
        g2.drawString("Novo Jogo ", ScreenWitdh/4 + 100, 200 + ScreenHeight/4);

      
        g2.fill(btn1);

     
         
        }
    
    
}
