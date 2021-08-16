package com.dao.productreview;

import com.google.inject.ImplementedBy;
import com.models.ProductReview;

@ImplementedBy(ProductReviewDao.class)
public interface ProductReviewAbstractDao {
    public void saveProductReview(ProductReview productReview);
    //TODO define the rest of the methods you might need... e.g. getReviewBySummary... or get by any field you find it suiyable to be the identifier
}
