package com.models;

import java.util.List;

import org.decimal4j.util.DoubleRounder;

public class Cart {
    private double subtotal, tax, grandTotal;
    private List<Product> products;

    public Cart() {
    }

    public Cart(List<Product> products) {
        this.products = products;
        this.subtotal = getSubtotal();
        this.grandTotal = getGrandTotal();
    }

    public Cart(List<Product> products, double taxRate) {
        this.products = products;
        this.subtotal = getSubtotal();
        this.tax = getRelativeTax(taxRate);
        this.grandTotal = getGrandTotal();
    }

    public List<Product> getCartProducts() {
        return products;
    }

    public void setCartProducts(List<Product> products) {
        this.products = products;
    }

    public double getSubtotal() {
        products.forEach(cartProduct -> this.subtotal = this.subtotal + cartProduct.getPrice() * cartProduct.getQty());
        return this.subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cart other = (Cart)obj;
        if (Double.doubleToLongBits(grandTotal) != Double.doubleToLongBits(other.grandTotal))
            return false;
        if (products == null) {
            if (other.products != null)
                return false;
        } else if (!products.equals(other.products))
            return false;
        if (Double.doubleToLongBits(subtotal) != Double.doubleToLongBits(other.subtotal))
            return false;
        if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cart [subtotal=" + subtotal + ", tax=" + tax + ", grandTotal=" + grandTotal + ", products=" + products + "]";
    }

    public double getRelativeTax(double taxRate) {
        return DoubleRounder.round(taxRate * this.subtotal, 2);
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getGrandTotal() {
        return this.subtotal + this.tax;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

}
