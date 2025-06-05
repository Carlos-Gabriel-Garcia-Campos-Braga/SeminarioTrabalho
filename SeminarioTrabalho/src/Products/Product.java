package Products;

public class Product {
    private String Model;
    private String Category;
    private double Value;
    private int Quantity;

    private Product(Product productClone)
    {
        this.Model = productClone.Model;
        this.Category = productClone.Category;
        this.Value  = productClone.Value;
        this.Quantity = productClone.Quantity;
    }

    public Product(String model, String category, double value, int quantity)
    {
        this.Model = model;
        this.Category = category;
        this.Value = value;
        this.Quantity = quantity;
    }

    public void setModel(String model)
    {
        if(model.isEmpty())
        {
            throw new IllegalArgumentException("O modelo da camiseta nao pode estar vazio!");
        }
        this.Model = model;
    }

    public String getModel()
    {
        return Model;
    }

    public void setCategory(String category)
    {
        if(category.isEmpty())
        {
            throw new IllegalArgumentException("O produto deve estar em alguma categoria!");
        }
        this.Category = category;
    }

    public String getCategory()
    {
        return Category;
    }

    public void setValue(double value)
    {
        if(value < 0)
        {
            throw new IllegalArgumentException("O valor nao pode ser negativo!");
        }
        this.Value = value;
    }

    public double getValue()
    {
        return Value;
    }

    public void setQuantity(int quantity)
    {
        if(quantity < 0)
        {
            throw new IllegalArgumentException("A quantidade nao pode ser negativa!");
        }
        this.Quantity = quantity;
    }

    public int getQuantity()
    {
        return Quantity;
    }

    //Metodo que serve para clonar o Objeto
    public Product Clone(Product productClone)
    {
        if(productClone == null)
        {
            throw new IllegalArgumentException("Nada para ser clonado!");
        }
        return new Product(this);
    }

    @Override
    public String toString()
    {
        return "Produto" +
               "\nModelo: " + Model +
               "\nCategoria: " + Category +
               "\nValor: " + Value +
               "\nQuantidade em estoque: " + Quantity;
    }
}
