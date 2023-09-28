import java.util.Calendar;
import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Campeonato {
   
    Random rand = new Random();

    private String nombre;
    private int year;
    //Carrera[] carreras = new Carrera[23];
    //Escuderia[] escuderias = new Escuderia[10];


    //Pilotos[] pilotos = new Pilotos[20];
    // Lista de Fechas
    public Campeonato(String nombre, int year){
        this.nombre = nombre;
        this.year = year;
    }
    public void RegistrarEscuderia(ArrayList<Escuderia> escuderias,ArrayList<Pilotos> pilotos,String nombreEscuderia){
        Escuderia patron = new Escuderia(nombreEscuderia);
        patron.AgregarPIlotos(pilotos);
        escuderias.add(patron);
    }

    public void crearCalendario(ArrayList<String> fechas){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fecha=Calendar.getInstance();
        int year = rand.nextInt(45)+1980;
        int month = rand.nextInt(12)+1;
        fecha.set(Calendar.YEAR, year);
        fecha.set(Calendar.MONTH, month);
        int dia = rand.nextInt(fecha.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
        fecha.set(Calendar.DAY_OF_MONTH, dia);
        Date fechaFormat = fecha.getTime();
        String fechaFinal = sdf.format(fechaFormat);
        for(int i=0;i<23;i++){
            if(i==0){
                fechas.add(fechaFinal);
            }
            else{
                fecha.roll(Calendar.DAY_OF_MONTH, 7);
            }
        }
    }
}
