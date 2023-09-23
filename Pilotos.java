public class Pilotos {
    
    private String nombre;
    private String nacionalidad;
    private String escuderia;
    private int no_carro;

    public Pilotos(String nombre, String nacionalidad, String escuderia, int no_carro){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.escuderia = escuderia;
        this.no_carro = no_carro;
    }

    public String getNombre(){
        return nombre;
    }
    public String getNacionalidad(){
        return nacionalidad;
    }
    public String getEscuderia(){
        return escuderia;
    }
    public int getNo_Carro(){
        return no_carro;
    }
}
