/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import java.util.Random;
import javax.media.opengl.GL;

/**
 *
 * @author PC
 */
public class Enemies extends Gamer {

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

    public boolean colisionJugador() {
        boolean salida = false;
        float umbral = 0;

        umbral = 0.1f;
        salida = salida || (Math.abs(x - FinalGame.jugador.getX()) < umbral && Math.abs(z - FinalGame.jugador.getZ()) < umbral);

        return salida;

    }
}
