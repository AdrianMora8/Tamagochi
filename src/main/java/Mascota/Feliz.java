package Mascota;

public class Feliz implements EstadoMascota {
    @Override
    public void alimentar(MascotaVirtual mascota, MascotaVirtualGUI gui) {
        if (mascota.getNivelHambre() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está completamente satisfecho y no quiere comer más.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " come con gusto, felizmente.");
            mascota.setNivelHambre(Math.min(100, mascota.getNivelHambre() + 30)); // Incremento mayor porque está feliz.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void jugar(MascotaVirtual mascota, MascotaVirtualGUI gui) {
        if (mascota.getNivelEnergia() <= 10) {
            gui.mostrarMensaje(mascota.getNombre() + " está demasiado cansado para seguir jugando.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " juega entusiasmado y lleno de alegría.");
            mascota.setNivelEnergia(Math.max(0, mascota.getNivelEnergia() - 20)); // Usa más energía porque está activo.
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void dormir(MascotaVirtual mascota, MascotaVirtualGUI gui) {
        if (mascota.getNivelEnergia() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está completamente descansado y no quiere dormir ahora.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " duerme feliz y tranquilamente, recuperando energías.");
            mascota.setNivelEnergia(100);
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void curar(MascotaVirtual mascota, MascotaVirtualGUI gui) {
        if (mascota.getNivelSalud() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " está en perfecta salud y no necesita curación.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " utiliza su felicidad para recuperarse más rápidamente.");
            mascota.setNivelEnfermedad(Math.max(0, mascota.getNivelSalud() + 20));
            gui.actualizarEstadoMascota();
        }
    }

    @Override
    public void limpiar(MascotaVirtual mascota, MascotaVirtualGUI gui) {
        if (mascota.getNivelLimpieza() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " ya está completamente limpio.");
        } else {
            gui.mostrarMensaje(mascota.getNombre() + " aprovecha su buen humor para hacer una limpieza a fondo.");
            mascota.setNivelLimpieza(100);
            gui.actualizarEstadoMascota();
        }
    }
}
