/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herramientas;

import java.sql.*;

/**
 * @author Daniel MP 
 * Clase que registra diferentes parámetros de la pártida en
 * una BBDD
 */
public class RegistradorBBDD {

    public RegistradorBBDD() {
    }

    /**
     * Metodo que cada vez que se da un paso, se suma 1 en la celda de la base de datos
     */
    public void registradorPasos() {
        try {
            //se incluye JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se conecta
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", Login.userBBDD, Login.passwordBBDD);
            //sesión
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM `goblindb`.`estadisticas`");
            
             stmt.executeUpdate("UPDATE `goblindb`.`estadisticas` SET `pasos` = `pasos` + 1");
            
            //tijeras
            conn.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException esql) {
            System.out.println("Error SQL: " + esql);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
        }
    }
    
    /**
     * Metodo que registra el numero de enemigos que ha derrotado en total a lo
     * largo de diferentes partidas
     */
    public void registradorBajas() {
        try {
            //se incluye JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se conecta
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", Login.userBBDD, Login.passwordBBDD);
            //sesión
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM `goblindb`.`estadisticas`");
            
             stmt.executeUpdate("UPDATE `goblindb`.`estadisticas` SET `enemigosderrotados` = `enemigosderrotados` + 1");
            
            //tijeras
            conn.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException esql) {
            System.out.println("Error SQL: " + esql);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
        }
    }
    
    /**
     * Metodo que mantiene el conteo de game overs
     */
    public void registradorMuertes() {
        try {
            //se incluye JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            //se conecta
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", Login.userBBDD, Login.passwordBBDD);
            //sesión
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //resultSet
            ResultSet rs = stmt.executeQuery("SELECT * FROM `goblindb`.`estadisticas`");
            
             stmt.executeUpdate("UPDATE `goblindb`.`estadisticas` SET `muertes` = `muertes` + 1");
            
            //tijeras
            conn.close();
            stmt.close();
        } catch (ClassNotFoundException | SQLException esql) {
            System.out.println("Error SQL: " + esql);
        } catch (Exception e) {
            System.out.println("Error desconocido: " + e);
        }
    }
    
    

}
