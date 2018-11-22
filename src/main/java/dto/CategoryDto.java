package dto;

/**
 *
 */
public class CategoryDto {
    private String categoryName;

    /**
     * This class is handling data for categories
     *
     * @author Cristi Borlea
     * @version 1.0
     */
    public CategoryDto() {
    }

    public CategoryDto(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "<table balign=\"center\", border=\"1\">" +
                "<td>" + categoryName + "</td>" +
                " </table>";
    }
}
