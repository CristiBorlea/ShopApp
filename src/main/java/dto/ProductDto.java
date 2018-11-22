package dto;

public class ProductDto {
    private String name;
    private String description;
    private float price;

    /**
     * DTO model of product
     * This class is handling data for products
     *
     * @author Cristi Borlea
     * @version 1.0
     */
    public ProductDto() {

    }

    public ProductDto(String name, String description, float price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "<table balign=\"center\", border=\"1\">" +
                "<td>" + name + "</td>" +
                "<td>" + description + "</td>" +
                "<td>" + price + "</td>" +
                " </table>";
//                + "<p><a href=\"http://localhost:9001/details/*\"><h4>See details</h4></a></p>";
    }
}
