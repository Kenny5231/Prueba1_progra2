/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
    class VideoGameItem extends BlockBusterItem {
    private  String consola;
    private static final String[] CONSOLAS_VALIDAS = {"PLAYSTATION", "XBOX", "WII"};

    public VideoGameItem(int codigo, String nombre, String consola) {
        super(codigo, nombre, 30);
        this.consola = validarConsola(consola);
    }

    private String validarConsola(String consola) {
        for (String consolaValida : CONSOLAS_VALIDAS) {
            if (consolaValida.equalsIgnoreCase(consola)) {
                return consolaValida;
            }
        }
        return "Desconocida";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + consola + " Game";
    }

    @Override
    public double pagoRenta(int dias) {
        return precioRenta * dias;
    }
}

