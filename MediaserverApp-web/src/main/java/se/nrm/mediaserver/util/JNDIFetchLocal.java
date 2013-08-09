/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver.util;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import se.nrm.mediaserver.service.MediaLocalService;

/**
 *
 * @author ingimar
 */
public class JNDIFetchLocal {

//    public static MediaLocalService outreach() {
//        MediaLocalService bean = null;
//        try {
//            Properties jndiProps = new Properties();
//            jndiProps.put("java.naming.factory.initial", "com.sun.enterprise.naming.impl.SerialInitContextFactory");
//            jndiProps.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
//            jndiProps.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
//
//            jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "172.16.34.34");
//            Context ctx = new InitialContext(jndiProps); //
//            /*
//             * EJB5181:Portable JNDI names for EJB MediaLocalServiceBean: 
//             * [java:global/MediaserverApp-ejb/MediaLocalServiceBean, 
//             * java:global/MediaserverApp-ejb/MediaLocalServiceBean!se.nrm.mediaserver.service.MediaLocalService]|#]
//             * java:global/MediaserverApp-ejb/MediaLocalServiceBean!se.nrm.mediaserver.service.MediaLocalService
//             */
//            bean = (MediaLocalService) ctx.lookup("java:global/MediaserverApp-ejb/MediaLocalServiceBean!se.nrm.mediaserver.service.MediaLocalService");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
