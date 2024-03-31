package Mascota;


import javax.swing.*;

public class Main {
     public static void main(String[] args) {
        // Crear una instancia de la mascota virtual
        MascotaVirtual miMascota = new MascotaVirtual("Fido", "Marrón");

        // Crear e inicializar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            MascotaVirtualGUI gui = new MascotaVirtualGUI(miMascota);
            gui.setVisible(true);
        });
    }
}
