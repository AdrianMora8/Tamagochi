package Mascota;

public class Pokemon extends PokemonVirtual {
    private String tipo;
    private int nivel;
    private int experienciaActual = 0;
    private int experienciaParaSubirDeNivel = 100;

    public Pokemon(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
        this.nivel = 1;
    }

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

    public int getExperienciaActual() {
        return experienciaActual;
    }

    public void setExperienciaActual(int experienciaActual) {
        this.experienciaActual = experienciaActual;
    }

    public int getExperienciaParaSubirDeNivel() {
        return experienciaParaSubirDeNivel;
    }

    public void setExperienciaParaSubirDeNivel(int experienciaParaSubirDeNivel) {
        this.experienciaParaSubirDeNivel = experienciaParaSubirDeNivel;
    }


    
    public void ganarExperiencia(int puntos) {
        experienciaActual += puntos;
        if (experienciaActual >= experienciaParaSubirDeNivel) {
            nivel++;
            experienciaActual -= experienciaParaSubirDeNivel;
            mejorarEstadisticas();
            System.out.println(getNombre() + " ha subido al nivel " + nivel + "!");
        }
    }

    private void mejorarEstadisticas() {
            setNivelEnergia(getNivelEnergia() + 10);
            setNivelSalud(getNivelSalud() + 20);
            setNivelFelicidad(getNivelFelicidad() + 5);
            // Ajusta las estadísticas como consideres necesario
        }

}

