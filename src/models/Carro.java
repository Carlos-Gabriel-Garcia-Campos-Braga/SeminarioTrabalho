package models;

/*
Precisamos implementar a interface Cloneable para sinalizar que a classe permite ser clonada usando o método clone();

A interface Cloneable não possuí métodos (marker interface), serve apenas para marcar uma classe com uma característica especial, 
permitindo que o Java ou alguma API interna trate os objetos dessa classe de maneira diferenciada;

Se você tentar usar clone() sem implementar Cloneable, o Java lança a exceção: java.lang.CloneNotSupportedException
*/
public class Carro extends Object implements Cloneable {
    // Atributos da Classe Carro
    private String modelo;
    private String marca;
    private int ano;
    private String motor;
    private String rodas;
    private String combustivel;
    private String freio;
    private double preco;
    
    // Construtor Public 
    public Carro(String modelo, String marca, int ano, String motor, String rodas, String combustivel, String freio, double preco)
    {
        this.modelo = modelo;
        this.marca = marca;
        this.ano  = ano;
        this.motor = motor;
        this.rodas = rodas;
        this.combustivel = combustivel;
        this.freio = freio;
        this.preco = preco;
    }

    // Getters
    public String getModelo() { return modelo; }
    public String getMarca() { return marca; }
    public int getAno() { return ano; }
    public String getMotor() { return motor; }
    public String getRodas() { return rodas; }
    public String getCombustivel() { return combustivel; }
    public String getFreio() { return freio; }
    public double getPreco() { return preco; }
    
    // Setters com validações e regras de negócio
    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("Modelo não pode ser nulo ou vazio");
        }
        if (modelo.length() < 2) {
            throw new IllegalArgumentException("Modelo deve ter pelo menos 2 caracteres");
        }
        if (modelo.length() > 50) {
            throw new IllegalArgumentException("Modelo não pode ter mais de 50 caracteres");
        }
        this.modelo = modelo.trim();
    }
    
    public void setAno(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        if (ano < 1900) {
            throw new IllegalArgumentException("Ano não pode ser anterior a 1900");
        }
        if (ano > anoAtual + 1) {
            throw new IllegalArgumentException("Ano não pode ser mais de 1 ano no futuro");
        }
        this.ano = ano;
    }
    
    public void setMotor(String motor) {
        if (motor == null || motor.trim().isEmpty()) {
            throw new IllegalArgumentException("Motor não pode ser nulo ou vazio");
        }
        
        // Lista de motores válidos
        String[] motoresValidos = {
            "1.0", "1.0 Turbo", "1.3", "1.4", "1.5", "1.5 Turbo", 
            "1.6", "1.8", "1.8 Flex", "1.8 Híbrido", "2.0", "2.0 Turbo",
            "2.4", "3.0", "3.5", "V6", "V8"
        };
        
        boolean motorValido = false;
        for (String motorPadrao : motoresValidos) {
            if (motor.trim().toLowerCase().contains(motorPadrao.toLowerCase())) {
                motorValido = true;
                break;
            }
        }
        
        if (!motorValido) {
            throw new IllegalArgumentException("Motor '" + motor + "' não é válido. " +
                "Motores aceitos: " + String.join(", ", motoresValidos));
        }
        
        this.motor = motor.trim();
    }
    
    public void setRodas(String rodas) {
        if (rodas == null || rodas.trim().isEmpty()) {
            throw new IllegalArgumentException("Especificação das rodas não pode ser nula ou vazia");
        }
        
        // Valida formato "Aro XX" onde XX é um número entre 13 e 22
        if (!rodas.matches("^Aro\\s+(1[3-9]|2[0-2])$")) {
            throw new IllegalArgumentException("Rodas devem estar no formato 'Aro XX' onde XX está entre 13 e 22");
        }
        
        this.rodas = rodas.trim();
    }
    
    public void setCombustivel(String combustivel) {
        if (combustivel == null || combustivel.trim().isEmpty()) {
            throw new IllegalArgumentException("Combustível não pode ser nulo ou vazio");
        }
        
        String[] combustiveisValidos = {"Gasolina", "Etanol", "Flex", "Diesel", "Híbrido", "Elétrico", "GNV"};
        boolean combustivelValido = false;
        
        for (String combustivelPadrao : combustiveisValidos) {
            if (combustivel.trim().equalsIgnoreCase(combustivelPadrao)) {
                combustivelValido = true;
                this.combustivel = combustivelPadrao; // Padroniza a capitalização
                break;
            }
        }
        
        if (!combustivelValido) {
            throw new IllegalArgumentException("Combustível '" + combustivel + "' não é válido. " +
                "Combustíveis aceitos: " + String.join(", ", combustiveisValidos));
        }
    }
    
    public void setFreio(String freio) {
        if (freio == null || freio.trim().isEmpty()) {
            throw new IllegalArgumentException("Sistema de freio não pode ser nulo ou vazio");
        }
        
        String[] freiosValidos = {
            "Convencional", "ABS", "ABS + EBD", "ABS + EBD + ESP", 
            "ABS + EBD + ESP + ASR", "Regenerativo"
        };
        
        boolean freioValido = false;
        for (String freioPadrao : freiosValidos) {
            if (freio.trim().equalsIgnoreCase(freioPadrao)) {
                freioValido = true;
                this.freio = freioPadrao; // Padroniza a capitalização
                break;
            }
        }
        
        if (!freioValido) {
            throw new IllegalArgumentException("Sistema de freio '" + freio + "' não é válido. " +
                "Sistemas aceitos: " + String.join(", ", freiosValidos));
        }
    }
    
    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        
        this.preco = preco;
    }

    // Método clone que faz cópia do objeto
    @Override // Estamos sobrescrevendo o método clone da classe pai Object
    public Carro clone() {
        try {
            /*
             * Estamos chamando o método clone() da classe Object e depois fazendo o Casting para Carro
             * super.clone() não executa os construtores da sua classe. Ele simplesmente copia o estado atual da memória (valores dos atributos).
             */
            return (Carro) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar o objeto", e);
        }
    }

      @Override
    public String toString() {
        return String.format("""
            =====Carro=====
                Marca: %s
                Modelo: %s
                Ano: %d
                Motor: %s
                Rodas: %s
                Combustível: %s
                Freio: %s
                Preço: R$ %.2f
            """, marca, modelo, ano, motor, rodas, combustivel, freio, preco);
    }

}
