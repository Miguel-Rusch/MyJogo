package Entity;

import src.GamePanel;
import tile1.osso;
import tile1.tileMa;

public class ColisionChecker {
    GamePanel gp;
     int cont;
    public ColisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checker(Entity entity){
       
        
        int posXLeft = (entity.x / gp.titleSize);
        int posXRight = (entity.x / gp.titleSize) + 1;
        
        int posYHigh =  (entity.y / gp.titleSize);
       
       osso.calcularPos();
        if(entity.x >= osso.ossoX && osso.ossoX+128 >= entity.x && entity.y >= osso.ossoY && entity.y <= osso.ossoY+128){
            
            osso.setDefaultValues();    
           
        }
        

        switch (entity.direction) {
            case "Down":
                    if(tileMa.mapColision[posXLeft][posYHigh] == true){
                        entity.colisionOn = true;
                        System.out.println("18 colision");
                    }
                break;
        
            default:
                break;
        }
        if(tileMa.mapColision[posXLeft][posYHigh + 1] == true || tileMa.mapColision[posXRight][posYHigh+ 1] == true){
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
    
}
