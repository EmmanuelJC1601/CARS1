import java.util.*;

public class Cars4 {
    
    public static void main(String[] args) {
        ArrayList<Campeonato> campeonato = new ArrayList<>();
        ArrayList<Pilotos> pilotos= new ArrayList<>();
        ArrayList<Carrera> carreras= new ArrayList<>();
        ArrayList<Escuderia> escuderias= new ArrayList<>();
        ArrayList<String> fechas= new ArrayList<>();
        HashSet<String> paisesPilotos = new HashSet<String>();
        HashSet<String> paisesParticipantes = new HashSet<String>();

        int op = 0; 
        int op2 = 0; 
        int ContCamp = 0; 
        int contCarrera=0;
        int totalEscuderias;
        int totalPistas=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n------------------------ Formula 1 ------------------------\n");

        do {
            System.out.println("-------------------- Menu de Opciones --------------------\n");
            System.out.print("1. Crear Campeonato (Registrar Escuderias y sus Pilotos)\n2. Iniciar Carrera\n");
            System.out.print("3. Consultar Carreras Anteriores\n4. Finalizar Campeonato\n");
            System.out.print("5. Mostrar Elementos\n6. Cerrar Programa\n");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    if (ContCamp == 0){
                        System.out.println("\n----------------------- Campeonato -----------------------");
                        System.out.print("\nAgregar Nombre: ");
                        String name_Camp = sc.nextLine();
                        System.out.print("\nAgregar año de realización: ");
                        int year_Camp = sc.nextInt();
                        sc.nextLine();
                        Campeonato camp = new Campeonato(name_Camp, year_Camp);
                        campeonato.add(camp);
                        
                        System.out.print("\nCuantas escuderias va a registar?\n"
                        +"(Se registran 2 pilotos por escuderia): ");
                        totalEscuderias = sc.nextInt();
                        sc.nextLine();

                        for(int i = 0; i < totalEscuderias; i++){
                            System.out.println("\n------------------------ Escuderia "+(i+1)+" ------------------------");
                            System.out.print("\nAgregar Nombre: ");
                            String name_Esc = sc.nextLine();
                            camp.registrarEscuderia(escuderias, pilotos, name_Esc, paisesPilotos);
                        }

                        System.out.print("\nCuantas pistas va a registar?\n"
                        +"(El numero de pistas determina el máximo de carreras): ");
                        totalPistas = sc.nextInt();
                        sc.nextLine();
                    
                        for(int i = 0; i < totalPistas; i++){
                            System.out.println("\n-------------------------- Pista "+(i+1)+" --------------------------");
                            System.out.print("\nAgregar Lugar (pais): ");
                            String lug_pis = sc.nextLine();
                            paisesParticipantes.add(lug_pis);
                            System.out.print("\nAgregar Distancia total: ");
                            double kil_pis = sc.nextDouble();
                            System.out.print("\nAgregar Vueltas: ");
                            int vuel_pis = sc.nextInt();
                            sc.nextLine();
                            Carrera pistas = new Carrera(lug_pis, kil_pis, vuel_pis);
                            carreras.add(pistas);
                        }

                        System.out.println("\n-------------------------- Fechas --------------------------\n");
                        camp.crearCalendario(fechas, totalPistas);
                        int i = 1;
                        for (String fecha : fechas) {
                            System.out.println("Carrera "+ i +" : "+ fecha);
                            i ++;
                        }
                        System.out.println("\n............... Fechas Creadas Correctamente ...............\n");

                        ContCamp ++;
                    }else{
                        System.out.println("\nYa está en curso un Campeonato, espere a que este finalice\n");
                    }
                    break;

                case 2:
                    if(ContCamp==0){
                        System.out.println("!!! ERROR !!! Campeonato NO creado\n");
                    }
                    else{
                        if(Carrera.contador()>contCarrera){
                            System.out.println("\n---------------- La carrera "+(contCarrera+1)+" ha empezado ----------------\n");
                            Carrera.iniciarCarrera(carreras.get(contCarrera), pilotos);
                            System.out.println("\n---------------- Resultados ----------------\n");
                            carreras.get(contCarrera).mostrarResultados();
                            System.out.println("---------------- La carrera "+(contCarrera+1)+" ha terminado ----------------\n");
                            contCarrera++;
                        }
                        else{
                            System.out.println("\nYa no hay pistas donde correr\n");
                        }
                    }
                    break;

                case 3:
                    if(ContCamp==0){
                        System.out.println("!!! ERROR !!! Campeonato NO creado\n");
                    }
                    else{
                        if(contCarrera==0){
                            System.out.println("!!! ERROR !!! No hay carreras para consultar\n");
                        }
                        else{
                            System.out.println("\n-------------------- Consulta Carreras --------------------");
                            System.out.println("\t* Solo puede ver "+ contCarrera + " carrera(s) *");
                            System.out.print("\nNumero de Carrera: ");
                            int num_Carre = sc.nextInt();

                            if(num_Carre <= contCarrera){
                                System.out.println("\n--------------- Resultados de la Carrera "+ num_Carre + " ---------------\n");
                                Carrera carre_consul = carreras.get(num_Carre - 1);
                                carre_consul.mostrarResultados();
                            }else{
                                System.out.println("... .... ... Carrera Inexistente ... .... ...");
                            }
                        }
                    }
                    break;

                case 4:
                    if(ContCamp==0){
                        System.out.println("!!! ERROR !!! Campeonato NO creado\n");
                    }
                    else{
                        if(contCarrera == totalPistas){
                            System.out.println("\n--------------- El Campeonato ha terminado ---------------\n");
                            System.out.println("-------------------- Clasificacion de Pilotos --------------------\n");
                            Campeonato.podioCorredores(pilotos, escuderias);
                            for (Escuderia constructor : escuderias) {
                                constructor.sumarPuntos();
                            }
                            System.out.println("\n-------------------- Clasificacion de Escuderias --------------------\n");
                            Campeonato.podioConstructores(escuderias);
                            System.out.println("");

                            pilotos.clear();
                            carreras.clear();
                            escuderias.clear();
                            fechas.clear();
                            campeonato.clear();
                            ContCamp = 0;

                            System.out.println("\n-------------------- Paises de los Pilotos --------------------\n");
                            for (String nacionalidad : paisesPilotos) {
                                System.out.println(nacionalidad);
                            }

                            System.out.println("\n-------------------- Sedes Participantes --------------------\n");
                            for (String lugar : paisesParticipantes) {
                                System.out.println(lugar);
                            }
                            paisesPilotos.clear();
                            paisesParticipantes.clear();

                        }else{
                            System.out.println("\n... .... ... Campeonato en Curso ... .... ...");
                        }
                    }
                    break;
                case 5:
                    if(ContCamp==0){
                        System.out.println("!!! ERROR !!! Campeonato NO creado\n");
                    }
                    else{
                        System.out.println("------------------------ Opciones ------------------------\n");
                        System.out.print("1. Informacion de los Pilotos\n2. Resultado de las Carreras Anteriores\n");
                        System.out.print("3. Posiciones actuales del Campeonato\n");
                        System.out.print("Opcion: ");
                        op2 = sc.nextInt();
                        switch(op2){
                            case 1:
                                for (Escuderia escuderia : escuderias){
                                    System.out.println("\n---------- Escuderia '"+ escuderia.getMarca()+"' ----------\n");
                                    int i=1;
                                    for (Pilotos pilot : escuderia.getPilotos() ){
                                        System.out.println("--------------- Piloto: " + i + " ---------------");
                                        pilot.Imprimir();
                                        i++;
                                    }
                                }
                                break;
                            case 2:
                                int j=0;
                                for(Carrera carrera : carreras){
                                    if(j<=contCarrera){
                                        System.out.println("----------------------- Resultados de la carrera: "+ (j+1)+" -----------------------\n");
                                        carrera.mostrarResultados();
                                    }
                                    j++;
                                }
                                System.out.println("");
                                break;

                            case 3:
                                System.out.println("------------------ Posiciones Actuales del "+campeonato.get(0).getNombre()+" ------------------");
                                Campeonato.posiciones(pilotos);
                                break;
                            default:
                                System.out.println("!!! ERROR !!! Opcion NO Disponible\n");
                                break;
                        }
                    }
                    break;
                case 6:
                    return;

                default:
                    System.out.println("!!! ERROR !!! Opcion NO Disponible\n");
                    break;
            }

        } while (op != 6);
        sc.close();
    }
}
