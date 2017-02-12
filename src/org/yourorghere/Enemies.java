/*
 * @brief Clase Enemies que hereda de la clase Gamer todas las funciones
 */
package org.yourorghere;

import java.util.Random;
import javax.media.opengl.GL;

/**
 * @brief Desarrollo de la clase Enemies
 * @author Lara_Lopez
 */
public class Enemies extends Gamer {

    /**
     * @brief Enemies es un constructor que recibe parametros heredados de la
     * clase Gamer
     *
     * @param gl Objeto Gl para los gráficos
     * @param x Posición en x
     * @param y Posición en y
     * @param z Posición en z
     * @param w Anchura del objeto
     * @param h Altura del objeto
     * @param r Color canal R
     * @param g Color canal G
     * @param b Color canal B
     *
     */
    public Enemies(GL gl, float x, float y, float z, float w, float h, float v, float r, float g, float b) {
        super(gl, x, y, z, w, h, v, r, g, b);
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setG(float g) {
        this.g = g;
    }

    public void setB(float b) {
        this.b = b;
    }

    /**
     * @brief Método perseguir definido para seguir a un objeto recibido como
     * parámetro
     * @param g1
     */
    public void perseguir(Gamer g1) {

        if (x < g1.getX()) {
            x += v;
        } else {
            x -= v;
        }

        if (z < g1.getZ()) {
            z += v;
        } else {
            z -= v;
        }

    }

    public float Random() {
        Random rand = new Random();
        float mirandom = rand.nextFloat();
        return ((mirandom * 2) - 1) / 100;
    }

    /**
     * @brief Método colisionJugador para comprobar el momento en que dos
     * objetos chocan
     * @return Verdadero o Falso según sea la colisión
     */
    public boolean colisionJugador() {
        boolean salida = false;
        float umbral = 0;

        umbral = 0.1f;
        salida = salida || (Math.abs(x - FinalGame.jugador.getX()) < umbral && Math.abs(z - FinalGame.jugador.getZ()) < umbral);

        return salida;

    }
}
