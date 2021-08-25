package com.dao.productreview;

import com.google.inject.ImplementedBy;
import com.models.ProductReview;

import java.util.List;

@ImplementedBy(ProductReviewDao.class)
public interface ProductReviewAbstractDao {
    public void saveProductReview(ProductReview productReview);
    public List<ProductReview> getAllReviews(String listName);

    List<ProductReview> getAllReviews();

    public ProductReview getReviewByName(String listName, String name);
    //TODO define the rest of the methods you might need... e.g. getReviewBySummary... or get by any field you find it suiyable to be the identifier
}
