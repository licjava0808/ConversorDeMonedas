import java.util.Scanner;

public class Calculos {
    //Esta clase es la encargada de manejar la lógica relacvionada con las conversiones de moneda. Pero para poder realizarlo necesita información de las tasas de cambio obtenidas a través de ConsultaDeConversion para realizar estas conversiones.
    private String monedaPrincipal;
    private String monedaSecundaria;
    private double cantidadCambiar;

    Scanner lectura = new Scanner(System.in);
    VerificarConversion conversion;

    /* Escoge una instancia de VerificarConversion como parámetro y la asigna a una variable de instancia llamada conversion. De esta forma conseguimos, que cada objeto de Calculos tenga acceso a una
instancia de VerificarConversion, lo que le permite al sistema realizar consultas de conversiones de moneda cuando sea necesario. */

    public Calculos(VerificarConversion conversion) {
        this.conversion = conversion;
    }

    public String getMonedaPrincipal() {
        return monedaPrincipal;
    }

    public String getMonedaSecundaria() {
        return monedaSecundaria;
    }

    public double getCantidadCambiar() {
        return cantidadCambiar;
    }

    public void almacenarValor(String monedaPrincipal, String monedaSecundaria) {
        this.monedaPrincipal = monedaPrincipal;
        this.monedaSecundaria = monedaSecundaria;

        System.out.println("Ingrese el monto que deseas Convertir:");
        this.cantidadCambiar = Double.parseDouble(lectura.nextLine());
    }

    public void almacenarValorTipificado() {
        String menuOtrasOpciones = """
                Currency Code    Currency Name           Country
                MXN              Mexican Peso            Mexico
                USD              United States Dollar    United States
                ARS              Argentine Peso          Argentina
                BOB              Bolivian Boliviano      Bolivia
                BRL              Brazilian Real          Brazil
                CLP              Chilean Peso            Chile
                COP              Colombian Peso          Colombia
                DOP              Dominican Peso          Dominican Republic
                """;

        System.out.println(menuOtrasOpciones);
        System.out.println("Ingrese la moneda Principal con 3 caracteres");
        this.monedaPrincipal = lectura.next();
        System.out.println("Ingrese la moneda Secundaria con 3 caracteres");
        this.monedaSecundaria = lectura.next();

        boolean entradaCorrecta = false;
        do {
            System.out.println("Ingrese el monto que deseas Convertir:");
            if (lectura.hasNextDouble()) {
                this.cantidadCambiar = lectura.nextDouble();
                entradaCorrecta = true;
            } else {
                System.out.println("Error, Por favor ingrese un monto en formato númerico.");
                lectura.next(); //Limpiar el buffer de entrada.
            }
        } while (!entradaCorrecta);
    }

    public String obtenerMensajeRespuesta(){
        String mensaje = getMonedaPrincipal().toUpperCase() + "$ " + getCantidadCambiar() + " " + " Equivalentes a: " + getMonedaSecundaria().toUpperCase()+"$ " + conversion.buscarConversion(getMonedaPrincipal(),getMonedaSecundaria(),cantidadCambiar);
        System.out.println(mensaje);
        return mensaje;
    }
}


