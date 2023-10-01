import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Random;

public class Carrera {
    
    Random rand = new Random();

    private TreeMap <Double, String> resultados = new TreeMap<>();
    
    private String lugar;
    private double kilometraje;
    private int no_vueltas;
    private static int contador=0;

    public Carrera(String lugar, double kilometraje, int no_vueltas){
        this.lugar=lugar;
        this.kilometraje=kilometraje;
        this.no_vueltas=no_vueltas;
        contador++;
    }

    public String getLugar(){
        return lugar;
    }
    public double getKilometraje(){
        return kilometraje;
    }
    public int getNo_Vueltas(){
        return no_vueltas;
    }

    public void ImprimirPista(){
        System.out.println("Lugar: " + getLugar());
        System.out.println("Kilometraje: " + getKilometraje());
        System.out.println("Número de Vueltas: " + getNo_Vueltas()); 
    }

    public void posiciones(ArrayList<Pilotos> pilotos){
        for(Pilotos piloto : pilotos){
            Double tiempo = rand.nextDouble(1.3,3.0);
            if(this.resultados.containsKey(tiempo)){
                this.resultados.put((tiempo+0.01), piloto.getNombre());
            }
            else{
                this.resultados.put(tiempo, piloto.getNombre());
            }
        }
    }

    public void mostrarResultados(){
        int i=1;
        for(Double tiempo : this.resultados.keySet()){
            System.out.print("Posicion: "+i+"\tTiempo: "+tiempo+"\tPiloto: "+this.resultados.get(tiempo));
            if(i==1)
                System.out.println("\tPuntos: 25");
            else if(i==2)
                System.out.println("\tPuntos: 18");
            else if(i==3)
                System.out.println("\tPuntos: 15");
            else if(i==4)
                System.out.println("\tPuntos: 12");
            else if(i==5)
                System.out.println("\tPuntos: 10");
            else if(i==6)
                System.out.println("\tPuntos: 8");
            else if(i==7)
                System.out.println("\tPuntos: 6");
            else if(i==8)
                System.out.println("\tPuntos: 4");
            else if(i==9)
                System.out.println("\tPuntos: 2");
            else if(i==10)
                System.out.println("\tPuntos: 1");
            else
                System.out.println("\tPuntos: 0");
            i++;
        }
        System.out.println("");
    }

    public void sumarPuntos(ArrayList<Pilotos> pilotos){
        int i = 1;
        int puntaje;
        for(Double tiempo : this.resultados.keySet()){
            for(Pilotos piloto : pilotos){
                if(this.resultados.get(tiempo) == piloto.getNombre()){
                    if(i == 1){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+25);
                    }
                    else if(i == 2){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+18);
                    }
                    else if(i == 3){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+15);
                    }
                    else if(i == 4){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+12);
                    }   
                    else if(i == 5){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+10);
                    }    
                    else if(i == 6){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+8);
                    }    
                    else if(i == 7){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+6);
                    }   
                    else if(i == 8){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+4);
                    } 
                    else if(i == 9){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+2);
                    }
                    else if(i == 10){
                        puntaje=piloto.getPuntos();
                        piloto.setPuntos(puntaje+1);
                    }
                }
            }
            i++;
        }
    }

    public static void iniciarCarrera(Carrera carrera, ArrayList<Pilotos> pilotos){
        carrera.posiciones(pilotos);
        carrera.sumarPuntos(pilotos);
    }

    public static int contador(){
        return contador;
    }
}
