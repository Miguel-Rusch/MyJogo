package tile1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import src.GamePanel;

public class DisplayPonto {
    GamePanel gp;
    public DisplayPonto(GamePanel gp){
        this.gp = gp;
    }
    public void update(){

    }
  public void draw (Graphics2D g2){
    Font f = new Font("Dialog", Font.BOLD, 100);
    g2.setFont(f);
    g2.setColor(Color.black);
    g2.drawString(osso.pontos, 100, 100);
    
  }
}
