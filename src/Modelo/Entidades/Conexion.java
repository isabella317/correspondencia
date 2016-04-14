package Modelo.Entidades;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/* CLASE CONEXION ENCARGADO DE REALIZAR CONSULTAS Y ESTABLECER CONEXION A BD */
public class Conexion {

    private static EntityManagerFactory EnConexion;
    private static DAO.Tablas.Usuario UsDaoTabla;
    private static DAO.Tablas.Rol RlDaoTabla;

    public Conexion() {
        UsDaoTabla = new DAO.Tablas.Usuario();
        RlDaoTabla = new DAO.Tablas.Rol();

        EnConexion = Persistence.createEntityManagerFactory("correspondenciaPU");

    }

    private static Conexion conexion;

    public static Conexion getInstance() {

        if (conexion == null) {
            conexion = new Conexion();
        }

        return conexion;
    }

    public EntityManagerFactory getConexion() {
        return EnConexion;
    }
}
