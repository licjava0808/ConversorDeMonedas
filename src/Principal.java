import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionEscogida = 0;

        //Esta instancia se usa para realizar consultas de conversiones de moneda.
        VerificarConversion conversion = new VerificarConversion();

        /* La razón de pasarle como parámetro una instancia de
VerificarConversion; al constructor de Calculos es porque la clase
Calculos; necesita tener acceso a una instancia de VerificarConversion
para poder realizar las conversiones de moneda. */

        Calculos calculos = new Calculos(conversion);
        GeneradorDeArchivo generador = new GeneradorDeArchivo();

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n*****************************************************
                **** Bienvenidos al Conversor de Monedas JAAValdez ****
                
                1.-- Peso Mexicano ==========>> Dólar Estadounidense
                2.-- Peso Mexicano ==========>> Euro
                3.-- Peso Mexicano ==========>> Libra Esterlina
                4.-- Dólar Estadounidense ===>> Peso Mexicano
                5.-- Euro ===================>> Peso Mexicano
                6.-- Libra Esterlina ========>> Peso Mexicano
                7.-- Pesos Dominicanos ======>> Dólar Estadounidense
                8.-- Dólar Estadounidense ===>> Pesos Dominicanos
                9.-- Otra opción de Conversión
                10.- Salir
                """;

        while (opcionEscogida != 10) {
            try {
                System.out.println(menu);
                opcionEscogida = Integer.parseInt(lectura.nextLine());

                //Buscar la marca de tiempo actual
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObjet = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObjet);

                switch (opcionEscogida) {
                    case 1:
                        calculos.almacenarValor("MXN", "USD");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;

                    case 2:
                        calculos.almacenarValor("MXN", "EUR");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;

                    case 3:
                        calculos.almacenarValor("MXN", "GBP");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;

                    case 4:
                        calculos.almacenarValor("USD","MXN");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;

                    case 5:
                        calculos.almacenarValor("EUR","MXN");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;

                    case 6:
                        calculos.almacenarValor("GBP","MXN");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;

                    case 7:
                        calculos.almacenarValor("DOP","USD");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;


                    case 8:
                        calculos.almacenarValor("USD","DOP");
                        respuestas.add(formattedDate + "_" +
                                calculos.obtenerMensajeRespuesta());
                        break;


                    case 9:
                        calculos.almacenarValorTipificado();
                        respuestas.add(formattedDate + " _ " + calculos.obtenerMensajeRespuesta());
                        break;

                    case 10:
                        break;
                    default:
                        System.out.println("Ingrese una opción válida!");

                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error, Por favor ingresar solamente código de moneda válido.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error, Por favor ingrese un valor númerico que sea válido.");
            }
        }

        generador.guardarJson(respuestas);

        System.out.println("Finalizando la Aplicación!");
    }
}
