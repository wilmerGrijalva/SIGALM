/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.cnr.sigalm.ejbs;

import java.util.List;
import javax.ejb.Local;
import sv.gob.cnr.sigalm.entities.Menu;
import sv.gob.cnr.sigalm.entities.Rol;

/**
 *
 * @author javii
 */
@Local
public interface MenuFacadeLocal {

    void create(Menu menu);

    void edit(Menu menu);

    void remove(Menu menu);

    Menu find(Object id);

    List<Menu> findAll();

    List<Menu> findRange(int[] range);

    int count();
    
    List<Menu> listAllMenus(Rol rol);
}
