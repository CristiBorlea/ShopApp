package controllers;


import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @author Cristi Borlea
 * @version 1.0
 */
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * The doGet method return a response on a HTML page
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        ProductService productService = new ProductService();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>ProductServlet.java:doGet(): Servlet code!</title>");
            writer.println("</head>");

            writer.println("<body>");
            writer.println("<h1><u>Product list: </u></h1>");
            writer.println("<h3><table > <tr>\n" +
                    "  <th>      Name  </th>\n" +
                    "  <th>      Description  </th>\n" +
                    "  <th>      Price  </th>\n" +
                    "</tr></table><h3>");
            writer.println("<h3>" + productService.getAllProducts() + "</h3>");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
