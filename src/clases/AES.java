package clases;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec; 
import java.util.*;
import sun.misc.BASE64Encoder;

public class AES {

    public String encryptAES(String llavesimetrica, String mensaje){
        byte[] campoCifrado = null;
        
        SecretKeySpec key = new SecretKeySpec(llavesimetrica.getBytes(), "AES");
        Cipher cifrado;
        try {
            cifrado = Cipher.getInstance("AES");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            campoCifrado = cifrado.doFinal(mensaje.getBytes());
            
            String base64 = new BASE64Encoder().encode(campoCifrado);
            
            return base64;
        } catch (Exception e) {
            return "La longitud de la llave tiene que ser de 16, 24 o 32 caracteres ENCR";
        }
    }
    
    public byte[] encryptAESHidden(String llavesimetrica, String mensaje){
        byte[] campoCifrado = null;
        SecretKeySpec key = new SecretKeySpec(llavesimetrica.getBytes(), "AES");
        Cipher cifrado;
        try {
            cifrado = Cipher.getInstance("AES");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            campoCifrado = cifrado.doFinal(mensaje.getBytes());
            
            return campoCifrado;
            
        } catch (Exception e) {
            System.out.println("ERROR, la llave es muy chica o muy grande");
            System.out.println(e.getMessage());
        }
        
        return campoCifrado;
    }
    
    
    public String decryptAES(String llavesimetrica, byte[] campoCifrado){
        byte[] campoDescifrado = null;
        
        SecretKeySpec key = new SecretKeySpec(llavesimetrica.getBytes(), "AES");
        Cipher cifrado;       
        try {
            cifrado = Cipher.getInstance("AES");
            cifrado.init(Cipher.DECRYPT_MODE, key);
            byte[] mensajeDescifrado = cifrado.doFinal(campoCifrado);
            String mensajedesci = new String(mensajeDescifrado);
            
            return mensajedesci;
        } catch (Exception e) {
            return "La longitud de la llave tiene que ser de 16, 24 o 32 caracteres";
        }
    }
    
}