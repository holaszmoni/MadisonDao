package com.steps;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;

import com.dao.product.ProductAbstractDao;
import com.google.inject.Inject;
import com.models.Cart;
import com.models.Product;
import com.pages.CartPage;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;

public class CartSteps extends AbstractSteps {
    private static final long serialVersionUID = 1L;
    private CartPage cartPage;
    @Inject
    ProductAbstractDao productDao;

    @Step
    public void verifyCartWithPercentageTaxesDetails(double taxRate) {
        @SuppressWarnings("unchecked")
        Cart expectedCart = new Cart((List<Product>)SerenitySessionUtils.getFromSession(SerenityKeyConstants.CART_PRODUCTS_LIST), taxRate);
        Cart actualCart = cartPage.getCartDetails();
        System.out.println("Expected cart is: " + expectedCart.toString());
        System.out.println("Actual cart is: " + actualCart.toString());
        Assert.assertTrue("Cart details are not as expected!", expectedCart.equals(actualCart));
    }

    @Step
    public void verifyNoTaxesCartDetails() {
        @SuppressWarnings("unchecked")
        Cart expectedCart = new Cart((List<Product>)SerenitySessionUtils.getFromSession(SerenityKeyConstants.CART_PRODUCTS_LIST));
        Cart actualCart = cartPage.getCartDetails();
        System.out.println("Expected cart is: " + expectedCart.toString());
        System.out.println("Actual cart is: " + actualCart.toString());
        Assert.assertTrue("Cart details are not as expected!", expectedCart.equals(actualCart));
    }

    @Step
    public void emptyCartIfIsNotAlreadyEmpty() {
        cartPage.emptyCartIfIsNotAlreadyEmpty();
    }

    @Step
    public void emptyCart() {
        cartPage.emptyCart();
    }

    @Step
    public void verifyCartIsEmpty() {
        Assert.assertTrue("Cart is not empty!", basePage.containsText("You have no items in your shopping cart."));
    }

    @Step
    public void updateCartProductQuantity(String productName, int newQuantity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Product product = productDao.getProductByName(SerenityKeyConstants.CART_PRODUCTS_LIST, productName);
        cartPage.updateProductQuantity(productName, newQuantity);
        product.setQty(newQuantity);
        product.setSubtotal(product.getPrice() * newQuantity);
        productDao.updateProduct(SerenityKeyConstants.CART_PRODUCTS_LIST, product);
    }

    @Step
    public void removeCartProduct(String productName) {
        Product product = productDao.getProductByName(SerenityKeyConstants.CART_PRODUCTS_LIST, productName);
        cartPage.removeCartProduct(productName);
        productDao.removeProduct(SerenityKeyConstants.CART_PRODUCTS_LIST, product);
    }
}
