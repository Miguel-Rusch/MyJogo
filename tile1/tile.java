package tile1;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public class tile {
    public BufferedImage image;
    public boolean colision = false;
    public static int titleSize = 128; 
    public static  Rectangle[] tileRect= new Rectangle[4];
    public static Rectangle[] rect(double x, double y){
   
    int j = (int) x;
    int i = (int) y;
    
    tileRect[0] = new Rectangle(2000,20000,0,0);
    tileRect[1] =  new Rectangle(j,i +36 ,titleSize, 1);
    tileRect[2] =  new Rectangle(j,i,titleSize, titleSize/4);//Não configurado
    tileRect[3] = new Rectangle(j,i - 12,titleSize, -18 +titleSize - titleSize/4);
    return tileRect;
    }
  
    
}
