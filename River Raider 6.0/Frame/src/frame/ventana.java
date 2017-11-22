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
import java.io.IOException;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author Ali Colmenares y Miguel Zamudio
 * Clase que crea la "ventana" del menu
 */
class ventana {
    //JFrame fr;
    Ten diez;
    Frame fr;
    JLabel fondo,inst, banner;
    JPanel panel;
    JButton ins,star,score,cred,salir,top;
    JTextField f1;
    public static String nombre;
    panel lp;
    inst in;
    Top t;
    Archivo arch;
    Creditos cre;
    Ten aa;
  
/**
 * 
 * @param frame Constructor por parametro para añadir al frame principal
 */
    public ventana(Frame frame) {
        this.fr = frame;
        componentes();
        frame.frame.add(panel);
        fondo();
    }

   
/**
 * metodo para iniciar todos los componentes del panel
 */

    private void componentes() {
        panel = new JPanel();
        GroupLayout grupo = new GroupLayout(panel);
        panel.setLayout(grupo);
        panel.setBackground(new Color(193,205,193));
        panel.setBounds(0, 0, 1000, 600);
        //Agrego los botones
          panel.setLayout(null);
          
         star = new JButton("JUGAR");
        Font str = new Font("arial", 22, 32);
        star.setFont(str);
        star.setBounds(50, 450, 180, 50);
        
      
        ins = new JButton("Instrucciones");
         Font x = new Font("arial", 12, 26);
        ins.setFont(x);
        ins.setBounds(230, 450, 200, 50);
              
        
        cred = new JButton("Creditos");
        Font c = new Font("arial", 22, 32);
        cred.setFont(c);
        cred.setBounds(420, 450, 180, 50);
        
         
        top = new JButton("TOP 10");
        Font c3 = new Font("arial", 22, 32);
        top.setFont(c3);
        top.setBounds(590,450, 180, 50);
        
        salir = new JButton("Salir");
        Font c2 = new Font("arial", 22, 32);
        salir.setFont(c2);
        salir.setBounds(750, 450, 180, 50);
       
        f1 = new JTextField("User");
       Font f = new Font("arial",10,22);
       f1.setFont(f);      
       f1.setBounds(600, 50, 300,70);
       f1.setBackground(Color.WHITE);
       
       URL url2 = getClass().getResource("inicio/poster.png");
        ImageIcon imagen2 = new ImageIcon(url2);
        Icon icono = new ImageIcon(imagen2.getImage().getScaledInstance(300, 168, 300));
       banner = new JLabel(icono);
       banner.setBounds(75, 25, icono.getIconWidth(), icono.getIconHeight());
       
   
       panel.add(f1);
        panel.add(star);
        panel.add(ins);
         panel.add(cred);
         panel.add(salir);
         panel.add(top);
        panel.add(banner);

        
        star.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    panel.setVisible(false);
                    fr.frame.remove(panel);
                    
                    /**
                     * Se usa el constructor de la clase panel
                     * manda por parametros el frame donde sera añadido
                     */
                    
                    fr.pn = new panel(fr.frame);
                    String nombre = f1.getText()+"          ".substring(0, 8);
                    arch = new Archivo(nombre);
                } catch (IOException ex) {
                   
                }
            }


        });
        
        /**
         * Indico la accion de que si oprime un boton me manda a las instrucciones
         */
        ins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                /**
                 * Constructor de la clase instrucciones 
                 * Constructor de la clase instrucciones 
                 */
               in = new inst(fr);
             
            
            }


        });
        /**
         * Accion del boton cred que muestra los creditos del juego
         */
        cred.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
           panel.setVisible(false);
           cre = new Creditos(fr);
            }
        });
        
        /**
         * Accion del boton Salir, le da cierre al juego
         */
        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Gracias por jugar");
                System.exit(0);
            }
        });
        /**
         * Accion del boton top, que despliega los 10 mejores jugadores
         */
        top.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    panel.setVisible(false);
                    aa = new Ten(fr);
                    aa.llenar();
                } catch (IOException ex) {
                    
                }
                
                
            }
        });

    }

    /**
     * Imagen de fondo del panel en el menu
     */
    private void fondo() {
        fondo = new JLabel();
        fondo.setBounds(0, 0, 1000, 600);
        URL url = getClass().getResource("inicio/fondo.jpg");
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), fondo.getHeight()));
        fondo.setIcon(icon);
        fondo.repaint();
        panel.add(fondo);

    }
    
    
   


}
