/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.site;

import Models.WA2P_Utente;
import java.util.ArrayList;

/**
 *
 * @author FSEVERI\bizzotto3061
 */
public class Login {
    private String username;
    private String password;
    private Database db;
    
    
    public Login(String user, String pw, Database db){
        username=user;
        password=pw;
        this.db=db;
    }//Login
    
    public WA2P_Utente checkLogin(){
        WA2P_Utente u;
        ArrayList<WA2P_Utente> ut= db.getUtenti();
        for(WA2P_Utente utente : ut){
            if(utente.getNickname().equals(username)&& utente.getPw().equals(password)){
                u=utente;
                return u;
            }
        }
        return null;
    }
    
    
}//Login
