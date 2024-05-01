package Mascota;

public class Enfermo implements EstadoMascota {
    @Override
    public void alimentar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelHambre() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " no tiene apetito debido a la enfermedad, pero está saciado.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " come poco, afectado por su mal estado.");
            mascota.setNivelHambre(Math.min(100, mascota.getNivelHambre() + 5)); // Menor eficiencia en la alimentación.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void jugar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() <= 10) {
            gui.mostrarMensaje(mascota.getNombre() + " está demasiado débil para jugar.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " intenta jugar pero se siente muy mal.");
            mascota.setNivelEnergia(Math.max(0, mascota.getNivelEnergia() - 20));
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void dormir(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelEnergia() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " ya está completamente descansado pero sigue enfermo.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " tiene un sueño algo pesado pero recuperador.");
            mascota.setNivelEnergia(100);
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void curar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelSalud() >= 40 ) {
            gui.mostrarMensaje(mascota.getNombre() + " No necesita ser curado");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " mejora gradualmente su salud.");
            mascota.setNivelSalud(Math.max(0, mascota.getNivelSalud()+ 20));
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void limpiar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelLimpieza() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " ya está limpio y no necesita más cuidados.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " se limpia meticulosamente para evitar infecciones.");
            mascota.setNivelLimpieza(100);
            gui.actualizarEstadoMascota();
        }
    }
}