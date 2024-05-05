
package Mascota;

public class PokemonVirtual {
    private String nombre;
    private int nivelFelicidad;
    private int nivelHambre;
    private int nivelEnergia;
    private int nivelLimpieza; 
    private int nivelSalud;
    private int tiempoJuego; 
    private EstadoPokemon estado; 
    

        

    public PokemonVirtual(String nombre) {
        this.nombre = nombre;
        this.nivelFelicidad = 50; 
        this.nivelHambre = 50; 
        this.nivelEnergia = 50; 
        this.nivelLimpieza = 100; 
        this.nivelSalud = 50;
        this.tiempoJuego=0;
        this.estado = new Saludable(); 
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivelFelicidad(int nivelFelicidad) {
        this.nivelFelicidad = nivelFelicidad;
    }

    public void setNivelHambre(int nivelHambre) {
        this.nivelHambre = nivelHambre;
    }

    public void setNivelEnergia(int nivelEnergia) {
        this.nivelEnergia = nivelEnergia;
    }

    public void setNivelLimpieza(int nivelLimpieza) {
        this.nivelLimpieza = nivelLimpieza;
    }

    public void setNivelSalud(int nivelSalud) {
        this.nivelSalud = nivelSalud;
    }

    public void setTiempoJuego(int tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }
    
    public void setEstado(EstadoPokemon nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNivelFelicidad() {
        return nivelFelicidad;
    }

    public int getNivelHambre() {
        return nivelHambre;
    }

    public int getNivelEnergia() {
        return nivelEnergia;
    }

    public int getNivelLimpieza() {
        return nivelLimpieza;
    }

    public int getNivelSalud() {
        return nivelSalud;
    }

    public EstadoPokemon getEstado() {
        return estado;
    }

    public int getTiempoJuego() {
        return tiempoJuego;
    }
     
    
    
    public void alimentar(PokemonGUI gui) {
        estado.alimentar(this, gui);
            verificarLimites();
    }

    public void jugar(PokemonGUI gui) {
        estado.jugar(this, gui);
            verificarLimites();
        
    }

    public void dormir(PokemonGUI gui) {
        estado.dormir(this, gui);
            verificarLimites();
        
    }

    public void curar(PokemonGUI gui) {
        estado.curar(this, gui);
        verificarLimites();
    }

    public void limpiar(PokemonGUI gui) {
        estado.limpiar(this, gui);
        verificarLimites();
 
    }

    
        public void verificarLimites() {
        nivelFelicidad = Math.min(Math.max(nivelFelicidad, 0), 100); 
        nivelHambre = Math.min(Math.max(nivelHambre, 0), 100);     
        nivelEnergia = Math.min(Math.max(nivelEnergia, 0), 100);     
        nivelLimpieza = Math.min(Math.max(nivelLimpieza, 0), 100);  
        nivelSalud = Math.min(Math.max(nivelSalud,0),100);
    }
    
        public void cambiarEstado(EstadoPokemon nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
    
    
    

}
