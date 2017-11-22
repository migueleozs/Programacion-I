
package frame;

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author ali.colmenares y miguel zamudio
 * Enemigos y objetos que apareceran en el mapa
 */

class Objetos {
    JLabel personaje = new JLabel();
    JLabel enemigo = new JLabel();
    Point pos2 = new Point(250, 0);
      Point posicion;
      public static int ALTO=80,ANCHO=80;
      Rectangle boat;
      Rectangle avion;

    Objetos(int x, int y) {
        this.posicion = new Point(50, -1000);
        boat = new Rectangle(50,40,x,y);
        avion = new Rectangle(0, 0, ANCHO, ALTO);
        setTamaño(x, y);
      
        paint();
        paint2();

    }

    /**
     * 
     * @param x Establesco un tamaño pasado por parametros del panel Central para x
     * @param y Establesco un tamaño pasado por parametros del panel Central para y
     */
    private void setTamaño(int x, int y) {
        personaje.setSize(x, y);
        enemigo.setSize(ANCHO,ALTO);
        personaje.setLocation(posicion);
        enemigo.setLocation(pos2);
    }

    /**
     * Ingreso el bote al mapa
     */
    private void paint() {
        URL url = getClass().getResource("objetos/boat.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(personaje.getWidth(), personaje.getHeight(), Image.SCALE_DEFAULT));
        personaje.setIcon(icon);
        personaje.repaint();
    }
    
    /**
     * Ingreso el avion enemigo al mapa
     */
    private void paint2() {
              URL url = getClass().getResource("objetos/Avion.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(enemigo.getWidth(), enemigo.getHeight(), Image.SCALE_DEFAULT));
        enemigo.setIcon(icon);
        enemigo.repaint();
    }

    
    /**
     * 
     * @param x Obtengo su posicion para poder darle movimiento en x
     * @param y Obtengo su posicion para poder darle movimiento en y
     * Y le doy posicion y tamaño para las colisiones
     */
    public void setPosicion(int x, int y) {
        personaje.setLocation(x, y);
        boat.setBounds(x, y,(int) boat.getWidth(),(int) boat.getHeight());
    }
    /**
     * 
     * @param x Obtengo su posicion para poder darle movimiento en x
     * @param y Obtengo su posicion para poder darle movimiento en y
     */
    public void setAvionPosicion(int x ,int y){
        enemigo.setLocation(x, y);
        avion.setBounds(x, y,(int) avion.getWidth(),(int) avion.getHeight());
    }

    /**
     * 
     * @return regresamos la poscion para poder darle movimiento para x
     */
    public int posX() {
        return personaje.getX();
    }

    /**
     * 
     * @return regresamos la poscion para poder darle movimiento para y
     */
    public int posY() {
        return personaje.getY();
    }

    /**
     * Aqui es para mover a el avion en este caso usaremos mas el getY en el
     * panel
     *
     * @return regresamos posicion
     */
    public int aposX() {
        return enemigo.getX();
    }

    /**
     * 
     * @return regresamos la poscion para poder darle movimiento para y
     */
    public int aposY() {
        return enemigo.getY();
    }

}
