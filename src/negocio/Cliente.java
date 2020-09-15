
package negocio;


public class Cliente {
    
    //atributos de la clase
    private int id;
    private String nombre;
    private String direccion;
    private float saldo;
    
    //Constructor sin parametros
    public Cliente() {
    }
    
    //Constuctor con parametros
    public Cliente(int id, String nombre, String direccion, float saldo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.saldo = saldo;
    }
    
    //Métedos get y set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    
    
    
}
