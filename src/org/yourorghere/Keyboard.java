/*
 *@ Clase Keyboard para manejar las acciones del juego a través de los eventos del teclado 
 */
package org.yourorghere;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.glu.GLU;

/**
 * @brief Desarrollo del Keyboard para el manejo del teclado
 * @author Lara_Lopez
 */
public class Keyboard implements KeyListener {

    private GLCanvas canvas;
    public boolean[] keybuffer;
    GLU glu = new GLU();

    /**
     * @brief Conección del canvas con el teclado para la captura y entrada de
     * eventos
     * @param canvas
     */
    public Keyboard(GLCanvas canvas) {
        this.canvas = canvas;
        keybuffer = new boolean[256];
    }

    /**
     * @brief Método para la distribución de las telas
     * @param e Asignación de teclas
     */
    public void keyTyped(KeyEvent e) {

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

            FinalGame.option = 1;
        }
        if (e.getKeyChar() == 'o') {

            FinalGame.option = 2;
        }
    }

    /**
     * @brief Comprobación de las teclas presionadas
     * @param e Lectura de la tecla presionada
     */
    public void keyPressed(KeyEvent e) {
        keybuffer[e.getKeyChar()] = true;
    }

    public void keyReleased(KeyEvent e) {
        keybuffer[e.getKeyChar()] = false;
    }

}
