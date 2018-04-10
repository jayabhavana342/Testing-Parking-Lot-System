import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;


import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import static com.jogamp.opengl.GL.GL_LINES;

class OneTriangle {
    protected static void setup(GL2 gl2, int width, int height) {
        gl2.glMatrixMode(GL2.GL_PROJECTION);
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D(0.0f, width, 0.0f, height);

        gl2.glMatrixMode(GL2.GL_MODELVIEW);
        gl2.glLoadIdentity();

        gl2.glViewport(0, 0, width, height);
    }

    protected static void render(GL2 gl, int width, int height) {
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        // draw a triangle filling the window
        gl.glLoadIdentity();
//        gl2.glBegin(GL.GL_TRIANGLES);
//        gl2.glColor3f(1, 0, 0);
//        gl2.glVertex2f(0, 0);
//        gl2.glColor3f(0, 1, 0);
//        gl2.glVertex2f(width, 0);
//        gl2.glColor3f(0, 0, 1);
//        gl2.glVertex2f(width / 2, height);
//        gl2.glEnd();

//        gl.glColor3f(3, 3, 3);
//        gl.glBegin(GL2.GL_QUADS);
//        gl.glVertex3f(0, (float) -0.001, 0);
//        gl.glVertex3f(0, (float) -0.001, 10);
//        gl.glVertex3f(10, (float) -0.001, 10);
//        gl.glVertex3f(10, (float) -0.001, 0);
//        gl.glEnd();

//        gl.glBegin(GL_LINES);
//        for (int i = 0; i <= 10; i++) {
//            if (i == 0) {
//                gl.glColor3f(1, 1, 1);
//            } else {
//                gl.glColor3f(1, 1, 1);
//            }
//            ;
//            gl.glVertex3f(i, 0, 0);
//            gl.glVertex3f(i, 0, 10);
//            if (i == 0) {
//                gl.glColor3f(1, 1, 1);
//            } else {
//                gl.glColor3f(1, 1, 1);
//            }
//            gl.glVertex3f(0, 0, i);
//            gl.glVertex3f(10, 0, i);
//        }
//
//        gl.glEnd();


        gl.glBegin(GL2.GL_LINES);
        gl.glColor3f(1.0f, 1.0f, 1.0f); // White (RGB)
        for (float x = 0; x < width; x += 1) {
            gl.glVertex3f(x, 0.0f, 0.0f);
            gl.glVertex3f(x, (width), 0.0f);
        }
        for (float y = 0; y < height; y += 1) {
            gl.glVertex3f(0.0f, y, 0.0f);
            gl.glVertex3f(width, y, 0.0f);
        }
        gl.glEnd();

    }
}

/**
 * A minimal program that draws with JOGL in an AWT Frame.
 *
 * @author Wade Walker
 */
class OneTriangleAWT {

    public static void main(String[] args) {
        GLProfile glprofile = GLProfile.get(GLProfile.GL2);
        GLCapabilities glcapabilities = new GLCapabilities(glprofile);
        final GLCanvas glcanvas = new GLCanvas(glcapabilities);

        glcanvas.addGLEventListener(new GLEventListener() {

            @Override
            public void reshape(GLAutoDrawable glautodrawable, int x, int y, int width, int height) {
                OneTriangle.setup(glautodrawable.getGL().getGL2(), width, height);
            }

            @Override
            public void init(GLAutoDrawable glautodrawable) {
            }

            @Override
            public void dispose(GLAutoDrawable glautodrawable) {
            }

            @Override
            public void display(GLAutoDrawable glautodrawable) {
                OneTriangle.render(glautodrawable.getGL().getGL2(), glautodrawable.getSurfaceWidth(), glautodrawable.getSurfaceHeight());

                final GL2 gl = glautodrawable.getGL().getGL2();
                gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
                gl.glEnable(GL2.GL_TEXTURE_2D);
                int textureId = 0;
                gl.glBindTexture(GL2.GL_TEXTURE_2D, textureId);
                gl.glPushMatrix();
                gl.glOrtho(0, 10, 0, 10, 0, 10);

                gl.glMatrixMode(GL2.GL_MODELVIEW);
                gl.glMatrixMode(GL2.GL_PROJECTION);
                gl.glPushMatrix();
                gl.glLoadIdentity();
                gl.glDepthMask(false);

                try {
                    File im2 = new File("F:\\jayabhavana342\\Parking-Lot-System\\images\\layout.png");
                    Texture t2 = TextureIO.newTexture(im2, true);
                    textureId = t2.getTextureObject(gl);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                gl.glBegin(GL2.GL_QUADS);
                gl.glTexCoord2f(0f, 0f);
                gl.glVertex2f(0, 0);
                gl.glTexCoord2f(0f, 1f);
                gl.glVertex2f(0, 10);
                gl.glTexCoord2f(1f, 1f);
                gl.glVertex2f(10, 10);
                gl.glTexCoord2f(1f, 0f);
                gl.glVertex2f(10, 0);
                gl.glEnd();

                gl.glDepthMask(true);
                gl.glPopMatrix();

//                gl.glPushMatrix();
//                gl.glLoadIdentity();
//                gl.glBegin(GL2.GL_POINTS);
//                for (float i = 0; i <= 10; ) {
//                    gl.glVertex2f(i, i);
//                    i += 0.01;
//                }
//                gl.glEnd();
//                gl.glPopMatrix();

                gl.glPushMatrix();
                gl.glLoadIdentity();
                gl.glPointSize( 6.0f);
                gl.glColor3f(0.0f,1.0f,0.0f);
                gl.glBegin(GL2.GL_POINTS);
                for (float i = 0; i < 10; ) {
                    for (float j = 1; j < 10;) {
                        gl.glVertex2f(i, j);
                        System.out.print("(" + i + " : " + j + ") ");
                        j = j + (float) 0.2;
                    }
                    System.out.println();
                    i = i + (float) 0.2;
                }
                gl.glEnd();
                gl.glPopMatrix();


            }
        });

        glcanvas.setSize(600, 800);

        final Frame frame = new Frame("One Triangle AWT");
        frame.add(glcanvas);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowevent) {
                frame.remove(glcanvas);
                frame.dispose();
                System.exit(0);
            }
        });

        frame.setSize(1240, 880);
        frame.setVisible(true);
    }
}