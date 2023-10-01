import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Escuderia {
    
    private String marca;
    private Pilotos[] pilotos = new Pilotos[2];
    static int contador_Escu = 0;
    private int puntos;

    public Escuderia(String marca){
        this.marca = marca;
        contador_Escu += 1;
    }
    public String getMarca(){
        return marca;
    }

    public int getPuntos(){
        return puntos;
    }

    public Pilotos[] getPilotos(){
        return pilotos;
    }

    public void AgregarPIlotos(ArrayList<Pilotos> pilotos, HashSet<String> paisesPilotos){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++){
            System.out.println("\n------------------------ Piloto "+ (i + 1) +" -------------------------");
            System.out.print("\nAgregar nombre: ");
            String nombre = sc.nextLine();
            System.out.print("\nAgregar nacionalidad: ");
            String nacionalidad = sc.nextLine();
            paisesPilotos.add(nacionalidad);
            System.out.print("\nAgregar No.Auto: ");
            int no_carro = sc.nextInt();
            sc.nextLine();
            Pilotos piloto = new Pilotos(nombre, nacionalidad, no_carro);
            this.pilotos[i] = piloto;
            pilotos.add(piloto);
        }
    }

    public void sumarPuntos(){
        for(Pilotos piloto: this.pilotos){
            this.puntos+=piloto.getPuntos();
        }
    }
}
