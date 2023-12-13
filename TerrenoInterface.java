import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerrenoInterface extends JFrame {
    private JTextField anchoField;
    private JTextField largoField;
    private JButton calcularButton;

    public TerrenoInterface() {
        // Configuración de la interfaz
        setTitle("Calculadora de Terreno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Creación de componentes
        JLabel anchoLabel = new JLabel("Ancho:");
        JLabel largoLabel = new JLabel("Largo:");

        anchoField = new JTextField(10);
        largoField = new JTextField(10);

        calcularButton = new JButton("Calcular");

        // Configuración del diseño
        JPanel panel = new JPanel();
        panel.add(anchoLabel);
        panel.add(anchoField);
        panel.add(largoLabel);
        panel.add(largoField);
        panel.add(calcularButton);

        add(panel);

        // Configuración del evento del botón
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTerreno();
            }
        });
    }

    private void calcularTerreno() {
        try {
            double ancho = Double.parseDouble(anchoField.getText());
            double largo = Double.parseDouble(largoField.getText());

            Terreno terreno = new Terreno(ancho, largo);

            JOptionPane.showMessageDialog(this,
                    "Perímetro del terreno: " + terreno.calcularPerimetro() + "\n" +
                    "Área del terreno: " + terreno.calcularArea() + "\n" +
                    "Cantidad de semilla necesaria: " + terreno.calcularCantidadSemilla(0.5),
                    "Resultados", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos para el ancho y el largo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TerrenoInterface().setVisible(true);
            }
        });
    }
}
