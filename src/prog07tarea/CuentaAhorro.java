package prog07tarea;
/**
 *Subclase de CuentaBancaria
 * @author Fernando Gómez Romano
 */
public class CuentaAhorro extends CuentaBancaria{
    private float tipoInteresAnual;
    
    public CuentaAhorro (){
    }

    public CuentaAhorro (Persona titular, float saldo, String iban, float tipoInteresAnual){
        super(titular, saldo, iban);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    //Getter de tipoInteresAnual
    public double getTipoInteresAnual(){
        return tipoInteresAnual;
    }
    //Setter de tipoInteresAnual
    public void setTipoInteresAnual(float tipoInteresAnual){
        this.tipoInteresAnual = tipoInteresAnual;
    }

}
