package Mascota;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MascotaAnimadaGUI extends JPanel implements ActionListener {
    private int x = 0; // Coordenada x de la mascota
    private int y = 100; // Coordenada y de la mascota
    private Timer timer;

    public MascotaAnimadaGUI() {
        timer = new Timer(10, this); // Timer para la animación con intervalo de 10 milisegundos
        timer.start(); // Comenzar el temporizador
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la mascota en las coordenadas x, y
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50); // Dibujar un círculo como mascota (puedes personalizarlo)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualizar las coordenadas de la mascota
        x++; // Mover la mascota hacia la derecha
        if (x > getWidth()) { // Si la mascota se sale del panel, reiniciar su posición
            x = 0;
        }
        repaint(); // Volver a pintar la interfaz gráfica
    }
}