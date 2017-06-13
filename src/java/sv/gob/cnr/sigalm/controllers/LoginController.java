/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.cnr.sigalm.controllers;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sv.gob.cnr.sigalm.ejbs.UsuarioFacadeLocal;
import sv.gob.cnr.sigalm.entities.Usuario;
import sv.gob.cnr.sigalm.util.Mensaje;

/**
 *
 * @author javii
 */

@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;
    private Mensaje m;
    private Boolean session=false;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getSession() {
        return session;
    }

    public void setSession(Boolean session) {
        this.session = session;
    }
    
    public String inciarSesion(){
        m = new Mensaje();
        String respuesta = null;
        try {
            Usuario u = usuarioFacadeLocal.login(this.usuario);
            if (u != null) {
                this.session=true;
                this.usuario.setUsrNombre(u.getUsrNombre());
                this.usuario.setUsrApellido(u.getUsrApellido());
                respuesta = "principal?faces-redirect=true"; // Navegación explicita
            }
            else{
                m.warn("Datos incorrectos");
            }
        } catch (Exception e) {
            m.error("Error");
        }
        return respuesta;
    }
    
    public void verificarSession(){
        session=true;
    }
}
