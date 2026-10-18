package ventilacion;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GenerarDatosVentilacion {

    public static void main(String[] args) throws Exception {
        List<String> lineas = Files.readAllLines(Paths.get("ventilacion/datos_ventilacion.csv"));

        List<String> dias = new ArrayList<>();
        List<String> velocidades = new ArrayList<>();
        List<String> usos = new ArrayList<>();

        for (int i = 1; i < lineas.size(); i++) {
            String[] columnas = lineas.get(i).split(",");
            dias.add(columnas[0]);
            velocidades.add(columnas[1]);
            usos.add(columnas[2]);
        }

        String js = "var dias = ['" + String.join("','", dias) + "'];\n"
                + "var velocidades = [" + String.join(",", velocidades) + "];\n"
                + "var usos = [" + String.join(",", usos) + "];\n";

        Files.writeString(Paths.get("ventilacion/datos_ventilacion.js"), js);
        System.out.println("Datos generados: datos_ventilacion.js");
    }
}
