package com.dao.product;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.google.inject.ImplementedBy;
import com.models.Product;

@ImplementedBy(ProductDao.class)
public interface ProductAbstractDao {
    public void saveProduct(String listName, Product product);

    public void removeProduct(String listName, Product product);

    public List<Product> getAllProducts(String listName);

    public Product getProductByName(String listName, String name);

    public void updateProduct(String listName, Product product) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
