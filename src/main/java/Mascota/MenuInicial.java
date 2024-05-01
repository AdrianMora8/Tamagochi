package Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuInicial extends JFrame {
    public MenuInicial() {
        super("Pokémon Tamagotchi - Menú Inicial");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JButton btnCargarDatos = new JButton("Cargar Datos");
        JButton btnNuevosDatos = new JButton("Nuevos Datos");

        btnCargarDatos.addActionListener(this::cargarDatos);
        btnNuevosDatos.addActionListener(this::mostrarOpcionesPokemon);

        panel.add(btnCargarDatos);
        panel.add(btnNuevosDatos);

        add(panel);
    }
    
    private void cargarDatos(ActionEvent e) {
        String[] options = {"Pikachu", "Charmander"};
        String pokemon = (String) JOptionPane.showInputDialog(
            this,
            "Seleccione el Pokémon cuyos datos desea cargar:",
            "Cargar Datos",
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );

        if (pokemon != null) {
            try {
                MascotaVirtual mascota = GestorDatos.cargarDatos(pokemon);
                if (mascota != null) {
                    MascotaVirtualGUI gui = new MascotaVirtualGUI(mascota);
                    gui.setVisible(true);
                    this.dispose(); // Cierra la ventana de menú inicial
                } else {
                    JOptionPane.showMessageDialog(this, "No se encontraron datos para " + pokemon, "Error de Carga", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarOpcionesPokemon(ActionEvent e) {
        Object[] options = {"Pikachu", "Charmander"};
        String pokemon = (String) JOptionPane.showInputDialog(this, "Seleccione el Pokémon para comenzar:", "Nuevo Juego",
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (pokemon != null) {
            iniciarNuevoJuego(pokemon);
        }
    }
    private void iniciarNuevoJuego(String pokemon) {
        MascotaVirtual mascota;
        switch (pokemon) {
            case "Pikachu":
                mascota = new Pikachu("Pikachu");
                break;
            case "Charmander":
                mascota = new Charmander("Charmander");
                break;
            default:
                return;
        }
        MascotaVirtualGUI gui = new MascotaVirtualGUI(mascota);
        gui.setVisible(true);
        this.dispose(); // Cierra la ventana de menú
    }



}
