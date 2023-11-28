package tile1;




import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Entity.ColisionChecker;
import Entity.Entity;
import src.GamePanel;

public class tileMa{
    GamePanel gp;
    tile [] tile;
    int mapTileNUm [] [];
    public static boolean mapColision [][]; 

    public tileMa(GamePanel gp){
    this.gp = gp;
     tile = new tile[10];
     mapTileNUm = new int[gp.maxScreenCo1][gp.maxScreenRow1];   
     mapColision = new boolean[gp.maxScreenCo1][gp.maxScreenRow1];
     getTitleImages();
     loadMap("/Mapa/1mapa.txt");
    }

    public void getTitleImages(){
        try {
            tile[0] = new tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Imagens/cenario/ceu.png"));
            tile[0].colision = false;

            tile[1] = new tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Imagens/cenario/plataforma.png"));
            tile[1].colision = true;

            tile[2] = new tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Imagens/cenario/marrom.png"));
            tile[2].colision = true;

            tile[3] = new tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Imagens/cenario/terra.png"));
            tile[3].colision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int co1 = 0;
            int row = 0;

            while (co1 < gp.maxScreenCo1 && row < gp.maxScreenRow1){
                String line = br.readLine();

                while (co1 < gp.maxScreenCo1) {
                    String numbers [] = line.split(" ");

                    int num = Integer.parseInt(numbers[co1]);

                    mapTileNUm[co1][row] = num;
                    mapColision[co1][row] = tile[num].colision;
                    co1++;
                    
                }
                if(co1 ==gp.maxScreenCo1){
                    co1 =0;
                    row++;
                    
                }
                
                
            }
            br.close(); 
        } catch (Exception e) {
            
        }
    }
    public void draw (Graphics2D g2){
       
        

      
        
        int co1 = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while (co1 < gp.maxScreenCo1 && row < gp.maxScreenRow1) {
            int titleNum = mapTileNUm[co1][row];
            g2.drawImage(tile[titleNum].image, x, y,gp.titleSize,gp.titleSize,null);
            co1++;
            x += gp.titleSize;

            if(co1 == gp.maxScreenCo1){
                co1 = 0;
                x = 0;
                row++;
                y += gp.titleSize;
            }
        }
    }







}
