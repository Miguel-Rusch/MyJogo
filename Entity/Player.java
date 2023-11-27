package Entity;


import src.GamePanel;
import src.KeyHandler;
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
        if(Kh.leftPressed == true){
            direction = "Left";
           
        }else if(Kh.upPressed == true){
            direction = "Up";

         }else if(Kh.downPressed == true){
            direction = "Down";
            
        }
        if(Kh.rightPressed == true){
            direction = "Right";
        }
        mover = true;
    }else{
        mover = false;
    }
        

       if(mover){
        switch (direction) {
            case "Left":
                    System.out.println("aahh");
                    x -= speed;
                    
                break;
            case "Up":
                    y -= speed;
                    
                break;
            case "Down":
                    y += speed;
                    
                break;
            case "Right":
                    x += speed;
                    
                break;
        }
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

