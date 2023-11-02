/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
    import java.time.LocalDate;


abstract class BlockBusterItem {
    protected int codigo;
    protected String nombre;
    protected double precioRenta;
    protected LocalDate fechaAdicion;

    public BlockBusterItem(int codigo, String nombre, double precioRenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioRenta = precioRenta;
        this.fechaAdicion = LocalDate.now();
    } 
    @Override
    
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio de Renta: " + precioRenta;
    }
    public abstract double pagoRenta(int dias);
}

