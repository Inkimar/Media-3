OBS:
- Remember to edit the file se.nrm.mediaserver.util.BeanService in the web-module.
- you need to edit the ip-number.

5Augusti 2013:
- If testing the web then you must deploy the EAR-file.
- run by -> http://localhost:8080/MediaserverApp-web/Local
- - have not succeeded in adding a record to the database !?

5Augusti 2013:
- J2SE-client works - using remote-interface ( remember to check the IP-nummer ).

bean.test()
bean.getServerDate()
Using :
MediaService bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean");

Where 
@Remote // @Local
public interface MediaService {

    void save(Object media);
    String test();
    String getServerDate();
}

@Stateless
public class MediaServiceBean implements Serializable, MediaService {

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
