/*
 *@brief Clase laberinto para la generación del escenario del Juego de Video 
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.media.opengl.GL;

/**
 * @brief Desarrollo de la clase Laberinto
 * @author Lara_Lopez
 */
public class Laberinto {

    private float x;
    private float y;
    private float z;
    private float w;
    private float h;
    private float d;
    private float r;
    private float g;
    private float b;
    private GL gl;
    public Cube piso, p1, p2, p3, p4, p41;
    public Cube pz1, pz2, pz3, pz4, pz5, pz6, pz7;
    public Cube p1z, p2z, p3z, p4z, p5z, p6z, p7z, p8z;
    public Cube px1, px2, px3, px4, px5, px6;
    public Cube p1x, p2x, p3x, p4x, p5x, p6x, p7x, p8x;
    public ArrayList<Cube> paredesX;
    public ArrayList<Cube> paredesZ;
    private Texture floor, paredes, cerramiento;

    /**
     * @brief Constructor para la generación de un laberinto a manera de
     * escenario
     * @param gl Primitiva GL para la construcción del escenario
     * @param x Posición del escenario en X
     * @param y Posición del escenario en Y
     * @param z Posición del escenario en Z
     * @param w Ancho de las paredes del escenario
     * @param h Altura de las paredes del escenario
     * @param d Espesor de las paredes del escenario
     * @param r Color canal R
     * @param g Color canal G
     * @param b Color canal B
     */
    public Laberinto(GL gl, float x, float y, float z, float w, float h, float d, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.r = r;
        this.g = g;
        this.b = b;
        try {
            floor = TextureIO.newTexture(new File("src/Images/fondo.jpg"), true);
            paredes = TextureIO.newTexture(new File("src/Images/paredes.jpg"), true);
            cerramiento = TextureIO.newTexture(new File("src/Images/cerramiento.jpg"), true);

        } catch (IOException e) {
            System.err.print("No se puede cargar textura" + e);
            System.exit(1);
        }
        /**
         * Generación de los límites del escenario
         */
        piso = new Cube(gl, x, y, z, w * 4, h / 5, d * 4, 0, 0.4f, 0.3f, 0.2f, floor);
        p1 = new Cube(gl, x - w * 2f, y + h / 2, z, w / 20, h, d * 4, 0, 0.4f, 0.3f, 0f, cerramiento);  //paredes laterales contorno
        p2 = new Cube(gl, x, y + h / 2, z - d * 2, w * 4, h, d / 20, 0, 0.4f, 0.3f, 0.01f, cerramiento);
        p3 = new Cube(gl, x + w * 2, y + h / 2, z, w / 20, h, d * 4, 0, 0.4f, 0.3f, 0f, cerramiento);
        p4 = new Cube(gl, x - 1.2f, y + h / 2, z + d * 2, w * 1.6f, h, d / 20, 0, 0.4f, 0.3f, 0.01f, cerramiento);
        p41 = new Cube(gl, x + 1.2f, y + h / 2, z + d * 2, w * 1.6f, h, d / 20, 0, 0.4f, 0.3f, 0.01f, cerramiento);

        /**
         * Paredes laterales parte superior 
         */
        pz1 = new Cube(gl, x - 1.3f, y + h / 2, z + 1.3f, w * 1.4f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        pz2 = new Cube(gl, x - 1.3f, y + h / 2, z + 1f, w / 2, h, d / 20, 0, 0, 0.5f, 0, paredes);
        pz3 = new Cube(gl, x - 1.3f, y + h / 2, z + 0.5f, w * 0.6f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        pz4 = new Cube(gl, x - 1.1f, y + h / 2, z, w + 0.2f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        pz5 = new Cube(gl, x - 0.75f, y + h / 2, z - 0.5f, w + 0.5f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        pz6 = new Cube(gl, x - 0.6f, y + h / 2, z - 0.8f, w * 0.6f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        pz7 = new Cube(gl, x - 1.2f, y + h / 2, z - 1f, w * 0.6f, h, d / 20, 0, 0, 0.5f, 0, paredes);

        /**
         * Paredes laterales parte Inferior 
         */
        p1z = new Cube(gl, x + 1.2f, y + h / 2, z + 1.5f, w + 0.5f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        p2z = new Cube(gl, x + 1.5f, y + h / 2, z + 1f, w / 2f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        p3z = new Cube(gl, x + 0.75f, y + h / 2, z + 0.25f, w * 1.5f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        p4z = new Cube(gl, x + 1.6f, y + h / 2, z - 0.25f, w * 0.8f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        p5z = new Cube(gl, x + 0.5f, y + h / 2, z - 0.25f, w * 0.5f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        p6z = new Cube(gl, x + 0.5f, y + h / 2, z - 1f, w * 1.5f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        p7z = new Cube(gl, x + 0.2f, y + h / 2, z - 1.5f, w * 1.5f, h, d / 20, 0, 0, 0.5f, 0, paredes);
        p8z = new Cube(gl, x + 1.5f, y + h / 2, z - 1.5f, w / 2f, h, d / 20, 0, 0, 0.5f, 0, paredes);

       /**
         * Paredes horizontales parte superior 
         */       
        px1 = new Cube(gl, x - 0.6f, y + h / 2, z + 0.6f, w / 20, h, d * 1.2f, 0, 1f, 1f, 0f, paredes);
        px2 = new Cube(gl, x - 1.6f, y + h / 2, z + 0.4f, w / 20, h, d * 1.2f, 0, 1f, 1f, 0f, paredes);
        px3 = new Cube(gl, x - 1.5f, y + h / 2, z - 0.8f, w / 20, h, d * 0.6f, 0, 1f, 1f, 0f, paredes);
        px4 = new Cube(gl, x - 0.9f, y + h / 2, z - 1.4f, w / 20, h, d + 0.2f, 0, 1f, 1f, 0f, paredes);
        px5 = new Cube(gl, x, y + h / 2, z + 0.5f, w / 20, h, d * 2, 0, 1f, 1f, 0f, paredes);

        /**
         * Paredes horizontales parte inferior 
         */
        p1x = new Cube(gl, x + 0.75f, y + h / 2, z + 1.1f, w / 20, h, d * 1.1f, 0, 1f, 1f, 0f, paredes);
        p2x = new Cube(gl, x + 1.4f, y + h / 2, z + 0.8f, w / 20, h, d / 2, 0, 1f, 1f, 0f, paredes);
        p3x = new Cube(gl, x + 0.3f, y + h / 2, z - 0.25f, w / 20, h, d / 2, 0, 1f, 1f, 0f, paredes);
        p4x = new Cube(gl, x + 1f, y + h / 2, z - 0.6f, w / 20, h, d, 0, 1f, 1f, 0f, paredes);
        p5x = new Cube(gl, x - 0.1f, y + h / 2, z - 1.6f, w / 20, h, d * 0.8f, 0, 1f, 1f, 0f, paredes);
        p6x = new Cube(gl, x + 1.8f, y + h / 2, z - 1.6f, w / 20, h, d * 0.8f, 0, 1f, 1f, 0f, paredes);

        paredesX = new ArrayList<Cube>();
        paredesX.add(px1);
        paredesX.add(px2);
        paredesX.add(px3);
        paredesX.add(px4);
        paredesX.add(px5);
        paredesX.add(p1x);
        paredesX.add(p2x);
        paredesX.add(p3x);
        paredesX.add(p4x);
        paredesX.add(p5x);
        paredesX.add(p6x);
        paredesX.add(p1);
        paredesX.add(p3);

        paredesZ = new ArrayList<Cube>();
        paredesZ.add(pz1);
        paredesZ.add(pz2);
        paredesZ.add(pz3);
        paredesZ.add(pz4);
        paredesZ.add(pz5);
        paredesZ.add(pz6);
        paredesZ.add(pz7);
        paredesZ.add(p1z);
        paredesZ.add(p2z);
        paredesZ.add(p3z);
        paredesZ.add(p4z);
        paredesZ.add(p5z);
        paredesZ.add(p6z);
        paredesZ.add(p7z);
        paredesZ.add(p8z);
        paredesZ.add(p2);
        paredesZ.add(p4);
        paredesZ.add(p41);

    }
    
    /**
     * Método para dibujar el escenario
     */
    public void drawLaberinto() {
        for (Cube v : paredesX) {
            v.DrawCube();
        }
        for (Cube v : paredesZ) {
            v.DrawCube();
        }
        piso.DrawCube();

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

    public float getW() {
        return w;
    }
}
