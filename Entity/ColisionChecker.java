package Entity;

import src.GamePanel;

public class ColisionChecker {
    GamePanel gp;
    public ColisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checker(Entity entity,boolean mapColision[][]){
        int posX = (entity.x / gp.titleSize);
        
        int posY =  (entity.y / gp.titleSize);
System.out.println(mapColision[posX][posY]  );
        switch (entity.direction) {
            case "Down":
                    if(mapColision[posX][posY] == true){
                        entity.colisionOn = true;
                        System.out.println("18 colision");
                    }
                break;
        
            default:
                break;
        }
        if(mapColision[posX][posY + 1] == true){
            entity.colisionFall = false;
        }else{
            entity.colisionFall = true;
        }
    }
}
