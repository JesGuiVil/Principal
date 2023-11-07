package hashmap;

public class Producto {
    private int stock;
    private double precio;

    public Producto(int stock, double precio) {
        this.stock = stock;
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
