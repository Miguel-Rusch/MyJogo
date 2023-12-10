
package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javafx.geometry.Rectangle2D;


public class Entity {
 public static int x, y;
 public int speed;
public int caida;
public int duracaoPulo;
public int pular;
static int titleSize = 128;
public static Rectangle  playerRect ;


public static int p;
public int ossoX;
public int ossoY;
 


public Rectangle solidAerea;
public boolean colisionOn = false;
public boolean colisionFall;
public static boolean colisionDeath = false;

public boolean gameOver;

public String direction  = "e";

public BufferedImage cachorrinhoL,cachorrinhoR ,ossoB;



}