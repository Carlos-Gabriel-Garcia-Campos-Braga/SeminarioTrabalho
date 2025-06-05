package app;

import models.Carro;

public class App {
    public static void main(String[] args) throws Exception {
        // Cria um objeto carro original
        Carro carroOriginal = new Carro("Civic", "Preto", "AXB-123");

        // Cria uma cópia usando o prototype(clone)
        Carro carroClone = carroOriginal.clone();

        // Modifica o clone para demonstrar que são objetos independentes na memória
        carroClone.setCor("Vermelho");
        carroClone.setPlaca("AXC-321");

        //Saída no terminal para verificar a diferença
        System.out.println("Carro Original: " + carroOriginal);
        System.out.println("Carro Clone: " + carroClone);
    }
}
