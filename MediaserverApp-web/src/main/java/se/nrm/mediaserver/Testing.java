/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.nrm.mediaserver.domain.*;
import se.nrm.mediaserver.service.MediaService;
import se.nrm.mediaserver.util.BeanService;

/**
 *
 * @author ingimar
 */
@WebServlet(name = "Testing", urlPatterns = {"/Testing"})
public class Testing extends HttpServlet {

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
            out.println("<h1>15:47 Testing at " + request.getContextPath() + "</h1>");
            MediaService bean = BeanService.outreach(); // this.outreach();
            out.println("<h1>15:47  Testing at " + bean + "</h1>"); // här kan jag se att det är en böna.

            out.println("<h1>15:47  Testing at " + bean.test() + "</h1>");
            Media media = this.get();
            out.println("<h1>Serverdate is  " + bean.getServerDate() + "</h1>");
            out.println("<h1>15:47  Testing skriver ut. " + media + "</h1>");
            // bean.save(media);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private Media get() {
        Media media = new Image();
        media.setFilename("Butterfly-22Maj-kl17:27.jpg");
        media.setOwner("Larssons");
        return media;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
