package Store;

import java.util.ArrayList;

import Products.Product;

public class Store {
    public ArrayList<Product> ProductsAvaible = new ArrayList<Product>();

    public void AddProducts(Product product)
    {
        ProductsAvaible.add(product);
    }
}
