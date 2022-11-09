package Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatCliente extends Remote {
    void mensajeCliente(String mensaje) throws RemoteException;
}
