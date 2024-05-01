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
import java.util.Map;
import java.util.HashMap;




public class MascotaVirtualGUI extends JFrame{
    private MascotaVirtual mascota;// Etiqueta para mostrar el GIF
    private Map<String, ImageIcon> gifs;  // Mapa para guardar los 
    private int tiempoJuego=0;
    private Timer gifTimer;

    private JLabel lblHoraActual, 
            lblTiempoJuego, 
            lblEstado, 
            lblNivelEnergia, 
            lblNivelHambre, 
            lblNivelFelicidad, 
            lblNivelLimpieza, 
            lblNivelEnfermedad,
            lblNombre,
            lblGif;
    
    
    public MascotaVirtualGUI(MascotaVirtual mascota) {
        this.mascota = mascota;
        this.gifs=cargaGifs();
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
        lblNivelEnfermedad = new JLabel("Salud: " + mascota.getNivelSalud());
        lblHoraActual = new JLabel("Hora Actual: --:--:--");
        lblTiempoJuego = new JLabel("Tiempo de Juego: 0 dias");
        lblEstado = new JLabel("Estado: " + mascota.getEstado().getClass().getSimpleName());

        pnlPrincipal.add(lblGif);
        pnlAtributos.add(lblNombre);
        pnlAtributos.add(lblNivelEnergia);
        pnlAtributos.add(lblNivelHambre);
        pnlAtributos.add(lblNivelFelicidad);
        pnlAtributos.add(lblNivelLimpieza);
        pnlAtributos.add(lblNivelEnfermedad);
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
        updateGif(mascota.getNombre().toLowerCase());

        setVisible(true);
    }
        
    private void updateGif(String key) {
        updateGif(key, 0); // Llama al método sobrecargado con un retardo de 0 segundos
    }
        
    private void updateGif(String key, int delay) {
        
        ImageIcon icon = gifs.get(key);
        if (icon != null) {
            lblGif.setIcon(icon);
                if (delay > 0) {
                    javax.swing.Timer timer = new javax.swing.Timer(delay, e -> updateGif(mascota.getNombre()));
                    timer.setRepeats(false);
                    timer.start();
                    gifTimer.stop();  
            
        }
    } 
}
    
    private Map<String,ImageIcon> cargaGifs(){
        Map<String, ImageIcon> gifs = new HashMap<>();
        if (mascota.getNombre().equalsIgnoreCase("pikachu")) {
            System.out.println("entro");
        gifs.put("pikachu", new ImageIcon(getClass().getResource( "/pikachu/pikachu.gif")));
        gifs.put("comer", new ImageIcon(getClass().getResource( "/pikachu/Pcomer.gif")));
        gifs.put("jugar", new ImageIcon(getClass().getResource( "/pikachu/Pjugar.gif")));
        gifs.put("dormir", new ImageIcon(getClass().getResource( "/pikachu/Pdormir.gif")));
        gifs.put("curar", new ImageIcon(getClass().getResource( "/pikachu/Pcurar.gif")));
        gifs.put("limpiar", new ImageIcon(getClass().getResource( "/pikachu/Plimpiar.gif")));
        }else{
            System.out.println("entro 2");
        gifs.put("charmander", new ImageIcon(getClass().getResource( "/charmander/charmander.gif")));
        gifs.put("comer", new ImageIcon(getClass().getResource( "/charmander/C-comer.gif")));
        gifs.put("jugar", new ImageIcon(getClass().getResource( "/charmander/C-jugar.gif")));
        gifs.put("dormir", new ImageIcon(getClass().getResource( "/charmander/C-dormir.gif")));
        gifs.put("curar", new ImageIcon(getClass().getResource( "/charmander/C-curar.gif")));
        gifs.put("limpiar", new ImageIcon(getClass().getResource( "/charmander/C-limpiar.gif")));
        
        }
        return gifs;
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
        actionListener.actionPerformed(e);  // Ejecutar la acción específica
        updateGif(label.toLowerCase(), 7000); // Cambiar al GIF de la acción y volver después de 7 segundos
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
        lblNivelEnfermedad.setText("Salud: " + mascota.getNivelSalud());
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
                mascota.setNivelEnfermedad(49);
                actualizarEstadoMascota();
            }if (nuevoEstado instanceof  Energico) {
                mascota.setNivelEnergia(100);
            }       
        actualizarEstadoMascota();
        JOptionPane.showMessageDialog(this, "El estado de " + mascota.getNombre() + " ha cambiado a " + nuevoEstado.getClass().getSimpleName());
        }
    }
        
    public static void guardarDatos(MascotaVirtual mascota) {
        GestorDatos.guardarDatos(mascota, mascota.getNombre());
        }
    }

