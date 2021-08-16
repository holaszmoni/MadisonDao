package com.dao.productreview;

import com.models.ProductReview;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;

public class ProductReviewDao implements ProductReviewAbstractDao {

    @Override
    public void saveProductReview(ProductReview productReview) {
        System.out.println("Saving product review having summary " + productReview.getSummary() + " ...");
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.PRODUCTS_REVIEWS, productReview);
    }
}
