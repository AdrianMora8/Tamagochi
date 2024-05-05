package Mascota;

public class Triste implements EstadoPokemon {
    @Override
    public void alimentar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelHambre() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " no tiene apetito, pero ya está saciado.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " come sin mucho entusiasmo.");
            mascota.setNivelHambre(Math.min(100, mascota.getNivelHambre() + 10)); // Come menos efectivamente.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void jugar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() <= 10) {
            gui.mostrarMensaje(mascota.getNombre() + " está demasiado desanimado y cansado para jugar.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " intenta jugar, pero su tristeza lo hace menos activo.");
            mascota.setNivelEnergia(Math.max(0, mascota.getNivelEnergia() - 10));
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void dormir(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " ya está descansado, pero aún parece triste.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " duerme inquietamente, agitado por sus penas.");
            mascota.setNivelEnergia(100);
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void curar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelSalud() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " no está enfermo, solo triste.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " mejora lentamente su salud, a pesar de la tristeza.");
            mascota.setNivelSalud(100);
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void limpiar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelLimpieza() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " no necesita limpieza.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " se limpia, aunque de manera desganada.");
            mascota.setNivelLimpieza(100);
            gui.actualizarEstadoMascota();
        }
    }
}
