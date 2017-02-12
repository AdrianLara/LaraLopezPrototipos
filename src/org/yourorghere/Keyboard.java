/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.glu.GLU;

/**
 *
 * @author PC
 */
public class Keyboard implements KeyListener {

    private GLCanvas canvas;
    public boolean[] keybuffer;
    //GL gl = drawable.getGL();
    GLU glu = new GLU();//Contiene funciones de mas alto nivel 

    public Keyboard(GLCanvas canvas) {
        this.canvas = canvas;
        keybuffer = new boolean[256];
    }

    public void keyTyped(KeyEvent e) {
        //System.out.println(e);

       
        if (keybuffer['w']) {
            FinalGame.jugador.avanzar();
        }

        if (keybuffer['s']) {
            FinalGame.jugador.retroceder();
        }

        if (keybuffer['a']) {

            FinalGame.jugador.izquierda();
        }

        if (keybuffer['d']) {

            FinalGame.jugador.derecha();
        }
        if (e.getKeyChar() == 'z') {

            FinalGame.cx += 1f;
        }
        if (e.getKeyChar() == 'x') {

            FinalGame.cy += 1f;
        }
        if (e.getKeyChar() == 'c') {

            FinalGame.cz += 1f;

        }
        if (e.getKeyChar() == 'v') {

            FinalGame.cx -= 1f;
        }
        if (e.getKeyChar() == 'b') {

            FinalGame.cy -= 1f;
        }
        if (e.getKeyChar() == 'n') {

            FinalGame.cz -= 1f;
        }
        if (e.getKeyChar() == 'p') {

         FinalGame.option=1;
        }
         if (e.getKeyChar() == 'o') {

         FinalGame.option=2;
        }
    }

    public void keyPressed(KeyEvent e) {
        keybuffer[e.getKeyChar()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keybuffer[e.getKeyChar()] = false;
    }

}
