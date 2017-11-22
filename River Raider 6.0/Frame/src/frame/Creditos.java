/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ali.colmenares y miguel zamudio
 */


/**
 * 
 * Colocamos los creditos a traves de un JPanel y como una foto
 * 
 */
public class Creditos {

    JPanel panel;
    JLabel inst;
    Frame fra;
    JButton regresar;
    ventana vn;
    
    /**
     * 
     * @param fr frame que se pasa por la principal para que no se abran muchas
     * ventanas y se vea mas limpio
     */
    Creditos(Frame fr) {
        this.fra = fr;
        componentes();
        ventana();
        panel.setVisible(true);
        fr.frame.add(panel);
    }

    /**
     * Agregamos el JPanel 
     * y los botones de regreso para ir a ventana
     */
    private void componentes() {
       panel = new JPanel();
        GroupLayout grupo = new GroupLayout(panel);
        panel.setLayout(grupo);
        panel.setBackground(new Color(193, 205, 193));
        panel.setBounds(0, 0, 1000, 600);
        //Se agrega el boton para poder regresar a la pantalla de inicio
        panel.setLayout(null);
        regresar = new JButton("Regresar");
         Font str = new Font("arial", 22, 32);
        regresar.setFont(str);
        //Se le da las dimensiones como las coordenadas del boton
        regresar.setBounds(10, 50, 200, 50);
        panel.add(regresar);
        
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           panel.setVisible(false);
            fra.frame.remove(panel);
           vn = new ventana(fra);
            }
        });
    }

    /**
     * Foto de los creditos
     */
    private void ventana() {
         //las instrucciones son una imagen 
        inst = new JLabel();
        //se coloca que ocupe todo el frame
        inst.setBounds(0, 0, 1000, 580);
        URL url = getClass().getResource("inicio/creditos.png");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(inst.getWidth(), inst.getHeight(), inst.getHeight()));
        inst.setIcon(icon);
        inst.repaint();
        panel.add(inst);
    }
    
}
