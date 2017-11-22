
package frame;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ali.colmenares y miguel zamudio
 * Aqui agregamos alrededor del mapa el cesped para dar limitaciones
 * al igual damos un rectangle para detectar las colisioones
 */
public class Cesped {
    JLabel c = new JLabel();
    JLabel c2 = new JLabel();
    JLabel agua = new JLabel();
    Point p = new Point();
    Point p2 = new Point(800,0);
    Point p3 = new Point(0, 0);
    Rectangle a1;
    Rectangle a2;
    public static int ALTO=600, ANCHO=200;

    /**
     * contructor por defecto
     */
    public Cesped() {
        setPosicion();
        paint();
        paint2();
        paint3();
    }

    /**
     * Asigancion de la posicion inicial y tamaño
     */
    private void setPosicion() {
        c.setSize(ANCHO, ALTO);
        c2.setSize(ANCHO,ALTO);
        a1 = new Rectangle(0, 0, ANCHO, ALTO);
        a2 = new Rectangle(800, 0, ANCHO, ALTO);
        agua.setSize(1000,600);
        c2.setLocation(p2);
       agua.setLocation(p3);
       
    }

    /**
    * Agregamos la imagen del cesped
    */
    private void paint() {
       URL url = getClass().getResource("mundo/Grass2.jpg");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(c.getWidth(), c.getHeight(), Image.SCALE_DEFAULT));
        c.setIcon(icon);
        c.repaint();
    }

     /**
    * Agregamos la imagen del cesped
    */
    private void paint2() {
        URL url = getClass().getResource("mundo/Grass2.jpg");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(c2.getWidth(), c2.getHeight(), Image.SCALE_DEFAULT));
        c2.setIcon(icon);
        c2.repaint();
    }

    /**
     * Foto del agua 
     */
    private void paint3() {
          URL url = getClass().getResource("mundo/Agua2.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(agua.getWidth(), agua.getHeight(), Image.SCALE_DEFAULT));
        agua.setIcon(icon);
        agua.repaint();
    }
    
    
    
    
}
