package Modelo;

/* CLASE GENERADORA DE ADVERTENCIAS PARA EL USUARIO.*/
public class Advertencia {

    private String mensaje;

    public Advertencia() {
    }

    public String getCorrespondenciaRemitente() {
        mensaje = "Es necesario ingresar el personal remitente.";
        return mensaje;
    }

    public String getConexionFallida() {
        mensaje = "Por favor verifique su conexión a internet e intentelo de nuevo.";
        return mensaje;
    }

    public String getDatosInc() {
        mensaje = "Debe ingresar los campos completamente.";
        return mensaje;
    }

    public String getLongContrasena() {
        mensaje = "La longitud de la contraseña debe ser de 6 a 10 caracteres.";
        return mensaje;
    }

    public String getSeleccionUsuario() {
        mensaje = "Debe elegir el funcionario que desea registrar como usuario.";
        return mensaje;
    }

    public String getIncIdentificacion() {
        mensaje = "Debe ingresar la identificación.";
        return mensaje;
    }

    public String getCuentaInactivada() {
        mensaje = "Cuenta inactiva, no puede recuperar la contraseña.";
        return mensaje;
    }

    public String getContrasenaInc() {
        mensaje = "Contraseñas no coinciden.";
        return mensaje;
    }

    public String getContrasena() {

        mensaje = "La contraseña es incorrecta.";
        return mensaje;
    }

    public String getUsuario() {

        mensaje = "Esta cuenta no existe.";
        return mensaje;
    }

    public String getInactivacion() {

        mensaje = "Su cuenta se ha inactivado";
        return mensaje;
    }

    public String getIdentificacion() {

        mensaje = "La identificación ingresada no existe";
        return mensaje;
    }

    public String getadvInactiva(int n) {

        mensaje = "Lleva " + n + " intento(s) errado(s); al quinto intento fallido, su cuenta será inactivada";
        return mensaje;
    }

    public String getCorreoEnviado() {

        mensaje = "Correo enviado satisfactoriamente. ";
        return mensaje;
    }

    public String getRegistroUsuario() {

        mensaje = "El usuario se ha registrado satisfactoriamente. ";
        return mensaje;
    }

    public String getRegistroFuncionario() {

        mensaje = "El funcionario se ha registrado satisfactoriamente. ";
        return mensaje;
    }

    public String getCorreoInvalido() {

        mensaje = "El formato del correo electronico es invalido. ";
        return mensaje;
    }

    public String getusuarioRegistrado() {

        mensaje = "El Funcionario que ha ingresado ya se encuentra registrado. ";
        return mensaje;
    }

    public String getModificarUsuario() {

        mensaje = "El Funcionario se ha modificado satisfactoriamente. ";
        return mensaje;
    }

    public String getConfUsuario() {

        mensaje = "El Usuario se ha modificado satisfactoriamente. ";
        return mensaje;
    }

    public String getModificar() {

        mensaje = "Debe seleccionar la fila del funcionario a modificar. ";
        return mensaje;
    }

    public String getModificarFuncionario() {

        mensaje = "El Funcionario se ha modificado satisfactoriamente. ";
        return mensaje;
    }

}
