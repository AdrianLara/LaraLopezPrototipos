package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JOptionPane;

/**
 * Shutrun.java <BR> author: Brian Paul (converted to Java by Ron Cemer and Sven
 * Goethel)
 * <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class FinalGame implements GLEventListener {

    public Floor suelo;
    public static Gamer jugador;
    public static ArrayList<Enemies> enemigo;
    public static Enemies e1;
    public static Laberinto l;
    public static float cx;
    public static float cy;
    public static float cz;
    public static int option;

    public static void main() {

        Frame ventana = new Frame("JOGL app"); //Metodo clase Frame
        ventana.setSize(1000, 700);//Tama�o De La ventana
        ventana.addWindowListener(new WindowAdapter() { //Manejador de Ventanas Y Cerrar Ventana
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        GLCanvas canvas = new GLCanvas();//Objeto De tipo Canvas que me permite dibujar
        ventana.add(canvas);

        // Manejador De eventos canvas (Pertenece a la misma clase GLEventListener
        canvas.addGLEventListener(new FinalGame());

        //Crea Animacion
        //Crea objeto para que se ejecute 60 veces por segundo
        Animator animador = new FPSAnimator(canvas, 50);
        animador.add(canvas);
        animador.start();

        ventana.setVisible(true);//Visible la ventana

        //Manejador De pulsacion de teclas
        Keyboard keylistener = new Keyboard(canvas);
        canvas.addKeyListener(keylistener);

    }

    public void init(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glEnable(GL.GL_DEPTH_TEST);

        //Manejador Del Movimiento Del Mouse
        Mouse mouselistener = new Mouse();
        mouselistener.init(drawable);

        cx = 1f;
        cy = 10f;
        cz = 0f;
        option = 1;

        suelo = new Floor(gl, 0.7f, -0.3f, 0.7f, 11f, 1f, 0.0f, 1.0f, 0.0f);
        jugador = new Gamer(gl, 0, 0.4f, 2f, 0.03f, 0.01f, 0.01f, 1f, 1f, 1f);
        enemigo = new ArrayList<Enemies>();
        enemigo.add(new Enemies(gl, -1, 0.5f, 0.2f, 0.04f, 0.004f, 0.002f, 0f, 1f, 1f));
        enemigo.add(new Enemies(gl, 1.8f, 0.5f, 0.4f, 0.04f, 0.004f, 0.002f, 0f, 1f, 1f));
        enemigo.add(new Enemies(gl, 1.7f, 0.5f, -0.5f, 0.04f, 0.004f, 0.002f, 0f, 1f, 1f));
        enemigo.add(new Enemies(gl, 0.4f, 0.5f, -1.8f, 0.04f, 0.004f, 0.002f, 0f, 1f, 1f));
        enemigo.add(new Enemies(gl, -1.8f, 0.5f, -1.8f, 0.04f, 0.004f, 0.002f, 0f, 1f, 1f));
        enemigo.add(new Enemies(gl, -1f, 0.5f, 1.8f, 0.04f, 0.004f, 0.002f, 0f, 1f, 1f));
        l = new Laberinto(gl, 0.0f, 0.0f, 0f, 1f, 1f, 1, 0.5f, 0.4f, 0f);

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    public void update() {

        jugador.update();
        /* Iterator<Enemies> ite = enemigo.iterator();
         while (ite.hasNext()) {
         Enemies e = ite.next();
         e.update();
         if (e.colisionJugador()) {
         ite.remove();
                                   
         }
         if(enemigo.isEmpty()){
         JOptionPane.showMessageDialog(null, "YOU WIN");           
         }
         }*/

    }

    public void render(GLAutoDrawable drawable) {

        GL gl = drawable.getGL();
        GLU glu = new GLU();//Contiene funciones de mas alto nivel 
        gl.glMatrixMode(GL.GL_MODELVIEW);//Matriz para dibujar, matriz vista de modelo
        gl.glLoadIdentity(); //Matriz identidad para borrar
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); //Metodo Limpia la iterraccion anterior

        l.drawFloor();

        suelo.drawFloor();

        jugador.drawGamer();
        /*
         for (Enemies v : enemigo) {
         v.drawGamer();
         }*/

        //vista de camara
        gl.glMatrixMode(GL.GL_PROJECTION); //Matriz De Proyecciones
        gl.glLoadIdentity(); //Todas las perspectivas se representan medante matrices
        glu.gluPerspective(45f, 1f, 0.2f, 20f);
        switch (option) {

            case 1:
                glu.gluLookAt(cx, cy, cz, 0f, 0f, 0f, 0f, 1f, 0f);
                break;

            case 2:
                glu.gluLookAt(jugador.getX(), jugador.getY() - 0.1f, jugador.getZ(), jugador.getX() + Math.cos(jugador.angle) * 2.0f, jugador.getY(), jugador.getZ() + Math.sin(jugador.angle) * 2.0f, 0, 2, 0);
                break;

            default:
                System.out.println("Bienvenido");
                break;

        }

        glu.gluLookAt(cx, cy, cz, 0f, 0f, 0f, 0f, 1f, 0f);
        System.out.println(option);
        //glu.gluLookAt(3f, 3f, 3f, jugador.getX(), jugador.getY(), jugador.getZ(), 0f, 1f, 0f);
        //glu.gluLookAt(jugador.getX(), jugador.getY() - 0.1f, jugador.getZ(), jugador.getX() + Math.cos(jugador.angle) * 2.0f, jugador.getY(), jugador.getZ() + Math.sin(jugador.angle) * 2.0f, 0, 2, 0);
    }

    public void display(GLAutoDrawable drawable) {
        update();
        render(drawable);
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public float Random() {
        Random rand = new Random();
        float mirandom = rand.nextFloat();
        return ((mirandom * 2) - 1);
    }

    public float Random1() {
        Random rand = new Random();
        float mirandom = rand.nextFloat();
        return ((mirandom));
    }
}
