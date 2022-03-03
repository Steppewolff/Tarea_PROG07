package prog07tarea;
/**
 *Clase abstract para ser usada como molde de cuenta corriente y cuenta de ahorro
 * @author Fernando Gómez Romano
 */
public abstract class CuentaBancaria {
    private Persona titular;
    private float saldo;
    private String iban;

    //Constructor por defecto    
    public CuentaBancaria(){
    }

    //Constructor con todos los parámetros de la clase
    public CuentaBancaria(Persona titular, float saldo, String iban){
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    //Getter de titular
    public Persona getTitular(){
        return titular;
    }
    //Setter de titular
    public void setTitular(Persona titular){
        this.titular = titular;
    }

    //Getter de saldo
    public float getSaldo(){
        return saldo;
    }
    //Setter de saldo
    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    //Getter de iban
    public String getIban(){
        return iban;
    }
    //Setter de iban
    public void setIban(String iban){
        this.iban = iban;
    }

}
