/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

/**
 *
 * @author eluli
 */
public class CalificarRespuesta {
     public int calificar(String respuestaCapitan , String respuestaAdministrador){
        int calificacionRespuesta = 0 ;
          
        if(respuestaCapitan.equals(respuestaAdministrador)){
            calificacionRespuesta++;
        }

        return calificacionRespuesta;
    }
}
