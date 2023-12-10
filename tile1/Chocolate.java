package tile1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Random;

import javax.imageio.ImageIO;


import Entity.Entity;

import src.GamePanel;


public class Chocolate{
    GamePanel gp;
    Random rng = new Random();
    BufferedImage chocoHo, chocoVe;
    public int numChoco, prevChoco; 
    static int titleSize = 128;   
    public static int choX,choY;
    public static int[]posX = new int[60],posY = new int[60], posOri = new int[60];
    public static int pointer;
    public boolean Ho;
    public  int borderHo =2304;
    public int borderVe = 800;
    public int limiteLado = 2;
    public static  Rectangle[] chocoRect = new Rectangle[60];
    //Variaveis que pode ser mudada caso dificuldade seja aumentada
    public static int velocidade = 5;
    


 

    public Chocolate(GamePanel gp){
        this.gp = gp;
        pointer = 1;
     
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
    public void criarChoco(){
        if(Ho == false){
        
        posY[numChoco] = 20 + pointer*titleSize/2;
        posX[numChoco] = 0;
        posOri[numChoco] = 1;
    
        }else{
        
        posY[numChoco] = 0;
        if(pointer % 2== 0 && pointer < 27){
        posX[numChoco ] = (27 -pointer)*titleSize/2;
        }else{
        posX[numChoco ] = pointer*titleSize/2;    
        }
        posOri[numChoco]= 0; 
        }
        System.out.println(pointer);
        pointer++;

    }
    public void movimentarChoco(){
        for(int cont = 0; cont <= numChoco; cont++){
            if(cont % 4 == 0){
                posX[cont] += velocidade;
                 if(posX[cont] >= borderHo){
                    posX[cont] = 0;
                 }
            }else{                
                posY[cont] += velocidade;
                if(posY[cont] >= borderHo){
                    posY[cont] = 0;
                }
            }
        }
    }
 
  
    public void update(){
    int i = Integer.parseInt(osso.pontos);
    prevChoco = numChoco;    
    numChoco = i/2;
    
    if(numChoco >= 40){
        numChoco = 40;
    }
    if(numChoco % 4 == 0){
        Ho = false;
    }else{
        Ho = true;
    }
    if(prevChoco < numChoco){
         criarChoco();
    }
   movimentarChoco();
        
    
     
     
    }

    public void draw (Graphics2D g2){
        BufferedImage image = chocoHo;
    for(int cont = 1; cont < pointer; cont++){
        if(posOri[cont] == 1){
        image = chocoVe;
         chocoRect[cont] = new Rectangle(posX[cont] + 20 ,posY[cont] + titleSize/4 ,-12+titleSize - titleSize/4,titleSize/2  );
        }else{
        image = chocoHo;
        chocoRect[cont] = new Rectangle(posX[cont]  + titleSize/4 + 5,posY[cont] + 10,titleSize/2,-12+titleSize  - titleSize/4);
        }
 
      
    g2.drawImage(image, posX[cont], posY[cont],titleSize,titleSize,null);
    }
        
    }
    
}
