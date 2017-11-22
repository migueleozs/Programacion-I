
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
 * Para colocar la foto del medidor de gasolina
 */
public class Medidor {

    JLabel med = new JLabel();
    public static int ALTO = 150, ANCHO = 150;
    Point pos = new Point(-20, 23);

    /**
     * Contructor por defecto
     */
    public Medidor() {
        setTamaño();
        paint();
    }

    /**
     * Tamaño por defecto de las imagenes
     * y posicion
     */
    private void setTamaño() {
        med.setSize(ANCHO, ALTO);
        med.setLocation(pos);
    }

    /**
     * Ingreso la imagen de la gasolina como indicador
     */
    private void paint() {
        URL url = getClass().getResource("objetos/indicador.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(med.getWidth(), med.getHeight(), Image.SCALE_DEFAULT));
        med.setIcon(icon);
        med.repaint();
    }

}
