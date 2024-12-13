package util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Clase que proporciona métodos para encriptar y desencriptar un número de teléfono usando AES.
 * La clave de encriptación es generada a partir de una clave secreta predefinida.
 */
public class EncriptacionTelefono {

    // Clave secreta para la encriptación y desencriptación
    private static final String CLAVE_SECRETA = "1234567890123456"; // 16 caracteres para AES-128

    /**
     * Encripta el número de teléfono utilizando AES.
     * 
     * @param telefono El número de teléfono a encriptar.
     * @return El número de teléfono encriptado en formato Base64.
     * @throws Exception Si ocurre un error durante la encriptación.
     */
    public static String encriptarTelefono(String telefono) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(telefono.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    /**
     * Desencripta un número de teléfono encriptado utilizando AES.
     * 
     * @param telefonoEncriptado El número de teléfono encriptado en formato Base64.
     * @return El número de teléfono desencriptado.
     * @throws Exception Si ocurre un error durante la desencriptación.
     */
    public static String desencriptarTelefono(String telefonoEncriptado) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(telefonoEncriptado));
        return new String(decrypted);
    }

}
