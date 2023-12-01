package Entity;

import src.GamePanel;
import tile1.tileMa;

public class ColisionChecker {
    GamePanel gp;
    public ColisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checker(Entity entity){
        tileMa tm = new tileMa(gp);
        
        int posXLeft = (entity.x / gp.titleSize);
        int posXRight = (entity.x / gp.titleSize) + 1;
        
        int posYHigh =  (entity.y / gp.titleSize);
        


        switch (entity.direction) {
            case "Down":
                    if(tm.mapColision[posXLeft][posYHigh] == true){
                        entity.colisionOn = true;
                        System.out.println("18 colision");
                    }
                break;
        
            default:
                break;
        }
        if(tm.mapColision[posXLeft][posYHigh + 1] == true || tm.mapColision[posXRight][posYHigh+ 1] == true){
            entity.colisionFall = false;
             Entity ent = new Entity();
             ent.colisionFall = false;
            System.out.println("36 colision");
            
         
        }else{
            entity.colisionFall = true;
             entity.p = 2;
             Entity ent = new Entity();
             ent.colisionFall = true;
        }
        
    } 
    public boolean osso(Entity entity){
               tileMa tm = new tileMa(gp);
        int posXLeft = (entity.x / gp.titleSize);
        int posXRight = (entity.x / gp.titleSize) + 1;
        
        int posYHigh =  (entity.y / gp.titleSize);
        Boolean retorn = false;
        System.out.println(entity.x);

        if(false){
            retorn = true;
        }
        System.out.println(retorn);
        return retorn;
    }  
}
