package se.nrm.mediaserver.beans;

import java.io.Serializable;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.nrm.mediaserver.service.MediaService;

/**
 *
 * @author ingimar
 */
@Stateless
public class MediaServiceBean implements MediaService {

    @PersistenceContext(unitName = "MysqlStatesPU")
    private EntityManager em;

    @Override
    public String test() {
        System.out.println("Metoden test");
        String s = this.getClass().getCanonicalName();
        return s;
    }

    @Override
    public String getServerDate() {
        System.out.println("Metoden getServerDate");
        Date date = new Date();
        return "EJB-bean says Hello. Servertime is " + date.toString();
    }

    @Override
    public void save(Object media) {
        em.merge(media);
    }
}
