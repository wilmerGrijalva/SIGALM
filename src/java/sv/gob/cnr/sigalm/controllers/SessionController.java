/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.cnr.sigalm.controllers;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import sv.gob.cnr.sigalm.entities.Usuario;

/**
 *
 * @author javii
 */
@Named
@ViewScoped
public class SessionController implements Serializable{
    
    public void verificarSesion(){
        FacesContext fc = FacesContext.getCurrentInstance();
        try {
            Usuario u = (Usuario) fc.getExternalContext().getSessionMap().get("usuario");
            fc.getExternalContext().redirect("index.xhtml");
            if (u == null){
                fc.getExternalContext().redirect("index.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
