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


public class osso{
    GamePanel gp;
    static int [] posOsso;
    BufferedImage  ossoB; 
    public static int p,ossoY, ossoX;
    static int titleSize = 128;   
   
    public static String pontos;
    static int pontuacao = 0;
    public static  Rectangle ossoRect;

    public osso(GamePanel gp){
        this.gp = gp;
        
        posOsso = new int[100];
     
        getOssoimage();
        loadOsso("/Mapa/mapa1/mapaOsso.txt");
        setDefaultValues();
    }
    public static void setDefaultValues(){
         p =numRng();
         pontos = "" + pontuacao +"";
         pontuacao++;
       
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
    public static int numRng(){
        Random rng = new Random();
        return rng.nextInt(8);
    }
    
    public static void calcularPos(){
          int z = posOsso[p]/1000;
         ossoX =128 * (posOsso[p] / 1000);
         ossoY = 128 * (posOsso[p] - z *1000);
      
          ossoRect = new Rectangle(ossoX-4,ossoY + titleSize/4,titleSize,titleSize/2);
    }
    public void update(){
      
        
      
    }

    public void draw (Graphics2D g2){
        BufferedImage image = ossoB;
       
       
    
    calcularPos();
        
   
        
     
       g2.setColor(Color.red);
       g2.fill(ossoRect);
        g2.drawImage(image, ossoX, ossoY,gp.titleSize,gp.titleSize, null);
        
    }
    
}

