package controllers;

import dto.CharacteristicDto;
import dto.ProductDto;
import dto.ProductReviewDto;
import service.CharacteristicService;
import service.ProductService;
import service.ReviewService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "CharacteristicServlet")
public class CharacteristicServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * The doGet method return a response on a HTML page
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        CharacteristicService characteristicService = new CharacteristicService();
        ProductService productService = new ProductService();
        ReviewService reviewService = new ReviewService();

        try (PrintWriter writer = response.getWriter()) {
            String characteristic = request.getParameter("characteristic");
            int productId = Integer.parseInt(characteristic);

            ProductDto product = productService.getProductById(productId);
            List<ProductReviewDto> reviewDTOList = reviewService.getReviewsForProduct(productId);
            List<CharacteristicDto> characteristicDtoList = characteristicService.getCharacteristicForProduct(productId);

            writer.println("<!DOCTYPE html><html>");
            writer.println("<head>");
            writer.println("<meta charset=\"UTF-8\" />");
            writer.println("<title>CharacteristicServlet.java:doGet(): Servlet code!</title>");
            writer.println("</head>");
            writer.println("<body>");

            writer.println("<h1><u>Product Characteristics: </u></h1>");
            writer.println("<h3><table > <tr>\n" +
                    "  <th>      Name  </th>\n" +
                    "  <th>      Description  </th>\n" +
                    "  <th>      Price  </th>\n" +
                    "</tr></table><h3>");
            writer.println("<h3>" + product + "</h3>");

            writer.println("<h2>Product Review: </h2>");
            writer.println("<h3><table > <tr>\n" +
                    "  <th>      Review  </th>\n" +
                    "  <th>      Username  </th>\n" +
                    "  <th>      Email  </th>\n" +
                    "</tr></table><h3>");
            writer.println("<h3>" + reviewDTOList + "</h3>");

            writer.println("<h2>Product Features: </h2>");
            writer.println("<h3>" + characteristicDtoList + "</h3>");
        } catch (SQLException | NumberFormatException e) {
            System.err.println(e);
        }
    }
}
