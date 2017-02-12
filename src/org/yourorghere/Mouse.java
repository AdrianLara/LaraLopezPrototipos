/*
 *@brief Clase Mouse para el movimiento del Actor principal
 */
package org.yourorghere;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/**
 *@brief Desarrollo de la clase mouse
 * @author Lara_Lopez
 */
public class Mouse implements MouseListener,MouseMotionListener,GLEventListener {
    float oldx;///<Ultima posición del mouse    
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
    
    /**
     * @brief Método para control con el mouse cuando se mueve sobre la pantalla
     * @param me  Captura la posición del mouse
     */
    public void mouseMoved(MouseEvent me) {  
        
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
