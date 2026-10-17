package calefaccion;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GenerarDatosCalefaccion {

    public static void main(String[] args) throws Exception {
        List<String> lineas = Files.readAllLines(Paths.get("calefaccion/datos_calefaccion.csv"));

        List<String> dias = new ArrayList<>();
        List<String> temperaturas = new ArrayList<>();
        List<String> consumos = new ArrayList<>();

        for (int i = 1; i < lineas.size(); i++) {
            String[] columnas = lineas.get(i).split(",");
            dias.add(columnas[0]);
            temperaturas.add(columnas[1]);
            consumos.add(columnas[2]);
        }

        String js = "var dias = ['" + String.join("','", dias) + "'];\n"
                + "var temperaturas = [" + String.join(",", temperaturas) + "];\n"
                + "var consumos = [" + String.join(",", consumos) + "];\n";

        Files.writeString(Paths.get("calefaccion/datos_calefaccion.js"), js);
        System.out.println("Datos generados: datos_calefaccion.js");
    }
}