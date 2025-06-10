package Application;

import Products.Car;

public class App {
    public static void main(String[] args) throws Exception {
        try
        {
            Car c1 = new Car("Etios", "Toyota", 2020, "1.0 Turbo", "Aro 14", "Alcool", "ABS", 68.000);

            System.out.println(c1);
        }
        catch(Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
}
