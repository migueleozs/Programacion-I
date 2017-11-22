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
import java.io.*;
import javax.swing.*;


/**
 *
 * @author ali.colmenares y miguel.Zamudio
 */

/**
 * 
 * Metodo por defecto de la clase
 */
public final class Ten {
   
    int x=0;
    String archi="Top10.txt",arch="Top.txt";
    Top[] vecTop;
      JPanel panel;
    Frame fr;
    
    JLabel[] vectlab = new JLabel[11];
    String [] vectStr = new String[11];
    
    JButton regresar;
    ventana vn;
    int c=0;
    

    /**
     * 
     * @param frame pasador por parametros para no agregar mas ventanas
     * @throws IOException colocado para que no de error de Try Catch
     */
    public Ten(Frame frame) throws IOException {
        this.fr = frame;
        
        
        separar();
        
        File f = new File(archi);
       
            int aux=0; String aux2;
            
            for (int k = 0; k <vecTop.length; k++) {
                for (int j = k+1; j <vecTop.length; j++) {
                     if(vecTop[k].getPuntos() < vecTop[j].getPuntos()){
                     aux=vecTop[k].getPuntos();
                     vecTop[k].setPuntos(vecTop[j].getPuntos());
                     vecTop[j].setPuntos(aux);
                     
                     aux2=vecTop[k].getNombre();
                     vecTop[k].setNombre(vecTop[j].getNombre());
                     vecTop[j].setNombre(aux2);
                     }   
                
                }
                             
              } 
            
            
            File f1 = new File("Top10.txt");
               FileWriter fw;
            fw = new FileWriter(f1,false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (int i = 0; i < 10; i++) {
            
            fw.append(vecTop[i].getNombre()+" "+vecTop[i].getPuntos()+"\r\n");
            bw.newLine();
           
        }
            fw.close();
            
           
        llenar();
        componentes();
        
        panel.setBackground(Color.LIGHT_GRAY.darker());
        panel.setVisible(true);
        fr.frame.add(panel);
        
    }
    
    /**
     * Para agregar al panel los componentes como el Jlabel 
     * botones y tamaño
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
        //Se le da las dimensiones como las coordenadas del boton
        regresar.setBounds(10, 50, 200, 50);
        panel.add(regresar);
         
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           panel.setVisible(false);
            fr.frame.remove(panel);
           vn = new ventana(fr);
            }
        });
        
        for (int i = 0; i < 10; i++) {
            vectlab [i] = new JLabel(vectStr[i]);
            vectlab[i].setBounds(300,(i*50)+20, 450, 50);
            vectlab[i].setVisible(true);
            vectlab[i].setFont(new Font("Goudy Stout",2,25));
          
            panel.add(vectlab[i]);
        }
        
        
    }

    
    /**
     * Llenamos el vector para luego ordenarlo y mandarlo al JLabel
     */
    public void llenar(){
         String a;
        for (int k = 9; k >=0; k--) {
                  a = vecTop[k].getNombre()+"  "+vecTop[k].getPuntos();
                      
                  vectStr[k]=a;
                  
        }
        
    }
    
    /**
     * 
     * @throws FileNotFoundException agregado para evitar errores de Try Catch
     * @throws IOException agregado para evitar errores de Try Catch
     * separamos la cadenas para luego ser guardadas
     */
     public void separar() throws FileNotFoundException, IOException {
        String[] puntuacion;
        String linea, linea2;
        
        
        FileReader fr = new FileReader(arch); 
        BufferedReader bw = new BufferedReader(fr); 
            linea=bw.readLine();
            int x = 0;
            while(linea!=null){
                x++;
                linea=bw.readLine();
                
            } 
        bw.close(); fr.close();
        vecTop=new Top[x];
       
        FileReader fr2 = new FileReader(arch); 
        BufferedReader bw2 = new BufferedReader(fr2);
            linea2=bw2.readLine();
            x=0;
            while(linea2!=null){
                puntuacion=linea2.split("/");
                
                vecTop[x]=new Top(puntuacion[0],Integer.parseInt(puntuacion[1]));
                
                
                x++;
                linea2=bw2.readLine();
                
            }
        bw2.close(); fr2.close();
        
        
    }
    
    }
        
        
    
 
