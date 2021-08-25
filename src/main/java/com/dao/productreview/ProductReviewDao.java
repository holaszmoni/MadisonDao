package com.dao.productreview;

import com.models.ProductReview;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;

import java.util.List;

public class ProductReviewDao implements ProductReviewAbstractDao {

    @Override
    public void saveProductReview(ProductReview productReview) {
        System.out.println("Saving product review having summary " + productReview.getSummary() + " ...");
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.PRODUCTS_REVIEWS, productReview);
    }

    @Override
    public List<ProductReview> getAllReviews(String listName) {
        return null;
    }

    @Override
    public List<ProductReview> getAllReviews() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.PRODUCTS_REVIEWS);
    }

        @Override
    public ProductReview getReviewByName(String listName, String name) {
        return getAllReviews(listName).parallelStream().filter(item -> item.getSummary().equalsIgnoreCase(name)).findFirst().orElse(null);

    }
//    public ProductReview getReviewBySummary(String summary) {
//        List<ProductReview> productReviews = getAllReviews();
//        return productReviews.parallelStream().filter(item -> item.getSummary().equalsIgnoreCase(summary)).findFirst().orElse(null);
//    }
}

