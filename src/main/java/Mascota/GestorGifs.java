
package Mascota;

import javax.swing.ImageIcon;
import java.util.HashMap;
import java.util.Map;

public class GestorGifs {
    private Map<String, ImageIcon> gifs;

    public GestorGifs(String nombreMascota) {
        gifs = new HashMap<>();
        cargarGifs(nombreMascota);
        cargarGifInicial(nombreMascota);
    }
    
    

    private void cargarGifs(String nombreMascota) {
        if (nombreMascota.equalsIgnoreCase("pikachu")) {
            gifs.put("pikachu", new ImageIcon(getClass().getResource( "/pikachu/pikachu.gif")));
            gifs.put("comer", new ImageIcon(getClass().getResource( "/pikachu/Pcomer.gif")));
            gifs.put("jugar", new ImageIcon(getClass().getResource( "/pikachu/Pjugar.gif")));
            gifs.put("dormir", new ImageIcon(getClass().getResource( "/pikachu/Pdormir.gif")));
            gifs.put("curar", new ImageIcon(getClass().getResource( "/pikachu/Pcurar.gif")));
            gifs.put("limpiar", new ImageIcon(getClass().getResource( "/pikachu/Plimpiar.gif")));
            gifs.put("ataque", new ImageIcon(getClass().getResource( "/pikachu/Pataque.gif")));
        } else if (nombreMascota.equalsIgnoreCase("charmander")) {
            gifs.put("charmander", new ImageIcon(getClass().getResource( "/charmander/charmander.gif")));
            gifs.put("comer", new ImageIcon(getClass().getResource( "/charmander/C-comer.gif")));
            gifs.put("jugar", new ImageIcon(getClass().getResource( "/charmander/C-jugar.gif")));
            gifs.put("dormir", new ImageIcon(getClass().getResource( "/charmander/C-dormir.gif")));
            gifs.put("curar", new ImageIcon(getClass().getResource( "/charmander/C-curar.gif")));
            gifs.put("limpiar", new ImageIcon(getClass().getResource( "/charmander/C-limpiar.gif")));
            gifs.put("ataque", new ImageIcon(getClass().getResource( "/charmander/C-ataque.gif")));
        }
        
    }

    public ImageIcon getGif(String action) {
        return gifs.get(action);
    }
    
    private void cargarGifInicial(String nombreMascota) {
    gifs.put(nombreMascota, new ImageIcon(getClass().getResource("/" + nombreMascota + "/" + nombreMascota + ".gif/")));
}
}
