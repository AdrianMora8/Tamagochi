package Mascota;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.UIManager;

public class MetodosMascota {
 
    private MascotaVirtualGUI gui;


    public MetodosMascota(MascotaVirtualGUI gui,MascotaVirtual mascota) {
        this.gui = gui;
    }
        public static void cargarEstilo() {
        try {
            // Establecer el LookAndFeel de Nimbus
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            // Actualizar la apariencia de los componentes
            UIManager.put("TextArea.border", BorderFactory.createEmptyBorder(10, 10, 10, 10));
            UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 16));
            UIManager.put("Label.font", new Font("Arial", Font.BOLD, 18));
            UIManager.put("TextArea.font", new Font("Arial", Font.PLAIN, 14));
            UIManager.put("Button.background", new Color(76, 175, 80));
            UIManager.put("Button.foreground", Color.BLACK);
            UIManager.put("Button.border", BorderFactory.createEmptyBorder(15, 20, 15, 20));
            UIManager.put("Button.hoverBackground", new Color(69, 160, 73));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    
    
}

