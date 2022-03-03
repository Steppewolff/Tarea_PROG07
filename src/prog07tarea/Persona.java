package prog07tarea;

/**
 *Clase que almacena la iformación de clientes titulares de una cuenta
 * @author Fernando Gómez Romano
 */
public class Persona {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;

    //Constructor por defecto
    public Persona(){
    }

    //Constructor con todos los parámetros de la clase
    public Persona(String nombre, String apellido1, String apellido2, String dni){
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;    }    
    
    //Getter de nombre
    public String getNombre(){
        return nombre;
    }
    //Setter de nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    //Getter de apellido1
    public String getApellido1(){
        return apellido1;
    }
    //Setter de apellido1
    public void setApellido1(String apellido1){
        this.apellido1 = apellido1;
    }

    //Getter de apellido2
    public String getApellido2(){
        return apellido2;
    }
    //Setter de apellido2
    public void setApellido2(String apellido2){
        this.apellido2 = apellido2;
    }
    
    //Getter de dni
    public String getDni(){
        return dni;
    }
    //Setter de dni
    public void setDni(String dni){
        this.dni = dni;
    }

}
