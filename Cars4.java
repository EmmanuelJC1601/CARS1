import java.util.*;

public class Cars4 {
    
    public static void main(String[] args) {
        ArrayList<Pilotos> pilotos= new ArrayList<>();
        ArrayList<Carrera> carreras= new ArrayList<>();
        ArrayList<Escuderia> escuderias= new ArrayList<>();
        ArrayList<String> fechas= new ArrayList<>();
        
        int op = 0; // Variable para las opciones
        int op2 = 0; // Variable para las opciones del punto 5
        int ContCamp = 0; // Contador de Campeonatos
        int contCarrera=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--------------- Formula 1 ---------------\n");

        do {
            System.out.println("--------------- Menu de Opciones ---------------\n");
            System.out.print("1. Crear Campeonato\n2. Iniciar Carrera\n");
            System.out.print("3. Consultar Carreras Anteriores\n4. Finalizar Campeonato\n");
            System.out.print("5. Mostrar Elementos\n6. Cerrar Programa\n");
            System.out.print("Opcion: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    if (ContCamp == 0){
                        




                        ContCamp ++;
                    }
                    break;
                case 2:
                    if(Carrera.contador()>contCarrera){
                        System.out.println("La carrera "+(contCarrera+1)+" ha empezado.");
                        Carrera.iniciarCarrera(carreras.get(contCarrera), pilotos);
                        contCarrera++;
                    }
                    else{
                        System.out.println("No hay pistas suficientes donde correr, crea mas");
                    }

                    break;
                case 3:

                    break;
                case 4:



                    ContCamp = 0;
                    break;
                case 5:
                    System.out.println("--------------- Opciones ---------------\n");
                    System.out.print("1. Info Pilotos\n2. Resultado Carreras Anteriores\n");
                    System.out.print("3. Posiciones del Campeonato\n");
                    System.out.print("Opcion: ");
                    op2 = sc.nextInt();
                    switch(op2){
                        case 1:

                            break;
                        case 2:
                            int i=1;
                            for(Carrera carrera : carreras){
                                System.out.println("Resultados de la carrera: "+i);
                                carrera.mostrarResultados();
                                i++;
                            }
                            break;
                        case 3:

                            break;
                        default:
                            System.out.println("!!! ERROR !!! Opcion NO Disponible");
                            break;
                    }
                    break;
                case 6:
                    return;

                default:
                    System.out.println("!!! ERROR !!! Opcion NO Disponible");
                    break;
            }






        } while (op != 6);
        sc.close();
    }
}
