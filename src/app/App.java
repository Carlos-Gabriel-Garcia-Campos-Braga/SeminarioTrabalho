package app;

import models.Carro;

public class App {
    public static void main(String[] args) throws Exception {
        // Cria um objeto carro original
        Carro carroOriginal = new Carro("Etios", "Toyota", 2020, "1.0 Turbo", "Aro 14", "Alcool", "ABS", 68.000);

        // Cria uma cópia usando o prototype(clone)
        Carro carroClone = carroOriginal.clone();

        // Modifica o clone para demonstrar que são objetos independentes na memória
        carroClone.setMotor("1.0");
        carroClone.setAno(2018);
        carroClone.setPreco(59.000);

        //Saída no terminal para verificar a diferença
        System.out.println("Carro Original: " + carroOriginal);
        System.out.println("Carro Clone: " + carroClone);
    }
}
