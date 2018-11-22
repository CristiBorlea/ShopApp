package service;

import dao.ReviewDao;
import dto.ProductReviewDto;
import model.Review;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Service handling business logic of review entities.
 *
 * @author Cristi Borlea
 * @version 1.0
 */

public class ReviewService {

    private ReviewDao reviewDao;

    public ReviewService() {
        this.reviewDao = new ReviewDao();
    }

    /**
     * This method return a list of reviewDto
     *
     * @return reviewDtos list
     * @throws SQLException
     */
    public List<ProductReviewDto> getReviewsForProduct(int productId) throws SQLException {
        List<ProductReviewDto> reviewDtoList = new ArrayList<>();
        List<Review> reviews = reviewDao.getReviewsById(productId);
        for (Review reviewModel : reviews) {
            ProductReviewDto dto = convert(reviewModel);
            reviewDtoList.add(dto);
        }
        return reviewDtoList;
    }

    /**
     * This method convert Review model to ProductReviewDto
     */

    private ProductReviewDto convert(Review review) {
        ProductReviewDto dto = new ProductReviewDto();
        dto.setEmail(review.getEmail());
        dto.setUsermane(review.getUsername());
        dto.setReview(review.getText());
        return dto;
    }

}
