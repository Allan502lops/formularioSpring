package views;

import com.mycompany.gestionvehiculos.Vehiculo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import org.springframework.web.client.RestTemplate;

public class FormularioVehiculo extends JFrame {

    private JLabel labelPlaca, labelModelo, labelColor, labelPuertas;
    private JTextField txtPlaca, txtModelo, txtColor, txtPuertas;
    private JButton btnAgregar, btnActualizar;

    public FormularioVehiculo() {
        initComponents();
    }

    private void initComponents() {
        labelPlaca = new JLabel("Placa:");
        labelModelo = new JLabel("Modelo:");
        labelColor = new JLabel("Color:");
        labelPuertas = new JLabel("Puertas:");

        txtPlaca = new JTextField(20);
        txtModelo = new JTextField(20);
        txtColor = new JTextField(20);
        txtPuertas = new JTextField(20);

        btnAgregar = new JButton("Agregar");
        btnActualizar = new JButton("Actualizar");

        // Asociar ActionListener a los botones
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String modelo = txtModelo.getText();
                String color = txtColor.getText();
                int puertas = Integer.parseInt(txtPuertas.getText());

                Vehiculo vehiculo = new Vehiculo(placa, modelo, color, puertas);
                boolean success = agregarVehiculo(vehiculo);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Auto agregado exitosamente.");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar el auto.");
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                String modelo = txtModelo.getText();
                String color = txtColor.getText();
                int puertas = Integer.parseInt(txtPuertas.getText());

                Vehiculo vehiculo = new Vehiculo(placa, modelo, color, puertas);
                boolean success = actualizarVehiculo(vehiculo);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Datos del auto actualizados correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos del auto.");
                }
            }
        });

        // Crear un panel para organizar los elementos en orientación vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(labelPlaca);
        panel.add(txtPlaca);
        panel.add(labelModelo);
        panel.add(txtModelo);
        panel.add(labelColor);
        panel.add(txtColor);
        panel.add(labelPuertas);
        panel.add(txtPuertas);

        // Crear un panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnActualizar);

        // Agregar los paneles al JFrame
        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(panel);
        getContentPane().add(panelBotones);

        setTitle("Formulario de Vehículo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }


    private boolean agregarVehiculo(Vehiculo vehiculo) {
        String url = "http://localhost:8080/vehiculos";
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.postForObject(url, vehiculo, Void.class);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean actualizarVehiculo(Vehiculo vehiculo) {
        String placa = vehiculo.getPlaca();
        String url = "http://localhost:8080/vehiculos/" + placa;
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.put(url, vehiculo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void limpiarCampos() {
        txtPlaca.setText("");
        txtModelo.setText("");
        txtColor.setText("");
        txtPuertas.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioVehiculo().setVisible(true);
            }
        });
    }
}
