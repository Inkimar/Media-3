package se.testing.maven.j2se.client;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import se.nrm.mediaserver.service.MediaService;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Start 9Augusti : 14:51: Hej världen!");
        try {

            MediaService bean = fetchBean();
            System.out.println("Response coming from bean :->" + bean.test()+"<-");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("END: Hej världen!");
    }

    /*
     * using the remote
     */
    private static MediaService fetchBean() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "172.16.23.18");
        Context ctx = new InitialContext(jndiProps);
        //  	MediaserverApp-ear
        MediaService bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean");
        return bean;
    }
}
