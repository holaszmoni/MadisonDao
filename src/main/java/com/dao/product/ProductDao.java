package com.dao.product;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.models.Product;
import com.tools.utils.SerenitySessionUtils;

public class ProductDao implements ProductAbstractDao {

    @Override
    public void saveProduct(String listName, Product product) {
        System.out.println("Saving product " + product.getName() + " ...");
        SerenitySessionUtils.saveObjectInSerenitySessionList(listName, product);
    }

    @Override
    public void removeProduct(String listName, Product product) {
        SerenitySessionUtils.removeObjectFromSerenitySessionList(listName, product);

    }

    @Override
    public List<Product> getAllProducts(String listName) {
        return SerenitySessionUtils.getFromSession(listName);
    }

    @Override
    public Product getProductByName(String listName, String name) {
        return getAllProducts(listName).parallelStream().filter(item -> item.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    public void updateProduct(String listName, Product product) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        SerenitySessionUtils.replaceObjectInSerenitySessionList(listName, product,
                "name", product.getName());
    }

}
