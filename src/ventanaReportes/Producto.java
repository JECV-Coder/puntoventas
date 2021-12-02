package ventanaReportes;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Producto {
    private SimpleStringProperty fecha;
    private SimpleIntegerProperty cod;
    private SimpleStringProperty nombre;
    private SimpleIntegerProperty cantidad;
    private SimpleFloatProperty precio;
    private SimpleFloatProperty subtotal;

    public Producto(String fechaa, int codd, String nombree, int cantidadd, float subtotall) {
        this.fecha = new SimpleStringProperty(fechaa);
        this.cod = new SimpleIntegerProperty(codd);
        this.nombre = new SimpleStringProperty(nombree);
        this.cantidad = new SimpleIntegerProperty(cantidadd);
        this.subtotal = new SimpleFloatProperty(subtotall);
    }

    public Producto(int codd, String nombree, int cantidadd, float precioo) {
        this.cod = new SimpleIntegerProperty(codd);
        this.nombre = new SimpleStringProperty(nombree);
        this.cantidad = new SimpleIntegerProperty(cantidadd);
        this.precio = new SimpleFloatProperty(precioo);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fechaa) {
        fecha.set(fechaa);
    }

    public int getCod() {
        return cod.get();
    }

    public void setCod(int codd) {
        cod.set(codd);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombree) {
        nombre.set(nombree);
    }

    public int getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(int cantidadd) {
        cantidad.set(cantidadd);
    }

    public float getPrecio() {
        return precio.get();
    }

    public void setPrecio(float precioo) {
        precio.set(precioo);
    }

    public float getSubtotal() {
        return subtotal.get();
    }

    public void setSubtotal(float subtotal1) {
        precio.set(subtotal1);
    }
}
