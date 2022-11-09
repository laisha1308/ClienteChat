import Interfaces.ChatServidor;

import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            String nom = nombre;
            System.setProperty("java.rmi.server.hostname","192.168.1.10");
            Registry registry = LocateRegistry.getRegistry("192.168.1.10", 5000);
            ChatServidor servidor = (ChatServidor) registry.lookup("chat");
            new Thread(new implementacionClienteChat(nom, servidor)).start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
