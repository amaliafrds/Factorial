import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TugasGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton hitungButton;
    private JLabel hasilLabel;

    public TugasGUI() {
        setTitle("Menghitung Faktorial");
        setSize(500, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        
        inputField = new JTextField(8);
        inputField.setPreferredSize(new Dimension(60, 30));
        hitungButton = new JButton("Hitung");
        hasilLabel = new JLabel("Hasil : ");
        
        hitungButton.addActionListener(this);

        panel.add(new JLabel("Masukkan bilangan : "));
        panel.add(inputField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(hitungButton);
        panel.add(buttonPanel);

        panel.add(hasilLabel);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent f) {
        if (f.getSource() == hitungButton) {
            try {
                int bilangan = Integer.parseInt(inputField.getText());

                if (bilangan < 0) {
                    JOptionPane.showMessageDialog(this, "Masukkan bilangan positif!");
                    return;
                }

                long hasil = countFactorial(bilangan);
                hasilLabel.setText("Hasil: " + hasil);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Masukkan bilangan yang valid!");
            }
        }
    }

    private long countFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        long faktorial = 1;
        for (int i = 2; i <= n; i++) {
            faktorial *= i;
        }
        return faktorial;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TugasGUI());
    }

    private void setResizeable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}