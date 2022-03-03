package prog07tarea;
/**
 *
 * @author Fernando Gómez Romano
 */
public class ArrayCuentas {
    private int numCuentas;
    private CuentaBancaria [] summaryCuentas;
    private String [] listadoCuentas;
    private boolean aux;
    private float aux_num;
    private String aux_st;
    private String output;
    
 /**
 *
 * Método constructor sin argumentos
 */
    public ArrayCuentas (){
    }

 /**
 *
 * Método constructor con argumentos
 * @param maxcuentas dimensión para el array
 */
    public ArrayCuentas(int maxCuentas){
        this.numCuentas = numCuentas;
        
        summaryCuentas = new CuentaBancaria [maxCuentas];
        numCuentas = 0; //Se inicializa el contador con el número de cuentas creadas aqui porque solo se llamará una vez al principio del programa
    }

 /**
 *
 * Método que almacena las nuevas cuentas creadas y lleva el contador del número creado
 * @param cuentaNueva objeto cuenta, importa cada cuenta creada
 * @return true si finaliza correctamente el proceso
 */
    public boolean abrirCuenta (CuentaBancaria cuentaNueva){
        if (numCuentas < summaryCuentas.length){
            summaryCuentas[numCuentas] = cuentaNueva;
            
            numCuentas = numCuentas + 1;
            
            return true; 
        }
        else{
            return false;
        }
    }

 /**
 *
 * Método que exporta un array con el listado de las cuentas creadas
 * 
 * @return listadoCuentas con el array de las cuentas
 */
    public String [] listadoCuentas (){
//        CuentaBancaria [] listado = new CuentaBancaria [numCuentas];
        listadoCuentas = new String [100];
        for (int i = 0; i<numCuentas; i++){
            listadoCuentas [i] = "Cuenta nº" + i + " Iban: " + summaryCuentas[i].getIban() + " Titular: " + summaryCuentas[i].getTitular().getNombre()+ " " +summaryCuentas[i].getTitular().getApellido1()+ " " +summaryCuentas[i].getTitular().getApellido2() + " Saldo: " + summaryCuentas[i].getSaldo();
        }

        return listadoCuentas;
    }
    
/**
 *
 * Método que exporta la informacioón de una cuenta concreta, pedida por IBAN
 * @param ibanBuscado IBAN de la cuenta para mostrar
 * @return output con la información de la cuenta
 */
public String informacionCuenta (String ibanBuscado){
        output = null;

        for (int i = 0; i<numCuentas; i++){
            if (summaryCuentas[i].getIban().equals(ibanBuscado)){
                output = "Cuenta nº" + i + " Iban: " + summaryCuentas[i].getIban() + " Titular: " + summaryCuentas[i].getTitular().getNombre()+ " " +summaryCuentas[i].getTitular().getApellido1()+ " " +summaryCuentas[i].getTitular().getApellido2() + " Saldo: " + summaryCuentas[i].getSaldo();
                break;
            }
        }

        return output;
    }
    
 /**
 *
 * Método que realiza el ingreso de saldo en una cuenta identificada por IBAN
 * @param ibanBuscado IBAN de la cuenta en la que realizar el ingreso
 * @param ingreso cantidad a ingresar
 * @return true si se realiza correctamente el ingreso
 */
    public boolean ingresoCuenta (String ibanBuscado, float ingreso){
        aux = false;

        for (int i = 0; i<numCuentas; i++){
            if (summaryCuentas[i].getIban().equals(ibanBuscado)){
                summaryCuentas[i].setSaldo((float) (summaryCuentas[i].getSaldo() + ingreso));
                aux = true;
                break;
            }
        }

        return aux;
    }

 /**
 *
 * Método que realiza la retirada de saldo de una cuenta identificada por IBAN
 * @param ibanBuscado IBAN de la cuenta en la que realizar el ingreso
 * @param retirada cantidad a retirar
 * @return true si se realiza correctamente el ingreso
 */
    public boolean retiradaCuenta (String ibanBuscado, float retirada){
        aux = false;

        for (int i = 0; i<numCuentas; i++){
            if ((summaryCuentas[i].getIban().equals(ibanBuscado)) && (retirada<=summaryCuentas[i].getSaldo())){
                summaryCuentas[i].setSaldo((float) (summaryCuentas[i].getSaldo() - retirada));
                aux = true;
                break;
            }
        }

        return aux;
    }

 /**
 *
 * Método que consulta el saldo de una cuenta identificada por IBAN
 * @param ibanBuscado IBAN de la cuenta en la que realizar el ingreso
 */
    public float obtenerSaldo (String ibanBuscado){
        aux_num = -1;

        for (int i = 0; i<numCuentas; i++){
            if (summaryCuentas[i].getIban().equals(ibanBuscado)){
                aux_num = (float) summaryCuentas[i].getSaldo();
            }
        }
        return aux_num;
    }
}