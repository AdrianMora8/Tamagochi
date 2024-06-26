package Mascota;

public class Cansado implements EstadoPokemon {
    @Override
    public void alimentar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelHambre() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + " Ya no tiene hambre ");
            mascota.verificarLimites();
        }else{
        gui.mostrarMensaje(mascota.getNombre() + " come despacio, parece muy cansado.");
            mascota.setNivelHambre(mascota.getNivelHambre()+20); // Levemente menos eficaz que normal.
            gui.actualizarEstadoMascota();
            mascota.verificarLimites();
        }
    }

    @Override
    public void jugar(PokemonVirtual mascota, PokemonGUI gui) {
        
        if (mascota.getNivelEnergia() == 0) {
            gui.mostrarMensaje(mascota.getNombre() + " se quedo sin energias para jugar");
            mascota.verificarLimites();
        }else{
        gui.mostrarMensaje(mascota.getNombre() + " intenta jugar, pero se cansa rápidamente.");
            mascota.setNivelEnergia(mascota.getNivelEnergia()-30);
                gui.actualizarEstadoMascota();
                mascota.verificarLimites();
        
        }
    }

    @Override
    public void dormir(PokemonVirtual mascota, PokemonGUI gui) {
        
        if (mascota.getNivelEnergia() == 100) {
            gui.mostrarMensaje(mascota.getNombre() + "No necesita dormir aun");
            
        }else{
        gui.mostrarMensaje(mascota.getNombre() + " se duerme rápidamente, exhausto por el día.");
            mascota.setNivelEnergia(100); // Recarga completa de energía.
                gui.actualizarEstadoMascota();   
        }        
        mascota.verificarLimites();
    }

    @Override
    public void curar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelSalud()<= 40 ) {
            mascota.setNivelSalud(100);
                gui.mostrarMensaje(mascota.getNombre() + " Ha sido curado");
                    gui.actualizarEstadoMascota();
                    mascota.verificarLimites();
        }else{
        gui.mostrarMensaje(mascota.getNombre() + " no está enfermo, solo necesita descansar.");
        mascota.verificarLimites();
        }
    }

    @Override
    public void limpiar(PokemonVirtual mascota, PokemonGUI gui) {
        if (mascota.getNivelLimpieza() <= 40) {
        gui.mostrarMensaje(mascota.getNombre() + " se limpia sin mucha energía.");
            mascota.setNivelLimpieza(100); // Completamente limpio.
                gui.actualizarEstadoMascota();
                mascota.verificarLimites();
        }else{
            gui.mostrarMensaje(mascota.getNombre() + " No necesita limpiarse aun");
            mascota.verificarLimites();
        }
    }
}