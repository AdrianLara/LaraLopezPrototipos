/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import javax.media.opengl.GL;
import java.io.File;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class Cube {

    private GL gl;
    public float x;
    public float y;
    public float z;
    private float w;//ANCHURA
    private float h;//ALTURA
    private float d;//PROFUNDIDAD
    private float r;//ROJO
    private float g;//VERDE
    private float b;//AZUL
    private float angle;//ANGULO ROTACION
//    private Texture cara1, cara2, cara3, cara4, cara5, cara6;
    private Texture cara;
    public Cube(GL gl, float x, float y, float z, float w, float h, float d, float angle, float r, float g, float b, Texture cara) {

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
        this.angle = angle;
        this.cara=cara;
//        try {
//            //Se indica la localizacion de la figura                
//            cara1 = TextureIO.newTexture(new File("src/org/yourorghere/images.jpg"), true);
//            cara2 = TextureIO.newTexture(new File("src/org/yourorghere/images.jpg"), true);
//            cara3 = TextureIO.newTexture(new File("src/org/yourorghere/images.jpg"), true);
//            cara4 = TextureIO.newTexture(new File("src/org/yourorghere/images.jpg"), true);
//            cara5 = TextureIO.newTexture(new File("src/org/yourorghere/images.jpg"), true);
//            cara6 = TextureIO.newTexture(new File("src/org/yourorghere/images.jpg"), true);
//        } catch (IOException e) {
//            System.err.print("No se puede cargar textura" + e);
//            System.exit(1);
//        }
    }

    public void DrawCube(float a) {

        gl.glPushMatrix();
        gl.glTranslatef(x, y, z); //traslada el eje de puntos al centro
        gl.glRotatef(angle, 0, 1, 0);//Rotate(grados,vectores unitarios en el sentido que quiero que gire) 
        gl.glTranslatef(-x, -y, -z);  //Me permite volver al origen

        cara.enable();//habilitamos
        cara.bind();//pegamos
        gl.glBegin(GL.GL_QUADS); //Cara Frontal
        gl.glColor3f(r, g, b);

        
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(x - w / 2, y + h / 2, z - d / 2);

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(x - w / 2, y - h / 2, z - d / 2);

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(x + w / 2, y - h / 2, z - d / 2);

        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glEnd();
        cara.disable();

        cara.enable();
        cara.bind();
        gl.glBegin(GL.GL_QUADS); //Cara atras
        gl.glColor3f(r, g, b);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(x - w / 2, y + h / 2, z + d / 2);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(x - w / 2, y - h / 2, z + d / 2);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(x + w / 2, y - h / 2, z + d / 2);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(x + w / 2, y + h / 2, z + d / 2);
        gl.glEnd();
        cara.disable();

        cara.enable();
        cara.bind();
        gl.glBegin(GL.GL_QUADS); //Cara izquiera
        gl.glColor3f(r, g, b);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(x - w / 2, y + h / 2, z - d / 2);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(x - w / 2, y - h / 2, z - d / 2);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(x - w / 2, y - h / 2, z + d / 2);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(x - w / 2, y + h / 2, z + d / 2);
        gl.glEnd();
        cara.disable();

        cara.enable();
        cara.bind();
        gl.glBegin(GL.GL_QUADS); //Cara derecha
        gl.glColor3f(r, g, b);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(x + w / 2, y - h / 2, z - d / 2);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(x + w / 2, y - h / 2, z + d / 2);
        gl.glTexCoord2f(1 , 0);
        gl.glVertex3f(x + w / 2, y + h / 2, z + d / 2);
        gl.glEnd();
        cara.disable();

        cara.enable();
        cara.bind();
        gl.glBegin(GL.GL_QUADS); //Cara arriba
        gl.glColor3f(r, g, b);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(x - w / 2, y + h / 2, z - d / 2);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(x + w / 2, y + h / 2, z + d / 2);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(x - w / 2, y + h / 2, z + d / 2);
        gl.glEnd();
        cara.disable();
        
        cara.enable();
        cara.bind();
        gl.glBegin(GL.GL_QUADS); //Cara abajo
        gl.glColor3f(r, g, b);
        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(x - w / 2, y - h / 2, z - d / 2);
        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(x + w / 2, y + h / 2, z - d / 2);
        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(x + w / 2, y - h / 2, z + d / 2);
        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(x - w / 2, y - h / 2, z + d / 2);

        gl.glEnd();
        cara.disable();

        gl.glPopMatrix();
    }

    public void DrawCube() {
        DrawCube(0);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getX() {
        return x;
    }

    public float getW() {
        return w;
    }

    public float getZ() {
        return z;
    }
    public float getD(){
        return d;
    }
}
