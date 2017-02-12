/*
 *@class Clase Gamer para la implementación de los diferentes actores en el juego
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;

/**
 * @Desarrollo de la clase Gamer
 * @author Lara_Lopez
 */
public class Gamer {

    public float x;
    public float y;
    public float z;
    public float w;
    public float h;
    public float v;
    public float r;
    public float g;
    public float b;
    public float angle;

    private GL gl;
    public Cube cabeza;
    public Cube tronco;
    public Cube pierna1;
    public Cube pierna2;
    public Cube brazo1;
    public Cube brazo2;
    private Texture cara;

    /**
     * @brief Constructor para la creación de los diferentes actores en el
     * escenario
     * @param gl Primitiva GL para la creación del actor
     * @param x Posición del Actor en X
     * @param y Posición del Actor en Y
     * @param z Posición del Actor en Z
     * @param w Ancho del Actor
     * @param h Altura del Actor
     * @param v Velocidad de movimiento del Actor
     * @param r Color en el canal R
     * @param g Color en el canal G
     * @param b Color en el canal B
     */
    public Gamer(GL gl, float x, float y, float z, float w, float h, float v, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.v = v;
        this.r = r;
        this.g = g;
        this.b = b;
        try {

            cara = TextureIO.newTexture(new File("src/Images/images.jpg"), true);

        } catch (IOException e) {
            System.err.print("No se puede cargar textura" + e);
            System.exit(1);
        }

        cabeza = new Cube(gl, x, y, z, 2.8f * w, 30 * h, 2.0f * w, 0, r, g, b, cara);
        tronco = new Cube(gl, x, y, z, 2.0f * w, 26 * h, 1.8f * w, 0, r, g, b, cara);
        pierna1 = new Cube(gl, x, y, z, 0.6f * w, 24 * h, 1.7f * w, 0, r, g, b, cara);
        pierna2 = new Cube(gl, x, y, z, 0.6f * w, 24 * h, 1.7f * w, 0, r, g, b, cara);
        brazo1 = new Cube(gl, x, y, z, 0.3f * w, 24 * h, 1.7f * w, 0, r, g, b, cara);
        brazo2 = new Cube(gl, x, y, z, 0.3f * w, 24 * h, 1.7f * w, 0, r, g, b, cara);
        angle = 0.0f;
    }

    /**
     * @brief Método drawgamer para la implementación y renderización del Actor
     * creado
     *
     * Es creado a partir de objetos tipo Cube que dan la forma de un humano al
     * objeto Actor
     */
    public void drawGamer() {
        cabeza.DrawCube();
        tronco.DrawCube();
        pierna1.DrawCube();
        pierna2.DrawCube();
        brazo1.DrawCube();
        brazo2.DrawCube();
    }

    /**
     * @brief Método update para la actualización de las posiciones del Actor
     */
    public void update() {
        cabeza.x = x;
        cabeza.y = y - 0.22f;
        cabeza.z = z;
        tronco.x = x;
        tronco.y = y - 0.32f;
        tronco.z = z;
        brazo1.x = x - w - 0.01f;
        brazo1.y = y - 0.34f;
        brazo1.z = z;
        brazo2.x = x + w + 0.01f;
        brazo2.y = y - 0.34f;
        brazo2.z = z;
        pierna1.x = x - w + 0.02f;
        pierna1.y = y - h - 0.4f;
        pierna1.z = z;
        pierna2.x = x + w - 0.03f;
        pierna2.y = y - h - 0.4f;
        pierna2.z = z;
        cabeza.setAngle((float) (-angle * (180 / Math.PI)) + 90);

    }

    /**
     * @brief Método avanzar para controlar los movimientos lineales hacia
     * adelante del Actor
     */
    public void avanzar() {

        if (!this.colision(x + (float) (Math.cos(angle) * v), z + (float) (Math.sin(angle) * v))) {
            x += Math.cos(angle) * v;
            z += Math.sin(angle) * v;

        }
    }

    /**
     * @brief Método avanzar para controlar los movimientos lineales hacia atrás
     * del Actor
     */
    public void retroceder() {

        if (!this.colision(x - (float) (Math.cos(angle) * v), z - (float) (Math.sin(angle) * v))) {
            x -= Math.cos(angle) * v;
            z -= Math.sin(angle) * v;
        }
    }

    public void izquierda() {
        angle -= 0.05f;
        //z += v;
    }

    public void derecha() {
        angle += 0.05f;
        //z -= v;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    /**
     * @brief Método para detectar las colisiones entre los diferentes objetos
     * del escenario
     * @param nx Umbral de choque en el eje X
     * @param nz Umbral de choque en el eje Y
     * @return Valor de verdad para definir acciones posteriores
     */
    public boolean colision(float nx, float nz) {
        boolean salida = false;
        for (Cube l : FinalGame.l.paredesZ) {
            float umbralx = w / 2 + l.getW() / 2;
            float umbralz = w / 2 + 0.1f;
            salida = salida || (Math.abs(nx - l.getX()) < umbralx && (Math.abs(nz - l.getZ()) < umbralz));
        }
        for (Cube l : FinalGame.l.paredesX) {
            float umbralz = w / 2 + l.getD() / 2f;
            float umbralx = w / 2f + 0.1f;
            salida = salida || (Math.abs(nx - l.getX()) < umbralx && (Math.abs(nz - l.getZ()) < umbralz));
        }
        return salida;
    }
}
