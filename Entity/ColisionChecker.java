package Entity;

import src.GamePanel;

public class ColisionChecker {
    GamePanel gp;
    public ColisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checker(Entity entity,boolean mapColision[][]){
        int posXLeft = (entity.x / gp.titleSize);
        int posXRight = (entity.x / gp.titleSize) + 1;
        
        int posYHigh =  (entity.y / gp.titleSize);
        
System.out.println(mapColision[posXLeft][posYHigh]  );

        switch (entity.direction) {
            case "Down":
                    if(mapColision[posXLeft][posYHigh] == true){
                        entity.colisionOn = true;
                        System.out.println("18 colision");
                    }
                break;
        
            default:
                break;
        }
        if(mapColision[posXLeft][posYHigh + 1] == true || mapColision[posXRight][posYHigh+ 1] == true){
            entity.colisionFall = false;
        }else{
            entity.colisionFall = true;
        }
    }
}
