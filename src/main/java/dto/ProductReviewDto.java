package dto;

public class ProductReviewDto {
    private String review;
    private String usermane;
    private String email;

    /**
     * DTO model of review
     * This class is handling data for reviews
     *
     * @author Cristi Borlea
     * @version 1.0
     */
    public ProductReviewDto() {

    }

    public ProductReviewDto(String review, String usermane, String email) {
        this.review = review;
        this.usermane = usermane;
        this.email = email;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUsermane() {
        return usermane;
    }

    public void setUsermane(String usermane) {
        this.usermane = usermane;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "<table balign=\"center\", border=\"1\">" +
                "<td>" + review + "</td>" +
                "<td>" + usermane + "</td>" +
                "<td>" + email + "</td>" +
                " </table>";
    }
}
