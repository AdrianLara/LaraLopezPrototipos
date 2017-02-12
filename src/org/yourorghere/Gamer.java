/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;

/**
 *
 * @author PC
 */
public class Gamer {

    public float x;//Posicion x
    public float y;//Posicion y
    public float z;//Posicion z
    public float w;//Anchura
    public float h;//Altura
    public float v;//Velocidad
    public float r;//Rojo
    public float g;//Verde
    public float b;//Azul
    public float angle;//Angulo De Movimiento

    private GL gl;//Primivita GL
    public Cube cabeza;
    public Cube tronco;
    public Cube pierna1;
    public Cube pierna2;
    public Cube brazo1;
    public Cube brazo2;
    private Texture cara;

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
            //Se indica la localizacion de la figura                
            cara = TextureIO.newTexture(new File("src/org/yourorghere/images.jpg"), true);
            
        } catch (IOException e) {
            System.err.print("No se puede cargar textura" + e);
            System.exit(1);
        }
        cabeza = new Cube(gl, x, y, z, 2.8f * w, 30 * h, 2.0f * w, 0, r, g, b,cara);
        tronco = new Cube(gl, x, y, z, 2.0f * w, 26 * h, 1.8f * w, 0, r, g, b,cara);
        pierna1 = new Cube(gl, x, y, z, 0.6f * w, 24 * h, 1.7f * w, 0, r, g, b,cara);
        pierna2 = new Cube(gl, x, y, z, 0.6f * w, 24 * h, 1.7f * w, 0, r, g, b,cara);
        brazo1 = new Cube(gl, x, y, z, 0.3f * w, 24 * h, 1.7f * w, 0, r, g, b,cara);
        brazo2 = new Cube(gl, x, y, z, 0.3f * w, 24 * h, 1.7f * w, 0, r, g, b,cara);

        angle = 0.0f;
    }

    public void drawGamer() {
        cabeza.DrawCube();
        tronco.DrawCube();
        pierna1.DrawCube();
        pierna2.DrawCube();
        brazo1.DrawCube();
        brazo2.DrawCube();
    }

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

    public void avanzar() {

//        x += Math.cos(angle) * v;
//        z += Math.sin(angle) * v;
        if (!this.colision(x + (float) (Math.cos(angle) * v), z + (float) (Math.sin(angle) * v))) {
            x += Math.cos(angle) * v;
            z += Math.sin(angle) * v;
          
        }
    }

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

    public boolean colision(float nx, float nz) {
        boolean salida = false;
//        
        for (Cube l : FinalGame.l.paredesZ) {
            float umbralx = w / 2 + l.getW() / 2;
            float umbralz = w / 2+0.1f;
            salida = salida||(Math.abs(nx - l.getX()) < umbralx && (Math.abs(nz - l.getZ()) < umbralz));
        }
        for (Cube l : FinalGame.l.paredesX) {
            float umbralz = w / 2 + l.getD() / 2f;
            float umbralx = w / 2f+0.1f;
            salida = salida||(Math.abs(nx - l.getX()) < umbralx && (Math.abs(nz - l.getZ()) < umbralz));
        }
        return salida;
    }
}
