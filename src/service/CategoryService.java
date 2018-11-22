package service;

import dao.CategoryDao;
import dto.CategoryDto;
import model.Category;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service handling business logic of category entities.
 *
 * @author Cristi Borlea
 * @version 1.0
 */

public class CategoryService {

    private CategoryDao categoryDao;

    public CategoryService() {
        this.categoryDao = new CategoryDao();
    }

    /**
     * This method return a list of CategoryDto
     *
     * @return categoryDtos list
     * @throws SQLException
     */
    public List<CategoryDto> getAllCategories() throws SQLException {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        List<Category> categories = categoryDao.getAllCategories();

        for (Category category : categories) {
            CategoryDto dto = convertCategory(category);
            categoryDtos.add(dto);
        }
        return categoryDtos;
    }

    private CategoryDto convertCategory(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setCategoryName(category.getCategoryName());
        return dto;
    }

}
