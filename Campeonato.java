import java.util.*;
import java.text.SimpleDateFormat;

public class Campeonato {
   
    Random rand = new Random();

    private String nombre;
    private int year;

    public Campeonato(String nombre, int year){
        this.nombre = nombre;
        this.year = year;
    }
    public void registrarEscuderia(ArrayList<Escuderia> escuderias,ArrayList<Pilotos> pilotos,String nombreEscuderia){
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
    public void crearPista(ArrayList<Carrera> carreras){
        Scanner sc = new Scanner(System.in);
        sc.next();
        System.out.println("\nIngresa los datos de la pista");
        System.out.print("\nAgregar lugar: ");
        String lugar = sc.nextLine();
        System.out.print("\nAgregar kilometraje: ");
        double kilometraje = sc.nextDouble();
        System.out.println("\nAgregar No.Vueltas: ");
        int no_vueltas = sc.nextInt();
        Carrera pista = new Carrera (lugar, kilometraje, no_vueltas);
        carreras.add(pista);
        sc.close();
    }

    public static void posiciones(ArrayList<Pilotos> pilotos){
        ArrayList<Integer> puntos= new ArrayList<>();
        for(Pilotos piloto : pilotos){
            puntos.add(piloto.getPuntos());
        }
        Collections.sort(puntos);
        Collections.reverse(puntos);
        ArrayList<Pilotos> copy_Pilotos = new ArrayList<>(pilotos);
        int x=1;
        for(Integer points : puntos){
            for(Pilotos piloto : copy_Pilotos){
                if(points==piloto.getPuntos()){
                    //piloto.setPuntos(10000);
                    System.out.println("Posicion: "+x+"\tPiloto: "+piloto.getNombre()+"\tPuntos: "+points);
                }
            }
            x++;
        }
    }

    public static void podioCorredores(ArrayList<Pilotos> pilotos, ArrayList<Escuderia> escuderias){
        ArrayList<Integer> puntos= new ArrayList<>();
        for(Pilotos piloto : pilotos){
            puntos.add(piloto.getPuntos());
        }
        Collections.sort(puntos);
        Collections.reverse(puntos);
        ArrayList<Pilotos> copy_Pilotos = new ArrayList<>(pilotos);
        for(int i=0;i<3;i++){
            int x=0;
            for(Pilotos piloto : copy_Pilotos){
                if(puntos.get(i)==piloto.getPuntos()){
                    //piloto.setPuntos(10000);
                    int numEscuderia=x/2;
                    /* 
                    if(i==0){

                    }
                    else if(i==1){

                    }
                    else{

                    }*/
                    System.out.println("Posicion: "+(i+1)+"\tPiloto: "+piloto.getNombre()
                    +"\tPuntos: "+puntos.get(i)+"\tEscuderia: "+escuderias.get(numEscuderia).getMarca());
                }
                x++;
            }
        }
    }

    public static void podioConstructores(ArrayList<Escuderia> escuderias){
        ArrayList<Integer> puntos= new ArrayList<>();
        for(Escuderia escuderia : escuderias){
            puntos.add(escuderia.getPuntos());
        }
        Collections.sort(puntos);
        Collections.reverse(puntos);
        ArrayList<Escuderia> copy_Escuderias = new ArrayList<>(escuderias);
        int x=1;
        for(Integer points : puntos){
            for(Escuderia escuderia : copy_Escuderias){
                if(points==escuderia.getPuntos()){
                    System.out.println("Posicion: "+x+"\tEscuderia: "+escuderia.getMarca()+"\tPuntos: "+points);
                }
            }
            x++;
        }
    }

}
