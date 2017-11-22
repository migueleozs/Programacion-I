 
package frame;

import java.applet.AudioClip;
/**
 * 
 * @author ali.colmenares y miguel zamudio
 * sonido de las monedas cuando se destruye un enemigo
 */
public class Monedas {

    /**
     * Contructor por defecto
     */
    public Monedas() {
        
    }
    
    /**
     * Ingresamos el sonido para que se reprodusca
     */
    public void sonido(){
           AudioClip sonido;
       sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sound/moneda.wav"));
       sonido.play();
    }
    
    
}
