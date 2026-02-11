package MainGame;

import Herramientas.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Daniel MP
 */
public class Main {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        //instanciación necesaria de objetos
        Juego partida = new Juego();
        Scanner reader = new Scanner(System.in);
        Login login = new Login();
        LogDeErrores log = new LogDeErrores();
        int opcion = 0;
        
        //comienzo del código
        do {
            try {
                while (true) {
                    if (Login.sesionIniciada == false) {
                        System.out.println("Quieres iniciar la base de datos?\n"
                                + "(Esta es esencial si pretendes guardar partida y tener un perfil,"
                                + "de lo contraro, se recomienda no iniciarla)\n"
                                + "1: Si 2: No");
                        opcion = reader.nextInt();
                        if (opcion == 1) {
                            login.iniciarBBDD();
                        }
                    }
                    System.out.println("Bienvenido a goblin quest");
                    System.out.println("Quieres iniciar sesion o registrarte?\n1:No 2:Registrarme 3:Iniciar sesion 4:Salir");
                    opcion = reader.nextInt();
                    switch (opcion) {
                        case 1:
                            Login.sesionIniciada = false;
                            break;
                        case 2:
                            login.registroUser();
                        case 3:
                            login.iniciarSesion();
                            break;
                        case 4:
                            System.exit(0);
                    }
                    partida.jugar();
                }
            } catch (Exception e) {
                log.registradorErrores(" " + e);
                reader.nextLine();
            }
        } while (true);

    }//fin main

    //Herramienta de utilidad para generar pausas en el código
    public static void esperar(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El sleep fue interrumpido: " + e.getMessage());
        }
    }

}//fin class
