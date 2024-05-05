package Mascota;

public class Energico implements EstadoPokemon {
    @Override
    public void alimentar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelHambre() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está completamente lleno y rebosante de energía!");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " come rápidamente y con entusiasmo, aprovechando cada bocado para recuperar fuerzas.");
            mascota.setNivelHambre(Math.min(100, mascota.getNivelHambre() + 30)); // Comen más eficientemente porque están energéticos.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void jugar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() <= 10) {
            gui.mostrarMensaje(mascota.getNombre() + " ha gastado casi toda su energía y necesita descansar.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " juega con una energía inagotable y mucho entusiasmo.");
            mascota.setNivelEnergia(Math.max(0, mascota.getNivelEnergia() - 15)); // Consumo de energía un poco mayor debido a la actividad intensa.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void dormir(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está demasiado energico para dormir ahora.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " finalmente se toma un descanso, aunque le cuesta dormir.");
            mascota.setNivelEnergia(100);
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void curar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelSalud() == 100 ) {
            gui.mostrarMensaje(mascota.getNombre() + " está en plena forma y no necesita ningún tipo de cura.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " utiliza su energía para combatir la enfermedad más rápidamente.");
            mascota.setNivelSalud(Math.max(0, mascota.getNivelSalud() + 20));
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void limpiar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelLimpieza() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " ya está completamente limpio y no para de moverse.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " se limpia rápidamente y con eficacia, apenas tomando un descanso.");
            mascota.setNivelLimpieza(100);
            gui.actualizarEstadoMascota();
        }
    }
}