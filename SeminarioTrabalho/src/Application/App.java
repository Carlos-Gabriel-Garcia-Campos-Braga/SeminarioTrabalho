package Application;

import Products.Brand;
import Products.Car;

public class App {
    public static void main(String[] args) throws Exception {
        try
        {
            Car c1 = new Car(2020, "1.0 Turbo", "Aro 14", "Alcool", "ABS", 68.000);

            Car c2 = c1.clone();
            c2.setMotor("1.0");
            c2.setAno(2018);
            c2.setPreco(59.000);
            
            Brand corollas = new Brand();
            
            corollas.setModelo("Corolla");
            corollas.setMarca("Toyota");
            Car c4 = corollas.clone();
            c4.setAno(2020);
            c4.setCombustivel("Diesel");
            c4.setFreio("ABS");
            c4.setRodas("Aro 16");
            c4.setMotor("1.6");
            c4.setPreco(70.000);
            Brand c5 = corollas.clone();
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c4);
            System.out.println(c5);
        }
        catch(Exception ex)
        {
            throw new Exception(ex.getMessage());
        }
    }
}
