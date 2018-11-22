package service;

import dao.ProductDao;
import dto.ProductDto;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service handling business logic of product entities.
 *
 * @author Cristi Borlea
 * @version 1.0
 */

public class ProductService {

    private ProductDao productDao;

    public ProductService() {
        this.productDao = new ProductDao();
    }

    /**
     * This method return a list of ProductDto
     *
     * @return productDtos list
     * @throws SQLException
     */
    public List<ProductDto> getAllProducts() throws SQLException {
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productDao.getAllProducts();
        for (Product product : products) {
            ProductDto dto = convertProduct(product);
            productDtos.add(dto);
        }
        return productDtos;
    }

    public ProductDto getProductById(int productId) throws SQLException {
        Product product = productDao.getProductById(productId);
        ProductDto dto = convertProduct(product);
        return dto;
    }

    public List<ProductDto> getAllProductsByCategory(int categoryId) throws SQLException {
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productDao.getAllProductsByCategory(categoryId);
        for (Product product : products) {
            ProductDto dto = convertProduct(product);
            productDtos.add(dto);
        }
        return productDtos;
    }

    /**
     * This method convert Product model to ProductDto
     */

    private ProductDto convertProduct(Product product) {
        ProductDto dto = new ProductDto();
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }
}
