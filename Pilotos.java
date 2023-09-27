public class Pilotos {
    
    private String nombre;
    private String nacionalidad;
    private int no_carro;

    public Pilotos(String nombre, String nacionalidad, int no_carro){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.no_carro = no_carro;
    }
    public String getNombre(){
        return nombre;
    }
    public String getNacionalidad(){
        return nacionalidad;
    }
    public int getNo_Carro(){
        return no_carro;
    }
    public void Imprimir(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nacionalidad: " + getNacionalidad());
        System.out.println("Número de carro: " + getNo_Carro()); 
    }
}
