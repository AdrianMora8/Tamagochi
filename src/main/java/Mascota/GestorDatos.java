package Mascota;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestorDatos {

    private static final String PATH = "src/";  

    public static String getNombreArchivo(String pokemon) {
        return PATH + pokemon.toLowerCase() + ".txt";
    }

    public static void guardarDatos(PokemonVirtual mascota, String pokemon) {
        String nombreArchivo = getNombreArchivo(pokemon);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(mascota.getNombre() + "," +
                         mascota.getNivelFelicidad() + "," +
                         mascota.getNivelHambre() + "," +
                         mascota.getNivelEnergia() + "," +
                         mascota.getNivelLimpieza() + "," +
                         mascota.getNivelSalud() + "," +
                         mascota.getTiempoJuego());
            writer.newLine();
            System.out.println("Datos guardados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
        }
    }

    public static PokemonVirtual cargarDatos(String pokemon) throws IOException {
        String nombreArchivo = getNombreArchivo(pokemon);
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            throw new IOException("Archivo no encontrado: " + nombreArchivo);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                String[] data = line.split(",");
                PokemonVirtual mascota = new PokemonVirtual(data[0]);  // Asume que el nombre es el primer dato
                mascota.setNivelFelicidad(Integer.parseInt(data[1]));
                mascota.setNivelHambre(Integer.parseInt(data[2]));
                mascota.setNivelEnergia(Integer.parseInt(data[3]));
                mascota.setNivelLimpieza(Integer.parseInt(data[4]));
                mascota.setNivelSalud(Integer.parseInt(data[5]));
                mascota.setTiempoJuego(Integer.parseInt(data[6]));
                return mascota;
            }
        }
        return null;
    }
}