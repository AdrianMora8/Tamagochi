
package Mascota;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Timer;
import java.util.Scanner;
import java.util.TimerTask;

public class MascotaVirtual {
    private String nombre;
    private String color;
    private int nivelFelicidad;
    private int nivelHambre;
    private int nivelEnergia;
    private boolean estaEnfermo;
    private boolean estaSucio;
    private int edad;
    private String estadoAnimo;
    private  MascotaVirtualGUI gui;
        

    public MascotaVirtual(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.nivelFelicidad = 50; // Nivel de felicidad inicial
        this.nivelHambre = 50; // Nivel de hambre inicial
        this.nivelEnergia = 50; // Nivel de energía inicial
        this.estaEnfermo = false; // No está enfermo inicialmente
        this.estaSucio = false; // No está sucio inicialmente
        this.edad = 0; // Edad inicial
        this.estadoAnimo = "Neutral"; // Estado de ánimo inicial
        this.gui = gui; // Almacenar la referencia a la instancia de MascotaVirtualGUI
    }


    public void actualizarAtributos(Scanner scanner) {
        System.out.println("Actualización de atributos de la mascota:");
        System.out.print("Nombre: ");
        nombre = scanner.nextLine();
        System.out.print("Color: ");
        color = scanner.nextLine();
        System.out.print("Nivel de felicidad: ");
        nivelFelicidad = scanner.nextInt();
        System.out.print("Nivel de hambre: ");
        nivelHambre = scanner.nextInt();
        System.out.print("Nivel de energía: ");
        nivelEnergia = scanner.nextInt();
        System.out.print("¿Está enfermo? (true/false): ");
        estaEnfermo = scanner.nextBoolean();
        System.out.print("¿Está sucio? (true/false): ");
        estaSucio = scanner.nextBoolean();
        System.out.print("Edad: ");
        edad = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea después de leer el entero
        System.out.print("Estado de ánimo: ");
        estadoAnimo = scanner.nextLine();
    }


    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNivelFelicidad(int nivelFelicidad) {
        this.nivelFelicidad = nivelFelicidad;
    }

    public void setNivelHambre(int nivelHambre) {
        this.nivelHambre = nivelHambre;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public void setEstaEnfermo(boolean estaEnfermo) {
        this.estaEnfermo = estaEnfermo;
    }

    public void setEstaSucio(boolean estaSucio) {
        this.estaSucio = estaSucio;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoAnimo(String estadoAnimo) {
        this.estadoAnimo = estadoAnimo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getNivelFelicidad() {
        return nivelFelicidad;
    }

    public int getNivelHambre() {
        return nivelHambre;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public boolean estaEnfermo() {
        return estaEnfermo;
    }

    public boolean estaSucio() {
        return estaSucio;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstadoAnimo() {
        return estadoAnimo;
    }

    public void alimentar() {
        // Implementación de alimentar
        if (!estaEnfermo) {
            nivelHambre += 10;
            nivelFelicidad += 5;
            nivelEnergia += 10;
            verificarLimites();
            System.out.println(nombre + " ha sido alimentado y se siente feliz.");
        } else {
            System.out.println(nombre + " está enfermo y no puede comer.");
        }
    }

  public void jugar() {
        if (!estaEnfermo) {
            nivelFelicidad += 10;
            nivelEnergia -= 20;
            nivelHambre -= 10;
            
            if(nivelEnergia <= 0) {
                System.out.println(nombre+"Esta cansado y no puede jugar");
            }else{
            System.out.println(nombre + " ha jugado contigo y se divirtió.");
            }
            verificarLimites();
        } else {
            System.out.println(nombre + " está enfermo y no puede jugar.");
        }
    }

    public void dormir() {
        nivelEnergia += 30;
        verificarLimites();
        System.out.println(nombre + " ha dormido y se siente descansado.");
    }

    public void curar() {
        estaEnfermo = false;
        System.out.println(nombre + " ha sido curado.");
    }

    public void limpiar() {
        estaSucio = false;
        System.out.println(nombre + " ha sido limpiado.");
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Color: " + color);
        System.out.println("Nivel de felicidad: " + nivelFelicidad);
        System.out.println("Nivel de hambre: " + nivelHambre);
        System.out.println("Nivel de energía: " + nivelEnergia);
        System.out.println("Estado de salud: " + (estaEnfermo ? "Enfermo" : "Saludable"));
        System.out.println("Estado de limpieza: " + (estaSucio ? "Sucio" : "Limpio"));
        System.out.println("Edad: " + edad);
        System.out.println("Estado de ánimo: " + estadoAnimo);
    }

    public void mostrarHoraActual() {
    LocalTime horaActual = LocalTime.now();
    System.out.println("Hora actual: " + horaActual);
    }


    public void iniciarAvanceAutomatico() {
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            avanzarUnAnio();
            gui.actualizarEstado();
        }
    }, 0, 20000); // Se ejecuta cada 20 segundos (20000 milisegundos)
}
    private void avanzarUnAnio() {
    // Simular efectos del tiempo en la mascota (por ejemplo, aumentar el hambre)
    edad++;
    nivelHambre += 2;
    if (estaEnfermo) {
        nivelFelicidad--;
    }
    if (nivelHambre < 60) {
        estaEnfermo = true;
    }
    if (edad % 24 == 0) {
        estaSucio = true;
    }
    verificarLimites();
    // También podrías simular otros efectos como disminuir la felicidad gradualmente, etc.
    }

    private void verificarLimites() {
        nivelFelicidad = Math.min(Math.max(nivelFelicidad, 0), 100);
        nivelHambre = Math.min(Math.max(nivelHambre, 0), 100);
        nivelEnergia = Math.min(Math.max(nivelEnergia, 0), 100);
    }

    public void guardarDatos(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(nombre + "," + nivelFelicidad + "," + nivelHambre + "," + nivelEnergia + "," + estaEnfermo + "," + estaSucio + "," + edad + "," + color + "," + estadoAnimo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String[] datos = reader.readLine().split(",");
            nombre = datos[0];
            nivelFelicidad = Integer.parseInt(datos[1]);
            nivelHambre = Integer.parseInt(datos[2]);
            nivelEnergia = Integer.parseInt(datos[3]);
            estaEnfermo = Boolean.parseBoolean(datos[4]);
            estaSucio = Boolean.parseBoolean(datos[5]);
            edad = Integer.parseInt(datos[6]);
            color = datos[7];
            estadoAnimo = datos[8];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
