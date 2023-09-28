public class Pilotos {
    
    private String nombre;
    private String nacionalidad;
    private int no_carro;
    private int puntos;

    public Pilotos(String nombre, String nacionalidad, int no_carro){
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.no_carro = no_carro;
        this.puntos=0;
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

    public int getPuntos(){
        return puntos;
    }


    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad=nacionalidad;
    }

    public void setNo_Carro(int no_carro){
        this.no_carro=no_carro;
    }

    public void setPuntos(int puntos){
        this.puntos=puntos;
    }

    public void Imprimir(){
        System.out.println("Nombre: " + getNombre());
        System.out.println("Nacionalidad: " + getNacionalidad());
        System.out.println("Número de carro: " + getNo_Carro()); 
    }
}
