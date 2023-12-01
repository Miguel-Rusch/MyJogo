package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import javax.imageio.ImageIO;

import src.GamePanel;
import tile1.tileMa;

public class osso extends Entity{
    GamePanel gp;
    int [] posOsso;

    public osso(GamePanel gp){
        this.gp = gp;
        tileMa tm = new tileMa(gp);
        posOsso = new int[100];
     
        getOssoimage();
        loadOsso("/Mapa/mapa1/mapaOsso.txt");
        setDefaultValues();
    }
    public void setDefaultValues(){
         p =numRng();
         direction = "e";

    }

    public void getOssoimage(){
         
        try {
            ossoB = ImageIO.read(getClass().getResourceAsStream("/Imagens/objetos/osso.png"));
            //ainda tem o osso dourado
       
          //  
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
    public void loadOsso(String filePath){
           
        try {
        
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int co1 = 0;
            int row = 0;
            int totalOsso = 0;
            

            while (co1 < gp.maxScreenCo1 && row < gp.maxScreenRow1){
                String line = br.readLine();

                while (co1 < 17) {
                     
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[co1]);
                    

                    if(num == 1){
                     
                        posOsso[totalOsso] = co1 * 1000 + row;
                        totalOsso++;
                        
                        
                    }
                   
                    co1++;
                    System.out.println(co1);
                    
                }
                
                    co1 =0;
                    row++;
                       System.out.println("21 osso");
                    
                
                
                
            }
        
            

        } catch (Exception e) {
            
        }
    }
    public int numRng(){
        Random rng = new Random();
        return rng.nextInt(4);
    }
    public void update(){
        Entity ent = new Entity();
        ColisionChecker ck = new ColisionChecker(gp);
       ck.checker(ent);
          if(ck.osso(this) == true){
        setDefaultValues();
        System.out.println("106 osso");
       }
        
      
    }

    public void draw (Graphics2D g2){
        BufferedImage image = ossoB;
       
       
    
     
        
        int z = posOsso[p]/1000;
         ossoX =gp.titleSize * (posOsso[p] / 1000);
         ossoY = gp.titleSize * (posOsso[p] - z *1000);
     
        
     
       
       
        g2.drawImage(image, ossoX, ossoY,gp.titleSize,gp.titleSize, null);
    }
    
}

