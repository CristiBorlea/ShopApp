package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Cristi Borlea
 * @version 1.0
 */
public class HomeServlet extends HttpServlet {

    public static final String LOCALHOST = "http://localhost:9005";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * The doGet method return a response on a HTML page
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>HomeServlet.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println(" <div align=\"center\"><h1>Welcome to my phones shop</h1></div><br>");
//                    writer.println("<h3>" + ProductDao.getNull()+"</h3>");
            writer.println("<p><a href=\"" + LOCALHOST + "/products\"><h1>View products</h1></a></p>");
            writer.println("<br> <br>");

//                    writer.println("<h3>" + ProductDao.getNull()+"</h3>");
            writer.println("<p><a href=\"" + LOCALHOST + "/categories\"><h1>View categories</h1></a></p>");
            writer.println("<br> <br>");


            writer.println("</body>");
            writer.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

