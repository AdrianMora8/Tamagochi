package Mascota;

import javax.swing.*;
import java.awt.*;

public class EstiloUI {
    // Colores definidos
private static final Color COLOR_FONDO_PRINCIPAL = new Color(207, 216, 220);  // Azul marino suave
    private static final Color COLOR_FONDO_SECUNDARIO = new Color(176, 190, 197); // Gris azulado
    private static final Color COLOR_TEXTO = new Color(0,255,255);               // Casi negro
    private static final Color COLOR_BOTON_HOVER = new Color(144, 164, 174);      // Gris azulado más oscuro

    // Fuentes
    private static final Font FUENTE_PRINCIPAL = new Font("SansSerif", Font.BOLD, 40);
    private static final Font FUENTE_BOTON = new Font("SansSerif", Font.PLAIN, 16);
    
    private static final int ANCHO_GIF = 400;
    private static final int ALTO_GIF = 400;
    
    

    public static void aplicarEstilo() {
        try {
           
            // Establecer el LookAndFeel de Nimbus
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

            // Estilos para el fondo
            UIManager.put("Panel.background", COLOR_FONDO_PRINCIPAL);
            UIManager.put("Button.background", COLOR_FONDO_SECUNDARIO);
            UIManager.put("Button.foreground", COLOR_TEXTO);
            UIManager.put("Button.font", FUENTE_BOTON);
            UIManager.put("Button.border", BorderFactory.createEmptyBorder(10, 15, 10, 15));
            UIManager.put("Button.hoverBackground", COLOR_BOTON_HOVER);

            // Estilos para los labels
            UIManager.put("Label.font", FUENTE_PRINCIPAL);
            UIManager.put("Label.foreground", COLOR_TEXTO);
            UIManager.put("Label.font", new Font("Arial", Font.BOLD, 18));
            UIManager.put("Panel.background", new Color(0x123456)); //

            // Estilos para TextArea
            UIManager.put("TextArea.font", new Font("SansSerif", Font.PLAIN, 14));
            UIManager.put("TextArea.border", BorderFactory.createEmptyBorder(5, 5, 5, 5));
            UIManager.put("TextArea.background", Color.BLUE);
            
                        // Estilos para JTextField
            UIManager.put("TextField.font", FUENTE_PRINCIPAL);
            UIManager.put("TextField.background", Color.WHITE);
            UIManager.put("TextField.foreground", COLOR_TEXTO);
            UIManager.put("TextField.border", BorderFactory.createLineBorder(COLOR_FONDO_SECUNDARIO, 1));

            // Actualizar otros componentes si es necesario
            // Por ejemplo, para barras de desplazamiento, listas, etc.
            UIManager.put("ScrollPane.background", COLOR_FONDO_PRINCIPAL);
            UIManager.put("List.background", COLOR_FONDO_SECUNDARIO);
            UIManager.put("List.foreground", COLOR_TEXTO);
            UIManager.put("List.font", FUENTE_PRINCIPAL);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
