
package frame;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author ali.colmenares
 */

//Aqui se establecen las imagenes como la del avion
//o en otras palabras se suben al java
class Imagenes {

    JLabel personaje = new JLabel();
    //Coloco a mi personaje en una posicion dada
      Point posicion = new Point(400,450);
    private final int pos = 1;
    public static int ALTO=100,ANCHO=100;
    Rectangle area;

    /**
     * 
     * @param x Tamaño de ANCHO
     * @param y tamaño de ALTO
     */
    Imagenes(int x, int y) {
        setTamaño(x, y);
        area = new Rectangle(400,450,x,y);
       paint();
       
    }


    
    /**
     * 
     * @param x para dar tamaño en x
     * @param y para dar tamaño en Y
     */
    private void setTamaño(int x, int y) {
        personaje.setSize(ALTO, ANCHO);
        personaje.setLocation(posicion);
    }

    /**
     * Subo la imagen del avion
     */
    private void paint() {
    
        URL url = getClass().getResource("imagen/Avion.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(personaje.getWidth(), personaje.getHeight(), Image.SCALE_DEFAULT));
        personaje.setIcon(icon);
        personaje.repaint();

    }

   
   /**
    * 
    * @param x Pasa la posicion del avion para x
    * @param y como en Y
    * Y el area setbound coloca el cuadro el cual detectara colisiones
    */ 
    public void setPosicion(int x, int y) {    
        personaje.setLocation(x, y);
        area.setBounds(x, y,(int) area.getWidth(),(int) area.getHeight());
    }

    /**
     * 
     * @return regresamos la posicion de x para poder mover la imagen
     */
    public int posX() {
        return personaje.getX();
    }

    /**
     * 
     * @return regresamos la posicion de y para poder mover la imagen
     */
    public int posY() {
        return personaje.getY();
    }

  
}
