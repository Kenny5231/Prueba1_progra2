/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kenny
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BlockBusterApp {

    private BlockBuster blockBuster;
    private JFrame frame;

    public BlockBusterApp() {
        blockBuster = new BlockBuster();

        frame = new JFrame("BlockBuster App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 80, 25);
        frame.add(lblCodigo);

        JTextField txtCodigo = new JTextField();
        txtCodigo.setBounds(120, 20, 200, 25);
        frame.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 50, 80, 25);
        frame.add(lblNombre);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(120, 50, 200, 25);
        frame.add(txtNombre);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 80, 80, 25);
        frame.add(lblTipo);

        String[] tipos = {"MOVIE", "GAME"};
        JComboBox<String> comboBox = new JComboBox<>(tipos);
        comboBox.setBounds(120, 80, 200, 25);
        frame.add(comboBox);

        JButton btnAgregar = new JButton("Agregar Item");
        btnAgregar.setBounds(20, 120, 150, 25);
        frame.add(btnAgregar);

        JButton btnBuscar = new JButton("Buscar Item");
        btnBuscar.setBounds(200, 120, 150, 25);
        frame.add(btnBuscar);

        JLabel lblDias = new JLabel("Días a alquilar:");
        lblDias.setBounds(20, 150, 150, 25);
        frame.add(lblDias);

        JTextField txtDias = new JTextField();
        txtDias.setBounds(150, 150, 100, 25);
        frame.add(txtDias);

        JButton btnAlquilar = new JButton("Alquilar");
        btnAlquilar.setBounds(20, 180, 150, 25);
        frame.add(btnAlquilar);
        
        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(200, 180, 150, 25);
        frame.add(btnExit);

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres salir?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmed == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtCodigo.getText().isEmpty() || txtNombre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No deje campos vacíos.");
                } else {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    String nombre = txtNombre.getText();
                    String tipo = comboBox.getSelectedItem().toString();
                    blockBuster.agregarItem(codigo, nombre, tipo);
                    JOptionPane.showMessageDialog(null, "Item agregado.");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtCodigo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No deje campos vacíos.");
                } else {
                    int codigo = Integer.parseInt(txtCodigo.getText());
                    String tipo = comboBox.getSelectedItem().toString();
                    BlockBusterItem item = blockBuster.buscarItem(codigo, tipo);
                    if (item != null) {
                        JOptionPane.showMessageDialog(null, "Item encontrado: " + item.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Item no encontrado.");
                    }
                }
            }
        });

        btnAlquilar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (txtCodigo.getText().isEmpty() || txtDias.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No deje campos vacíos.");
        } else {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String tipo = comboBox.getSelectedItem().toString();
            int dias = Integer.parseInt(txtDias.getText());

            BlockBusterItem item = blockBuster.buscarItem(codigo, tipo);
            if (item != null) {
                double monto = item.pagoRenta(dias);
                JOptionPane.showMessageDialog(null, "Item encontrado:\n" + item.toString() + "\n\nMonto a pagar: " + monto);
            } else {
                JOptionPane.showMessageDialog(null, "Item no encontrado.");
            }
        }
    }
});

        frame.setVisible(true);
    }
}