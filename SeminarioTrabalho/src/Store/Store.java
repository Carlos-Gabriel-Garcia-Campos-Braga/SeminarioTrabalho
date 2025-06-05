package Store;

import java.util.ArrayList;

import Products.Product;

public class Store {
    private ArrayList<Product> ProductsAvailable = new ArrayList<Product>();

    public void AddProducts(Product product)
    {
        ProductsAvailable.add(product);
    }

    public ArrayList<Product> ShowItems()
    {
        if(ProductsAvailable == null)
        {
            throw new IllegalArgumentException("Lista vazia!");
        }

        return ProductsAvailable;
    }

    public int TotalQuantity()
    {
        int total = 0;

        for(Product p : ProductsAvailable)
        {
            total += p.getQuantity();
        }

        return total;
    }

    public double ValueInStock()
    {
        double value = 0;

        for(Product p : ProductsAvailable)
        {
            value += p.getValue();
        }

        return value;
    }
}
