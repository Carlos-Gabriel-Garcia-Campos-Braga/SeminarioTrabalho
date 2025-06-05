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
    private String cor;
    private String placa;

    // Construtor da Classe Carro
    public Carro(String modelo, String cor, String placa) {
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }

    // Getters and Setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
        return "Carro [modelo=" + modelo + ", cor=" + cor + ", placa=" + placa + "]";
    }

}
