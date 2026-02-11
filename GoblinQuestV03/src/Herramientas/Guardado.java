package Herramientas;

import java.io.*;
import Mapa.Mapa;
import Personajes.Protagonista;
import java.util.Scanner;

/**
 * Clase que permite el uso de diferentes guardados y cargados
 *
 * @author Daniel MP
 */
public class Guardado implements Serializable {

    private final String RUTA_GUARDADO = "saves/guardar.txt";
    Scanner reader = new Scanner(System.in);

    /**
     * Metodo que guarda el estado de los objetos en un txt
     *
     * @param mc
     * @param mapa
     */
    public void guardar(Protagonista mc, Mapa mapa) {
        if (!Login.sesionIniciada) {
            System.out.println("Para guardar debes iniciar sesion");
            return;
        }

        Object[] objetos = cargarTodo();

        System.out.println("En que ranura de guardado quieres guardar? (1 o 2)");
        int opcion = reader.nextInt();

        int index;
        if (opcion == 1) {
            index = 0;
        } else {
            index = 2;
        }
        objetos[index] = mc;
        objetos[index + 1] = mapa;

        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(RUTA_GUARDADO);
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < 4; i++) {
                oos.writeObject(objetos[i]);
            }
            System.out.println("Guardado exitoso en ranura " + opcion);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar flujo: " + e);
            }
        }
    }

    /**
     * Metodo para comprobar si el archivo está vacío
     *
     * @return
     */
    public boolean archivoVacio() {
        File archivo = new File(RUTA_GUARDADO);

        if (archivo.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para cargar los objetos del archivo de guardado
     *
     * @return
     */
    private Object[] cargarTodo() {
        File svf = new File(RUTA_GUARDADO);
        Object[] objetos = new Object[4];

        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(svf);
            ois = new ObjectInputStream(fis);
            for (int i = 0; i < 4; i++) {
                try {
                    objetos[i] = ois.readObject();
                } catch (EOFException e) {

                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de guardado no encontrado: " + e);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar: " + e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar flujo: " + e);
            }
        }
        return objetos;
    }

    /**
     * Metodo para cargar los objetos del archivo de guardado, si es la ranura 1
     * carga los dos primeros, si es la 2, los dos últimos
     *
     * @param numPartida
     * @return
     */
    public Object[] cargar(int numPartida) {
        do {
            if (!Login.sesionIniciada) {
                System.out.println("Para cargar partida debes iniciar sesion");
            } else {
                Object[] objetos = cargarTodo();
                int index;
                if (numPartida == 1) {
                    index = 0;
                } else {
                    index = 2;
                }

                if (objetos[index] == null || objetos[index + 1] == null) {
                    System.out.println("No hay partida guardada en la ranura " + numPartida);
                    return null;
                }

                return new Object[]{objetos[index], objetos[index + 1]};
            }

        } while (true);

    }//fin cargar

}//fin class
