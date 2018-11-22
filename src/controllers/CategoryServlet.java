package controllers;

import dto.CategoryDto;
import service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Cristi Borlea
 * @version 1.0
 */
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * The doGet method return a response on a HTML page
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        CategoryService categoryService = new CategoryService();

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>CategoryServlet.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            List<CategoryDto> allCategories = categoryService.getAllCategories();
            writer.println("<h1><u>CategoryDto list: <u></h1>");
            writer.println("<h3><table > <tr>\n" +
                    "  <th>      CategoryDto  </th>\n" +
                    "</tr></table><h3>");
            writer.println("<h3>" + allCategories + "</h3>");
            writer.println("</body>");
            writer.println("</html>");
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
}
