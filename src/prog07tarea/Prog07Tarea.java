package prog07tarea;
/**
 *
 * @author Fernando Gómez Romano
 */
//Se importan las clases externas que se van a utilizar en el programa
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prog07Tarea {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //COnjunto de atributos para la clase principal
        String inputMainMenu = "1";//variable que almacena el valor escrito por pantalla del menu principal 
        String inputNewAccount;//variable que almacena el valor escrito por pantalla del submenu para crear una nueva cuenta
        String input_nombre;//las input_xxx son variables para almacenar valores que ser reciben en la clase principal al llamar a métodos de otras clases
        String input_apellido1;
        String input_apellido2;
        String input_dni;
        float input_saldo;
        String input_iban;
        float input_tipoInteresAnual;
        float input_comisionMantenimiento;
        float input_tipoInteresDescubierto;
        float input_maximoDescubierto;
        String ibanBuscado;//variable para almacenar el iban que se va a pasar para buscar en las opciones donde hace falta
        float ingreso;//cantidad ingresada en cuenta
        float retirada;//cantidad retirada de una cuenta
        float aux_saldo;//variable para recibir el saldo al llamar al método que lo consulta en el array de cuentas
        final int MAXCUENTAS = 100;//constante para el tamaño del array de cuentas, número máximo de cuentas almacenables

        ArrayCuentas arrayCuentas = new ArrayCuentas(MAXCUENTAS);
        Scanner input = new Scanner(System.in); //Se instancia Scanner

        //Este bucle while hace que el programa se mantenga corriendo mientras en el menu principal no se escoja la opción 7
        while ((Integer.parseInt(inputMainMenu) >= 1) & (Integer.parseInt(inputMainMenu) < 7)){
            Pattern patMain = Pattern.compile("[1-7]"); //Se establece regla para que el input sea un número de una cifra
            System.out.println("Menú principal: ");
            System.out.println("1.	Abrir una nueva cuenta.");
            System.out.println("2.	Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
            System.out.println("3.	Obtener los datos de una cuenta concreta.");
            System.out.println("4.	Realizar un ingreso en una cuenta.");
            System.out.println("5.	Retirar efectivo de una cuenta.");
            System.out.println("6.	Consultar el saldo actual de una cuenta.");
            System.out.println("7.	Salir de la aplicación.");
            System.out.println("Introduzca una de las opciones de la lista anterior para comenzar):");
            inputMainMenu = input.nextLine()  ;
            System.out.println("La opción escogida es:" + inputMainMenu);
            Matcher matMain = patMain.matcher(inputMainMenu); //Compara la entrada con la regla REGEX
            while(!matMain.matches()){ /*Bucle condicional que itera mientras la entrada no tenga el formato definido en variable patMain*/
                System.out.println("Menú principal: ");
                System.out.println("1.	Abrir una nueva cuenta.");
                System.out.println("2.	Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
                System.out.println("3.	Obtener los datos de una cuenta concreta.");
                System.out.println("4.	Realizar un ingreso en una cuenta.");
                System.out.println("5.	Retirar efectivo de una cuenta.");
                System.out.println("6.	Consultar el saldo actual de una cuenta.");
                System.out.println("7.	Salir de la aplicación.");
                System.out.print("El valor introducido no es correcto, introduzca un número del 1 al 7 por favor:");
                inputMainMenu = input.nextLine();
                matMain = patMain.matcher(inputMainMenu);
            }

            //Este selector permite defnir el código para cada una de las opciones del menú prinicipal
            switch (Integer.parseInt(inputMainMenu)){
                case 1:
                    Pattern patAccount = Pattern.compile("[1-2]"); //Se establece regla para que el input sea un número de una cifra 1-2
                    System.out.println("Menú nueva cuenta:");
                    System.out.println("1.	Si quiere abrir una nueva CUENTA DE AHORRO");
                    System.out.println("2.	Si quiere abrir una nueva CUENTA CORRIENTE");
                    System.out.println("Introduzca una de las opciones de la lista anterior para comenzar):");
                    inputNewAccount = input.nextLine();
                    System.out.println("La opción escogida es:" + inputNewAccount);
                    Matcher matAccount = patAccount.matcher(inputNewAccount); //Compara la entrada con la regla REGEX
                    while(!matAccount.matches()){ /*Bucle condicional que itera mientras la entrada no tenga el formato definido en variable patAccount*/
                        System.out.println("Menú nueva cuenta:");
                        System.out.println("1.	Si quiere abrir una nueva CUENTA DE AHORRO");
                        System.out.println("2.	Si quiere abrir una nueva CUENTA CORRIENTE");
                        System.out.println("El valor introducido no es correcto, introduzca un número del 1 al 2 por favor:");
                        inputNewAccount = input.nextLine();
                        matAccount = patAccount.matcher(inputNewAccount);
                    }
                    switch (Integer.parseInt(inputNewAccount)){//este selector permite almacenar el diferente uso cuando se abre una cuenta corriente o una de ahorro
                        case 1:
                            System.out.println("Introduzca NOMBRE del titular de la cuenta:");
                            input_nombre = input.nextLine();
                            System.out.println("Introduzca PRIMER APELLIDO del titular de la cuenta: ");
                            input_apellido1 = input.nextLine();
                            System.out.println("Introduzca SEGUNDO APELLIDO del titular de la cuenta: ");
                            input_apellido2 = input.nextLine();
                            Pattern patDni = Pattern.compile("[0-9]{8}[a-zA-Z]");
                            System.out.println("Introduzca DNI del titular de la cuenta: ");
                            input_dni = input.nextLine();
                            Matcher matDni = patDni.matcher(input_dni);
                            while(!matDni.matches()){
                                System.out.println("El formato de DNI no es correcto, introduzca un DNI correcto del titular de la cuenta: ");
                                input_dni = input.nextLine();
                                matDni = patDni.matcher(input_dni);
                            }
                            Persona newClient = new Persona (input_nombre, input_apellido1, input_apellido2, input_dni);
                            System.out.println("Introduzca SALDO INICIAL de la nueva cuenta: ");
                            input_saldo = Float.parseFloat(input.nextLine());
                            Pattern patIban = Pattern.compile("ES[0-9]{20}");
                            System.out.println("Introduzca IBAN de la nueva cuenta: ");
                            input_iban = input.nextLine();
                            Matcher matIban = patIban.matcher(input_iban);
                            while(!matIban.matches()){
                                System.out.println("El formato del IBAN no es correcto, introduzca un IBAN correcto para la nueva cuenta: ");
                                input_iban = input.nextLine();
                                matIban = patIban.matcher(input_iban);
                            }
                            System.out.println("Introduzca el TIPO DE INTERÉS ANUAL de la nueva cuenta: ");
                            input_tipoInteresAnual = Float.parseFloat(input.nextLine());
                            CuentaAhorro newSavingsAccount = new CuentaAhorro (newClient, input_saldo, input_iban, input_tipoInteresAnual);
                            System.out.println("La nueva CUENTA DE AHORRO " + input_iban + " se ha creado correctamente");
                            arrayCuentas.abrirCuenta(newSavingsAccount);

                            break;

                        case 2:
                            System.out.println("Introduzca NOMBRE del titular de la cuenta: ");
                            input_nombre = input.nextLine();
                            System.out.println("Introduzca PRIMER APELLIDO del titular de la cuenta: ");
                            input_apellido1 = input.nextLine();
                            System.out.println("Introduzca SEGUNDO APELLIDO del titular de la cuenta: ");
                            input_apellido2 = input.nextLine();
                            Pattern patDni2 = Pattern.compile("[0-9]{8}[a-zA-Z]");
                            System.out.println("Introduzca DNI del titular de la cuenta: ");
                            input_dni = input.nextLine();
                            matDni = patDni2.matcher(input_dni);
                            while(!matDni.matches()){
                                System.out.println("El formato de DNI no es correcto, introduzca un DNI correcto del titular de la cuenta: ");
                                input_dni = input.nextLine();
                                matDni = patDni2.matcher(input_dni);
                            }
                            newClient = new Persona (input_nombre, input_apellido1, input_apellido2, input_dni);
                            System.out.println("Introduzca SALDO INICIAL de la nueva cuenta: ");
                            input_saldo = Float.parseFloat(input.nextLine());
                            Pattern patIban2 = Pattern.compile("ES[0-9]{20}");
                            System.out.println("Introduzca IBAN de la nueva cuenta: ");
                            input_iban = input.nextLine();
                            matIban = patIban2.matcher(input_iban);
                            while(!matIban.matches()){
                                System.out.println("El formato del IBAN no es correcto, introduzca un IBAN correcto para la nueva cuenta: ");
                                input_iban = input.nextLine();
                                matIban = patIban2.matcher(input_iban);
                            }
                            System.out.println("Introduzca la COMISIÓN DE MANTENIMIENTO de la nueva cuenta: ");
                            input_comisionMantenimiento = Float.parseFloat(input.nextLine());
                            System.out.println("Introduzca el TIPO DE INTERÉS DESCUBIERTO de la nueva cuenta: ");
                            input_tipoInteresDescubierto = Float.parseFloat(input.nextLine());
                            System.out.println("Introduzca la MÁXIMA CANTIDAD ACEPTADA DE DESCUBIERTO de la nueva cuenta: ");
                            input_maximoDescubierto = Float.parseFloat(input.nextLine());
                            CuentaCorriente newCurrentAccount = new CuentaCorriente (newClient, input_saldo, input_iban, input_comisionMantenimiento, input_tipoInteresDescubierto, input_maximoDescubierto);
                            System.out.println("La nueva CUENTA CORRIENTE " + input_iban + " se ha creado correctamente");
    //                        System.out.println("Saldo: " + newClient.getSaldo());
                            arrayCuentas.abrirCuenta(newCurrentAccount);

                            break;
                    }

                    break;

                case 2:
                    String [] listado = arrayCuentas.listadoCuentas();
                    System.out.println("Listado de cuentas existentes: ");
                    for (int i = 0; i<listado.length; i++){
                        if (listado[i]!=null){
                            System.out.println(listado[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduzca por favor el IBAN de la cuenta que busca:");
                    ibanBuscado = input.nextLine();
                    String output = arrayCuentas.informacionCuenta(ibanBuscado);
                    System.out.println("Información de la cuenta solicitada: ");
                    System.out.println(output);
                    
                    break;
                case 4:
                    System.out.println("Introduzca por favor el IBAN de la cuenta para el ingreso:");
                    ibanBuscado = input.nextLine();
                    System.out.println("Introduzca por favor la CANTIDAD a ingresar:");
                    ingreso = Float.parseFloat(input.nextLine());
                    boolean result = arrayCuentas.ingresoCuenta(ibanBuscado, ingreso);
                    if (result){
                        System.out.println("La operación se ha procesado correctamente.");
                    }else{
                        System.out.println("Ha ocurrido algún error con la operación.");
                    }

                    break;
                case 5:
                    System.out.println("Introduzca por favor el IBAN de la cuenta para la retirada:");
                    ibanBuscado = input.nextLine();
                    System.out.println("Introduzca por favor la CANTIDAD a retirar:");
                    retirada = Float.parseFloat(input.nextLine());
                    result = arrayCuentas.retiradaCuenta(ibanBuscado, retirada);
                    if (result){
                        System.out.println("La operación se ha procesado correctamente.");
                    }else{
                        System.out.println("Ha ocurrido algún error con la operación.");
                    }

                    break;
                case 6:    
                    System.out.println("Introduzca por favor el IBAN de la cuenta para la consulta de SALDO:");
                    ibanBuscado = input.nextLine();
                    aux_saldo = arrayCuentas.obtenerSaldo(ibanBuscado);
                    System.out.println("El saldo actual de la cuenta " +ibanBuscado+ " es: " +aux_saldo);

                    break;
                case 7:
                    System.out.println("Ha elegido finalizar el programa. El programa se cerrará.");

                    break;
            }
        }
    }
}