package com.pages;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.models.Cart;
import com.models.Product;
import com.tools.constants.EnvironmentConstants;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#shopping-cart-table>tbody>tr")
    private List<WebElementFacade> productList;

    public void emptyCartIfIsNotAlreadyEmpty() {
        if (!getDriver().findElement(By.cssSelector(".header-minicart>a")).getAttribute("class").contains("no-count")) {
            getDriver().navigate().to(EnvironmentConstants.BASE_URL + "/checkout/cart/");
            clickOnWebElementWithText("Empty Cart");
        }
    }

    public void emptyCart() {
        clickOnWebElementWithText("Empty Cart");
    }

    public Cart getCartDetails() {
        Cart cart = new Cart();
        cart.setCartProducts(getProducts());
        cart.setGrandTotal(getTotalPrice());
        cart.setSubtotal(getSubtotal());
        cart.setTax(getTaxIfExists());
        return cart;
    }

    public WebElementFacade getProductContainer(String productName) {
        for (WebElementFacade productItem : productList) {
            if (productItem.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                return productItem;
            }
        }
        return null;
    }

    public void updateProductQuantity(String productName, int newQuantity) {
        WebElementFacade productContainer = getProductContainer(productName);
        typeInto(productContainer.findElement(By.cssSelector("input[title='Qty']")), String.valueOf(newQuantity));
        clickOn(productContainer.findElement(By.cssSelector("[title='Update']")));
    }

    public double getTotalPrice() {
        return Double.parseDouble(getDriver().findElement(By.cssSelector(".a-right>strong>span[class='price']")).getText().replaceAll("[^0-9.]+", ""));
    }

    public double getSubtotal() {
        return Double.parseDouble(getDriver().findElement(By.xpath("//tr/td[contains(text(),'Subtotal')]/following-sibling::td/span")).getText()
                .replaceAll("[^0-9.]+", ""));
    }

    public double getTaxIfExists() {
        if (getDriver().findElement(By.cssSelector("#shopping-cart-totals-table")).getText().contains("TAX")) {
            return Double.parseDouble(getDriver().findElement(By.xpath("//tr/td[contains(text(),'Tax')]/following-sibling::td/span")).getText()
                    .replaceAll("[^0-9.]+", ""));
        }
        return 0;
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (WebElementFacade productItem : productList) {
            Product product = new Product();
            product.setPrice(Double.parseDouble(productItem.findElement(By.cssSelector("td[class='product-cart-price']")).getText().replaceAll("[^0-9.]+", "")));
            product.setQty(Integer.parseInt(productItem.findElement(By.cssSelector("td[class='product-cart-actions']>input")).getAttribute("value")));
            product.setName(productItem.findElement(By.cssSelector(" .product-name>a")).getText());
            if (!productItem.findElements(By.cssSelector(".item-options")).isEmpty()) {
                product.setColor(productItem.findElement(By.cssSelector("td.product-cart-info dd:nth-child(2)")).getText());
                product.setSize(productItem.findElement(By.cssSelector(" dd:nth-child(4)")).getText());
            }
            product.setSubtotal(Double.parseDouble(productItem.findElement(By.cssSelector("td[class='product-cart-total'] span[class='price']")).getText()
                    .replaceAll("[^0-9.]+", "")));
            products.add(product);
        }
        return products;
    }

    public void removeCartProduct(String productName) {
        getProductContainer(productName).findElement(By.cssSelector(".product-cart-remove a")).click();
    }
}
