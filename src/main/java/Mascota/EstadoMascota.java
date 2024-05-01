package Mascota;

public interface EstadoMascota {
    void alimentar(PokemonVirtual mascota, PokemonGUI gui);
    void jugar(PokemonVirtual mascota, PokemonGUI gui);
    void dormir(PokemonVirtual mascota, PokemonGUI gui);
    void curar(PokemonVirtual mascota, PokemonGUI gui);
    void limpiar(PokemonVirtual mascota, PokemonGUI gui);
    
}

