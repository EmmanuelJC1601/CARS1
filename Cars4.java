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
            System.out.print("1. Crear Campeonato/Registrar Escuderias y sus Pilotos\n"
            +"2. Iniciar Carrera\n");
            System.out.print("3. Consultar Carreras Anteriores\n4. Finalizar Campeonato\n");
            System.out.print("5. Mostrar Elementos\n6. Cerrar Programa\n");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine(); // Eliminar el espacio en blanco

            switch (op) {
                case 1:
                    if (ContCamp == 0){
                        System.out.println("\n--------------- Campeonato ---------------");
                        System.out.print("\nAgregar Nombre: ");
                        String name_Camp = sc.nextLine();
                        System.out.print("\nAgregar año de realización: ");
                        int year_Camp = sc.nextInt();
                        sc.nextLine();
                        Campeonato camp = new Campeonato(name_Camp, year_Camp);
                    
                        for(int i = 0; i < 2; i++){
                            System.out.println("\n--------------- Escuderias ---------------");
                            System.out.print("\nAgregar Nombre: ");
                            String name_Esc = sc.nextLine();
                            camp.registrarEscuderia(escuderias, pilotos, name_Esc);
                        }
                    
                        for(int i = 0; i < 2; i++){
                            System.out.println("\n--------------- Pistas ---------------");
                            System.out.print("\nAgregar Lugar: ");
                            String lug_pis = sc.nextLine();
                            System.out.print("\nAgregar Distancia total: ");
                            double kil_pis = sc.nextDouble();
                            System.out.print("\nAgregar Vueltas: ");
                            int vuel_pis = sc.nextInt();
                            sc.nextLine();
                            Carrera pistas = new Carrera(lug_pis, kil_pis, vuel_pis);
                            carreras.add(pistas);
                        }

                        System.out.println("\n--------------- Fechas ---------------");
                        camp.crearCalendario(fechas);
                        for (String fecha : fechas) {
                            System.out.println(fecha);
                        }
                        System.out.println("\n.......... Fechas Creadas Correctamente ..........");

                        ContCamp ++;
                    }else{
                        System.out.println("\nYa está en curso un Campeonato, espere a que este finalice");
                    }
                    break;

                case 2:
                    if(Carrera.contador()>contCarrera){
                        System.out.println("\n---------- La carrera "+(contCarrera+1)+" ha empezado ----------");
                        Carrera.iniciarCarrera(carreras.get(contCarrera), pilotos);
                        contCarrera++;
                    }
                    else{
                        System.out.println("\nNo hay pistas suficientes donde correr, crea mas");
                    }

                    break;

                case 3:
                    System.out.println("\n--------------- Consulta Carreras ---------------");
                    System.out.println("\t\tSolo puede ver "+ contCarrera + " carrera(s)");
                    System.out.print("\nNumero de Carrera: ");
                    int num_Carre = sc.nextInt();

                    if(num_Carre <= contCarrera){
                        Carrera carre_consul = carreras.get(num_Carre - 1);
                        carre_consul.mostrarResultados();
                    }else{
                        System.out.println("... .... ... Carrera Inexistente ... .... ...");
                    }
                    break;

                case 4:
                    if(contCarrera == 2){
                        System.out.println("\n---------- El Campeonato ha terminado ----------");
                        Campeonato.podioCorredores(pilotos, escuderias);
                        Campeonato.podioConstructores(escuderias);
                        
                    }else{
                        System.out.println("\n... .... ... Campeonato en Curso ... .... ...");
                    }


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
                            for (Escuderia escuderia : escuderias){
                                System.out.println("--- Escuderia Correspondiente ---");
                                System.out.println("\t\t"+escuderia.getMarca());
                                int i=1;
                                for (Pilotos pilot : escuderia.getPilotos() ){
                                    System.out.println("------------ Piloto: " + i + "------------");
                                    pilot.Imprimir();
                                    i++;
                                }
                            }
                            break;
                        case 2:
                            int j=1;
                            for(Carrera carrera : carreras){
                                if(j<=contCarrera){
                                    System.out.println("Resultados de la carrera: "+j);
                                    carrera.mostrarResultados();
                                }
                                j++;
                            }
                            break;

                        case 3:
                            System.out.println("----POSICIONES ACTUALES----");
                            Campeonato.posiciones(pilotos);

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
