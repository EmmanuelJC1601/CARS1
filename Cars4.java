import java.util.*;

public class Cars4 {
    
    public static void main(String[] args) {
        int op = 0; // Variable para las opciones
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------------------------------ Formula 1 -------------------------\n");

        do {
            System.out.println("--------------- Menu de Opciones ---------------\n");
            System.out.print("1. Crear Campeonato\n2. Iniciar Carrera\n");
            System.out.print("3. Consultar Carreras Anteriores\n4. Finalizar Campeonato\n");
            System.out.print("5. Mostrar Elementos\n6. Cerrar Programa\n");
            System.out.println("Opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    return;

                default:
                    System.out.println("!!! ERROR !!! Opcion NO Disponible");
                    break;
            }






        } while (op != 6);
    }

}
