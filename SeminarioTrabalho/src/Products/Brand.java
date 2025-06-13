package Products;

public class Brand extends Car {
    private String modelo;
    private String marca;
    public Brand(Brand t) {
        super(t);
        this.modelo = t.modelo;
        this.marca = t.marca;
    }
    public Brand(int ano, String motor, String rodas, String combustivel, String freio, double preco) {
        super(ano,  motor, rodas, combustivel,freio,  preco);
    }
    public Brand(){

    }
    @Override
    public Brand clone(){
        return new Brand(this);
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    @Override
    public String toString() {
        return String.format("""
            =====Carro=====
                marca: %s
                modelo: %s
                Ano: %d
                Motor: %s
                Rodas: %s
                Combustível: %s
                Freio: %s
                Preço: R$ %.2f
            """, this.getMarca(),this.getModelo(),this.getAno(), this.getMotor(),this.getRodas(), this.getCombustivel(),this.getFreio(),this.getPreco());
    }
}
