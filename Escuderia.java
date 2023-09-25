public class Escuderia {
    
    private String Marca;
    private Pilotos piloto_1;
    private Pilotos piloto_2;
    static int contador_Escu = 0;

    public Escuderia(String Marca){
        this.Marca = Marca;
        contador_Escu += 1;
    }
    public String getMarca(){
        return Marca;
    }
    public Pilotos getPiloto_1(){
        return piloto_1;
    }
    public Pilotos getPiloto_2(){
        return piloto_2;
    }
    public void Imprimir(){
        System.out.println("- - - - - - "+getMarca()+" - - - - - -");
        System.out.println("Piloto: "+getPiloto_1());
        System.out.println("Piloto: "+getPiloto_2());
    }
}
