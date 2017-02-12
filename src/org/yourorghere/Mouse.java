/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author S7PC21
 */
public class Mouse implements MouseListener,MouseMotionListener,GLEventListener {
    float oldx;
    
    public void init(GLAutoDrawable drawable) {
       oldx = 0;
       drawable.addMouseMotionListener(this);
    }
     
    public void mouseClicked(MouseEvent me) {   
    }

    public void mousePressed(MouseEvent me) {  
    }

    public void mouseReleased(MouseEvent me) {  
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }

    public void mouseDragged(MouseEvent me) {
    }

    public void mouseMoved(MouseEvent me) {  
        //Metodo que s ejecuta cuando movemos el raton sobre el objeto drawable
        float mousex = me.getX();
        FinalGame.jugador.angle += (mousex-oldx)/100;
        oldx=mousex;
        
    }

    public void display(GLAutoDrawable drawable) {
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {  
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) { 
    }
    
}
