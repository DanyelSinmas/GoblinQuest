package Herramientas;

import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Daniel MP
 *
 * Clase que sirve para manejar el inicio de sesion y registro de usuarios
 */
public class Login {

    public static String nombreUser = "jugador 1";
    public static boolean sesionIniciada = false;
    protected static String userBBDD = "";
    protected static String passwordBBDD = "";
    LogDeErrores log = new LogDeErrores();

    /**
     * Metodo que devuelve una cadena de 5 numeros aleatorios
     *
     * @return
     */
    public void iniciarBBDD() {
        do {
            try {
                Scanner reader = new Scanner(System.in);
                System.out.println("Se requiere de iniciar la base de datos (MySQL)");
                System.out.println("Introduce el usuario");
                this.userBBDD = reader.nextLine();
                System.out.println("Introduce la contraseña");
                this.passwordBBDD = reader.nextLine();
                break;
            } catch (Exception e) {
                log.registradorErrores(" " + e);
            }
        } while (true);
    }

    public String crearCodigo() {
        int numAleatorio = 0;
        String codigo = "";

        for (int i = 0; i < 5; i++) {
            numAleatorio = (int) ((Math.random() * 9) + 1);
            codigo = codigo.concat("" + numAleatorio);
        }
        return codigo;
    }

    /**
     * Metodo que envia un email de autentificacion al correo del usuario
     * registrado
     *
     * @param emailDestinatario
     * @return
     */
    private String enviarAutentificacion(String emailDestinatario) {
        //datos usuario
        final String username = "danielclub007@gmail.com";
        final String password = "ctie ayzb udbj bmoj"; //contraseña de aplicaicón
        String codigo = crearCodigo();

        //se define el protocolo STMP de gmail, por ejemplo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);

            }
        });

        try {
            Message mensaje = new MimeMessage(session); //se crea el mensaje
            mensaje.setFrom(new InternetAddress("goblinquest@gmail.com")); //dirección FROM
            //destinatarios normales           
            mensaje.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailDestinatario));
            mensaje.setSubject("Codigo de autentificacion"); //título
            mensaje.setText("Introduzca el codigo de autentificacion: " + codigo); //Texto del mensaje

            //ejecución del envío
            Transport.send(mensaje);
            //System.out.println("Correo enviado correctamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
            log.registradorErrores(" " + e);
        }

        return codigo;
    }

    /**
     * Metodo para hashear la contraseña del usuario
     *
     * @param input
     * @param algoritmo
     * @return
     * @throws NoSuchAlgorithmException
     */
    private static String generarHash(String input, String algoritmo) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algoritmo);
        byte[] hashBytes = digest.digest(input.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public void registroUser() {
        Scanner reader = new Scanner(System.in);
        String username = "", password = "", email = "";

        try {
            //se incluye JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se conecta
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", Login.userBBDD, Login.passwordBBDD);
            //sesión
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM `goblindb`.`userdata`");
            rs.moveToInsertRow();
            System.out.println("Inserte email");
            email = reader.nextLine();
            rs.updateString("email", email);
            System.out.println("Inserte nombre de usuario");
            username = reader.nextLine();
            rs.updateString("nombre", username);
            System.out.println("Inserte password");
            password = reader.nextLine();
            String hash = generarHash(password, "SHA-256");
            rs.updateString("password", hash);
            rs.insertRow();
            //tijeras
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException esql) {
            System.out.println("Error SQL: " + esql);
            log.registradorErrores(" " + esql);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
            log.registradorErrores(" " + e);
        }
    }

    /**
     * Metodo para iniciar sesion
     *
     * @return
     */
    public boolean iniciarSesion() {
        Scanner reader = new Scanner(System.in);

        try {
            System.out.println("Inserte Email:");
            String email = reader.nextLine();//

            System.out.println("Inserte password:");
            String password = reader.nextLine();//
            String hash = generarHash(password, "SHA-256");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goblindb", Login.userBBDD, Login.passwordBBDD);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM userdata WHERE email = '" + email + "'");

            if (rs.next()) {
                if (rs.getString("password").equals(hash)) {
                    Login.nombreUser = rs.getString("nombre");
                    System.out.println("Introduce el codigo de autentificacion enviado al correo");
                    if (enviarAutentificacion(email).equals(reader.nextLine())) {
                        Login.sesionIniciada = true;
                        return true;
                    } else {
                        System.out.println("Codigo incorrecto");
                    }
                } else {
                    System.out.println("Contraseña incorrecta");
                }
            } else {
                System.out.println("Usuario no encontrado");
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            log.registradorErrores(" " + e);
        }
        return false;

    }
}
