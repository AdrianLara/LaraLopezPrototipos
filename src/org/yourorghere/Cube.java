/**
 * @brief Clase Cube que es una optimizacion para la gráfica de un cubo en OpenGL
 */
package org.yourorghere;

import javax.media.opengl.GL;
import java.io.File;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.IOException;

/**
 * @brief Desarrollo de la clase Cube
 * @author Lara_Lopez
 */
public class Cube {

    private GL gl;
    public float x;
    public float y;
    public float z;
    private float w;
    private float h;
    private float d;
    private float r;
    private float g;
    private float b;
    private float angle;
    private Texture cara;
    
    /**
     * @brief Cube es un constructor que recibe varios parámetros para la implementacion de nuevos
     * objetos con dichas características que nos ayudarán en la generación de objetos 3D
     * @param gl Objeto Gl para los gráficos
     * @param x Posición en x
     * @param y Posición en y
     * @param z Posición en z
     * @param w Anchura del objeto
     * @param h Altura del objeto
     * @param d Espesor del objeto
     * @param angle Angulo de dirección
     * @param r Color canal R
     * @param g Color canal G
     * @param b Color canal B
     * @param cara Elemento para texturizar
     * 
     */
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
    }

    /**
     * @brief Método DrawCube que dibuja una nueva figura tipo cubo de acuerdo a las especificaciones
     * del constructor
     * @param a 
     * @return Figura 3D tipo cubo
     */
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
