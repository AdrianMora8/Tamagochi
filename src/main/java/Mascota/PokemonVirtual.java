
package Mascota;

public class PokemonVirtual {
    private String nombre;
    private int nivelFelicidad;
    private int nivelHambre;
    private int nivelEnergia;
    private int nivelLimpieza; // Atributo para el nivel de limpieza
    private int nivelSalud;
    private int tiempoJuego; // Asegúrate de que esta variable está definida en tu clase.
    private EstadoMascota estado; // Referencia al estado actual
        

    public PokemonVirtual(String nombre) {
        this.nombre = nombre;
        this.nivelFelicidad = 50; // Nivel de felicidad inicial
        this.nivelHambre = 50; // Nivel de hambre inicial
        this.nivelEnergia = 50; // Nivel de energía inicial
        this.nivelLimpieza = 100; // Inicialización a un valor por defecto
        this.nivelSalud = 30; // No está enfermo inicialmente
        this.tiempoJuego=0;
        this.estado = new Cansado(); // Estado inicial
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
    
    public void setEstado(EstadoMascota nuevoEstado) {
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

    public EstadoMascota getEstado() {
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
    
        public void cambiarEstado(EstadoMascota nuevoEstado) {
        this.estado = nuevoEstado;
    }
    
    
    
    

}
