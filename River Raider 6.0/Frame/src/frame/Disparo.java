
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
 * Agregamos con una foto los diparos y colocamos un rectangle para 
 * detectar colisiones con el usuario
 */
class Disparo {

    public static int ALTO = 30, ANCHO = 30;
    JLabel disparo = new JLabel();
    Point p = new Point();
    Rectangle re;

    /**
     * 
     * @param x Posicion por defecto de las balas que se le dara al usuario y no salgan por otro lado
     * @param y Posicion para Y
     */
    Disparo(int x, int y) {
        setTamaño();
        setPosicion(x, y);
        re = new Rectangle(x, y, ALTO, ANCHO);
        paint();
    }

    /**
     * Tamaño de la bala
     */
    private void setTamaño() {
        disparo.setSize(ANCHO, ALTO);
    }

    /**
     * 
     * @param x Posicion para x para generar movimiento
     * @param y  Posicion para y
     */
    public void setPosicion(int x, int y) {
        disparo.setLocation(x, y);
      
    }

    /**
     * Imagen del laser
     */
    private void paint() {
      URL url = getClass().getResource("objetos/laser.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(disparo.getWidth(), disparo.getHeight(), Image.SCALE_DEFAULT));
        disparo.setIcon(icon);
        disparo.repaint();
    }
    
    /**
     * 
     * @return Regresamos x para mover el disparo
     */
     public int getX() {
        return disparo.getX();
    }

     /**
      * 
      * @return Regresamos y para mover el disparo
      */
    public int getY() {
        return disparo.getY();
    }
    
    

}
