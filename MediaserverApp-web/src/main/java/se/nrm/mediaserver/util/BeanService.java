package se.nrm.mediaserver.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import se.nrm.mediaserver.service.MediaService;

/**
 *
 * @author ingimar
 */
public class BeanService {
    public static MediaService outreach() {
        MediaService bean = null;
        try {
            Properties jndiProps = new Properties();
            jndiProps.put("java.naming.factory.initial", "com.sun.enterprise.naming.impl.SerialInitContextFactory");
            jndiProps.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
            jndiProps.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
            
            // Lenovo = 172.16.34.31 , Mint = 172.16.34.34
            jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "172.16.34.34"); // 192.168.10.163, 172.16.34.31, 172.16.34.34
            Context ctx = new InitialContext(jndiProps); //
            bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean!se.nrm.mediaserver.service.MediaService");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
