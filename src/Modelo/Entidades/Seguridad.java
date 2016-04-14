package Modelo.Entidades;
import java.io.*;
import java.security.*;
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/*CLASE ENCARGADA DE ENCRIPTAR CON EL ALGORITMO AES */
public class Seguridad {

    private SecretKey key;
    private Cipher cipher;
    private String algoritmo = "AES";
    private int keysize = 16;

    public Seguridad() {

    }

    public Seguridad(SecretKey key, Cipher cipher, String algoritmo, int keysize) {
        this.key = key;
        this.algoritmo = algoritmo;
        this.cipher = cipher;
        this.keysize = keysize;

    }

    public void addKey(String value) {
        byte[] valuebytes = value.getBytes();
        key = new SecretKeySpec(Arrays.copyOf(valuebytes, keysize), algoritmo);
    }

    public String encriptar(String texto) {
        String value = "";
        try {
            cipher = Cipher.getInstance(algoritmo);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] textobytes = texto.getBytes();
            byte[] cipherbytes = cipher.doFinal(textobytes);
            value = new BASE64Encoder().encode(cipherbytes);

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("1:  " + value);
            System.err.println(ex.getMessage());
        } catch (NoSuchPaddingException ex) {
            System.out.println("2:  " + value);
            System.err.println(ex.getMessage());
        } catch (InvalidKeyException ex) {
            System.out.println("3:  " + value);
            System.err.println(ex.getMessage());

        } catch (IllegalBlockSizeException ex) {
            System.out.println("4:  " + value);
            System.err.println(ex.getMessage());
        } catch (BadPaddingException ex) {
            System.out.println("5:  " + value);
            System.err.println(ex.getMessage());
        }
        return value;
    }

    public String desencriptar(String texto) {
        String str = "";
        try {
            byte[] value = new BASE64Decoder().decodeBuffer(texto);
            cipher = Cipher.getInstance(algoritmo);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] cipherbytes = cipher.doFinal(value);
            str = new String(cipherbytes);
        } catch (InvalidKeyException ex) {
            System.err.println(ex.getMessage());
        } catch (IllegalBlockSizeException ex) {
            System.err.println(ex.getMessage());
        } catch (BadPaddingException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex.getMessage());
        } catch (NoSuchPaddingException ex) {
            System.err.println(ex.getMessage());
        }
        return str;
    }

}
