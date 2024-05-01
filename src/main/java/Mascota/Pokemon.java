package Mascota;

public class Pokemon extends MascotaVirtual {
    private String tipo;
    private int nivel;

    public Pokemon(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
        this.nivel = nivel; // Nivel inicial
    }

    // Getters y Setters 
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    public void ganarExperiencia() {
        
    }
}

