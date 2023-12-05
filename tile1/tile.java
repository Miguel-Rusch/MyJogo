package tile1;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public class tile {
    public BufferedImage image;
    public boolean colision = false;
    static int titleSize = 128; 
    public static  Rectangle[] tileRect= new Rectangle[4];
    public static Rectangle[] rect(){
    tileRect[0] = new Rectangle(500,500 + titleSize/4,0,0);
     tileRect[1] = new Rectangle(500,500 + titleSize/4,titleSize,titleSize/2);
    return tileRect;
    }
  
    
}
