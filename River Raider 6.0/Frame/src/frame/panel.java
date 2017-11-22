package frame;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/**
 *
 * @author ali.colmenares y Miguel Zamudio
 * PANEL CENTRAL DE MOVIMIENTOS Y CARGA DE IMAGENES AQUI LLEGARAN TODOS LOS PARAMETROS DE LOS OBJETOS
 * QUE APARECERAN EN EL JUEGO 
 * 
 * Clase encargada en si en el movimiento del avion y de salir de la ventana
 * Al igual le doy tamaño al personaje
 */

final class panel {
    public Frame principal;
    private Imagenes person;
    private Monedas mon;
    private Objetos enemy;
    private Gasolina gaso;
    private Medidor med;
    private Vidas v;
    private Cesped ces;
    private Archivo arch;
    private Casas house;
    private JFrame fr;
    private JTextField f1,f2,f3;
    private JPanel panelVerdad;
    ArrayList<Disparo> di; //disparos en pantalla
    Timer t;//Movimientos de los barcos
    int puntos=0,Total=0;
    boolean band = true, bad2 = true;//para controlar la bajada del barco y gasolina
    int bandera, random,bandera2;//se Coloca para poder llevar al barco a una posicion aleatoria
    int vidas = 0,medidor=100,medidor2=100,tiempo=0,ace=14;//contador para las vidas y tiempo
    AudioClip sonido;
    Ten lista;
    
    
    /**
     * 
     * @param frame Constructor por parametro, donde se le envia el frame para añadirle todo
     * @throws IOException Para evitar cierre por problemas de entrada o salida
     */
    panel(JFrame frame) throws IOException {
           
        this.fr = frame;
        
        fr.requestFocus();
        ventana();  
        movimiento();
        agregarPersonaje();
            agregarEnemigos(); 
        agregarVida();
        agregarIndicador();
        agregarCasas();
        agregarCesped();
        
         agregarGasolina();  
       
        /**
         * Timer para movimientos de enemigos y contador del tiempo
         */

        t = new Timer(5, escuchante);
        t.start();

        fr.add(panelVerdad);
        di = new ArrayList<>();
    }
    
   
    /**
     * Establesco la ventana tamaño, color en el constructor por defecto
     */
    private void ventana() {

        panelVerdad = new JPanel();
        GroupLayout grupo = new GroupLayout(panelVerdad);
        panelVerdad.setLayout(grupo);
        panelVerdad.setBounds(0, 0, 1000, 600);
        panelVerdad.setBackground(new Color(152, 245, 255));
        
        /**
         * Se agrega el panel para la gasolina
         */
        f1 = new JTextField("100%");
       Font f = new Font("arial",10,22);
       f1.setFont(f);
       f1.setBounds(13, 50, 59,30);
       f1.setBackground(Color.WHITE);
       f1.setEditable(false);
       f1.setFocusable(false);
       panelVerdad.add(f1);
       
       
       f2 = new JTextField("Puntuacion:");
       Font F2 = new Font("arial", 8, 12);
       f2.setFont(F2);
       f2.setBounds(850, 30, 100, 60);
       f2.setBackground(Color.WHITE);
       f2.setEditable(false);
       f2.setFocusable(false);
       panelVerdad.add(f2);
       
       f3 = new JTextField("75");
       f3.setFont(new Font("arial",10,22));
       f3.setBounds(870, 100, 59,30);
       f3.setBackground(Color.WHITE);
       f3.setEditable(false);
       f3.setFocusable(false);
       panelVerdad.add(f3);

    }

    /**
     * Metodo encargado de la entrada del teclado para
     * el movimiento de la nave y el cierre por tecla esc
     */
    private void movimiento() {
        fr.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            /**
             * Listener encargado de escuchar los movimientos de el teclado para el avion
             */

                accion(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

    }

    /**
     * 
     * @param e Accion  de cuando oprima ESC se salga
     * Al igual que cuando oprima la flechas direccionales se mueva el avion
     */
    
    private void accion(KeyEvent e) {
        int bandeaux = e.getExtendedKeyCode();
        //Escape
        if (bandeaux == KeyEvent.VK_ESCAPE) {
            Total = puntos;
                    arch = new Archivo(Total);
            System.exit(0);
        }
        /**
         * El avion se podra mover con las teclas direccionales
         * como lo pide el proyecto, Al igual que con las teclas A D
         * por preferencia propia ya que la mayoria de los Juegos 
         * se mueven es con estas teclas y no las direccionales
         */ 
        //Derecha
        if (bandeaux == KeyEvent.VK_RIGHT || bandeaux == KeyEvent.VK_D) {
            
                person.setPosicion(person.posX() + 30, person.posY());
            
        }
        //Izquierda
        if (bandeaux == KeyEvent.VK_LEFT || bandeaux == KeyEvent.VK_A) {
           
                person.setPosicion(person.posX() - 30, person.posY());
            
        }
/**
 * Accion de disparar con la tecla Q o con la barra espaciadora
 */
        if (bandeaux == KeyEvent.VK_Q || bandeaux == KeyEvent.VK_SPACE) {
            agregarDisparos(person.personaje.getX() + 10, person.personaje.getY() + 10);
            agregarDisparos(person.personaje.getX() + 60, person.personaje.getY() + 10);
            
            
           /**
            * introduccion del sonido de disparo
            */
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sound/disparo2.wav"));
            sonido.play();
          
            /**
             * Acelerando el juego con flecha direccion arriba o tecla "w"
             */
        }if(bandeaux == KeyEvent.VK_UP||bandeaux == KeyEvent.VK_W){
            enemy.setPosicion(enemy.posX() + 1, enemy.posY() + ace);
            enemy.setAvionPosicion(enemy.aposX(), enemy.aposY()+ace);
            house.asetPosicion(house.aposX(), house.aposY()+ace);
            house.xsetPosicion(house.xposX(), house.xposY()+ace);
            house.setPosicion(house.posX(), house.posY()+ace);
            gaso.setPosicion(gaso.posX(), gaso.posY() + ace);
            house.dsetPosicion(house.dposX(), house.dposY()+ace);
            house.d1setPosicion(house.d1posX(), house.d1posY()+ace);
            house.d2setPosicion(house.d2posX(), house.d2posY()+ace);
        }

    }

    /**
     * EN ESTA SECCION SE AGREGARA A 1 SOLO PANEL 
     * TODOS LOS COMPONENTES YA SEAN ENEMIGOS
     * EL MISMO USUARIO OBJETOS ARBOLES ENTRE OTROS
     */
    private void agregarPersonaje() {
        person = new Imagenes(100, 100);
        panelVerdad.add(person.personaje);
    }
    private void agregarEnemigos() {
        enemy = new Objetos(100, 100);
        panelVerdad.add(enemy.personaje);
        panelVerdad.add(enemy.enemigo);
    }
    public void agregarDisparos(int x, int y) {
        /**
         *  agrego tamaño al avion pasandolo por parametros
         */
        Disparo dis = new Disparo(x, y);
        di.add(dis);
        panelVerdad.add(dis.disparo);
    }
    private void agregarGasolina() {
        gaso = new Gasolina();
        panelVerdad.add(gaso.gas);
    }
    private void agregarVida() {
        v = new Vidas();
        panelVerdad.add(v.vida1);
        panelVerdad.add(v.vida2);
        panelVerdad.add(v.vida3);
    }
    private void agregarIndicador() {
        med = new Medidor();
        panelVerdad.add(med.med);
    }
    
    private void agregarCesped(){
        ces = new Cesped();
        panelVerdad.add(ces.c);
        panelVerdad.add(ces.c2);
       //panel.add(ces.agua);
    }
    public void agregarCasas(){
        house = new Casas();
        panelVerdad.add(house.casa1);
        panelVerdad.add(house.casa2);
        panelVerdad.add(house.arbol);
        panelVerdad.add(house.casa4);
        panelVerdad.add(house.casa3);
        panelVerdad.add(house.arbol2);
    }
    
    /**
     * Movimiento de los enemigos
     */
    ActionListener escuchante = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            /**
             * Se coloca las intersecciones con el enemigo Como las vidas
             * 
             */
            if (enemy.boat.intersects(person.area)||enemy.avion.intersects(person.area)||person.area.intersects(ces.a1)||person.area.intersects(ces.a2)) {
                vidas++;
                if(person.area.intersects(ces.a1)||person.area.intersects(ces.a2))
                    person.setPosicion(400, 450);
                if(enemy.boat.intersects(person.area))//Si lo choca un barco
                enemy.setPosicion(bandera, 700);
                if(enemy.avion.intersects(person.area))//Si lo choca un avion
                enemy.setAvionPosicion(bandera2, 700);
                v.vida1.setVisible(false);
                if (vidas == 2) {
                    v.vida2.setVisible(false);
                }
                if (vidas == 3) {
                    v.vida3.setVisible(false);
                    Total = puntos;
                    arch = new Archivo(Total);
                    JOptionPane.showMessageDialog(null, "¡Perdio! Se quedo sin vidas. \n Puntuacion: "+puntos+"\nGracias por jugar");
                    fr.remove(panelVerdad);
                    panelVerdad.setVisible(false);
                    t.stop();               
                    System.exit(0);
                    
                }

            }    
                    
     /**
      * Aqui sera la frecuencia con que aparece el barco una vez llegue
      */
            /**
             * a 1200 volvera a una posicion aleatoria en X y Y=0
             */
            if (enemy.posY() < 1200) {
                /**
                 * Movimiento de los barcos como limites con la orilla
                 */
         
                if (enemy.posX() < 700 && band == true) {
                    enemy.setPosicion(enemy.posX() + 1, enemy.posY() + 2);
                    if (enemy.posX() == 700) {
                        band = false;}

                } else {
                    enemy.setPosicion(enemy.posX() - 1, enemy.posY() + 2);
                    if (enemy.posX() < 200) {
                        band = true;}
                }
            } else {
                /**
                 * Colocamos un random para que el barco no aparesca 
                 * en el mismo lugar
                 */
                bandera = (int) Math.floor(Math.random() * 680 + 200);
                enemy.setPosicion(bandera, -1000);
            }
           
            /**
             * Movimiento de los aviones enemigos
             */
            if(enemy.aposY()<650){             
                enemy.setAvionPosicion(enemy.aposX(), enemy.aposY()+3);               
            }else{
                bandera2 = (int) Math.floor(Math.random() * 500 + 400);
                enemy.setAvionPosicion(bandera2, -500);}
            
            /**
             * Movimientos para las casas
             */
              if(house.posY()<600){
                house.setPosicion(house.posX(), house.posY()+1);
                house.dsetPosicion(house.dposX(), house.dposY()+1);}
              else{
                  house.setPosicion(0, 0);
                   house.dsetPosicion(820, 0);}
              
              if(house.xposY()<600 ){
                  house.xsetPosicion(house.xposX(), house.xposY()+1);
                  house.d1setPosicion(house.d1posX(), house.d1posY()+1);
              }else{
                  house.xsetPosicion(0, 0);
              house.d1setPosicion(820, 0);}
              
              /**
               * movimientos de los arboles
               */
              if(house.aposY()<600){
                  house.d2setPosicion(house.d2posX(), house.d2posY()+1);
                  house.asetPosicion(house.aposX(), house.aposY()+1);               
              }else{
                  house.d2setPosicion(810, 0);
                  house.asetPosicion(0, 0); }

            /**
             * Colocamos los movimientos de la gasolina y captura de si misma
             */
            if (gaso.posY() < 1200 && bad2 == true) {
                gaso.setPosicion(gaso.posX(), gaso.posY() + 1);
            } else {
                /**
                 * Colocamos que salga en una posicion x aleatoria y 
                 * a una posicion Y -2000
                 */
                gaso.setPosicion(bandera, -2000); }
            
      
            medidor -= 1;
            if (medidor == 0) {
                tiempo++;
                f3.setText(String.valueOf(75-tiempo));
                medidor = 100;
                medidor2 -= 2;
                
                /**
                 * Contador de gasolina para fin de juego
                 */               
                if (tiempo >= 75) {
                    fr.remove(panelVerdad);
                    panelVerdad.setVisible(false);
                    t.stop();
                    JOptionPane.showMessageDialog(null, "¡Fin del Tiempo, Ha ganado! Gracias por jugar \nPuntuacion: "+puntos);
                  Total = puntos;
                    arch = new Archivo(Total);
                    System.exit(0);
                }
                /**
                 * Medidor de gasolina para cierre de juego
                 */
                if (medidor2<=0) {
                     fr.remove(panelVerdad);
                    panelVerdad.setVisible(false);
                    t.stop();
                    JOptionPane.showMessageDialog(null, "Se quedo sin gasolina... Gracias por jugar \nPuntuacion: "+puntos);
                  Total = puntos;
                    arch = new Archivo(Total);
                    System.exit(0);
                }
                medidor();
            }
            if (person.area.intersects(gaso.gasolina)) {
                medidor2 = 100;
                random = (int) Math.floor(Math.random() * 500 + 200);
                gaso.setPosicion(random, -10000);
            }
            /**
             * Aqui se reproduce el sonido cuando se elimina un enemigo
             */
             mon = new Monedas();
            for (int i = 0; i < di.size(); i++) {
                di.get(i).re.setBounds(di.get(i).getX(), di.get(i).getY(), 50, 50);
                di.get(i).setPosicion(di.get(i).getX(), di.get(i).getY() - 10);
                if (di.get(i).re.intersects(enemy.avion)) {
                    puntos+=20;
                   mon.sonido();
                    puntos();
                  bandera2 = (int) Math.floor(Math.random() * 500 + 400);
                    enemy.setAvionPosicion(bandera2, -500);
                }
                if (di.get(i).re.intersects(enemy.boat)) {
                    puntos+=20;
                   mon.sonido();
                    puntos();
                    bandera = (int) Math.floor(Math.random() * 500 + 200);
                    enemy.setPosicion(bandera, -500);
                }
                if(di.get(i).re.intersects(gaso.gasolina)){
                    puntos-=10;
                    puntos();
                    bandera = (int) Math.floor(Math.random() * 680 + 200);
                    gaso.setPosicion(bandera, -2000);
                }
                /**
                 * Se remueve el objeto de la clase Disparo que halla cumplido 
                 * mision
                 */
                if (di.get(i).getY() < 0) {
                    panelVerdad.remove(di.get(i).disparo);

               
                    di.remove(i);

                }
            }
        }

    };
    
    /**
     * Metodo encargardo de medir el tiempo en seg, convertido en String
     */
 private void medidor() {
            String seg;
        seg= String.valueOf(medidor2);
        f1.setText(seg+"%");
        }
 
        /**
         * Metodo encargado de medir el puntaje convertido en String
         */
 private void puntos(){
       String seg;
        seg= String.valueOf(puntos);
        f2.setText("Puntuacion: "+seg+"");
     
 }
 
 
}
