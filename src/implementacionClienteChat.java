import Interfaces.ChatCliente;
import Interfaces.ChatServidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class implementacionClienteChat extends UnicastRemoteObject implements ChatCliente, Runnable {
    ChatServidor servidor;
    public String nombre = null;

    implementacionClienteChat(String nombre, ChatServidor servidor) throws RemoteException {
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }

    public void mensajeCliente(String mensaje) throws RemoteException {
        System.err.println(mensaje);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String mensaje;

        while (true) {
            mensaje = scanner.nextLine();
            try {
                servidor.mensaje(nombre + ": " + mensaje);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
