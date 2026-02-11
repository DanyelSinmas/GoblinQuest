package Herramientas;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;

/**
 * Clase que permite registrar los errores en tiempo de ejecución dentro de un
 * fichero externo
 *
 * @author User
 */
public class LogDeErrores implements Serializable {

    //variables y objetos necesarios
    File log;
    private final String LOG_PATH = "logs\\logErrores.txt";
    private final String LOG_ESTATE = "logs\\estadoLogE.txt";
    LocalDateTime ahora;
    String fechaFormateada;
    int numError = 0;

    public LogDeErrores() {
        log = new File(LOG_PATH);
        ahora = LocalDateTime.now();
        fechaFormateada = (" " + ahora.getYear() + "/" + ahora.getMonthValue() + "/" + ahora.getDayOfMonth() + " a las " + ahora.getHour() + ":" + ahora.getMinute()) + " horas.";
        cargarNumError();
    }

    /**
     * Metodo para cargar el conteo de errores
     */
    private void cargarNumError() {
        File estado = new File(LOG_ESTATE);
        try (Scanner scanner = new Scanner(estado)) {
            if (scanner.hasNextInt()) {
                numError = scanner.nextInt();
            }
        } catch (IOException ioe) {
            System.err.println("Error inesperado: " + ioe);
        }
    }

    /**
     * Metodo para guardar el numero total de errores
     */
    private void guardarNumError() {
        try (FileWriter numEstado = new FileWriter(LOG_ESTATE)) {
            numEstado.write(String.valueOf(numError));
        } catch (IOException ioe) {
            System.err.println("Error inesperado: " + ioe);
        }
    }

    /**
     * Registra un error incrementando el contador y guardando el numero de
     * error en el txt
     */
    public void registradorErrores(String error) {
        numError++;
        guardarNumError();
        try (FileWriter fw = new FileWriter(log, true)) {
            System.out.println("Error, comprueba el archivo " + log.getPath() + " para mas informacion");
            fw.write(numError + ". Fecha error:" + fechaFormateada + " Descripcion:" + error + "\n");
        } catch (IOException ioe) {
            System.out.println("Error al escribir log: " + ioe);
        }
    }
}
