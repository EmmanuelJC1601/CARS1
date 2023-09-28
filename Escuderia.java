import java.util.Scanner;

public class Escuderia {
    
    private String marca;
    Pilotos[] pilotos = new Pilotos[2];
    static int contador_Escu = 0;

    public Escuderia(String marca){
        this.marca = marca;
        contador_Escu += 1;
    }
    
    public void AgregarPIlotos(){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++){
            sc.next();
            System.out.println("\n---------- Piloto "+ (i + 1) +" ----------");
            System.out.print("\nAgregar nombre: ");
            String nombre = sc.nextLine();
            System.out.print("\nAgregar nacionalidad: ");
            String nacionalidad = sc.nextLine();
            System.out.println("\nAgregar No.Auto: ");
            int no_carro = sc.nextInt();
            Pilotos piloto = new Pilotos(nombre, nacionalidad, no_carro);
            pilotos[i] = piloto;
        }
    
    }
    /*public void Imprimir(){
        System.out.println("- - - - - - "+getMarca()+" - - - - - -");
        System.out.println("Piloto: "+getPiloto_1());
        System.out.println("Piloto: "+getPiloto_2());
    }*/
}
