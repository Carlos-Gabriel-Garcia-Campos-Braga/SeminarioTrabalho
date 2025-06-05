package Application;

import Products.Product;
import Store.Store;

public class App {
    public static void main(String[] args) throws Exception {
        try
        {
            System.out.println("Bem-Vindo a Renner!");
            Store Renner = new Store();

            Product TShirts = new Product("Padrao", "Camiseta", 19.99, 12);
            Product Pants = new Product("Padrao", "Calça", 19.99, 10);

            Product StarWars = TShirts.Clone(TShirts);
            StarWars.setModel("Star-Wars");
            StarWars.setValue(39.9);

            Product Jeans = Pants.Clone(Pants);
            Jeans.setCategory("Jeans");
            Jeans.setValue(89.00);
            
            Renner.AddProducts(StarWars);
            Renner.AddProducts(Jeans);

            for(Product p : Renner.ShowItems())
            {
                System.out.println(p);
                System.out.println("==================");
            }
        }
        catch(Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
}
