/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.cnr.sigalm.ejbs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.cnr.sigalm.entities.Rol;
import sv.gob.cnr.sigalm.entities.Usuario;

/**
 *
 * @author javii
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "SIGALMPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public List<Rol> listAllRoles() {
        List<Rol> listRoles = null;
        try {
            listRoles = em.createNamedQuery("Rol.findAll").getResultList();
        } catch (Exception e) {
        }
        return listRoles;
    }

    @Override
    public Usuario login(Usuario u) {
        Usuario usuario = null;
        System.out.println("Fachada");
        try {
            System.out.println("try");
            System.out.println("Controler us: "+u.getUsrUsuario());
            System.out.println("Controler us: "+u.getUsrContrasenia());
            List<Usuario> usuarios = 
                    em.createNamedQuery("Usuario.login").
                            setParameter("usrUsuario", u.getUsrUsuario()).setParameter("usrContrasenia", u.getUsrContrasenia())
                            .getResultList();
            if (!usuarios.isEmpty()) {
                System.out.println("empty");
                usuario = usuarios.get(0);
            }
            System.out.println("finTry");
        } catch (Exception e) {
        }
        
        return usuario;
    }
    
}
