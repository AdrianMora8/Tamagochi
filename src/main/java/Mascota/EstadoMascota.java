package Mascota;

public interface EstadoMascota {
    void alimentar(MascotaVirtual mascota, MascotaVirtualGUI gui);
    void jugar(MascotaVirtual mascota, MascotaVirtualGUI gui);
    void dormir(MascotaVirtual mascota, MascotaVirtualGUI gui);
    void curar(MascotaVirtual mascota, MascotaVirtualGUI gui);
    void limpiar(MascotaVirtual mascota, MascotaVirtualGUI gui);
}

