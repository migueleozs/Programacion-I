
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
 */
public class Gasolina {
    JLabel gas = new JLabel();
    Point pos;
    public static int ALTO=100,ANCHO=100;
    Rectangle gasolina;

    /**
     * Contructor por defecto
     */
    public Gasolina() {
        this.pos = new Point(500, -400);        
        gasolina = new Rectangle(500, -400, ANCHO, ALTO);
        setTamaño();
        
        paint();
      
    }

    /**
     * Tamaño inicial de la imagen
     */
    private void setTamaño() {
        gas.setSize(ANCHO, ALTO);
        gas.setLocation(pos);
        
    }

    /**
     * Agregamos la imagen
     */
    private void paint() {
        URL url = getClass().getResource("objetos/gas.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(gas.getWidth(), gas.getHeight(), Image.SCALE_DEFAULT));
        gas.setIcon(icon);
        gas.repaint();
    }

    
    /**
     * 
     * @return regresamos la posicion de x para poder mover la imagen
     */
        public int posX() {
        return gas.getX();
    }

        /**
         * 
         * @return regresamos la posicion de y para poder mover la imagen
         */
    public int posY() {
        return gas.getY();
    }

    /**
     * 
     * @param x Para poder dar el area para las colisiones
     * @param y Para poder dar el area para las colisiones
     */
    void setPosicion(int x, int y) {
        gas.setLocation(x, y);
        gasolina.setBounds(x, y, (int)gasolina.getWidth(), (int)gasolina.getHeight());
    }

   
    

}
