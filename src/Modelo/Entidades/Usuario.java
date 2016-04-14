package Modelo.Entidades;

public class Usuario {

    private String nombre;
    private String apellido;
    private String telefono;
    private String identificacion;
    private String correo;
    private String contrasena;
    private String cargo;
    private int rol;

    public Usuario() {
    }

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;

    }

    public Usuario(String nombre, String apellido, String telefono, String identificacion, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.correo = correo;

    }

    public Usuario(String nombre, String apellido, String telefono, String identificacion, String correo, String contrasena, String cargo,int rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.correo = correo;
        this.contrasena = contrasena;
        this.cargo = cargo;
        this.rol=rol;

    }

    //metodos registrar, modificar,consultar   
    /**
     * @return the nombre1
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre1 the nombre1 to set
     */
    public void setNombre1(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido1
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the rol
     */
    public int getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

}
