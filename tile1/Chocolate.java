package tile1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;

import Entity.Entity;

import src.GamePanel;


public class Chocolate{
    GamePanel gp;
    BufferedImage chocoHo, chocoVe;
    public int numChoco; 
    static int titleSize = 128;   
    public static int choX,choY;
    public static int[]posX,posY;
    
 

    public Chocolate(GamePanel gp){
        this.gp = gp;
       
     
        getChocolateimage();
        
    }
    public static void setDefaultValues(){
         
    }

    public void getChocolateimage(){
         
        try {
            chocoHo = ImageIO.read(getClass().getResourceAsStream("/Imagens/objetos/chocolateHo.png"));
            chocoVe = ImageIO.read(getClass().getResourceAsStream("/Imagens/objetos/chocolateVe.png"));
          
       
          //  
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
 
  
    public void update(){
    int i = Integer.parseInt(osso.pontos);
        
    numChoco = i/4;

        
    
     
     
    }

    public void draw (Graphics2D g2){
        BufferedImage image = chocoVe;
     
    g2.drawImage(chocoHo, 100, 100,titleSize,titleSize,null);

        
    }
    
}
