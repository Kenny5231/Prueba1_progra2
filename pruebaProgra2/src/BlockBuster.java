/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
    import java.util.ArrayList;
import javax.swing.JOptionPane;

class BlockBuster {
    private  ArrayList<BlockBusterItem> items;
    public static double montoAPagar;

    public static double getMontoAPagar() {
        return montoAPagar;
    }

    public static void setMontoAPagar(double montoAPagar) {
        BlockBuster.montoAPagar = montoAPagar;
    }
    
    
    
    public BlockBuster() {
        items = new ArrayList<>();
    }

    public BlockBusterItem buscarItem(int codigo, String tipo) {
        for (BlockBusterItem item : items) {
            if (item.codigo == codigo && ((tipo.equals("MOVIE") && item instanceof MovieItem) || (tipo.equals("GAME") && item instanceof VideoGameItem))) {
                return item;
            }
        }
        return null;
    }

    public void agregarItem(int codigo, String nombre, String tipoItem) {
        BlockBusterItem itemExistente = buscarItem(codigo, tipoItem);
        if (itemExistente == null) {
            if (tipoItem.equals("MOVIE")) {
                items.add(new MovieItem(codigo, nombre, 0));
            } else if (tipoItem.equals("GAME")) {
                items.add(new VideoGameItem(codigo, nombre, "PLAYSTATION"));
            }
        } else {
                        JOptionPane.showMessageDialog(null, "Ya existe un item con el código " + codigo + " y tipo " + tipoItem);

        }
    }

    public void rentar(int codigo, String tipoItem, int dias) {
        BlockBusterItem item = buscarItem(codigo, tipoItem);
        if (item != null) {
             montoAPagar = item.pagoRenta(dias);
        } else {
            JOptionPane.showMessageDialog(null, "Item no existe");

        }
    }
    
    public void auditarMovieEstados() {
        for (BlockBusterItem item : items) {
            if (item instanceof MovieItem movieItem) {
                movieItem.evaluarEstado();
            }
        }
    }
}

