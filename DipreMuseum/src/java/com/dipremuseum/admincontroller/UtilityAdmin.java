/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dipremuseum.admincontroller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Amministratore;

/**
 *
 * @author Omar
 */
public class UtilityAdmin {
    public static boolean authcheck(List<Amministratore> admins,HttpServletRequest request) {
        Integer uid = (Integer) request.getSession().getAttribute("useridadmin");
        if (uid == null) {
            return false;
        }
        for (Amministratore admin : admins) {
            if (admin.getId() == uid) {
                return true;
            }
        }
        return false;
    }
}
