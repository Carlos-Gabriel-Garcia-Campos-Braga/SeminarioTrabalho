package Application;

import Products.Product;

public class App {
    public static void main(String[] args) throws Exception {
        try
        {
            Product TShirts = new Product("Padrao", "Camiseta", 19.99, 30);
            
            Product StarWars = TShirts.Clone(TShirts);
            StarWars.setModel("Star-Wars");
            StarWars.setValue(39.9);
            StarWars.setQuantity(12);
            

            System.out.println(StarWars.toString());
        }
        catch(Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
}
