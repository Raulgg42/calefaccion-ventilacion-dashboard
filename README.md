# calefaccion-ventilacion-dashboard
Dashboards web con ECharts que estiman el consumo de calefacción y ventilación a partir de datos meteorológicos

## Requisitos

- Java 11 o superior
- Conexión a internet, para descargar los datos de la API Open-Meteo y para que el navegador cargue la librería ECharts.
- Un navegador web para abrir los dashboards.

No hace falta ninguna clave de API: Open-Meteo es gratuita y no pide registro.

## Cómo ejecutar el paquete `calefaccion`

Sigue estos pasos en orden:

1. Ejecuta la clase `ObtenerDatosCalefaccion` para generar el archivo `datos_calefaccion.csv` y espera a que se genere correctamente.
2. Ejecuta la clase `GenerarDatosCalefaccion` para generar el archivo `datos_calefaccion.js` y espera a que se genere correctamente.
3. Abre el archivo `dashboard_calefaccion.html` en el navegador.

**Importante:** estos pasos deben repetirse cada día para actualizar los datos del dashboard. Si no se ejecutan de nuevo, los datos estarán desactualizados.


## Cómo ejecutar el paquete `ventilacion`

Sigue estos pasos en orden:

1. Ejecuta la clase `ObtenerDatosVentilacion` para generar el archivo `datos_ventilacion.csv` y espera a que se genere correctamente.
2. Ejecuta la clase `GenerarDatosVentilacion` para generar el archivo `datos_ventilacion.js` y espera a que se genere correctamente.
3. Abre el archivo `dashboard_ventilacion.html` en el navegador.

**Importante:** estos pasos deben repetirse cada día para actualizar los datos del dashboard. Si no se ejecutan de nuevo, los datos estarán desactualizados.


