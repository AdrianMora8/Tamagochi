package Mascota;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.*;





public class PokemonGUI extends JFrame{
    private PokemonVirtual mascota;
    private GestorGifs gestorGifs; 
    private int tiempoJuego=0;
    private Timer gifTimer;

    private JLabel lblHoraActual, 
            lblTiempoJuego, 
            lblEstado, 
            lblNivelEnergia, 
            lblNivelHambre, 
            lblNivelFelicidad, 
            lblNivelLimpieza, 
            lblNivelSalud,
            lblNombre,
            lblGif;
    
    
    public PokemonGUI(PokemonVirtual mascota) {
        this.mascota = mascota;
        this.gestorGifs = new GestorGifs(mascota.getNombre());
        iniciarGUI(); 
        reloj();
    }
        
        private void iniciarGUI() {
        setTitle("Tamagotchi Pokémon");
        setSize(700, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnlAtributos = new JPanel(new GridLayout(0, 1));
        JPanel pnlAcciones = new JPanel(new GridLayout(1, 0));
        JPanel pnlPrincipal = new JPanel(new BorderLayout());
        
        lblGif = new JLabel();  // Inicializa el JLabel para el GIF
        lblNombre = new JLabel("Nombre: " + mascota.getNombre());
        lblNivelEnergia = new JLabel("Energía: " + mascota.getNivelEnergia());
        lblNivelHambre = new JLabel("Hambre: " + mascota.getNivelHambre());
        lblNivelFelicidad = new JLabel("Felicidad: " + mascota.getNivelFelicidad());
        lblNivelLimpieza = new JLabel("Limpieza: " + mascota.getNivelLimpieza());
        lblNivelSalud = new JLabel("Salud: " + mascota.getNivelSalud());
        lblHoraActual = new JLabel("Hora Actual: --:--:--");
        lblTiempoJuego = new JLabel("Tiempo de Juego: 0 dias");
        lblEstado = new JLabel("Estado: " + mascota.getEstado().getClass().getSimpleName());

        pnlPrincipal.add(lblGif);
        pnlAtributos.add(lblNombre);
        pnlAtributos.add(lblNivelEnergia);
        pnlAtributos.add(lblNivelHambre);
        pnlAtributos.add(lblNivelFelicidad);
        pnlAtributos.add(lblNivelLimpieza);
        pnlAtributos.add(lblNivelSalud);
        pnlAtributos.add(lblHoraActual);
        pnlAtributos.add(lblTiempoJuego);
        pnlAtributos.add(lblEstado);

        agregarBoton(pnlAcciones, "Alimentar", e -> {
            mascota.alimentar(this);
            actualizarEstadoMascota();
            if (mascota.getNivelHambre() < 100) {
            updateGif("comer", 7000);
        }
        });
        agregarBoton(pnlAcciones, "Jugar", e -> {
            mascota.jugar(this);
            actualizarEstadoMascota();  // Llamada al método de actualización
            if (mascota.getNivelEnergia() > 0) {  // Suponiendo que 20 es el mínimo para jugar
        updateGif("jugar", 7000);
        }
        });
        agregarBoton(pnlAcciones, "Dormir", e -> {
            mascota.dormir(this);
            actualizarEstadoMascota();
            if (mascota.getNivelEnergia() !=100) {
            updateGif("dormir", 7000);
            }
        });
        agregarBoton(pnlAcciones, "Curar", e -> {
            mascota.curar(this);
            actualizarEstadoMascota();
            if (mascota.getNivelSalud() <= 40) {
            updateGif("curar", 7000); 
            }
        });
        agregarBoton(pnlAcciones, "Limpiar", e -> {
            mascota.limpiar(this);
            actualizarEstadoMascota();
            if (mascota.getNivelLimpieza() < 100) {
                }else{
                    updateGif("limpiar", 7000);
                
            }
        });

        agregarBoton(pnlAcciones, "Guardar Datos", e -> guardarDatos(mascota));
        
        
        add(pnlAtributos, BorderLayout.NORTH);
        add(pnlAcciones, BorderLayout.SOUTH);
        add(lblGif, BorderLayout.CENTER);
        lblGif.setHorizontalAlignment(JLabel.CENTER);
        lblGif.setPreferredSize(new Dimension(500, 300));
        updateGif(mascota.getNombre(), 0);

        setVisible(true);
    }

private void updateGif(String key, int delay) {
    ImageIcon icon = gestorGifs.getGif(key);  // Asumiendo que gestorGifs maneja correctamente los GIFs
    if (icon != null) {
        lblGif.setIcon(icon);
        if (delay > 0) {
            if (gifTimer != null) {
                gifTimer.stop();  // Detiene el temporizador anterior si existe
            }
            // Configura el temporizador para volver al GIF por defecto después de la demora
            gifTimer = new Timer(delay, e -> {
                ImageIcon defaultIcon = gestorGifs.getGif(mascota.getNombre());
                if (defaultIcon != null) {
                    lblGif.setIcon(defaultIcon);
                } else {
                    System.out.println("No se encontró el GIF por defecto para: " + mascota.getNombre());
                }
            });
            gifTimer.setRepeats(false);
            gifTimer.start();
        }
    }
}

    
        
    private void reloj() {
        Timer timer = new Timer(1000, e -> {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        lblHoraActual.setText("Hora actual: " + now.format(formatter));

        // Incrementar el tiempo del juego cada 3 minutos
        if (now.getMinute()% 3 == 0 && now.getSecond() == 0) {
            tiempoJuego++;
            if (mascota.getTiempoJuego() % 1 == 0) {  // Cada dia
                cambioEstado();
            }
        }
            lblTiempoJuego.setText("Tiempo de Juego: " + tiempoJuego + " dias");
                });
            timer.start();
        }
        
    private void agregarBoton(JPanel panel, String label, ActionListener actionListener) {
        JButton boton = new JButton(label);
        boton.addActionListener(e -> {
        actionListener.actionPerformed(e);  
        updateGif(label.toLowerCase(), 7000); 
        });
        panel.add(boton);
    }
    
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }  

    public void actualizarEstadoMascota() {
        lblEstado.setText("Estado: " + mascota.getEstado().getClass().getSimpleName());
        lblTiempoJuego.setText("Tiempo de Juego: " + mascota.getTiempoJuego() + " dias");
        lblNivelEnergia.setText("Energía: " + mascota.getNivelEnergia());
        lblNivelHambre.setText("Hambre: " + mascota.getNivelHambre());
        lblNivelSalud.setText("Salud: " + mascota.getNivelSalud());
        lblNivelFelicidad.setText("Felicidad: " + mascota.getNivelFelicidad());
        lblNivelLimpieza.setText("Limpieza: " + mascota.getNivelLimpieza());  
    }
    
    private void cambioEstado() {
        Random random = new Random();
            if (random.nextInt(100) < 25) {  // 25% probabilidad de cambiar de estado
                EstadoMascota[] estados = {new Saludable(), new Cansado(), new Energico(), new Enfermo(), new Feliz(), new Triste()};
                EstadoMascota nuevoEstado = estados[random.nextInt(estados.length)];
                mascota.setEstado(nuevoEstado);
            if (nuevoEstado instanceof Enfermo) {
                mascota.setNivelSalud(49);
                actualizarEstadoMascota();
            }if (nuevoEstado instanceof  Energico) {
                mascota.setNivelEnergia(100);
            }       
        actualizarEstadoMascota();
        JOptionPane.showMessageDialog(this, "El estado de " + mascota.getNombre() + " ha cambiado a " + nuevoEstado.getClass().getSimpleName());
        }
    }
        
    public static void guardarDatos(PokemonVirtual mascota) {
        GestorDatos.guardarDatos(mascota, mascota.getNombre());
        }
    }

