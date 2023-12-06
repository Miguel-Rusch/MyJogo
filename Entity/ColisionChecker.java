package Entity;

import src.GamePanel;
import tile1.osso;
import tile1.tile;
import tile1.tileMa;

public class ColisionChecker {
    GamePanel gp;
     int cont;
    public ColisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checker(Entity entity){
      
        
        int posXLeft = (int) (Player.playerRect.getX() / gp.titleSize);
        double r = (Player.playerRect.getX()  + Player.playerRect.getWidth());
        int posXRight = (int) (r/128);
       

        int posYHigh =  (entity.y / gp.titleSize);
        int tileNUm = tileMa.mapTileNUm[posXLeft][posYHigh + 1];
        int tileNumR = tileMa.mapTileNUm[posXRight][posYHigh + 1];
       osso.calcularPos();
      
       if(Player.playerRect.getX() < osso.ossoRect.getX() + osso.ossoRect.getWidth() &&
        Player.playerRect.getX() + Player.playerRect.getWidth()  > osso.ossoRect.getX() &&
        Player.playerRect.getY() < osso.ossoRect.getY() + osso.ossoRect.getHeight() &&
        Player.playerRect.getY() + Player.playerRect.getHeight() > osso.ossoRect.getY()){
         osso.setDefaultValues();
       }


       tile.rect(posXLeft * gp.titleSize,(posYHigh + 1 )*gp.titleSize);
      
          if(Player.playerRect.getY() >= tile.tileRect[tileNUm].getY() || Player.playerRect.getY() >= tile.tileRect[tileNumR].getY()){
        entity.colisionFall = false;
       
       }
       else{
       
        entity.colisionFall = true;
       }
       

        // switch (entity.direction) {aaaaaa
        //     case "Down":
        //             if(tileMa.mapColision[posXLeft][posYHigh] == true){
        //                 entity.colisionOn = true;   
        //                 System.out.println("18 colision");
        //             }
        //         break;
        
        //     default:
        //         break;
        // }
        // if(tileMa.mapColision[posXLeft][posYHigh + 1] == true || tileMa.mapColision[posXRight][posYHigh+ 1] == true){
        //     entity.colisionFall = false;
        //      Entity ent = new Entity();
        //      ent.colisionFall = false;

            
         
        // }else{
        //     entity.colisionFall = true;
        //      entity.p = 2;
        //      Entity ent = new Entity();
        //      ent.colisionFall = true;
        // }
        
        
        
    } 
    
}
