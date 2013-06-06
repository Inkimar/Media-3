/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver.beans;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.nrm.mediaserver.service.MediaLocalService;

/**
 *
 * @author ingimar
 */
@Stateless
public class MediaLocalServiceBean implements MediaLocalService {

    @PersistenceContext(unitName = "MysqlStatesPU")
    private EntityManager em;

    @Override
    public void saveLocal(Object media) {
        em.merge(media);
    }

    @Override
    public String testLocal() {
        System.out.println("Metoden test");
        String s = this.getClass().getCanonicalName();
        return s;
    }

    @Override
    public String getLocalServerDate() {
        System.out.println("Metoden getLocalServerDate");
        Date date = new Date();
        return "EJB-LOCAL says Hello. Servertime is " + date.toString();
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
