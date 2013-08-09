/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.nrm.mediaserver.media3.domain.Image;
import se.nrm.mediaserver.media3.domain.Media;

import se.nrm.mediaserver.service.MediaLocalService;

/**
 *
 * @author ingimar
 */
@WebServlet(name = "LocalClient", urlPatterns = {"/LocalClient"})
public class LocalClient extends HttpServlet {

    @EJB
    MediaLocalService localBean;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Testing</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LOCAL Testing at " + request.getContextPath() + "</h1>");

            out.println("<h1>Testing at " + localBean + "</h1>"); // här kan jag se att det är en böna.

            out.println("<h1> Testing at " + localBean.testLocal() + "</h1>");
            
            Media media = this.getMedia();
            out.println("<h1>Serverdate is  " + localBean.getLocalServerDate() + "</h1>");
            out.println("<h1> Testing skriver ut. " + media + "</h1>");
            out.println("<h1> 2013-08-09 klockan 14:26 NOT Saving </h1>");
            localBean.saveLocal(media);
            out.println("<h1> 2013-08-09 klockan 14:26 SAVED ? </h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private Media getMedia() {
        Media media = new Image();
        media.setFilename("Butterfly-22Maj-kl17:27.jpg");
        media.setOwner("Larssons");
        return media;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
