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
public class Floor {
    private float x;
    private float y;
    private float z;
    private float w;
    private float h;
    private float r;
    private float g;
    private float b;
    private GL gl;
    public Cube piso;
    private Texture cara;


    public Floor(GL gl,float x, float y,float z, float w, float h, float r, float g, float b) {
        this.gl=gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
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
        piso = new Cube(gl,x,y,z,w,h/1000,w-3.5f,0,r,g,b,cara);
        
        
    }
    
    public void drawFloor(){
        
        piso.DrawCube();    
}
}
