package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import src.GamePanel;
import tile1.tileMa;

public class osso extends Entity{
    GamePanel gp;
    public osso(GamePanel gp){
        this.gp = gp;
        tileMa tm = new tileMa(gp);
        getPlayerimage();
        posOsso("/Mapa/mapa1/mapaOsso.txt");
    }
    public void posOsso(String filePath){

        x = 200;
        y = 300;
    }
    public void getPlayerimage(){
         
        try {
            ossoB = ImageIO.read(getClass().getResourceAsStream("/Imagens/objetos/osso.png"));
            //ainda tem o osso dourado
       
          //  
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public void update(){}

    public void draw (Graphics2D g2){
        BufferedImage image = ossoB;

        g2.drawImage(image, x, y,gp.titleSize,gp.titleSize, null);
    }
    
}

