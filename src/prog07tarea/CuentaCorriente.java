package prog07tarea;
/**
 *Subclase de CuentaBancaria
 * @author Fernando Gómez Romano
 */
public class CuentaCorriente extends CuentaBancaria {
    private float comisionMantenimiento;
    private float tipoInteresDescubierto;
    private float maximoDescubierto;

    public CuentaCorriente (){
    }

    public CuentaCorriente (Persona titular, float saldo, String iban, float comisionMantenimiento, float tipoInteresDescubierto, float maximoDescubierto){
        super(titular, saldo, iban);
        this.comisionMantenimiento = comisionMantenimiento;
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubierto = maximoDescubierto;
    }

    //Getter de comisionMantenimiento
    public double getComisionMantenimiento(){
        return comisionMantenimiento;
    }
    //Setter de comisionMantenimiento
    public void setComisionMantenimiento(float comisionMantenimiento){
        this.comisionMantenimiento = comisionMantenimiento;
    }

    //Getter de tipoInteresDescubierto
    public double getTipoInteresDescubierto(){
        return tipoInteresDescubierto;
    }
    //Setter de tipoInteresDescubierto
    public void setTipoInteresDescubierto(float tipoInteresDescubierto){
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    //Getter de maximoDescubierto
    public double getMaximoDescubierto(){
        return maximoDescubierto;
    }
    //Setter de maximoDescubierto
    public void setMaximoDescubierto(float maximoDescubierto){
        this.maximoDescubierto = maximoDescubierto;
    }
}
