/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Miguel
 */
public class KeyHandler  implements KeyListener {
    public boolean  upPressed, downPressed, leftPressed,rightPressed,changeSprite, Mpressed;
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int code = e.getKeyCode();
       
       if(code == KeyEvent.VK_SPACE){
           upPressed = true;
           
           
       }
       if(code == KeyEvent.VK_S){
           downPressed = true;
       }
       if(code == KeyEvent.VK_A){
           leftPressed = true;
       }
       if(code == KeyEvent.VK_D){
           rightPressed = true;
       }
       if(code == KeyEvent.VK_C){
           changeSprite = true;
       }
       if(code == KeyEvent.VK_M){
            Mpressed = true;
       }
       
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
       int code = e.getKeyCode();
       
       if(code == KeyEvent.VK_SPACE){
           upPressed = false;
           
       }
       if(code == KeyEvent.VK_S){
           downPressed = false;
       }
       if(code == KeyEvent.VK_A){
           leftPressed = false;
       }
       if(code == KeyEvent.VK_D){
           rightPressed = false;
       }
       if(code == KeyEvent.VK_C){
           changeSprite = false;
       }
       if(code == KeyEvent.VK_M){
            Mpressed = false;
       }
    }
    
    
    
}