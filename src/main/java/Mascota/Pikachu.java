package Mascota;


public class Pikachu extends PokemonVirtual {
   private int nivelElectrico; // Puede representar la potencia de sus ataques eléctricos.

    public Pikachu(String nombre) {
    super(nombre);  // Asegurándonos de que el tipo es correctamente asignado
    this.nivelElectrico = 50;    // Un valor inicial para la capacidad eléctrica
}
    
    public void ataqueTrueno(PokemonGUI gui) {
        System.out.println(getNombre() + " usa Ataque Trueno!");
        gui.mostrarMensaje(getNombre() + " lanza un potente ataque trueno!");
        gui.updateGif("ataque_trueno", 7000);  // Suponiendo que existe un GIF para este ataque
    }

}

