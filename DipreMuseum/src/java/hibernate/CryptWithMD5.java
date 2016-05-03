/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Visitatore;

/**
 *
 * @author FSEVERI\ramescu2755
 */
public class CryptWithMD5 {
   private static MessageDigest md;
   private   ManageDatabase db;


   public static String cryptWithMD5(String pass){
    try {
        md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
    }
        return null;
   }
   
   public Boolean verificaPassword(String nome,String pass){
    String in = cryptWithMD5(pass);
    List<Visitatore> visitatori = db.getVisitatori();
        for (int i = 0; i < visitatori.size(); i++) {
            if (visitatori.get(i).getPassword().equals(in) && visitatori.get(i).getUsername().equals(nome)) {
                return true;
            }
        }
    return false;
   }
   
   
}

