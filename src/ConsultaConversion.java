import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {

    double realizaConversion(String divisa1, String divisa2, double cantidad) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/8616bcb6657cb3a38bd57e0c/latest/USD"+divisa1+"/"+divisa2+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
            return jsonResponse.get("conversion_result").getAsDouble();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
