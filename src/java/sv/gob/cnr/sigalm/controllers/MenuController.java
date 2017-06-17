/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.cnr.sigalm.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import sv.gob.cnr.sigalm.ejbs.MenuFacadeLocal;
import sv.gob.cnr.sigalm.entities.Menu;
import sv.gob.cnr.sigalm.entities.Usuario;
import sv.gob.cnr.sigalm.util.Util;

/**
 *
 * @author Jramos93
 */
@Named
@SessionScoped
public class MenuController implements Serializable {
    //private static final long serialVersionUID = 1L;

    @EJB
    private MenuFacadeLocal menuFacadeLocal;
    private List<Menu> menuList;
    private MenuModel model;

    @PostConstruct
    public void init() {
        menuList = menuFacadeLocal.findAll();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void establecerPermisos() {
        boolean menuSinHijos=false;
        HttpSession httpSession = Util.getSession();
        Usuario usr = (Usuario) httpSession.getAttribute("usuario");
       
        System.out.println(" Antes For menus");
        System.out.println(" Usuario: "+usr.getUsrNombre());
        for (Menu m : menuList) {
            System.out.println("For menus");
            
            // Busco los menus padres
            if (m.getMnuPadreId() == null) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getMnuNombre());
                
                for(Menu sub:menuList){
                    Menu submenu = sub.getMnuPadreId();
                    if(submenu!=null){
                        if(submenu.getMnuId() == m.getMnuId()){
                            menuSinHijos=true;
                            DefaultMenuItem item = new DefaultMenuItem(sub.getMnuNombre());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                if(menuSinHijos){
                    model.addElement(firstSubmenu);
                }
                else{
                    DefaultMenuItem item = new DefaultMenuItem(m.getMnuNombre());
                    model.addElement(item);
                }
            }
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

}
