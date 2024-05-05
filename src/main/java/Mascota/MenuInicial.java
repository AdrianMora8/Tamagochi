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
        String[] opciones = {"Pikachu", "Charmander"};
        String pokemon = (String) JOptionPane.showInputDialog(
            this,
            "Seleccione el Pokémon cuyos datos desea cargar:",
            "Cargar Datos",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (pokemon != null) {
            try {
                PokemonVirtual mascota = GestorDatos.cargarDatos(pokemon);
                if (mascota != null) {
                    PokemonGUI gui = new PokemonGUI(mascota);
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
        Object[] opciones = {"Pikachu", "Charmander"};
        String pokemon = (String) JOptionPane.showInputDialog(this, "Seleccione el Pokémon para comenzar:", "Nuevo Juego",
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        if (pokemon != null) {
            iniciarNuevoJuego(pokemon);
        }
    }
    
    private void iniciarNuevoJuego(String pokemon) {
        PokemonVirtual mascota;
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
        PokemonGUI gui = new PokemonGUI(mascota);
        gui.setVisible(true);
        this.dispose(); // Cierra la ventana de menú
    }
}
