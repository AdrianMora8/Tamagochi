package Mascota;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

public class MascotaVirtualGUI extends JFrame {
    private MascotaVirtual mascota;
    private JTextArea estadoTextArea;
    private MascotaAnimadaGUI mascotaAnimadaGUI;
    private JLabel horaLabel;
    private JLabel fechaJuegoLabel;
    private JButton alimentarButton;
    private JButton jugarButton;
    private JButton dormirButton;
    private JButton curarButton;
    private JButton limpiarButton;
    private JButton mostrarEstadoButton;
    private JButton actualizarAtributosButton;
    private JButton guardarDatosButton;
    private JButton cargarDatosButton;
    private int yearsPassedInGame;

    public MascotaVirtualGUI(MascotaVirtual mascota) {
        this.mascota = mascota;
        this.yearsPassedInGame = 0;

        cargarEstilo();

        setTitle("Mi Mascota Virtual");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        estadoTextArea = new JTextArea();
        estadoTextArea.setEditable(false);
        actualizarEstado();

        JScrollPane scrollPane = new JScrollPane(estadoTextArea);
        horaLabel = new JLabel();
        fechaJuegoLabel = new JLabel();
        actualizarFechaJuego();
        mascotaAnimadaGUI = new MascotaAnimadaGUI();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirHoraActual();
                if ((LocalDateTime.now().getSecond() % 20) == 0) {
                    yearsPassedInGame++;
                    actualizarFechaJuego();
                }
            }
        });
        timer.start();

        alimentarButton = new JButton("Alimentar");
        alimentarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.alimentar();
                actualizarEstado();
            }
        });

        jugarButton = new JButton("Jugar");
        jugarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.jugar();
                actualizarEstado();
            }
        });

        dormirButton = new JButton("Dormir");
        dormirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.dormir();
                actualizarEstado();
            }
        });

        curarButton = new JButton("Curar");
        curarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.curar();
                actualizarEstado();
            }
        });

        limpiarButton = new JButton("Limpiar");
        limpiarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.limpiar();
                actualizarEstado();
            }
        });

        mostrarEstadoButton = new JButton("Mostrar Estado");
        mostrarEstadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.mostrarEstado();
            }
        });

        actualizarAtributosButton = new JButton("Actualizar Atributos");
        actualizarAtributosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarAtributos();
                actualizarEstado();
            }
        });

        guardarDatosButton = new JButton("Guardar Datos");
        guardarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.guardarDatos("datos_mascota.txt");
            }
        });

        cargarDatosButton = new JButton("Cargar Datos");
        cargarDatosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mascota.cargarDatos("datos_mascota.txt");
                actualizarEstado();
            }
        });

        JPanel buttonsPanel = new JPanel(new GridLayout(3, 4));
        buttonsPanel.add(alimentarButton);
        buttonsPanel.add(jugarButton);
        buttonsPanel.add(dormirButton);
        buttonsPanel.add(curarButton);
        buttonsPanel.add(limpiarButton);
        buttonsPanel.add(mostrarEstadoButton);
        buttonsPanel.add(actualizarAtributosButton);
        buttonsPanel.add(guardarDatosButton);
        buttonsPanel.add(cargarDatosButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, mascotaAnimadaGUI);
        splitPane.setResizeWeight(0.5);

        add(splitPane, BorderLayout.CENTER);
        add(horaLabel, BorderLayout.NORTH);
        add(fechaJuegoLabel, BorderLayout.SOUTH);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void actualizarEstado() {
        StringBuilder estado = new StringBuilder("Estado de la mascota:\n");
        estado.append("Nombre: ").append(mascota.getNombre()).append("\n");
        estado.append("Color: ").append(mascota.getColor()).append("\n");
        estado.append("Nivel de felicidad: ").append(mascota.getNivelFelicidad()).append("\n");
        estado.append("Nivel de hambre: ").append(mascota.getNivelHambre()).append("\n");
        estado.append("Nivel de energía: ").append(mascota.getNivelEnergia()).append("\n");
        estado.append("¿Está enfermo?: ").append(mascota.estaEnfermo()).append("\n");
        estado.append("¿Está sucio?: ").append(mascota.estaSucio()).append("\n");
        estado.append("Edad: ").append(mascota.getEdad()).append("\n");
        estado.append("Estado de ánimo: ").append(mascota.getEstadoAnimo()).append("\n");

        estadoTextArea.setText(estado.toString());
    }

    private void imprimirHoraActual() {
        LocalDateTime horaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaFormateada = horaActual.format(formatter);
        horaLabel.setText("Hora actual: " + horaFormateada);
    }

    private void actualizarFechaJuego() {
        fechaJuegoLabel.setText("FechaJuego: " + yearsPassedInGame + " años");
    }

    private void actualizarAtributos() {
        String nuevoValor;

        nuevoValor = JOptionPane.showInputDialog("Nuevo nombre:");
        if (nuevoValor != null) {
            mascota.setNombre(nuevoValor);
        }

        nuevoValor = JOptionPane.showInputDialog("Nuevo color:");
        if (nuevoValor != null) {
            mascota.setColor(nuevoValor);
        }

        nuevoValor = JOptionPane.showInputDialog("Nuevo nivel de felicidad:");
        if (nuevoValor != null) {
            mascota.setNivelFelicidad(Integer.parseInt(nuevoValor));
        }

        nuevoValor = JOptionPane.showInputDialog("Nuevo nivel de hambre:");
        if (nuevoValor != null) {
            mascota.setNivelHambre(Integer.parseInt(nuevoValor));
        }

        nuevoValor = JOptionPane.showInputDialog("Nuevo nivel de energía:");
        if (nuevoValor != null) {
            mascota.setNivelEnergia(Integer.parseInt(nuevoValor));
        }

        nuevoValor = JOptionPane.showInputDialog("¿Está enfermo? (true/false):");
        if (nuevoValor != null) {
            mascota.setEstaEnfermo(Boolean.parseBoolean(nuevoValor));
        }

        nuevoValor = JOptionPane.showInputDialog("¿Está sucio? (true/false):");
        if (nuevoValor != null) {
            mascota.setEstaSucio(Boolean.parseBoolean(nuevoValor));
        }

        nuevoValor = JOptionPane.showInputDialog("Nueva edad:");
        if (nuevoValor != null) {
            mascota.setEdad(Integer.parseInt(nuevoValor));
        }

        nuevoValor = JOptionPane.showInputDialog("Nuevo estado de ánimo:");
        if (nuevoValor != null) {
            mascota.setEstadoAnimo(nuevoValor);
        }

        actualizarEstado();
    }

    private void cargarEstilo() {
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
