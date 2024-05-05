package Mascota;

public class Charmander extends PokemonVirtual {
    public Charmander(String nombre) {
        super(nombre);
    }

    // Método específico de Charmander para realizar un ataque especial
    public void lanzaLlamas(PokemonGUI gui) {
        System.out.println(getNombre() + " usa Lanza Llamas!");
        gui.mostrarMensaje(getNombre() + " lanza un fiero ataque de llamas!");
        gui.updateGif("lanza_llamas", 7000);  
    }
}
