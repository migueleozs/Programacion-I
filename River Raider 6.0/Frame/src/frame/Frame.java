package frame;

import java.awt.Color;
import javax.swing.JFrame;
import java.applet.AudioClip;
import javax.swing.ImageIcon;


/**
 *
 * @author ali.colmenares miguel zamudio
 * Clase principal
 */
 //Clase principal
public class Frame {

    JFrame frame;
    Archivo ar;
    ventana vn;
    panel pn;


    /**
     * Inicializo mi frame
     */
    public Frame() {
       AudioClip sonido;
      sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sound/Menu.wav"));
       sonido.loop();
       
              
        frame = new JFrame("River Raider");
         frame.setIconImage(new ImageIcon(getClass().getResource("objetos/boat.png")).getImage()); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,600);
        frame.getContentPane().setBackground(new Color(0,191,255));
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);     
      
        
        /**
         * Mando a ventana el frame por defecto de todas las clases
         */
         vn = new ventana(this);
        
      
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
     
        
    }
      
   /**
    * 
    * @param args Main del juego
    */
    public static void main(String[] args) {
        Frame f = new Frame();
        
        
    }
    
}
