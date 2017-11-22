
package frame;

import java.awt.Image;
import java.awt.Point;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * @author ali.colmenares y miguel zamudio
 * aqui las casas se moveran hacia abajo dando el efecto de que el mapa se mueve
 */
public class Casas {
    JLabel casa1 = new JLabel();
    JLabel casa2 = new JLabel();
    JLabel arbol= new JLabel();
    
     JLabel casa3 = new JLabel();
    JLabel casa4 = new JLabel();
    JLabel arbol2= new JLabel();
    
    Point p = new Point(0,20);
    Point p2 = new Point(0,300);
    Point p3= new Point(40,450);
    
    Point l = new Point(820,20);
    Point l2 = new Point(820,300);
    Point l3= new Point(810,450);
    
    public static int ALTO = 100, ANCHO =130;

    /**
     * EN ESTA CLASA SE COLOCARAN LOS OBJETOS QUE IRAN ALREDEDOR DEL AVION PARA DAR
     * SENTIMIENTO DE QUE EL MAPA ES EL QUE ESTA MOVIENDOSE
     */
    public Casas() {
        setPosicion();
        paint();
        paint2();
        paint3();
        paint4();
        paint5();
        paint6();

    }

    /**
     * Colocamos una posicion y tamaño por defecto a cada casa
     */
    private void setPosicion() {
        casa1.setSize(ANCHO, ALTO);
        casa2.setSize(ANCHO, ALTO);
        arbol.setSize(ANCHO, ALTO);
    
        casa3.setSize(ANCHO, ALTO);
        casa4.setSize(ANCHO, ALTO);
        arbol2.setSize(ANCHO, ALTO);
        
        casa1.setLocation(p);
        casa2.setLocation(p2);
        arbol.setLocation(p3);
        
        casa4.setLocation(l);
        casa3.setLocation(l2);
        
        
    }
   /**
    * Agregamos la imagen de una casa
    */
    private void paint() {
           URL url = getClass().getResource("mundo/Casa.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(casa1.getWidth(), casa1.getHeight(), Image.SCALE_DEFAULT));
        casa1.setIcon(icon);
        casa1.repaint();
    }
    //Posicion inicial en x y en Y
    public int posX() {
        return casa1.getX();
    }

    public int posY() {
        return casa1.getY();
    }
    //AQUI EN DONDE SE MODIFICARA EN EL TIMER 
    /**
     * 
     * @param x llega los parametros si se modifica x oY
     * @param y en esta caso para las casas solo se modificara Y ya que solo bajan
     */
    void setPosicion(int x, int y) {
        casa1.setLocation(x, y);

    }

    /**
    * Agregamos la imagen de una casa
    */
    private void paint2() {
         URL url = getClass().getResource("mundo/Casa2.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(casa2.getWidth(), casa2.getHeight(), Image.SCALE_DEFAULT));
        casa2.setIcon(icon);
        casa2.repaint();
    }

    
        public int xposX() {
        return casa2.getX();
    }

    public int xposY() {
        return casa2.getY();
    }
    
    void xsetPosicion(int x, int y) {
        casa2.setLocation(x, y);
       
    }

    /**
    * Agregamos la imagen de una casa
    */
    private void paint3() {
          URL url = getClass().getResource("mundo/tree.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(arbol.getWidth(), arbol.getHeight(), Image.SCALE_DEFAULT));
         arbol.setIcon(icon);
        arbol.repaint();
    }
    
     
        public int aposX() {
        return arbol.getX();
    }

    public int aposY() {
        return arbol.getY();
    }
    
    void asetPosicion(int x, int y) {
        arbol.setLocation(x, y);
       
    }

    /**
    * Agregamos la imagen de una casa
    */
    private void paint4() {
         URL url = getClass().getResource("mundo/Casa2.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(casa4.getWidth(), casa4.getHeight(), Image.SCALE_DEFAULT));
        casa4.setIcon(icon);
        casa4.repaint();
    }
    
       public int dposX() {
        return casa4.getX();
    }

    public int dposY() {
        return casa4.getY();
    }
    
      void dsetPosicion(int x, int y) {
        casa4.setLocation(x, y);

    }

      /**
    * Agregamos la imagen de una casa
    */
    private void paint5() {
          URL url = getClass().getResource("mundo/Casa.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(casa3.getWidth(), casa3.getHeight(), Image.SCALE_DEFAULT));
        casa3.setIcon(icon);
        casa3.repaint();
    }
          public int d1posX() {
        return casa3.getX();
    }

    public int d1posY() {
        return casa3.getY();
    }
    
      void d1setPosicion(int x, int y) {
        casa3.setLocation(x, y);

    }
    

      /**
    * Agregamos la imagen de una arbol
    */
    private void paint6() {
          URL url = getClass().getResource("mundo/tree.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(arbol2.getWidth(), arbol2.getHeight(), Image.SCALE_DEFAULT));
         arbol2.setIcon(icon);
        arbol2.repaint();
    }
     
           public int d2posX() {
        return arbol2.getX();
    }

    public int d2posY() {
        return arbol2.getY();
    }
    
      void d2setPosicion(int x, int y) {
        arbol2.setLocation(x, y);

    }
}
