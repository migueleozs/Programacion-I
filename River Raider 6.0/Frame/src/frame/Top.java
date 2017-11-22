/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

/**
 *
 * @author ali.colmenares y miguel zamudio
 * Almacenamos los nombres y los puntos para poder pasarlos por paramettos
 */
public class Top {

    String nombre;
    int Puntos;

    /**
     * Constructor por defecto
     */
    public Top() {
    }
    
    /**
     * 
     * @param nombre Inicalizando el nombre 
     * @param Puntos inizializando los puntos
     */
    public Top(String nombre,int Puntos) {
        this.nombre = nombre;
        this.Puntos = Puntos;
    }

    /**
     * 
     * @return Obtengo el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @return obtengo los puntos
     */
    public int getPuntos() {
        return Puntos;
    }

    /**
     * 
     * @param Puntos Establesco los puntos para luego ser usados en Ten
     */
    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    /**
     * 
     * @param nombre Establesco los nombres para luego ser usado en Ten
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
