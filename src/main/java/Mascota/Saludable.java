package Mascota;

public class Saludable implements EstadoMascota {
    
    
    @Override
    public void alimentar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelHambre() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está completamente lleno y en perfecta salud.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " come con salud y vigor.");
            mascota.setNivelHambre(Math.min(100, mascota.getNivelHambre() + 20)); // Efectividad normal de alimentación.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void jugar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() == 0) {
            gui.mostrarMensaje(mascota.getNombre() + " está demasiado cansado para continuar jugando.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " juega con gran energía y disfrute.");
            mascota.setNivelEnergia(Math.max(0, mascota.getNivelEnergia() - 10)); // Consumo de energía normal durante el juego.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void dormir(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está completamente descansado y no necesita más sueño.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " duerme profundamente y de manera saludable.");
            mascota.setNivelEnergia(100);
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void curar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelSalud() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está en plena forma y no necesita curación.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " aprovecha su buen estado de salud para recuperarse rápidamente.");
            mascota.setNivelSalud(0); // Asumimos que saludable implica la capacidad de recuperarse completamente.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void limpiar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelLimpieza() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " ya está impecable y no necesita limpieza.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " se mantiene limpio con facilidad.");
            mascota.setNivelLimpieza(100);
            gui.actualizarEstadoMascota();
        }
    }
}