
package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Entity {
 public int x, y;
 public int speed;
public int caida;
public int duracaoPulo;
public int pular;

public static int p;
public int ossoX;
public int ossoY;
 


public Rectangle solidAerea;
public boolean colisionOn = false;
public boolean colisionFall;

public boolean gameOver;

public String direction  = "e";

public BufferedImage cachorrinhoL,cachorrinhoR ,ossoB;



}