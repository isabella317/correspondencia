package Modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*CLASE ENCARGADA DE MANEJO DE FICHEROS PARA MODIFICAR EL NOMBRE DEL ARCHIVO Y ARCHIVARLO */
public class ManejoArchivo {
    

    public  void copiarArchivo(String archivoOrigen, String archivoDestino) throws IOException {
        
        FileInputStream copiarDesde = null;
        FileOutputStream copiarA = null;

        try {
            copiarDesde = new FileInputStream(archivoOrigen);
            copiarA = new FileOutputStream(archivoDestino);
            byte[] buffer = new byte[4096];
            int lecturaBytes;

            while ((lecturaBytes = copiarDesde.read(buffer)) != -1) {
                copiarA.write(buffer, 0, lecturaBytes);
            }
            System.out.println("El archivo se ha copiado correctamente.");
        } finally {
            if (copiarDesde != null) {
                try {
                    copiarDesde.close();
                } catch (IOException IOE) {
                    ;
                }
            }
            if (copiarA != null) {
                try {
                    copiarA.close();
                } catch (IOException IOE) {
                    ;
                }
            }
        }
    }

    public void renombrarArchivo(File actual, File proximo) {
        boolean a=actual.renameTo(actual);
}
}
