package Mascota;


import java.awt.EventQueue;

public class Main {
 public static void main(String[] args) {
     EstiloUI.aplicarEstilo(); 
     EventQueue.invokeLater(() -> {
        new MenuInicial().setVisible(true);
    });

}
}
