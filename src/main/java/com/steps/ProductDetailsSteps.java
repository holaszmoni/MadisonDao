package com.steps;

import net.thucydides.core.annotations.Step;

import com.dao.product.ProductAbstractDao;
import com.dao.productreview.ProductReviewAbstractDao;
import com.google.inject.Inject;
import com.models.Product;
import com.models.ProductReview;
import com.pages.ProductDetailsPage;
import com.tools.constants.SerenityKeyConstants;
import com.tools.factories.ProductReviewFactory;

public class ProductDetailsSteps extends AbstractSteps {
    private static final long serialVersionUID = 1L;
    private ProductDetailsPage productDetailsPage;
    @Inject
    private ProductAbstractDao productDao;
    @Inject
    private ProductReviewAbstractDao productReviewDao;

    public Product getProductDetails() {
        Product product = new Product();
        product.setName(productDetailsPage.getProductName());
        product.setColor(productDetailsPage.getProductRandomColor());
        product.setSize(productDetailsPage.getProductRandomSize());
        product.setPrice(productDetailsPage.getPrice());
        return product;
    }

    @Step
    public void addProductToCart(int quantity) {
        Product product = getProductDetails();
        productDetailsPage.typeInInputWithTitle("Qty", String.valueOf(quantity));
        product.setQty(quantity);
        product.setSubtotal(quantity * product.getPrice());
        productDetailsPage.clickOnWebElementWithText("Add to Cart");
        productDao.saveProduct(SerenityKeyConstants.CART_PRODUCTS_LIST, product);
    }

    @Step
    public void addProductToWishList(int quantity) {
        Product product = getProductDetails();
        productDetailsPage.typeInInputWithTitle("Qty", String.valueOf(quantity));
        product.setQty(quantity);
        productDetailsPage.clickOnWebElementWithText("Add to Wishlist");
        productDao.saveProduct(SerenityKeyConstants.WISHLIST_PRODUCTS_LIST, product);
    }

    @Step
    public void addProductReview(String summary) {
        ProductReview productReview = ProductReviewFactory.getProductReviewInstance(summary);
        //TODO complete the fields with data from productReview
        productReviewDao.saveProductReview(productReview);
    }

    @Step
    public void verifyProductReview(String summary) {
        //Product review  productReviewDao.getProductReviewBySummary(summary)....
    }
}
