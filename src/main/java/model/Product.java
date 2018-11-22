package model;

/**
 * This class is handling data for product entity
 *
 * @author Cristi Borlea
 * @version 1.0
 */

public class Product {

    private int id;
    private String name;
    private String categoryName;
    private String description;
    private float price;

    public Product(int id, String name, String categoryName, String description, float price) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "<table balign=\"center\", border=\"1\">" +
                "<td>" + name + "</td>" +
                "<td>" + description + "</td>" +
                "<td>" + price + "</td>" +
                " </table>" + "<p><a href=\"http://localhost:9001/details/*\"><h4>See details</h4></a></p>";
    }
}

