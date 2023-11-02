/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
    import java.time.LocalDate;

class MovieItem extends BlockBusterItem {
    private String estado;

    public MovieItem(int codigo, String nombre, double precioRenta) {
        super(codigo, nombre, precioRenta);
        this.estado = "ESTRENO";
    }

    @Override
    public String toString() {
        return super.toString() + " - Movie, Estado: " + estado;
    }

    @Override
    public double pagoRenta(int dias) {
        long diffInMonths = fechaAdicion.until(LocalDate.now()).toTotalMonths();
        if (estado.equals("ESTRENO") && dias > 2) {
            return precioRenta + 50 * (dias - 2);
        } else if (estado.equals("NORMAL") && dias > 5) {
            return precioRenta + 30 * (dias - 5);
        }
        return precioRenta * dias;
    }

    public void evaluarEstado() {
        long diffInMonths = fechaAdicion.until(LocalDate.now()).toTotalMonths();
        if (diffInMonths >= 5) {
            estado = "NORMAL";
        }
    }
}

