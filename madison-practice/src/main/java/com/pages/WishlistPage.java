package com.pages;

import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.models.Product;

public class WishlistPage extends BasePage {
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#wishlist-table>tbody>tr")
    private List<WebElementFacade> productList;

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        for (WebElementFacade productItem : productList) {
            Product product = new Product();
            product.setPrice(Double.parseDouble(productItem.findElement(By.cssSelector(".regular-price")).getText().replaceAll("[^0-9.]+", "")));
            product.setQty(Integer.parseInt(productItem.findElement(By.cssSelector(".input-text.qty")).getAttribute("value")));
            product.setName(productItem.findElement(By.cssSelector(" .product-name>a")).getText());
            if (productItem.getAttribute("innerHTML").contains("View Details")) {
                product.setColor(productItem.findElement(By.cssSelector(".item-options dl dt:nth-child(1)+dd")).getAttribute("innerHTML").trim());
                product.setSize(productItem.findElement(By.cssSelector(".item-options dl dt:nth-child(3)+dd")).getAttribute("innerHTML").trim());
            }
            products.add(product);
        }
        return products;
    }

    public void removeAllWishlistProducts() {
        if (!containsText("You have no items in your wishlist")) {
            for (WebElementFacade productItem : productList) {
                typeInto(productItem.findElement(By.cssSelector("input[name*='qty']")), "0");
            }
            clickOnWebElementWithText("Update Wishlist");
        }
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
        typeInto(productContainer.findElement(By.cssSelector("input[name*='qty']")), String.valueOf(newQuantity));
        productContainer.findElement(By.cssSelector("[title='Update Wishlist']")).click();
    }

    public List<Product> getProductsFromWishList() {
        List<Product> products = new ArrayList<>();
        for (WebElementFacade product : productList) {
            Product wishListProd = new Product();
            wishListProd.setName(product.findElement(By.cssSelector(".product-image")).getAttribute("title"));
            wishListProd.setPrice(Double.parseDouble(product.findElement(By.cssSelector("span[id*='product-price']")).getText().replaceAll("[^0-9.]+", "")));
            wishListProd.setQty(Integer.parseInt(product.findElement(By.cssSelector(".input-text.qty")).getAttribute("value")));
            wishListProd.setColor(product.findElement(By.cssSelector(".item-options dl dt:nth-child(1)+dd")).getAttribute("innerHTML").trim());
            wishListProd.setSize(product.findElement(By.cssSelector(".item-options dl dt:nth-child(3)+dd")).getAttribute("innerHTML").trim());
            products.add(wishListProd);
        }
        return products;
    }

    public void removeWishlistProduct(String productName) {
        getProductContainer(productName).findElement(By.cssSelector(".customer-wishlist-item-remove a")).click();
        getDriver().switchTo().alert().accept();
    }
}
