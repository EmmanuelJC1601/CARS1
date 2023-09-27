import java.util.*;

public class Campeonato {
   
    private String nombre;
    private int año;
    Carrera[] carreras = new Carrera[23];
    Escuderia[] escuderias = new Escuderia[10];
    //Pilotos[] pilotos = new Pilotos[20];
    // Lista de Fechas
    public Campeonato(String nombre, int año){
        this.nombre = nombre;
        this.año = año;
    }
    public void RegistrarEscuderia(String nombreEscuderia){
        Escuderia patron = new Escuderia(nombreEscuderia);
        
        escuderias[patron.contador_Escu-1] = 0;
    }

}
