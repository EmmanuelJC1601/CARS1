import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Random;

public class Carrera {
    
    Random rand = new Random();

    private TreeMap <Double, String> resultados = new TreeMap<>();
    
    private String lugar;
    private double kilometraje;
    private int no_vueltas;
    //private Pilotos[] piloto_car = new Pilotos[9];
    private static int contador;

    //CONSTRUCTORES
    public Carrera(String lugar, double kilometraje, int no_vueltas){
        this.lugar=lugar;
        this.kilometraje=kilometraje;
        this.no_vueltas=no_vueltas;
        contador++;
    }

    //GETTERS Y SETTERS
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

    //METODOS

    public void posiciones(ArrayList<Pilotos> pilotos){
        for(Pilotos piloto : pilotos){
            Double tiempo=rand.nextDouble(1.3,3.0);
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
                System.out.print("\tPuntos: 25");
            else if(i==2)
                System.out.print("\tPuntos: 18");
            else if(i==3)
                System.out.print("\tPuntos: 15");
            else if(i==4)
                System.out.print("\tPuntos: 12");
            else if(i==5)
                System.out.print("\tPuntos: 10");
            else if(i==6)
                System.out.print("\tPuntos: 8");
            else if(i==7)
                System.out.print("\tPuntos: 6");
            else if(i==8)
                System.out.print("\tPuntos: 4");
            else if(i==9)
                System.out.print("\tPuntos: 2");
            else if(i==10)
                System.out.print("\tPuntos: 1");
            else
                System.out.print("\tPuntos: 0");
            i++;
        }
    }

}
