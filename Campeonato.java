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
    public void registrarEscuderia(ArrayList<Escuderia> escuderias,ArrayList<Pilotos> pilotos,String nombreEscuderia, HashSet<String> paisesPilotos){
        Escuderia patron = new Escuderia(nombreEscuderia);
        patron.AgregarPIlotos(pilotos, paisesPilotos);
        escuderias.add(patron);
    }
    public String getNombre(){
        return nombre;
    }
    public void crearCalendario(ArrayList<String> fechas, int totalPistas){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar fecha=Calendar.getInstance();
        int month = 3;
        fecha.set(Calendar.YEAR, this.year);
        fecha.set(Calendar.MONTH, month);
        int dia = rand.nextInt(fecha.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
        fecha.set(Calendar.DAY_OF_MONTH, dia);
        Date fechaFormat = fecha.getTime();
        String fechaFinal = sdf.format(fechaFormat);
        for(int i=0;i<totalPistas;i++){
            if(i==0){
                fechas.add(fechaFinal);
            }
            else{
                fecha.add(Calendar.DAY_OF_MONTH, 7);
                Date fechaSDF = fecha.getTime();
                String fechaF = sdf.format(fechaSDF);
                fechas.add(fechaF);
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
        for(int i=0;i<3;i++){
            int x=0;
            for(Pilotos piloto : pilotos){
                if(puntos.get(i)==piloto.getPuntos()){
                    int numEscuderia=x/2;
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
        int x=1;
        for(Integer points : puntos){
            for(Escuderia escuderia : escuderias){
                if(points==escuderia.getPuntos()){
                    System.out.println("Posicion: "+x+"\tEscuderia: "+escuderia.getMarca()+"\tPuntos: "+points);
                }
            }
            x++;
        }
    }

}
