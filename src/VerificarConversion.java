import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class VerificarConversion {
    // Esta clase es encargada de realizar las consultas a una API para obtener las tasas de cambio entre diferentes monedas.

    public String buscarConversion(String monedaPrincipal, String monedaSecundaria, double cantidad){
        try {
            URI direccion=URI.create("https://v6.exchangerate-api.com/v6/c8cb0688181005cff00b5989/pair/" +
                    monedaPrincipal + "/" + monedaSecundaria + "/" + cantidad);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            return jsonObject.get("conversion_result").getAsString();


        }catch (NumberFormatException | IOException | InterruptedException e){
            System.out.println("Error en selección, favor revisar:");
            throw new RuntimeException("Error"+e.getMessage());
        }
    }
}
