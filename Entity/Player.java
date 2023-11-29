package Entity;


import src.GamePanel;
import src.KeyHandler;
import tile1.tileMa;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler Kh;
    boolean mover = true;
    boolean pressedUp;
    int acelerar;
    

    public Player(GamePanel gp , KeyHandler Kh){
        this.gp = gp;
        this.Kh = Kh;

        solidAerea = new Rectangle(0,0,48,48);
        

        setDefaultValues();
        getPlayerimage();
    }
    public void setDefaultValues(){
        x = 200;
        y = 10;
        speed = 5;
        duracaoPulo = 80;
        pular = 35;
        caida = 7;
        direction = "Left";
    }
    public void getPlayerimage(){
         System.out.println("b");
        try {
            cachorrinhoL = ImageIO.read(getClass().getResourceAsStream("/Imagens/player/cLeft.png"));
            cachorrinhoR = ImageIO.read(getClass().getResourceAsStream("/Imagens/player/cRight.png"));
       
          //  
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void update(){
    if(Kh.downPressed == true ||Kh.upPressed == true ||Kh.rightPressed == true ||Kh.leftPressed){
        if(Kh.upPressed == true){
            direction = "Up";
            pressedUp = true;
           
        }else if(Kh.leftPressed == true){
            direction = "Left";

         }else if(Kh.downPressed == true){
            direction = "Down";
            
        }
        if(Kh.rightPressed == true){
            direction = "Right";
        }
        mover = true;
    }else{
        if(pressedUp == false){
        mover = false;
        }else{
            mover = true;
        }

    }

       if(mover){
        switch (direction) {
            case "Left":
                    x -= speed;
                    
                break;
            case "Up":
                if(Kh.upPressed == false && pressedUp == true){
                    acelerar += duracaoPulo;
                    pressedUp = false;
                }
                    
                break;
            case "Down":
                    y += speed;
                    
                break;
            case "Right":
                    x += speed;
                    
                break;
        }
    }
        
     ColisionChecker cL =new ColisionChecker(gp);
        cL.checker(this, tileMa.mapColision);   
        if(colisionFall == true){
            y += caida; 
        }
        if(acelerar > 0){
        y -= pular ;
        acelerar-=caida;
        }
    }


    public void draw (Graphics2D g2){
       BufferedImage image = null;
        

        switch (direction) {
            case "Left":
                image = cachorrinhoL;
                break;
            case "Right":
                image = cachorrinhoR;
                break;
            default:
                image = cachorrinhoR;
                break;
        }
       
       // g2.fillRect(x, y, gp.titleSize, gp.titleSize);
        g2.drawImage(image, x, y,gp.titleSize,gp.titleSize, null);
       
    }
}

