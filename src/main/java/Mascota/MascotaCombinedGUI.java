
package Mascota;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MascotaCombinedGUI extends JFrame {
    private MascotaVirtual mascotaVirtual;
    private MascotaAnimadaGUI mascotaAnimadaGUI;
    private JTextArea infoMascotaTextArea;

    public MascotaCombinedGUI() {
        // Configurar la ventana
        setTitle("Mascotas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Crear la mascota virtual
        mascotaVirtual = new MascotaVirtual("Fido", "Marrón");

        // Crear la mascota animada
        mascotaAnimadaGUI = new MascotaAnimadaGUI();
        
        // Crear el área de texto para mostrar la información de la mascota virtual
        infoMascotaTextArea = new JTextArea();
        infoMascotaTextArea.setEditable(false);
        actualizarInfoMascota();

        // Añadir la mascota animada y el área de texto a la ventana
        add(mascotaAnimadaGUI, BorderLayout.CENTER);
        add(new JScrollPane(infoMascotaTextArea), BorderLayout.WEST);
        
        // Crear los botones
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        JButton alimentarButton = new JButton("Alimentar");
        JButton jugarButton = new JButton("Jugar");
        JButton dormirButton = new JButton("Dormir");
        JButton curarButton = new JButton("Curar");
        JButton limpiarButton = new JButton("Limpiar");

        // Asignar acciones a los botones
        alimentarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascotaVirtual.alimentar();
                actualizarInfoMascota();
            }
        });

        jugarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascotaVirtual.jugar();
                actualizarInfoMascota();
            }
        });

        dormirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascotaVirtual.dormir();
                actualizarInfoMascota();
            }
        });

        curarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascotaVirtual.curar();
                actualizarInfoMascota();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascotaVirtual.limpiar();
                actualizarInfoMascota();
            }
        });

        // Añadir los botones al panel
        buttonPanel.add(alimentarButton);
        buttonPanel.add(jugarButton);
        buttonPanel.add(dormirButton);
        buttonPanel.add(curarButton);
        buttonPanel.add(limpiarButton);

        // Añadir el panel de botones a la ventana
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Ajustar el tamaño de la ventana
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }
    
    private void actualizarInfoMascota() {
        StringBuilder info = new StringBuilder();
        info.append("Nombre: ").append(mascotaVirtual.getNombre()).append("\n");
        info.append("Color: ").append(mascotaVirtual.getColor()).append("\n");
        info.append("Nivel de felicidad: ").append(mascotaVirtual.getNivelFelicidad()).append("\n");
        info.append("Nivel de hambre: ").append(mascotaVirtual.getNivelHambre()).append("\n");
        info.append("Nivel de energía: ").append(mascotaVirtual.getNivelEnergia()).append("\n");
        info.append("¿Está enfermo?: ").append(mascotaVirtual.estaEnfermo()).append("\n");
        info.append("¿Está sucio?: ").append(mascotaVirtual.estaSucio()).append("\n");
        info.append("Edad: ").append(mascotaVirtual.getEdad()).append("\n");
        info.append("Estado de ánimo: ").append(mascotaVirtual.getEstadoAnimo()).append("\n");

        infoMascotaTextArea.setText(info.toString());
    }
}