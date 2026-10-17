package calefaccion;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObtenerDatosCalefaccion {

    public static void main(String[] args) throws Exception {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=40.4168&longitude=-3.7038&daily=temperature_2m_mean&forecast_days=7&timezone=auto";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder(URI.create(url)).build();
        String json = cliente.send(peticion, HttpResponse.BodyHandlers.ofString()).body();

        String[] dias = sacarLista(json, "time");
        String[] temperaturas = sacarLista(json, "temperature_2m_mean");

        for (int i = 0; i < dias.length; i++) {
            System.out.println(dias[i] + " -> " + temperaturas[i] + " °C");
        }
    }

    static String[] sacarLista(String json, String clave) {
        String marca = "\"" + clave + "\":[";
        int inicio = json.indexOf(marca) + marca.length();
        int fin = json.indexOf("]", inicio);
        return json.substring(inicio, fin).replace("\"", "").split(",");
    }
}