package ventilacion;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ObtenerDatosVentilacion {

    public static void main(String[] args) throws Exception {
        String url = "https://api.open-meteo.com/v1/forecast?latitude=40.4168&longitude=-3.7038&daily=wind_speed_10m_mean&wind_speed_unit=kmh&forecast_days=7&timezone=auto";

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder(URI.create(url)).build();
        String json = cliente.send(peticion, HttpResponse.BodyHandlers.ofString()).body();

        String[] dias = sacarLista(json, "time");
        String[] velocidades = sacarLista(json, "wind_speed_10m_mean");

        List<String> lineas = new ArrayList<>();
        lineas.add("Día,Velocidad del viento (km/h),Uso estimado de ventilación (kWh)");
        for (int i = 0; i < dias.length; i++) {
            double velocidad = Double.parseDouble(velocidades[i]);
            lineas.add(dias[i] + "," + velocidad + "," + calcularUso(velocidad));
        }

        Files.write(Paths.get("ventilacion/datos_ventilacion.csv"), lineas);
        System.out.println("CSV generado: datos_ventilacion.csv");
    }

    static double calcularUso(double velocidad) {
        if (velocidad <= 10) {
            return Math.round((10 - velocidad) * 50) / 10.0;
        }
        return 0;
    }

    static String[] sacarLista(String json, String clave) {
        String marca = "\"" + clave + "\":[";
        int inicio = json.indexOf(marca) + marca.length();
        int fin = json.indexOf("]", inicio);
        return json.substring(inicio, fin).replace("\"", "").split(",");
    }
}
